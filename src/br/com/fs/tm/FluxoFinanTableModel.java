package br.com.fs.tm;

import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.to.FluxoFinanTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class FluxoFinanTableModel extends AbstractTableModel {

    private final String colunas[] = {"Código", "Pedido", "Data/hora", "Forma pgto", "Conta", "Valor pedido", "Desconto", "Total", "Tipo", "Situação"};
    private ArrayList<FluxoFinanTO> dados = new ArrayList<>();

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
        FluxoFinanTO to = dados.get(l);
        switch (c) {
            case 0:
                return to.getIdFluxoFormatado(to.getIdFluxo());
            case 1:
                return to.getPedido().getIdPedFormatado(to.getPedido().getIdPedido());
            case 2:
                try {
                    return to.getDataHoraForm();
                } catch (Exception ex) {
                    Logger.getLogger(FluxoFinanTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            case 3:
                return to.getTipoPgto().getTipo();
            case 4:
                return to.getConta().getNome();
            case 5:
                return ReplaceMoedaRTA.doubleToMoeda(to.getPedido().getValorPedido());
            case 6:
                return ReplaceMoedaRTA.doubleToMoeda(to.getDesconto());
            case 7:
                return ReplaceMoedaRTA.doubleToMoeda(to.getValorTotal());
            case 8:
                return to.getTipomovimentacao();
            case 9:
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

    public void setDados(ArrayList<FluxoFinanTO> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public FluxoFinanTO getRowValue(int l) {
        return dados.get(l);
    }

}
