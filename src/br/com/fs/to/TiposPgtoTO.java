package br.com.fs.to;

public class TiposPgtoTO {
    private int idTipoPgto;
    private String tipo;
    private String descricao;
    private String situacao;

    public int getIdTipoPgto() {
        return idTipoPgto;
    }

    public void setIdTipoPgto(int idTipoPgto) {
        this.idTipoPgto = idTipoPgto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.trim().toUpperCase();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim().toUpperCase();
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao.trim().toUpperCase();
    }
    
    public void setIdTipoPgto(String id) throws Exception {
        try {
            setIdTipoPgto(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new Exception("Código inválido!" + e.getMessage());
        }
    }
    
    public String getIdTipoFormatado(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }
}
