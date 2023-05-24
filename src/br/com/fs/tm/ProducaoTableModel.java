package br.com.fs.tm;

import br.com.fs.to.ProducaoTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ProducaoTableModel extends AbstractTableModel {

    private final String colunas[] = {"Código", "Produto", "Qtde.", "Situação"};
    private ArrayList<ProducaoTO> dados = new ArrayList<>();

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
        ProducaoTO to = dados.get(l);
        switch (c) {
            case 0:
                return to.getIdProdFormatado(to.getIdproducao());
            case 1:
                return to.getProduto().getNome();
            case 2:
                if (to.getProduto().getUnidade().equals("UN")) {
                    return to.getQtdUnidade(to.getQtd());
                } else {
                    return to.getQtdKGL(to.getQtd());
                }
            case 3:
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

    public void setDados(ArrayList<ProducaoTO> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public ProducaoTO getRowValue(int l) {
        return dados.get(l);
    }

}
