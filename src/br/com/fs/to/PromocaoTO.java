package br.com.fs.to;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PromocaoTO {

    private int idPromocao;
    private ProdutoTO produto;
    private double valorVenda;
    private double valorPromocao;
    private Date inicio;
    private Date termino;
    private String situacao;
    private String query = "";

    public int getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }

    public ProdutoTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoTO produto) {
        this.produto = produto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorPromocao() {
        return valorPromocao;
    }

    public void setValorPromocao(double valorPromocao) {
        this.valorPromocao = valorPromocao;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao.trim().toUpperCase();
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String value, String lista) {
        if (value.trim().length() > 0) {
            query = query + " " + lista;
        }
        this.query = query;
    }

    public void setIdPromocao(String id) throws Exception {
        try {
            setIdPromocao(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new Exception("Código da promoção inválido!" + e.getMessage());
        }
    }

    public String getIdPromoFormatado(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }
    
    public String getDataFormInicio() throws Exception {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").format(inicio);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public String getDataFormTerm() throws Exception {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").format(termino);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
