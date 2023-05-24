package br.com.fs.tm;

import br.com.fs.to.TiposPgtoTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TiposPgtoTableModel extends AbstractTableModel {

    private final String colunas[] = {"Código", "Forma de pagamento", "Situação"};
    private ArrayList<TiposPgtoTO> dados = new ArrayList<>();

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
        TiposPgtoTO to = dados.get(l);
        switch (c) {
            case 0:
                return to.getIdTipoFormatado(to.getIdTipoPgto());
            case 1:
                return to.getTipo();
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

    public void setDados(ArrayList<TiposPgtoTO> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public TiposPgtoTO getRowValue(int l) {
        return dados.get(l);
    }

}
