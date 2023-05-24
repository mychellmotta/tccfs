package br.com.fs.dao;

import br.com.fs.to.ProdutoTO;
import br.com.fs.to.PromocaoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PromocaoDAO {

    public void inserir(PromocaoTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "INSERT INTO promocao (idproduto, valorvenda, "
                    + "valorpromocao, inicio, termino, situacao) "
                    + "VALUES (?, ?, ?, ?, ?, 'A')";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getProduto().getIdProduto());
            ps.setDouble(2, to.getValorVenda());
            ps.setDouble(3, to.getValorPromocao());
            ps.setDate(4, new java.sql.Date(to.getInicio().getTime()));
            ps.setDate(5, new java.sql.Date(to.getTermino().getTime()));
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

    public void alterar(PromocaoTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "UPDATE promocao SET valorpromocao = ?, inicio = ?, termino = ? WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setDouble(1, to.getValorPromocao());
            ps.setDate(2, new java.sql.Date(to.getInicio().getTime()));
            ps.setDate(3, new java.sql.Date(to.getTermino().getTime()));
            ps.setInt(4, to.getIdPromocao());
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

    public PromocaoTO buscarId(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT prom.id, prom.idproduto, prom.valorpromocao, prom.valorvenda, prom.inicio, prom.termino, prom.situacao, prod.nome FROM promocao prom JOIN produto prod "
                    + "ON (prom.idproduto = prod.id) WHERE prom.id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            PromocaoTO to = new PromocaoTO();
            ProdutoTO produto = new ProdutoTO();
            if (rs.next()) {
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setNome(rs.getString("nome"));

                to.setIdPromocao(rs.getInt("id"));
                to.setValorPromocao(rs.getDouble("valorpromocao"));
                to.setValorVenda(rs.getDouble("valorvenda"));
                to.setInicio(rs.getDate("inicio"));
                to.setTermino(rs.getDate("termino"));
                to.setProduto(produto);
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

    public void excluir(PromocaoTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql2 = "DELETE FROM promocao WHERE id = ?";
            PreparedStatement ps2 = c.getCon().prepareStatement(sql2);
            ps2.setInt(1, to.getIdPromocao());
            ps2.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void finalizar(PromocaoTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            Date date = new Date();
            String hoje = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String sql2 = "UPDATE promocao SET situacao = 'F', termino = '" + hoje + "' WHERE id = ?";
            PreparedStatement ps2 = c.getCon().prepareStatement(sql2);
            ps2.setInt(1, to.getIdPromocao());
            ps2.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public ArrayList buscarTodos(String query) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT prom.id, prom.idproduto, prom.inicio, "
                    + "prom.termino, prom.valorpromocao, "
                    + "prom.valorvenda, prod.nome, CASE WHEN prom.situacao = 'A'"
                    + " THEN 'ATIVA' ELSE 'FINALIZADA' END AS sit "
                    + "FROM promocao prom JOIN produto prod ON prod.id = "
                    + "prom.idproduto WHERE 1 = 1 "
                    + query + " "
                    + "ORDER BY prom.id DESC LIMIT 20";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<PromocaoTO> dados = new ArrayList();
            while (rs.next()) {
                PromocaoTO to = new PromocaoTO();
                ProdutoTO produto = new ProdutoTO();

                produto.setIdProduto(rs.getInt("prom.idproduto"));
                produto.setNome(rs.getString("prod.nome"));

                to.setIdPromocao(rs.getInt("prom.id"));
                to.setProduto(produto);
                to.setInicio(rs.getDate("prom.inicio"));
                to.setTermino(rs.getDate("prom.termino"));
                to.setValorPromocao(rs.getDouble("prom.valorpromocao"));
                to.setValorVenda(rs.getDouble("prom.valorvenda"));
                to.setSituacao(rs.getString("sit"));

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

    public static boolean verificaSeExistemPromocoes() throws Exception {
        Conexao c = new Conexao();
        try {
            Date date = new Date();
            String hoje = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String sql = "SELECT null FROM promocao WHERE situacao = 'A' AND termino < '" + hoje + "'";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
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

    public static void promocoesFinalizandoHoje() throws Exception {
        Conexao c = new Conexao();
        try {
            Date date = new Date();
            String hoje = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String sql = "SELECT prom.id, prom.idproduto, prod.nome, "
                    + "prom.inicio, prom.termino, prom.valorpromocao, "
                    + "prom.valorvenda, prom.situacao FROM promocao prom "
                    + "JOIN produto prod ON (prod.id = prom.idproduto) "
                    + "WHERE prom.situacao = 'A' AND "
                    + "prom.termino < '" + hoje + "'";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PromocaoTO to = new PromocaoTO();
                ProdutoTO produto = new ProdutoTO();
                produto.setIdProduto(rs.getInt("prom.idproduto"));
                produto.setNome(rs.getString("prod.nome"));
                to.setIdPromocao(rs.getInt("prom.id"));
                to.setProduto(produto);
                to.setInicio(rs.getDate("prom.inicio"));
                to.setTermino(rs.getDate("prom.termino"));
                to.setValorPromocao(rs.getDouble("prom.valorpromocao"));
                to.setValorVenda(rs.getDouble("prom.valorvenda"));
                to.setSituacao(rs.getString("situacao"));

                String sql3 = "UPDATE promocao SET situacao = 'F' WHERE id = ?";
                PreparedStatement ps3 = c.getCon().prepareStatement(sql3);
                ps3.setInt(1, to.getIdPromocao());
                ps3.execute();
                c.confirmar();
            }
        } catch (Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public static boolean verificaExiste(int produto, int promocao) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM promocao WHERE idproduto = ? AND id <> ? AND situacao = 'A' LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, produto);
            ps.setInt(2, promocao);
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
    
    public static boolean verificaExiste(int produto) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM promocao WHERE idproduto = ? AND situacao = 'A' LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, produto);
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
