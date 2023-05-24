package br.com.fs.dao;

import br.com.fs.to.CidadeTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CidadeDAO {

    public void inserir(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            CidadeTO to = (CidadeTO) obj;
            String sql = "INSERT INTO cidade(nome, uf, situacao) VALUES (?, ? , ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getNome());
            ps.setString(2, to.getUf());
            ps.setString(3, to.getSituacao());
            ps.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void alterar(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            CidadeTO to = (CidadeTO) obj;
            String sql = "UPDATE cidade set nome = ?, uf = ?, situacao = ? WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getNome());
            ps.setString(2, to.getUf());
            ps.setString(3, to.getSituacao());
            ps.setInt(4, to.getIdCidade());
            ps.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void excluir(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            CidadeTO to = (CidadeTO) obj;
            String sql = "DELETE FROM cidade WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getIdCidade());
            ps.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public boolean validarDelete(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT idcidade FROM funcionario WHERE idcidade = ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public Object buscarId(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT * FROM cidade WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            CidadeTO to = new CidadeTO();
            if (rs.next()) {
                to.setIdCidade(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setUf(rs.getString("uf"));
                to.setSituacao(rs.getString("situacao"));
            }
            return to;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public ArrayList buscarTodos() throws Exception {
        Conexao c = new Conexao();
        try {
            CidadeTO to = new CidadeTO();
            String sql = "SELECT id, nome, uf, case when situacao = 'A' then 'ATIVO'"
                    + " when situacao = 'I' then 'INATIVO' else null end as situacao"
                    + " FROM cidade ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList dados = new ArrayList();
            while (rs.next()) {
                ArrayList linha = new ArrayList();
                linha.add(to.getIdCidadeFormatado(rs.getInt("id")));
                linha.add(rs.getString("nome"));
                linha.add(rs.getString("uf"));
                linha.add(rs.getString("situacao"));
                dados.add(linha);
            }
            return dados;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public ArrayList filtro(String nome) throws Exception {
        Conexao c = new Conexao();
        try {
            CidadeTO to = new CidadeTO();
            String sql = "SELECT id, nome, uf, case when situacao = 'A' then 'ATIVO'"
                    + " when situacao = 'I' then 'INATIVO' else null end as situacao "
                    + "FROM cidade WHERE nome LIKE '%" + nome + "%' "
                    + "AND situacao = 'A' ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList dados = new ArrayList();
            while (rs.next()) {
                ArrayList linha = new ArrayList();
                linha.add(to.getIdCidadeFormatado(rs.getInt("id")));
                linha.add(rs.getString("nome"));
                linha.add(rs.getString("uf"));
                linha.add(rs.getString("situacao"));
                dados.add(linha);
            }
            return dados;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public static boolean verificaExiste(String nome, String uf, int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM cidade WHERE nome = ? and uf = ? and id <> ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, uf);
            ps.setInt(3, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }
}
