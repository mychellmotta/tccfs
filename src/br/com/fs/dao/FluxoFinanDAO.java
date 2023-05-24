package br.com.fs.dao;

import br.com.fs.to.ContaTO;
import br.com.fs.to.FluxoFinanTO;
import br.com.fs.to.PedidoTO;
import br.com.fs.to.TiposPgtoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FluxoFinanDAO {

    public ArrayList buscarTodos(String par) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT f.id, f.datahora, f.valortotal, f.desconto, f.idpedido, "
                    + "case when f.tipomovimentacao = 'E' then 'ENTRADA' else "
                    + "'SAÍDA' end as tipomovimentacao, case when f.situacao = 'P'"
                    + " then 'RECEBIDO' when f.situacao = 'A' then 'ABERTO' when f.situacao = 'E' then 'PAGO' "
                    + "end as situacao, c.nome as nomeconta, t.tipo as formapgto, "
                    + "p.valorpedido as valorpedido FROM fluxofinan f JOIN "
                    + "contas c ON c.id = f.idconta JOIN "
                    + "tipospgto t ON t.id = f.idtipospgto JOIN pedido p ON p.id = f.idpedido WHERE 1 = 1 "
                    + par + " "
                    + "ORDER BY f.id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<FluxoFinanTO> dados = new ArrayList();
            while (rs.next()) {
                FluxoFinanTO to = new FluxoFinanTO();
                PedidoTO pedido = new PedidoTO();
                ContaTO conta = new ContaTO();
                TiposPgtoTO forma = new TiposPgtoTO();

                to.setIdFluxo(rs.getInt("id"));
                to.setDatahora(new java.sql.Date(rs.getTimestamp("datahora").getTime()));
                to.setSituacao(rs.getString("situacao"));
                to.setDesconto(rs.getDouble("desconto"));
                to.setTipomovimentacao(rs.getString("tipomovimentacao"));
                to.setValorTotal(rs.getDouble("valortotal"));
                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.setValorPedido(rs.getDouble("valorpedido"));
                to.setPedido(pedido);
                conta.setNome(rs.getString("nomeconta"));
                to.setConta(conta);
                forma.setTipo(rs.getString("formapgto"));
                to.setTipoPgto(forma);

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

    public double buscarTrocoEntrega() throws Exception {
        Conexao c = new Conexao();
        try {
            Date date = new Date();
            String data = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String sql = "SELECT sum(pe.valortroco) as trocop FROM fluxofinan f "
                    + "JOIN pedido p ON f.idpedido = p.id JOIN "
                    + "pedidoentrega pe ON pe.idpedido = p.id WHERE f.datahora >= '" + data + "' AND f.situacao = 'A'";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("trocop");
            }
            return 0;
        } catch (SQLException e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public double caixaTotal() throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT ((SELECT SUM(valortotal) FROM fluxofinan "
                    + "WHERE situacao = 'P' AND tipomovimentacao = 'E' "
                    + "AND idconta = 1) - (IFNULL((SELECT SUM(valortotal) "
                    + "FROM fluxofinan WHERE situacao = 'E' AND "
                    + "tipomovimentacao = 'S' AND idconta = 1),0))) AS total "
                    + "FROM fluxofinan LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("total");
            }
            return 0;
        } catch (SQLException e) {
            throw new Exception("Erro: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void inserir(FluxoFinanTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "INSERT INTO fluxofinan(idpedido, valortotal, valorpago, troco, desconto, tipomovimentacao, datahora, idtipospgto, idconta, situacao) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getPedido().getIdPedido());
            ps.setDouble(2, to.getValorTotal());
            ps.setDouble(3, to.getValorPago());
            ps.setDouble(4, to.getTroco());
            ps.setDouble(5, to.getDesconto());
            ps.setString(6, to.getTipomovimentacao());
            ps.setString(7, to.getDataHoraBanco());
            ps.setInt(8, to.getTipoPgto().getIdTipoPgto());
            ps.setInt(9, to.getConta().getIdConta());
            ps.setString(10, to.getSituacao());
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

    public void cancelamentoPedido(FluxoFinanTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "INSERT INTO fluxofinan(idpedido, valortotal, valorpago, troco, desconto, tipomovimentacao, datahora, idtipospgto, idconta, situacao) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getPedido().getIdPedido());
            ps.setDouble(2, to.getValorTotal());
            ps.setDouble(3, to.getValorPago());
            ps.setDouble(4, 0);
            ps.setDouble(5, 0);
            ps.setString(6, to.getTipomovimentacao());
            ps.setString(7, to.getDataHoraBanco());
            ps.setInt(8, 1);
            ps.setInt(9, 1);
            ps.setString(10, to.getSituacao());
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

    public void inserirEntrega(FluxoFinanTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "INSERT INTO fluxofinan(idpedido, valortotal, tipomovimentacao, datahora, situacao, idconta, idtipospgto, desconto) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getPedido().getIdPedido());
            ps.setDouble(2, to.getValorTotal());
            ps.setString(3, to.getTipomovimentacao());
            ps.setString(4, to.getDataHoraBanco());
            ps.setString(5, to.getSituacao());
            ps.setInt(6, to.getConta().getIdConta());
            ps.setInt(7, to.getTipoPgto().getIdTipoPgto());
            ps.setDouble(8, to.getDesconto());
            ps.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception("Erro FLUXOFINANDAO: " + e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void alterar(String situacao, int id, double troco, double desconto, double total, double pago) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "UPDATE fluxofinan SET situacao = ?, troco = ?, "
                    + "desconto = ?, valortotal = ?, valorpago = ? WHERE idpedido = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, situacao);
            ps.setDouble(2, troco);
            ps.setDouble(3, desconto);
            ps.setDouble(4, total);
            ps.setDouble(5, pago);
            ps.setInt(6, id);
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

    public static FluxoFinanTO detalhaPedido(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT f.desconto, f.valortotal, c.nome as nomeconta, "
                    + "t.tipo FROM fluxofinan f JOIN pedido p on f.idpedido = p.id "
                    + "JOIN contas c on c.id = f.idconta JOIN tipospgto t on t.id = f.idtipospgto "
                    + "WHERE p.id = " + id + " LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            FluxoFinanTO to = new FluxoFinanTO();
            ContaTO conta = new ContaTO();
            TiposPgtoTO pgto = new TiposPgtoTO();
            while (rs.next()) {
                to.setDesconto(rs.getDouble("desconto"));
                to.setValorTotal(rs.getDouble("valortotal"));
                conta.setNome(rs.getString("nomeconta"));
                to.setConta(conta);
                pgto.setTipo(rs.getString("tipo"));
                to.setTipoPgto(pgto);
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

    public FluxoFinanTO detalhaPedidoFluxo(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT f.id as idfluxo, f.desconto, f.valortotal, c.nome as nomeconta, "
                    + "t.tipo, f.datahora, case when f.tipomovimentacao = 'E' then 'ENTRADA' else "
                    + "'SAÍDA' end as tipomovimentacao, case when f.situacao = 'P'"
                    + " then 'RECEBIDO' when f.situacao = 'A' then 'ABERTO' when f.situacao = 'E' then 'PAGO' "
                    + "end as situacao FROM fluxofinan f JOIN pedido p on f.idpedido = p.id "
                    + "JOIN contas c on c.id = f.idconta JOIN tipospgto t on t.id = f.idtipospgto "
                    + "WHERE f.id = " + id + " LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            FluxoFinanTO to = new FluxoFinanTO();
            ContaTO conta = new ContaTO();
            TiposPgtoTO pgto = new TiposPgtoTO();
            while (rs.next()) {
                to.setIdFluxo(rs.getInt("idfluxo"));
                to.setValorTotal(rs.getDouble("valortotal"));
                conta.setNome(rs.getString("nomeconta"));
                to.setConta(conta);
                pgto.setTipo(rs.getString("tipo"));
                to.setTipoPgto(pgto);
                to.setSituacao(rs.getString("situacao"));
                to.setDatahora(new java.sql.Date(rs.getTimestamp("datahora").getTime()));
                to.setTipomovimentacao(rs.getString("tipomovimentacao"));
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

    public void transfereConta(int conta, int pedido) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "UPDATE fluxofinan SET idconta = ? WHERE idpedido = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, conta);
            ps.setInt(2, pedido);
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
}
