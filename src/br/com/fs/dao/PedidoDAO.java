package br.com.fs.dao;

import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.to.FuncionarioTO;
import br.com.fs.to.PedidoTO;
import br.com.fs.to.ProdutoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoDAO {

    public int inserir(PedidoTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "INSERT INTO pedido(datahorapedido, idfuncionario, "
                    + "tipopedido, situacao, valorpedido, desconto, valortotal, senha) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getDataHoraBanco());
            ps.setInt(2, to.getFuncionario().getIdFuncionario());
            ps.setString(3, to.getTipoPedido());
            ps.setString(4, to.getSituacao());
            ps.setDouble(5, to.getValorPedido());
            ps.setDouble(6, to.getDesconto());
            ps.setDouble(7, to.getValortotal());
            ps.setInt(8, to.getSenha());
            ps.execute();
            c.confirmar();

            sql = "SELECT LAST_INSERT_ID() AS ID";
            ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("ID");
            } else {
                throw new Exception("Erro ao retornar o ID");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void atualizarPedido(PedidoTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "UPDATE pedido SET datahorapedido = ?, idfuncionario = ?, "
                    + "tipopedido = ?, situacao = ?, valorpedido = ?, desconto = ?, "
                    + "valortotal = ?, senha = ? WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getDataHoraBanco());
            ps.setInt(2, to.getFuncionario().getIdFuncionario());
            ps.setString(3, to.getTipoPedido());
            ps.setString(4, to.getSituacao());
            ps.setDouble(5, to.getValorPedido());
            ps.setDouble(6, to.getDesconto());
            ps.setDouble(7, to.getValortotal());
            ps.setInt(8, to.getSenha());
            ps.setInt(9, to.getIdPedido());
            ps.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public int defineSenha() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT count(*) AS senha FROM pedido "
                    + "WHERE datahorapedido >= current_date()";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("senha");
            } else {
                throw new Exception("Erro ao retornar a senha!");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao definir senha do pedido: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void alterar(String situacao, int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "UPDATE pedido SET situacao = ? WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, situacao);
            ps.setInt(2, id);
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

    public void excluir(PedidoTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "DELETE FROM pedido WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getIdPedido());
            ps.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public ArrayList buscarPedidos() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, case when tipopedido = 'E' then "
                    + "'DELIVERY' else 'LOCAL' end as "
                    + "tipopedido, senha, valortotal, datahorapedido, desconto, "
                    + "valorpedido, case when situacao = 'A' then "
                    + "'ABERTO' when situacao = 'P' then 'PAGO' end as situacao FROM pedido "
                    + "WHERE situacao != 'F' AND situacao != 'C' ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<PedidoTO> dados = new ArrayList();
            while (rs.next()) {
                PedidoTO to = new PedidoTO();
                to.setIdPedido(rs.getInt("id"));
                to.setTipoPedido(rs.getString("tipopedido"));
                to.setDataHoraPedido(new java.sql.Date(rs.getTimestamp("datahorapedido").getTime()));
                to.setValortotal(rs.getDouble("valortotal"));
                to.setDesconto(rs.getDouble("desconto"));
                to.setValorPedido(rs.getDouble("valorpedido"));
                to.setSituacao(rs.getString("situacao"));
                to.setSenha(rs.getInt("senha"));
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

    public ArrayList filtroPedidos(String arr) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, case when tipopedido = 'E' then "
                    + "'DELIVERY' else 'LOCAL' end as "
                    + "tipopedido, senha, valortotal, datahorapedido, desconto, "
                    + "valorpedido, case when situacao = 'A' then "
                    + "'ABERTO' when situacao = 'P' then 'PAGO' when "
                    + "situacao = 'F' then 'FINALIZADO' when situacao = 'C' "
                    + "then 'CANCELADO' end as situacao FROM pedido "
                    + "WHERE 1 = 1 " + arr + " ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<PedidoTO> dados = new ArrayList();
            while (rs.next()) {
                PedidoTO to = new PedidoTO();
                to.setIdPedido(rs.getInt("id"));
                to.setTipoPedido(rs.getString("tipopedido"));
                to.setDataHoraPedido(new java.sql.Date(rs.getTimestamp("datahorapedido").getTime()));
                to.setValortotal(rs.getDouble("valortotal"));
                to.setDesconto(rs.getDouble("desconto"));
                to.setValorPedido(rs.getDouble("valorpedido"));
                to.setSituacao(rs.getString("situacao"));
                to.setSenha(rs.getInt("senha"));
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

    public PedidoTO detalhaPedido(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT p.id as idpedido, f.nome as funcionarion, "
                    + "case when p.situacao = 'A' then 'ABERTO' when "
                    + "p.situacao = 'P' then 'PAGO' when p.situacao = 'C' "
                    + "then 'CANCELADO' else 'FINALIZADO' end as situacaoped, "
                    + "p.valortotal, p.valorpedido, p.senha, p.desconto, "
                    + "p.datahorapedido, case when p.tipopedido = 'L' then "
                    + "'LOCAL' else 'DELIVERY' end as tipopedido FROM pedido p"
                    + " JOIN funcionario f on f.id = p.idfuncionario WHERE "
                    + "p.id = " + id + " LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            PedidoTO to = new PedidoTO();
            FuncionarioTO functo = new FuncionarioTO();
            if (rs.next()) {
                to.setIdPedido(rs.getInt("idpedido"));
                to.setDataHoraPedido(new java.sql.Date(rs.getTimestamp("datahorapedido").getTime()));
                to.setValortotal(rs.getDouble("valortotal"));
                to.setDesconto(rs.getDouble("desconto"));
                to.setValorPedido(rs.getDouble("valorpedido"));
                to.setSituacao(rs.getString("situacaoped"));
                to.setSenha(rs.getInt("senha"));
                to.setTipoPedido(rs.getString("tipopedido"));
                functo.setNome(rs.getString("funcionarion"));
                to.setFuncionario(functo);
            }
            return to;
        } catch (Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public ArrayList detalhaPedidoCancelar(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            ProdutoTO to = new ProdutoTO();
            String sql = "SELECT p.id as idproduto, i.valorvenda, p.unidade as unid, "
                    + "p.nome as nomeproduto, p.precovenda, i.qtd as quant FROM itenspedido i JOIN "
                    + "produto p on i.idproduto = p.id WHERE i.idpedido = " + id + "";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList dados = new ArrayList();
            while (rs.next()) {
                ArrayList linha = new ArrayList();
                linha.add(to.getIdProdFormatado(rs.getInt("idproduto")));
                linha.add(rs.getString("nomeproduto"));
                if (rs.getString("unid").equals("UN")) {
                    linha.add(to.getQtdUnidade(rs.getDouble("quant")));
                } else {
                    linha.add(to.getQtdKGL(rs.getDouble("quant")));
                }
                linha.add(ReplaceMoedaRTA.doubleToMoeda(rs.getDouble("valorvenda")));
                dados.add(linha);
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

    public void voltarEstoquePedido(int id, double qtd) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "call sp_finalizapedido_iu (?, ?)";
            PreparedStatement ps = c.getCon().prepareCall(sql);
            ps.setDouble(2, -qtd);
            ps.setInt(1, id);
            ps.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public String estimativaFilaPedidos() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT time_format( SEC_TO_TIME( SUM( TIME_TO_SEC( p.duracaoproducao ) * i.qtd ) ),'%Hh%im%ss') \n"
                    + "AS fila_pedidos FROM produto p JOIN itenspedido i ON i.idproduto = p.id JOIN pedido pd ON pd.id = i.idpedido WHERE pd.situacao != 'C' AND pd.situacao != 'F'";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("fila_pedidos") == null) {
                    return "00h00m00s";
                } else {
                    return rs.getString("fila_pedidos");
                }
            } else {
                return "00h00m00s";
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public String estimativaFilaPedidos(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT time_format( SEC_TO_TIME( SUM( TIME_TO_SEC( p.duracaoproducao ) * i.qtd ) ),'%Hh%im%ss') "
                    + "AS fila_pedidos FROM produto p JOIN itenspedido i ON i.idproduto = p.id JOIN pedido pd ON pd.id = i.idpedido WHERE pd.situacao != 'C' AND pd.situacao != 'F' AND pd.id <= ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("fila_pedidos") == null) {
                    return "00h00m00s";
                } else {
                    return rs.getString("fila_pedidos");
                }
            } else {
                return "00h00m00s";
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
