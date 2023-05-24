package br.com.fs.to;

public class CidadeTO {
    private int idCidade;
    private String nome;
    private String uf;
    private String situacao;

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().toUpperCase();
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf.trim().toUpperCase();
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao.trim().toUpperCase();
    }
    
    public void setIdCidade(String id) throws Exception {
        try {
            setIdCidade(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new Exception("Código da cidade inválido!\n" + e.getMessage());
        }
    }
    
    public String getIdCidadeFormatado(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }
}
