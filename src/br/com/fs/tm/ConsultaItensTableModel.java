package br.com.fs.tm;

import br.com.fs.dao.ProdutoDAO;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.to.ProdutoTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ConsultaItensTableModel extends AbstractTableModel {

    private final String colunas[] = {"Código", "Nome", "Em estoque", "Preço de venda"};
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
        ProdutoTO produto = dados.get(l);
        ProdutoDAO dao = new ProdutoDAO();
        switch (c) {
            case 0:
                return produto.getIdProdFormatado(produto.getIdProduto());
            case 1:
                return produto.getNome();
            case 2:
                if (produto.getQtd() > 0) {
                    if (!produto.getUnidade().equals("UN")) {
                        return produto.getQtdKGL(produto.getQtd());
                    } else {
                        return produto.getQtdUnidade(produto.getQtd());
                    }
                } else if ((produto.getQtd() <= 0) && (produto.getComposto().equals("N"))) {
                    return "NÃO";
                } else {
                    try {
                        if (dao.checaDisponibilidade(produto.getIdProduto()) == true) {
                            return "NÃO, FALTAM ING.";
                        } else {
                            return dao.estoqueComposto(produto.getIdProduto());
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(ConsultaItensTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            case 3: {
                try {
                    return ReplaceMoedaRTA.doubleToMoeda(ProdutoDAO.precoProduto(produto.getIdProduto()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao construir tabela!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
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

    public void setDados(ArrayList<ProdutoTO> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public ProdutoTO getRowValue(int l) {
        return dados.get(l);
    }

}
