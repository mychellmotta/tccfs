package br.com.fs.tm;

import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.to.ItensPedidoTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ItensPedidoTableModel extends AbstractTableModel {

    private final String colunas[] = {"Código", "Produto(s)", "Qtde.", "Valor un."};
    private ArrayList<ItensPedidoTO> dados = new ArrayList<>();

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
        ItensPedidoTO to = dados.get(l);
        switch (c) {
            case 0:
                return to.getProduto().getIdProdFormatado(to.getProduto().getIdProduto());
            case 1:
                return to.getProduto().getNome();
            case 2:
                if (!to.getProduto().getUnidade().equals("UN")) {
                    return to.getQtdKGL(to.getQtd());
                } else {
                    return to.getQtdUnidade(to.getQtd());
                }
            case 3:
                return ReplaceMoedaRTA.doubleToMoeda(to.getValorVenda());
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

    public void setDados(ArrayList<ItensPedidoTO> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public ItensPedidoTO getRowValue(int l) {
        return dados.get(l);
    }

}
