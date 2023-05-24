package br.com.fs.to;

public class ContaTO {
    private int idConta;
    private String nome;
    private String situacao;

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().toUpperCase();
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao.trim().toUpperCase();
    }
    
    public void setIdConta(String id) throws Exception {
        try {
            setIdConta(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new Exception("Código inválido!" + e.getMessage());
        }
    }

    public String getIdContaForm(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }
}
