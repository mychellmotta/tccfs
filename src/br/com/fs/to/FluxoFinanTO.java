package br.com.fs.to;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FluxoFinanTO {

    private int idFluxo;
    private PedidoTO pedido;
    private double valorTotal;
    private double valorPago;
    private double troco;
    private double desconto;
    private String tipomovimentacao;
    private Date datahora;
    private TiposPgtoTO tipoPgto;
    private ContaTO conta;
    private String situacao;
    private String query = "";

    public int getIdFluxo() {
        return idFluxo;
    }

    public void setIdFluxo(int idFluxo) {
        this.idFluxo = idFluxo;
    }

    public PedidoTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoTO pedido) {
        this.pedido = pedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorPago() {
        return valorPago;
    }

    public ContaTO getConta() {
        return conta;
    }

    public void setConta(ContaTO conta) {
        this.conta = conta;
    }

    public String getTipomovimentacao() {
        return tipomovimentacao;
    }

    public void setTipomovimentacao(String tipomovimentacao) {
        this.tipomovimentacao = tipomovimentacao.trim().toUpperCase();
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }
    
    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public TiposPgtoTO getTipoPgto() {
        return tipoPgto;
    }

    public void setTipoPgto(TiposPgtoTO tipoPgto) {
        this.tipoPgto = tipoPgto;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao.trim().toUpperCase();
    }

    public void setIdFluxo(String id) throws Exception {
        try {
            setIdFluxo(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new Exception("Código inválido!" + e.getMessage());
        }
    }

    public String getIdFluxoFormatado(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }
    
    public String getDataHoraBanco() throws Exception {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(datahora);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public String getDataHoraForm() throws Exception {
        try {
            return new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm").format(datahora);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
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
}
