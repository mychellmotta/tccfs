package br.com.fs.dao;

import br.com.fs.to.ContaTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContasDAO {

    public static ArrayList montaCombo() {
        try {
            ArrayList dados = new ArrayList();
            Conexao c = new Conexao();
            String sql = "select id, nome from contas where situacao = 'A' order by id";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList vazio = new ArrayList();
            vazio.add("0");
            vazio.add("Selecione um item");
            dados.add(vazio);
            while (rs.next()) {
                ArrayList linha = new ArrayList();
                linha.add(rs.getString("id"));
                linha.add(rs.getString("nome"));
                dados.add(linha);
            }
            c.getCon().close();
            return dados;
        } catch (Exception e) {
            return null;
        }
    }

    public void inserirNovo(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            ContaTO to = (ContaTO) obj;
            String sql = "INSERT INTO contas(nome, situacao) VALUES (?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getNome());
            ps.setString(2, to.getSituacao());
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

    public void alterarNovo(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            ContaTO to = (ContaTO) obj;
            String sql = "UPDATE contas set nome = ?, situacao = ? WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getNome());
            ps.setString(2, to.getSituacao());
            ps.setInt(3, to.getIdConta());
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

    public static boolean verificaExiste(String nome, int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM contas WHERE nome = ? and id <> ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setInt(2, id);
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

    public ArrayList buscarContas() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, nome, case when situacao = 'A' then 'ATIVO'"
                    + " when situacao = 'I' then 'INATIVO' else null end as situacao "
                    + "FROM contas ORDER BY id DESC LIMIT 20";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ContaTO> dados = new ArrayList();
            while (rs.next()) {
                ContaTO to = new ContaTO();
                to.setIdConta(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setSituacao(rs.getString("situacao"));
                dados.add(to);
            }
            return dados;
        } catch (SQLException e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public Object buscarId(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            ContaTO to = new ContaTO();
            String sql = "SELECT id, nome, CASE WHEN situacao = 'A' THEN 'ATIVO' "
                    + "ELSE 'INATIVO' END AS situacao FROM contas WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                to.setIdConta(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
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

    public void excluir(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            ContaTO to = (ContaTO) obj;
            String sql = "delete from contas WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getIdConta());
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
            String sql = "SELECT null FROM fluxofinan WHERE idconta = ? LIMIT 1";
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
}
