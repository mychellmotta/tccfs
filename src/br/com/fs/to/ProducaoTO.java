package br.com.fs.to;

import java.util.Date;

public class ProducaoTO {

    private int idproducao;
    private ProdutoTO produto;
    private double qtd;
    private Date datainicio;
    private Date datatermino;
    private boolean segunda;
    private boolean terca;
    private boolean quarta;
    private boolean quinta;
    private boolean sexta;
    private boolean sabado;
    private boolean domingo;
    private String situacao;

    public int getIdproducao() {
        return idproducao;
    }

    public void setIdproducao(int idproducao) {
        this.idproducao = idproducao;
    }

    public ProdutoTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoTO produto) {
        this.produto = produto;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(Date datatermino) {
        this.datatermino = datatermino;
    }

    public boolean isSegunda() {
        return segunda;
    }

    public void setSegunda(boolean segunda) {
        this.segunda = segunda;
    }

    public boolean isTerca() {
        return terca;
    }

    public void setTerca(boolean terca) {
        this.terca = terca;
    }

    public boolean isQuarta() {
        return quarta;
    }

    public void setQuarta(boolean quarta) {
        this.quarta = quarta;
    }

    public boolean isQuinta() {
        return quinta;
    }

    public void setQuinta(boolean quinta) {
        this.quinta = quinta;
    }

    public boolean isSexta() {
        return sexta;
    }

    public void setSexta(boolean sexta) {
        this.sexta = sexta;
    }

    public boolean isSabado() {
        return sabado;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public boolean isDomingo() {
        return domingo;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao.toUpperCase().trim();
    }

    public String getIdProdFormatado(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }

    public int getQtdUnidade(double qtde) {
        int retorno = (int) qtde;
        return retorno;
    }

    public String getQtdKGL(double qtde) {
        String retorno = String.valueOf(qtde).replace(".", ",");
        return retorno;
    }
}
