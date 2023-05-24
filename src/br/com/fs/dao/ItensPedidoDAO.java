package br.com.fs.dao;

import br.com.fs.to.ItensPedidoTO;
import br.com.fs.to.ProdutoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItensPedidoDAO {

    public ArrayList buscarItens() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT * FROM produto WHERE tipo = 'F' AND situacao = 'A' ORDER BY id DESC LIMIT 20";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdutoTO> dados = new ArrayList();
            while (rs.next()) {
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setDescricao(rs.getString("descricao"));
                to.setPrecocusto(rs.getDouble("precocusto"));
                to.setPrecovenda(rs.getDouble("precovenda"));
                to.setQtd(rs.getDouble("qtd"));
                to.setComposto(rs.getString("composto"));
                to.setTipo(rs.getString("tipo"));
                to.setUnidade(rs.getString("unidade"));
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

    public ArrayList filtroItens(String parametro) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT * FROM produto WHERE tipo = 'F' AND "
                    + "situacao = 'A' AND nome LIKE '%" + parametro + "%' ORDER BY id DESC LIMIT 20";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdutoTO> dados = new ArrayList();
            while (rs.next()) {
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setDescricao(rs.getString("descricao"));
                to.setPrecocusto(rs.getDouble("precocusto"));
                to.setPrecovenda(rs.getDouble("precovenda"));
                to.setQtd(rs.getDouble("qtd"));
                to.setComposto(rs.getString("composto"));
                to.setTipo(rs.getString("tipo"));
                to.setUnidade(rs.getString("unidade"));
                to.setSituacao(rs.getString("situacao"));
                dados.add(to);
            }
            return dados;
        } catch (Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void inserir(ItensPedidoTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "INSERT INTO itenspedido(idpedido, idproduto, qtd, valorvenda) "
                    + "VALUES(?, ?, ?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getPedido().getIdPedido());
            ps.setInt(2, to.getProduto().getIdProduto());
            ps.setDouble(3, to.getQtd());
            ps.setDouble(4, to.getValorVenda());
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

    public static double retornaQtd(int produto, int pedido) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "select qtd from itenspedido WHERE idproduto = ? and idpedido = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, produto);
            ps.setInt(2, pedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("qtd");
            } else {
                return 0;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public boolean verificaSeExiste(int item, int pedido) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "select null from itenspedido WHERE idproduto = ? and idpedido = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, item);
            ps.setInt(2, pedido);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void removerItem(int idproduto, int idpedido, double qtd) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "DELETE FROM itenspedido WHERE idproduto = ? and idpedido = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, idproduto);
            ps.setInt(2, idpedido);
            ps.execute();
            c.confirmar();

            String sql2 = "call sp_finalizapedido_iu(" + idproduto + ", " + (-qtd) + ")";
            PreparedStatement ps2 = c.getCon().prepareStatement(sql2);
            ps2.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public ArrayList detalhaItensPedido(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT p.id as idproduto, i.valorvenda, "
                    + "p.nome as nomeproduto, p.unidade as unidadeprod, "
                    + "i.qtd FROM itenspedido i JOIN "
                    + "produto p on i.idproduto = p.id WHERE i.idpedido = " + id + "";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ItensPedidoTO> dados = new ArrayList();
            while (rs.next()) {
                ItensPedidoTO to = new ItensPedidoTO();
                ProdutoTO produto = new ProdutoTO();
                to.setQtd(rs.getDouble("qtd"));
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setNome(rs.getString("nomeproduto"));
                produto.setUnidade(rs.getString("unidadeprod"));
                to.setProduto(produto);
                to.setValorVenda(rs.getDouble("valorvenda"));
                dados.add(to);
            }
            return dados;
        } catch (Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }
}
