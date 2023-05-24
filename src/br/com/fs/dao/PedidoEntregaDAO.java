package br.com.fs.dao;

import br.com.fs.to.FuncionarioTO;
import br.com.fs.to.PedidoEntregaTO;
import br.com.fs.to.PedidoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoEntregaDAO {

    public void inserir(PedidoEntregaTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "INSERT INTO pedidoentrega(logradouro, numero, bairro, complemento, referencia, nomecliente, valortroco, contato, idpedido, observacao) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getLogradouro());
            ps.setString(2, to.getNumero());
            ps.setString(3, to.getBairro());
            ps.setString(4, to.getComplemento());
            ps.setString(5, to.getReferencia());
            ps.setString(6, to.getNomecliente());
            ps.setDouble(7, to.getValortroco());
            ps.setString(8, to.getContato());
            ps.setInt(9, to.getPedido().getIdPedido());
            ps.setString(10, to.getObservacao());
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

    public PedidoEntregaTO detalhaPedido(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT p.id AS idpedido, f.nome AS funcionarion, "
                    + "CASE WHEN p.situacao = 'A' THEN 'ABERTO' WHEN "
                    + "p.situacao = 'P' THEN 'PAGO' WHEN p.situacao = 'C' "
                    + "THEN 'CANCELADO' ELSE 'FINALIZADO' END AS situacaoped, "
                    + "p.valortotal, p.valorpedido, p.desconto, p.datahorapedido, "
                    + "e.nomecliente, e.numero, p.senha, "
                    + " e.logradouro, e.bairro, e.complemento, e.referencia, "
                    + "e.contato, e.valortroco AS trocoentrega, e.observacao FROM pedido p "
                    + "JOIN funcionario f ON f.id = p.idfuncionario JOIN "
                    + "pedidoentrega e ON e.idpedido = p.id WHERE p.id = ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            PedidoEntregaTO to = new PedidoEntregaTO();
            FuncionarioTO funcionario = new FuncionarioTO();
            PedidoTO pedido = new PedidoTO();
            if (rs.next()) {
                funcionario.setNome(rs.getString("funcionarion"));

                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.setSituacao(rs.getString("situacaoped"));
                pedido.setDesconto(rs.getDouble("desconto"));
                pedido.setValorPedido(rs.getDouble("valorpedido"));
                pedido.setValortotal(rs.getDouble("valortotal"));
                pedido.setSenha(rs.getInt("senha"));
                pedido.setDataHoraPedido(new java.sql.Date(rs.getTimestamp("datahorapedido").getTime()));
                pedido.setFuncionario(funcionario);

                to.setNomecliente(rs.getString("nomecliente"));
                to.setContato(rs.getString("contato"));
                to.setLogradouro(rs.getString("logradouro"));
                to.setNumero(rs.getString("numero"));
                to.setBairro(rs.getString("bairro"));
                to.setComplemento(rs.getString("complemento"));
                to.setReferencia(rs.getString("referencia"));
                to.setValortroco(rs.getDouble("trocoentrega"));
                to.setObservacao(rs.getString("observacao"));
                to.setPedido(pedido);
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

    public PedidoEntregaTO detalhaPedidoSimples(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT logradouro, numero, contato, "
                    + "nomecliente, valortroco FROM pedidoentrega "
                    + "WHERE idpedido = ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            PedidoEntregaTO to = new PedidoEntregaTO();
            if (rs.next()) {
                to.setNomecliente(rs.getString("nomecliente"));
                to.setContato(rs.getString("contato"));
                to.setLogradouro(rs.getString("logradouro"));
                to.setNumero(rs.getString("numero"));
                to.setValortroco(rs.getDouble("valortroco"));
            }
            return to;
        } catch (SQLException e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }
}
