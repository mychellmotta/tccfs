package br.com.fs.tm;

import br.com.fs.to.PromocaoTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class PromocaoTableModel extends AbstractTableModel {

    private final String colunas[] = {"Código", "Produto", "Início", "Término"};
    private ArrayList<PromocaoTO> dados = new ArrayList<>();

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
        PromocaoTO to = dados.get(l);
        switch (c) {
            case 0:
                return to.getIdPromoFormatado(to.getIdPromocao());
            case 1:
                return to.getProduto().getNome();
            case 2:
                try {
                    return to.getDataFormInicio();
                } catch (Exception ex) {
                    Logger.getLogger(PromocaoTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            case 3:
                try {
                    return to.getDataFormTerm();
                } catch (Exception ex) {
                    Logger.getLogger(PromocaoTableModel.class.getName()).log(Level.SEVERE, null, ex);
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

    public void setDados(ArrayList<PromocaoTO> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public PromocaoTO getRowValue(int l) {
        return dados.get(l);
    }

}
