package br.com.fs.dao;

import br.com.fs.to.FormulaTO;
import br.com.fs.to.ProdutoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FormulaDAO {

    public void inserir(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            FormulaTO to = (FormulaTO) obj;
            String sql = "INSERT INTO formula (idproduto, "
                    + "idingrediente, qtd) "
                    + "VALUES (?, ?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getProdutofinal().getIdProduto());
            ps.setInt(2, to.getIngrediente().getIdProduto());
            ps.setDouble(3, to.getQtd());
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
            FormulaTO to = (FormulaTO) obj;
            String sql = "UPDATE formula SET idingrediente = ?, "
                    + "qtd = ? WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getIngrediente().getIdProduto());
            ps.setDouble(2, to.getQtd());
            ps.setInt(3, to.getIdFormula());
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

    public ArrayList buscarIngredientes(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT f.id AS idf, f.idproduto, f.idingrediente, f.qtd AS qtdf, p.nome AS prodnome, p.unidade "
                    + "FROM formula AS f JOIN produto AS p ON f.idingrediente = p.id WHERE f.idproduto = " + id + " ORDER BY idf DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<FormulaTO> dados = new ArrayList();
            while (rs.next()) {
                FormulaTO to = new FormulaTO();
                ProdutoTO ingrediente = new ProdutoTO();
                to.setIdFormula(rs.getInt("idf"));
                ingrediente.setNome(rs.getString("prodnome"));
                ingrediente.setUnidade(rs.getString("unidade"));
                to.setIngrediente(ingrediente);
                to.setQtd(rs.getDouble("qtdf"));
                dados.add(to);
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

    public ArrayList buscarProdutosComFormula(String query) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT p.id, p.nome FROM produto p INNER JOIN "
                    + "formula f ON f.idproduto = p.id WHERE 1 = 1 "+query+
                    " GROUP BY p.id ORDER BY p.id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdutoTO> dados = new ArrayList();
            while (rs.next()) {
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                dados.add(to);
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
    
    public Object buscarId(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT f.id, f.qtd, f.idingrediente, p.nome, p.unidade FROM formula f"
                    + " JOIN produto p ON (p.id = f.idingrediente) WHERE f.id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            FormulaTO to = new FormulaTO();
            if (rs.next()) {
                ProdutoTO ingrediente = new ProdutoTO();
                ingrediente.setIdProduto(rs.getString("idingrediente"));
                ingrediente.setUnidade(rs.getString("unidade"));
                ingrediente.setNome(rs.getString("nome"));
                
                to.setIdFormula(rs.getInt("id"));
                to.setQtd(rs.getDouble("qtd"));
                to.setIngrediente(ingrediente);
            }
            return to;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void removerIngrediente(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            FormulaTO to = (FormulaTO) obj;
            String sql = "DELETE FROM formula WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getIdFormula());
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

    public boolean verificaExiste(int idproduto, int idingrediente, int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM formula WHERE idproduto = ? and idingrediente = ? and id <> ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, idproduto);
            ps.setInt(2, idingrediente);
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
