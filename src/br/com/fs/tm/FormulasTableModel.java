package br.com.fs.tm;

import br.com.fs.to.FormulaTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class FormulasTableModel extends AbstractTableModel {

    private final String colunas[] = {"Código", "Produto", "Qtde."};
    private ArrayList<FormulaTO> dados = new ArrayList<>();

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
        FormulaTO to = dados.get(l);
        switch (c) {
            case 0:
                return to.getIdFormFormatado(to.getIdFormula());
            case 1:
                return to.getIngrediente().getNome();
            case 2:
                if (to.getIngrediente().getUnidade().equals("UN")) {
                    return to.getQtdUnidade(to.getQtd());
                } else {
                    return to.getQtdKGL(to.getQtd());
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

    public void setDados(ArrayList<FormulaTO> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public FormulaTO getRowValue(int l) {
        return dados.get(l);
    }

}
