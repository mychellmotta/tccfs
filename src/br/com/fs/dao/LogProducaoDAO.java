package br.com.fs.dao;

import br.com.fs.to.LogProducaoTO;
import br.com.fs.to.ProducaoTO;
import br.com.fs.to.ProdutoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogProducaoDAO {

    public ArrayList buscarLogs(String query) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT l.id, l.idproducao, l.diaproducao, p.nome, p.unidade, pr.qtd FROM"
                    + " logproducao l INNER JOIN producao pr ON pr.id = l.idproducao"
                    + " INNER JOIN produto p ON p.id = pr.idproduto WHERE 1 = 1 "+query+" ORDER BY l.id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<LogProducaoTO> dados = new ArrayList();
            while (rs.next()){
                LogProducaoTO to = new LogProducaoTO();
                ProducaoTO producao = new ProducaoTO();
                ProdutoTO produto = new ProdutoTO();
                
                produto.setNome(rs.getString("nome"));
                produto.setUnidade(rs.getString("unidade"));
                
                producao.setProduto(produto);
                producao.setIdproducao(rs.getInt("idproducao"));
                producao.setQtd(rs.getDouble("qtd"));
                
                to.setIdLog(rs.getInt("id"));
                to.setProducao(producao);
                to.setDataproducao(rs.getDate("diaproducao"));
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
}
