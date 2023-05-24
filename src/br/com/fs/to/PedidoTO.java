package br.com.fs.to;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PedidoTO {

    private int idPedido;
    private double valorPedido;
    private double desconto;
    private double valortotal;
    private String tipoPedido;
    private Date dataHoraPedido;
    private String situacao;
    private int senha;
    private FuncionarioTO funcionario;
    private String query = "";

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido.trim().toUpperCase();
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao.trim().toUpperCase();
    }

    public FuncionarioTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioTO funcionario) {
        this.funcionario = funcionario;
    }

    public void setIdPedido(String id) throws Exception {
        try {
            setIdPedido(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new Exception("Código do pedido inválido!" + e.getMessage());
        }
    }

    public String getIdPedFormatado(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }

    public String getDataHoraBanco() throws Exception {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(dataHoraPedido);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getDataHoraForm() throws Exception {
        try {
            return new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm").format(dataHoraPedido);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    public String getSenhaFormatado(int senha) {
        String formatado = String.format("%03d", (senha));
        return (formatado);
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
