package br.com.fs.to;

public class ProdutoTO {
    private int idProduto;
    private String nome;
    private String descricao;
    private String unidade;
    private double precocusto;
    private double precovenda;
    private double qtd;
    private String composto;
    private String tipo;
    private String situacao;
    private String duracaoproducao;
    private String query = "";

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().toUpperCase();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim().toUpperCase();
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade.trim().toUpperCase();
    }

    public double getPrecocusto() {
        return precocusto;
    }

    public void setPrecocusto(double precocusto) {
        this.precocusto = precocusto;
    }

    public double getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(double precovenda) {
        this.precovenda = precovenda;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public String getComposto() {
        return composto;
    }

    public void setComposto(String composto) {
        this.composto = composto.trim().toUpperCase();
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao.trim().toUpperCase();
    }
    
    public void setIdProduto(String id) throws Exception {
        try {
            setIdProduto(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new Exception("Código do produto inválido!" + e.getMessage());
        }
    }
    
    public String getIdProdFormatado(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }
    
    public int getQtdUnidade(double qtde) {
        int retorno = (int) qtde;
        return retorno;
    }
    
    public String getQtdKGL(double qtde){
        String retorno = String.valueOf(qtde).replace(".", ",");
        return retorno;
    }

    public String getDuracaoproducao() {
        return duracaoproducao;
    }

    public void setDuracaoproducao(String duracaoproducao) {
        this.duracaoproducao = duracaoproducao.trim();
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
