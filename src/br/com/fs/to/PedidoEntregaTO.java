package br.com.fs.to;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class PedidoEntregaTO {
    private int idPedidoEntrega;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String referencia;
    private String nomecliente;
    private double valortroco;
    private String contato;
    private String observacao;
    private PedidoTO pedido;

    public int getIdPedidoEntrega() {
        return idPedidoEntrega;
    }

    public void setIdPedidoEntrega(int idPedidoEntrega) {
        this.idPedidoEntrega = idPedidoEntrega;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro.trim().toUpperCase();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero.trim().toUpperCase();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro.trim().toUpperCase();
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento.trim().toUpperCase();
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente.trim().toUpperCase();
    }

    public double getValortroco() {
        return valortroco;
    }

    public void setValortroco(double valortroco) {
        this.valortroco = valortroco;
    }
    
    public String getContatoFormatado() throws ParseException {
        MaskFormatter mf = new MaskFormatter("(##) ####-####");
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(String.format("%010d", Long.valueOf(contato)));
    }

    public PedidoTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoTO pedido) {
        this.pedido = pedido;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia.trim().toUpperCase();
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato.trim();
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao.trim().toUpperCase();
    }
}
