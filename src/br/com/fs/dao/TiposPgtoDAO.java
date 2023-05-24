package br.com.fs.dao;

import br.com.fs.to.TiposPgtoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TiposPgtoDAO {

    public void inserir(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            TiposPgtoTO to = (TiposPgtoTO) obj;
            String sql = "INSERT INTO tipospgto(tipo, descricao, situacao) VALUES (?, ? , ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getTipo());
            ps.setString(2, to.getDescricao());
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
            TiposPgtoTO to = (TiposPgtoTO) obj;
            String sql = "UPDATE tipospgto set tipo = ?, descricao = ?, situacao = ? WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getTipo());
            ps.setString(2, to.getDescricao());
            ps.setString(3, to.getSituacao());
            ps.setInt(4, to.getIdTipoPgto());
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
            TiposPgtoTO to = (TiposPgtoTO) obj;
            String sql = "DELETE FROM tipospgto WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getIdTipoPgto());
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
            String sql = "SELECT null FROM fluxofinan WHERE idtipospgto = ? LIMIT 1";
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

    public static boolean verificaExiste(String tipo, int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM tipospgto WHERE tipo = ? and id <> ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, tipo);
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

    public ArrayList buscarTodos() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, tipo, case when situacao = 'A' then 'ATIVO'"
                    + " else 'INATIVO' end as situacao FROM tipospgto ORDER BY id DESC LIMIT 20";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<TiposPgtoTO> dados = new ArrayList();
            while (rs.next()) {
                TiposPgtoTO to = new TiposPgtoTO();
                to.setIdTipoPgto(rs.getInt("id"));
                to.setTipo(rs.getString("tipo"));
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
            TiposPgtoTO to = new TiposPgtoTO();
            String sql = "SELECT id, tipo, descricao, CASE WHEN situacao = 'A' THEN 'ATIVO' "
                    + "ELSE 'INATIVO' END AS situacao FROM tipospgto WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                to.setIdTipoPgto(rs.getInt("id"));
                to.setTipo(rs.getString("tipo"));
                to.setDescricao(rs.getString("descricao"));
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

    public static ArrayList montaCombo() {
        try {
            ArrayList dados = new ArrayList();
            Conexao c = new Conexao();
            String sql = "select id, tipo from tipospgto order by id";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList vazio = new ArrayList();
            vazio.add("0");
            vazio.add("Selecione um item");
            dados.add(vazio);
            while (rs.next()) {
                ArrayList linha = new ArrayList();
                linha.add(rs.getString("id"));
                linha.add(rs.getString("tipo"));
                dados.add(linha);
            }
            c.getCon().close();
            return dados;
        } catch (Exception e) {
            return null;
        }
    }
}
