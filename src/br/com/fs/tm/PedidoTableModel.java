package br.com.fs.tm;

import br.com.fs.dao.PedidoDAO;
import br.com.fs.gui.DetalhesPedidoEntregaGUI;
import br.com.fs.gui.DetalhesPedidoGUI;
import br.com.fs.gui.PrincipalGUI;
import static br.com.fs.gui.PrincipalGUI.tbPedidos;
import br.com.fs.gui.RecebePedidoEntregaGUI;
import br.com.fs.rta.ButtonColumn;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.to.PedidoTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class PedidoTableModel extends AbstractTableModel {

    private final String colunas[] = {"Código", "Senha", "Tipo do pedido", "Data/hora", "Valor pedido", "Desconto", "Valor total", "Tempo estimado", "Situação", "Detalhes", "Finalizar"};
    private ArrayList<PedidoTO> dados = new ArrayList<>();
    private final PedidoDAO pedidodao = new PedidoDAO();

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
        PedidoTO pedido = dados.get(l);
        switch (c) {
            case 0:
                return pedido.getIdPedFormatado(pedido.getIdPedido());
            case 1:
                return pedido.getSenhaFormatado(pedido.getSenha());
            case 2:
                return pedido.getTipoPedido();
            case 3:
                try {
                    return pedido.getDataHoraForm();
                } catch (Exception ex) {
                    Logger.getLogger(PedidoTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            case 4:
                return ReplaceMoedaRTA.doubleToMoeda(pedido.getValorPedido());
            case 5:
                return ReplaceMoedaRTA.doubleToMoeda(pedido.getDesconto());
            case 6:
                return ReplaceMoedaRTA.doubleToMoeda(pedido.getValortotal());
            case 7:
                if (pedido.getSituacao().equals("FINALIZADO")
                        || pedido.getSituacao().equals("CANCELADO")) {
                    return "–––";
                } else {
                    try {
                        return pedidodao.estimativaFilaPedidos(pedido.getIdPedido());
                    } catch (Exception ex) {
                        Logger.getLogger(PedidoTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            case 8:
                return pedido.getSituacao();
            case 9:
                return montarColunaDetalhes(9);
            case 10:
                return montarColunaFinalizar(10);
        }
        return null;
    }

    public Object montarColunaDetalhes(int coluna) {
        ActionListener acaoEditar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tbPedidos.getSelectedRow();
                int codigo = Integer.parseInt(tbPedidos.getValueAt(row, 0).toString());
                String tipo = String.valueOf(tbPedidos.getValueAt(row, 2).toString());
                if (tipo.equals("LOCAL")) {
                    DetalhesPedidoGUI con = new DetalhesPedidoGUI(codigo);
                    con.setVisible(true);
                } else {
                    DetalhesPedidoEntregaGUI con = new DetalhesPedidoEntregaGUI(codigo);
                    con.setVisible(true);
                }
            }
        };
        ImageIcon iconeScript = new ImageIcon(getClass().getResource("/br/com/fs/img/infoblack.png"));
        return new ButtonColumn(tbPedidos, coluna, iconeScript, acaoEditar);
    }

    public Object montarColunaFinalizar(int coluna) {
        ActionListener acaoEditar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tbPedidos.getSelectedRow();
                int codigo = Integer.parseInt(tbPedidos.getValueAt(row, 0).toString());
                String tipo = String.valueOf(tbPedidos.getValueAt(row, 2).toString());
                String situacao = String.valueOf(tbPedidos.getValueAt(row, 8).toString());
                if ((situacao.equals("ABERTO")) || (situacao.equals("PAGO"))) {
                    int i = JOptionPane.showConfirmDialog(null, "Finalizar pedido " + String.valueOf(codigo) + "?", "Confirmar finalização", JOptionPane.YES_NO_OPTION);
                    if (i == JOptionPane.YES_OPTION) {
                        try {
                            if (tipo.equals("LOCAL")) {
                                PedidoDAO dao = new PedidoDAO();
                                dao.alterar("F", codigo);
                                PrincipalGUI.carregaTabela();
                                JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                RecebePedidoEntregaGUI gui = new RecebePedidoEntregaGUI(codigo);
                                gui.setVisible(true);
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(PedidoTableModel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    if (situacao.equals("CANCELADO")) {
                        JOptionPane.showMessageDialog(null, "Este pedido foi cancelado!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Este pedido já foi finalizado!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        };
        ImageIcon iconeScript = new ImageIcon(getClass().getResource("/br/com/fs/img/checkmark.png"));
        return new ButtonColumn(tbPedidos, coluna, iconeScript, acaoEditar);
    }

    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }

    @Override
    public boolean isCellEditable(int l, int c) {
        return (c >= 9);
    }

    public void setDados(ArrayList<PedidoTO> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public PedidoTO getRowValue(int l) {
        return dados.get(l);
    }

}
