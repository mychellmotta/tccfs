package br.com.fs.to;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PercaTO {

    private int idPerca;
    private ProdutoTO produto;
    private FuncionarioTO funcionario;
    private Date dataperca;
    private double qtdantes;
    private double qtdperca;
    private String motivo;

    public int getIdPerca() {
        return idPerca;
    }

    public void setIdPerca(int idPerca) {
        this.idPerca = idPerca;
    }

    public ProdutoTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoTO produto) {
        this.produto = produto;
    }

    public Date getDataperca() {
        return dataperca;
    }

    public void setDataperca(Date dataperca) {
        this.dataperca = dataperca;
    }

    public double getQtdantes() {
        return qtdantes;
    }

    public void setQtdantes(double qtdantes) {
        this.qtdantes = qtdantes;
    }

    public double getQtdperca() {
        return qtdperca;
    }

    public void setQtdperca(double qtdperca) {
        this.qtdperca = qtdperca;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo.toUpperCase().trim();
    }

    public String getDataHoraBanco() throws Exception {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(dataperca);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getDataHoraForm() throws Exception {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").format(dataperca);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getIdPercaFormatado(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }

    public FuncionarioTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioTO funcionario) {
        this.funcionario = funcionario;
    }
}
