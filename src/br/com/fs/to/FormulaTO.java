package br.com.fs.to;

public class FormulaTO {
    private int idFormula;
    private ProdutoTO produtofinal;
    private ProdutoTO ingrediente;
    private double qtd;

    public int getIdFormula() {
        return idFormula;
    }

    public void setIdFormula(int idFormula) {
        this.idFormula = idFormula;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }
    
    public void setIdFormula(String id) throws Exception {
        try {
            setIdFormula(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new Exception("Código da fórmula inválido!\n" + e.getMessage());
        }
    }
    
    public String getIdFormFormatado(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }

    public ProdutoTO getProdutofinal() {
        return produtofinal;
    }

    public void setProdutofinal(ProdutoTO produtofinal) {
        this.produtofinal = produtofinal;
    }

    public ProdutoTO getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(ProdutoTO ingrediente) {
        this.ingrediente = ingrediente;
    }
    
    public int getQtdUnidade(double qtde) {
        int retorno = (int) this.qtd;
        return retorno;
    }
    
    public String getQtdKGL(double qtde){
        String retorno = String.valueOf(qtde).replace(".", ",");
        return retorno;
    }
}
