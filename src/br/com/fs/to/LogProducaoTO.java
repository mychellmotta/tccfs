package br.com.fs.to;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogProducaoTO {
    private int idLog;
    private ProducaoTO producao;
    private Date dataproducao;
    private String query = "";

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public ProducaoTO getProducao() {
        return producao;
    }

    public void setProducao(ProducaoTO producao) {
        this.producao = producao;
    }

    public Date getDataproducao() {
        return dataproducao;
    }

    public void setDataproducao(Date dataproducao) {
        this.dataproducao = dataproducao;
    }
    
    public String getIdFormatado(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }
    
    public String getDataForm() throws Exception {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").format(dataproducao);
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
