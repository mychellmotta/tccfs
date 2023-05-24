package br.com.fs.tm;

import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.to.ProdutoTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ConsultaProdutosPromocaoTableModel extends AbstractTableModel {

    private final String colunas[] = {"Código", "Nome", "Preço de venda"};
    private ArrayList<ProdutoTO> dados = new ArrayList<>();

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
        ProdutoTO to = dados.get(l);
        switch (c) {
            case 0:
                return to.getIdProdFormatado(to.getIdProduto());
            case 1:
                return to.getNome();
            case 2:
                return ReplaceMoedaRTA.doubleToMoeda(to.getPrecovenda());
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

    public void setDados(ArrayList<ProdutoTO> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public ProdutoTO getRowValue(int l) {
        return dados.get(l);
    }

}
