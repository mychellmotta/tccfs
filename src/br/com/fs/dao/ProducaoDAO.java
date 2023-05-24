package br.com.fs.dao;

import br.com.fs.to.ProducaoTO;
import br.com.fs.to.ProdutoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ProducaoDAO {

    public void inserir(ProducaoTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "INSERT INTO producao(idproduto, datainicio, datatermino, "
                    + "qtd, segunda, terca, quarta, quinta, sexta, sabado, "
                    + "domingo, situacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getProduto().getIdProduto());
            ps.setDate(2, new java.sql.Date(to.getDatainicio().getTime()));
            ps.setDate(3, new java.sql.Date(to.getDatatermino().getTime()));
            ps.setDouble(4, to.getQtd());
            ps.setBoolean(5, to.isSegunda());
            ps.setBoolean(6, to.isTerca());
            ps.setBoolean(7, to.isQuarta());
            ps.setBoolean(8, to.isQuinta());
            ps.setBoolean(9, to.isSexta());
            ps.setBoolean(10, to.isSabado());
            ps.setBoolean(11, to.isDomingo());
            ps.setString(12, to.getSituacao());
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

    public void alterar(ProducaoTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "UPDATE producao set datainicio = ?, datatermino = ?, "
                    + "qtd = ?, segunda = ?, terca = ?, quarta = ?, quinta = ?, "
                    + "sexta = ?, sabado = ?, domingo = ? where id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(to.getDatainicio().getTime()));
            ps.setDate(2, new java.sql.Date(to.getDatatermino().getTime()));
            ps.setDouble(3, to.getQtd());
            ps.setBoolean(4, to.isSegunda());
            ps.setBoolean(5, to.isTerca());
            ps.setBoolean(6, to.isQuarta());
            ps.setBoolean(7, to.isQuinta());
            ps.setBoolean(8, to.isSexta());
            ps.setBoolean(9, to.isSabado());
            ps.setBoolean(10, to.isDomingo());
            ps.setInt(11, to.getIdproducao());
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

    public ArrayList buscarProducoes(String query) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "select p1.id, p2.nome, p2.unidade, p1.qtd, "
                    + "case when p1.situacao = 'A' then 'ATIVO' ELSE 'FINALIZADA' "
                    + "end as situacaoproducao "
                    + "from producao p1 inner join produto p2 "
                    + "on p2.id = p1.idproduto where p2.nome "
                    + "LIKE '%" + query + "%' order by p1.id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProducaoTO> dados = new ArrayList();
            while (rs.next()) {
                ProducaoTO to = new ProducaoTO();
                ProdutoTO produto = new ProdutoTO();
                produto.setNome(rs.getString("nome"));
                produto.setUnidade(rs.getString("unidade"));

                to.setIdproducao(rs.getInt("id"));
                to.setProduto(produto);
                to.setQtd(rs.getDouble("qtd"));
                to.setSituacao(rs.getString("situacaoproducao"));
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

    public ProducaoTO buscarId(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            ProducaoTO to = new ProducaoTO();
            String sql = "select producao.id as producaoid, producao.idproduto, producao.qtd as producaoqtd, producao.datainicio, producao.datatermino, producao.domingo, "
                    + "producao.segunda, producao.terca, producao.quarta, producao.quinta, producao.sexta, producao.sabado, CASE WHEN "
                    + "producao.situacao = 'A' THEN 'ATIVA' ELSE 'FINALIZADA' end as producaosituacao, produto.id, produto.nome, produto.qtd as produtoqtd, "
                    + "produto.precocusto, produto.precovenda, produto.unidade, produto.composto, produto.tipo "
                    + " from producao inner join produto on produto.id = producao.idproduto where producao.id = ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ProdutoTO produto = new ProdutoTO();
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setNome(rs.getString("nome"));
                produto.setQtd(rs.getDouble("produtoqtd"));
                produto.setUnidade(rs.getString("unidade"));
                produto.setTipo(rs.getString("tipo"));
                produto.setComposto(rs.getString("composto"));
                produto.setPrecocusto(rs.getDouble("precocusto"));
                produto.setPrecovenda(rs.getDouble("precovenda"));

                to.setIdproducao(rs.getInt("producaoid"));
                to.setProduto(produto);
                to.setSituacao(rs.getString("producaosituacao"));
                to.setDatainicio(rs.getDate("datainicio"));
                to.setDatatermino(rs.getDate("datatermino"));
                to.setQtd(rs.getDouble("producaoqtd"));
                to.setDomingo(rs.getBoolean("domingo"));
                to.setSegunda(rs.getBoolean("segunda"));
                to.setTerca(rs.getBoolean("terca"));
                to.setQuarta(rs.getBoolean("quarta"));
                to.setQuinta(rs.getBoolean("quinta"));
                to.setSexta(rs.getBoolean("sexta"));
                to.setSabado(rs.getBoolean("sabado"));
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

    public static boolean verifica(int idproduto, int idproducao) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "select null from producao where idproduto = ? and situacao = 'A' and id <> ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, idproduto);
            ps.setInt(2, idproducao);
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

    public void finalizar(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            Date date = new Date();
            String hoje = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String sql = "UPDATE producao SET situacao = 'F', datatermino = '" + hoje + "' WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
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

    public static String weekDay(Calendar cal) {
        return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
    }

    public ArrayList checagemDiaSemana(String dia) throws Exception {
        Conexao c = new Conexao();
        try {
            Date date = new Date();
            String hoje = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String sql = "select id from producao where datainicio <= '" + hoje + "' and datatermino >= '" + hoje + "' and situacao = 'A'";
            switch (dia) {
                case "Segunda-feira":
                    sql += " and segunda = true";
                    break;
                case "Terça-feira":
                    sql += " and terca = true";
                    break;
                case "Quarta-feira":
                    sql += " and quarta = true";
                    break;
                case "Quinta-feira":
                    sql += " and quinta = true";
                    break;
                case "Sexta-feira":
                    sql += " and sexta = true";
                    break;
                case "Sábado":
                    sql += " and sabado = true";
                    break;
                case "Domingo":
                    sql += " and domingo = true";
                    break;
            }
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProducaoTO> dados = new ArrayList();
            while (rs.next()) {
                ProducaoTO to = new ProducaoTO();
                to.setIdproducao(rs.getInt("id"));
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

    public boolean checagemDia(int idproducao) throws Exception {
        Conexao c = new Conexao();
        try {
            Date date = new Date();
            String hoje = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String sql = "select null from logproducao where diaproducao = '" + hoje + "' and idproducao = " + idproducao + "";
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

    public void registrarLog(int idproducao) throws Exception {
        Conexao c = new Conexao();
        try {
            Date date = new Date();
            String sql = "insert into logproducao(idproducao, diaproducao) values (?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, idproducao);
            ps.setDate(2, new java.sql.Date(date.getTime()));
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

    public static boolean verificaSeExistemProducoes() throws Exception {
        Conexao c = new Conexao();
        try {
            Date date = new Date();
            String hoje = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String sql = "SELECT null FROM producao WHERE situacao = 'A' AND datatermino < '" + hoje + "'";
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

    public static void producoesFinalizandoHoje() throws Exception {
        Conexao c = new Conexao();
        try {
            Date date = new Date();
            String hoje = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String sql = "select id from producao "
                    + "WHERE situacao = 'A' AND "
                    + "datatermino < '" + hoje + "'";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProducaoTO to = new ProducaoTO();
                to.setIdproducao(rs.getInt("id"));

                String sql3 = "UPDATE producao SET situacao = 'F' WHERE id = ?";
                PreparedStatement ps3 = c.getCon().prepareStatement(sql3);
                ps3.setInt(1, to.getIdproducao());
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
}
