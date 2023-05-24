package br.com.fs.dao;

import br.com.fs.to.ProdutoTO;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProdutoDAO {

    SimpleDateFormat paraTime = new SimpleDateFormat("HH:mm:ss");

    public void inserir(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            ProdutoTO to = (ProdutoTO) obj;
            String sql = "INSERT INTO produto (nome, descricao, unidade, "
                    + "precocusto, precovenda, qtd, composto, tipo, situacao, "
                    + "duracaoproducao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getNome());
            ps.setString(2, to.getDescricao());
            ps.setString(3, to.getUnidade());
            ps.setDouble(4, to.getPrecocusto());
            ps.setDouble(5, to.getPrecovenda());
            ps.setDouble(6, to.getQtd());
            ps.setString(7, to.getComposto());
            ps.setString(8, to.getTipo());
            ps.setString(9, to.getSituacao());
            Date data = paraTime.parse(to.getDuracaoproducao());
            Time time = new Time(data.getTime());
            ps.setTime(10, time);
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
            ProdutoTO to = (ProdutoTO) obj;
            String sql = "UPDATE produto SET nome = ?, descricao = ?, "
                    + "unidade = ?, precocusto = ?, precovenda = ?, qtd = ?, composto = ?, "
                    + "tipo = ?, situacao = ?, duracaoproducao = ? WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getNome());
            ps.setString(2, to.getDescricao());
            ps.setString(3, to.getUnidade());
            ps.setDouble(4, to.getPrecocusto());
            ps.setDouble(5, to.getPrecovenda());
            ps.setDouble(6, to.getQtd());
            ps.setString(7, to.getComposto());
            ps.setString(8, to.getTipo());
            ps.setString(9, to.getSituacao());
            Date data = paraTime.parse(to.getDuracaoproducao());
            Time time = new Time(data.getTime());
            ps.setTime(10, time);
            ps.setInt(11, to.getIdProduto());
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
            ProdutoTO to = (ProdutoTO) obj;
            String sql = "DELETE FROM produto WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getIdProduto());
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

    public ArrayList buscarTodos() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, nome, qtd, unidade, case when situacao = 'A' then 'ATIVO'"
                    + " when situacao = 'I' then 'INATIVO' else null end as situacao"
                    + " FROM produto ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdutoTO> dados = new ArrayList();
            while (rs.next()) {
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setQtd(rs.getDouble("qtd"));
                to.setUnidade(rs.getString("unidade"));
                to.setSituacao(rs.getString("situacao"));
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

    public ArrayList filtro(String query) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, nome, qtd, unidade, case when situacao = 'A' then 'ATIVO'"
                    + " when situacao = 'I' then 'INATIVO' else null end as situacao"
                    + " FROM produto WHERE 1 = 1 " + query + " ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdutoTO> dados = new ArrayList();
            while (rs.next()) {
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setQtd(rs.getDouble("qtd"));
                to.setUnidade(rs.getString("unidade"));
                to.setSituacao(rs.getString("situacao"));
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

    public ArrayList produtosFinaisAtivos(String query) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, nome, qtd, precocusto, precovenda, unidade, "
                    + " composto, case when situacao = 'A' then 'ATIVO'"
                    + " when situacao = 'I' then 'INATIVO' else null end as situacao"
                    + " FROM produto WHERE 1 = 1 " + query + " "
                    + " AND situacao = 'A' AND tipo = 'F' ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdutoTO> dados = new ArrayList();
            while (rs.next()) {
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setQtd(rs.getDouble("qtd"));
                to.setUnidade(rs.getString("unidade"));
                to.setComposto(rs.getString("composto"));
                to.setPrecovenda(rs.getDouble("precovenda"));
                to.setPrecocusto(rs.getDouble("precocusto"));
                to.setSituacao(rs.getString("situacao"));
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

    public boolean validarDeleteFormula(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM formula WHERE idproduto = ? LIMIT 1";
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
    
    public boolean validarDeleteProducao(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM producao WHERE idproduto = ? LIMIT 1";
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
    
    public boolean validarDeletePedido(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM itenspedido WHERE idproduto = ? LIMIT 1";
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
    
    public boolean validarDeleteFormulaIngrediente(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM formula WHERE idingrediente = ? LIMIT 1";
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
    
    public boolean validarDeletePromocao(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM promocao WHERE idproduto = ? LIMIT 1";
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
    
    public boolean validarDeletePerca(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM perca WHERE idproduto = ? LIMIT 1";
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
            String sql = "SELECT * FROM produto WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ProdutoTO to = new ProdutoTO();
            if (rs.next()) {
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
                to.setDuracaoproducao(new SimpleDateFormat("HH:mm:ss").format(rs.getTime("duracaoproducao")));
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

    public static boolean verificaExiste(String nome, int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM produto WHERE nome = ? and id <> ? LIMIT 1";
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

    public ArrayList buscarIngredientes() throws Exception {
        Conexao c = new Conexao();
        try {

            String sql = "SELECT id, nome, qtd, unidade FROM produto WHERE tipo = 'I' "
                    + "AND situacao = 'A' ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdutoTO> dados = new ArrayList();
            while (rs.next()) {
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setQtd(rs.getDouble("qtd"));
                to.setUnidade(rs.getString("unidade"));
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

    public ArrayList filtroIngredientes(String nome) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, nome, qtd, unidade FROM produto WHERE tipo = 'I' AND"
                    + " situacao = 'A' AND nome LIKE '%" + nome + "%' ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdutoTO> dados = new ArrayList();
            while (rs.next()) {
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setQtd(rs.getDouble("qtd"));
                to.setUnidade(rs.getString("unidade"));
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

    public ArrayList buscarProdutosCompostos() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, nome, qtd, unidade FROM produto WHERE composto = 'S' "
                    + "AND situacao = 'A' ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdutoTO> dados = new ArrayList();
            while (rs.next()) {
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setQtd(rs.getDouble("qtd"));
                to.setUnidade(rs.getString("unidade"));
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

    public ArrayList buscarProdutosBaixoEstoque() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, nome, qtd, unidade FROM produto WHERE qtd <= 5 "
                    + "AND situacao = 'A' AND composto = 'N' ORDER BY id";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdutoTO> dados = new ArrayList();
            while (rs.next()) {
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setQtd(rs.getDouble("qtd"));
                to.setUnidade(rs.getString("unidade"));
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

    public static boolean abrirAlertaBaixoEstoque() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM produto WHERE qtd <= 5 "
                    + "AND situacao = 'A' AND composto = 'N' LIMIT 1";
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

    public ArrayList filtroProdutosCompostos(String nome) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, nome, qtd, unidade FROM produto WHERE composto = 'S' AND"
                    + " situacao = 'A' AND nome LIKE '%" + nome + "%' ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdutoTO> dados = new ArrayList();
            while (rs.next()) {
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setQtd(rs.getDouble("qtd"));
                to.setUnidade(rs.getString("unidade"));
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

    public boolean checaDisponibilidade(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM produto p JOIN formula f on f.idingrediente = p.id where f.idproduto = " + id + " and p.qtd < f.qtd";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
        return false;
    }

    public int estoqueComposto(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "select "
                    + "p.nome as produtoFinal, "
                    + "min(truncate(p2.qtd / f.qtd, 0)) as EstoqueProducao "
                    + "from produto p "
                    + "inner join formula f"
                    + " on f.idproduto = p.id"
                    + " inner join produto p2"
                    + " on p2.id = f.idingrediente where p.id = ?"
                    + " group by p.nome";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("EstoqueProducao");
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
        return 0;
    }

    public ArrayList ajusteEstoqueProducao() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT * FROM produto WHERE tipo = 'I' AND "
                    + "composto = 'S' AND situacao = 'A' ORDER BY id DESC LIMIT 10";
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

    public ArrayList filtroAjusteEstoqueProducao(String parametro) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT * FROM produto WHERE tipo = 'I' AND "
                    + "composto = 'S' AND situacao = 'A' AND nome "
                    + "LIKE '%" + parametro + "%' ORDER BY id DESC LIMIT 10";
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

    public ProdutoTO ajusteEstoqueProdFocusLost(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT * FROM produto WHERE tipo = 'I' AND "
                    + "composto = 'S' AND situacao = 'A' AND id = ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ProdutoTO to = new ProdutoTO();
            if (rs.next()) {
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

    public void ajustarEstoqueItens(int idproduto, double qtd) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "update produto p, formula f set "
                    + "p.qtd = p.qtd - (" + qtd + " * f.qtd) where p.id = f.idingrediente and f.idproduto = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, idproduto);
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

    public void ajustarEstoqueProd(int idproduto, double qtd) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "update produto set qtd = qtd + " + qtd + " where id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, idproduto);
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

    public ArrayList ajusteEstoquePerca() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT * FROM produto WHERE situacao = 'A' ORDER BY id DESC LIMIT 10";
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

    public ArrayList filtroAjusteEstoquePerca(String parametro) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT * FROM produto WHERE situacao = 'A' AND nome"
                    + " LIKE '%" + parametro + "%' ORDER BY id DESC LIMIT 10";
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

    public void ajustarEstoqueBalanco(int idproduto, double qtd) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "update produto set qtd = ? where id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setDouble(1, qtd);
            ps.setInt(2, idproduto);
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

    public void zerarEstoque(int idproduto) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "update produto set qtd = 0 where id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, idproduto);
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

    public void zerarEstoque() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "update produto set qtd = 0 where id > 0";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
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

    public static double precoProduto(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT ifnull(prom.valorpromocao, prod.precovenda) AS valorvenda "
                    + "FROM produto prod LEFT JOIN promocao prom ON "
                    + "prom.idproduto = prod.id AND prom.situacao = 'A' WHERE prod.id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("valorvenda");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }
}
