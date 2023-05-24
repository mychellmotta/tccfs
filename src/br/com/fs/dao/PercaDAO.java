package br.com.fs.dao;

import br.com.fs.to.PercaTO;
import java.sql.PreparedStatement;

public class PercaDAO {

    public void inserir(PercaTO to) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "INSERT INTO perca(idproduto, dataperca, qtdantes, qtdperca, motivo, idfuncionario) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getProduto().getIdProduto());
            ps.setDate(2, new java.sql.Date(to.getDataperca().getTime()));
            ps.setDouble(3, to.getQtdantes());
            ps.setDouble(4, to.getQtdperca());
            ps.setString(5, to.getMotivo());
            ps.setInt(6, to.getFuncionario().getIdFuncionario());
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
