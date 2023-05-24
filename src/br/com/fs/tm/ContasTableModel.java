package br.com.fs.tm;

import br.com.fs.to.ContaTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ContasTableModel extends AbstractTableModel {

    private final String colunas[] = {"Código", "Nome", "Situação"};
    private ArrayList<ContaTO> dados = new ArrayList<>();

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
        ContaTO to = dados.get(l);
        switch (c) {
            case 0:
                return to.getIdContaForm(to.getIdConta());
            case 1:
                return to.getNome();
            case 2:
                return to.getSituacao();
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

    public void setDados(ArrayList<ContaTO> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public ContaTO getRowValue(int l) {
        return dados.get(l);
    }

}
