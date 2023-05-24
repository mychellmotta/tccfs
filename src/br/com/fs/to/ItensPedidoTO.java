package br.com.fs.to;

public class ItensPedidoTO {

    private int idItensPedido;
    private ProdutoTO produto;
    private double qtd;
    private double valorVenda;
    private PedidoTO pedido;

    public int getIdItensPedido() {
        return idItensPedido;
    }

    public void setIdItensPedido(int idItensPedido) {
        this.idItensPedido = idItensPedido;
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

    public PedidoTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoTO pedido) {
        this.pedido = pedido;
    }

    public int getQtdUnidade(double qtde) {
        int retorno = (int) this.qtd;
        return retorno;
    }
    
    public String getQtdKGL(double qtde){
        String retorno = String.valueOf(qtde).replace(".", ",");
        return retorno;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
}
