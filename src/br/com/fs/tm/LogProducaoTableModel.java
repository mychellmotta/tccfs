package br.com.fs.tm;

import br.com.fs.to.LogProducaoTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class LogProducaoTableModel extends AbstractTableModel {
    
    private final String colunas[] = {"Log", "Produção", "Data", "Produto", "Qtd."};
    private ArrayList<LogProducaoTO> dados = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return dados.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int l, int c) {
        LogProducaoTO to = dados.get(l);
        switch (c) {
            case 0:
                return to.getIdFormatado(to.getIdLog());
            case 1:
                return to.getIdFormatado(to.getProducao().getIdproducao());
            case 2:
                try {
                    return to.getDataForm();
                } catch (Exception ex) {
                    Logger.getLogger(LogProducaoTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            case 3:
                return to.getProducao().getProduto().getNome();
            case 4:
                if (to.getProducao().getProduto().getUnidade().equals("UN")) {
                    return to.getProducao().getQtdUnidade(to.getProducao().getQtd());
                } else {
                    return to.getProducao().getQtdKGL(to.getProducao().getQtd());
                }
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }
    
    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }
    
    @Override
    public boolean isCellEditable(int l, int c) {
        return false;
    }
    
    public void setDados(ArrayList<LogProducaoTO> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }
    
    public LogProducaoTO getRowValue(int l) {
        return dados.get(l);
    }
    
}
