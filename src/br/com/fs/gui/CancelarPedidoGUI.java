package br.com.fs.gui;

import br.com.fs.dao.FluxoFinanDAO;
import br.com.fs.dao.ItensPedidoDAO;
import br.com.fs.dao.PedidoDAO;
import br.com.fs.dao.ProdutoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.Mascaras;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.to.FluxoFinanTO;
import br.com.fs.to.PedidoTO;
import br.com.fs.to.ProdutoTO;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CancelarPedidoGUI extends javax.swing.JDialog {

    private PedidoTO pedido = new PedidoTO();
    private FluxoFinanTO finan = new FluxoFinanTO();
    private ArrayList<ProdutoTO> produtos;
    private final PedidoDAO dao = new PedidoDAO();
    private final Mascaras mascaras = new Mascaras();
    private final ProdutoDAO produtodao = new ProdutoDAO();
    private ProdutoTO produtoto = new ProdutoTO();

    public CancelarPedidoGUI(int codigo) {
        super();
        initComponents();
        this.setSize(524, 360);
        this.construtor(codigo);
    }

    private void construtor(int codigo) {
        this.setLocationRelativeTo(null);
        try {
            pedido = (PedidoTO) dao.detalhaPedido(codigo);
            finan = (FluxoFinanTO) FluxoFinanDAO.detalhaPedido(codigo);
            produtos = dao.detalhaPedidoCancelar(codigo);

            lbCodigoPedido.setText(pedido.getIdPedFormatado(pedido.getIdPedido()) + " - " + pedido.getSenhaFormatado(pedido.getSenha()));
            lbFuncionario.setText(pedido.getFuncionario().getNome());
            lbSituacao.setText(pedido.getSituacao());
            lbValorPedido.setText(ReplaceMoedaRTA.doubleToMoeda(pedido.getValorPedido()));
            lbDataHora.setText(pedido.getDataHoraForm());
            lbTipoConta.setText(finan.getTipoPgto().getTipo() + " em " + finan.getConta().getNome());
            lbDesconto.setText(ReplaceMoedaRTA.doubleToMoeda(finan.getDesconto()));
            lbValorTotal.setText(ReplaceMoedaRTA.doubleToMoeda(finan.getValorTotal()));

            this.atualizarBusca(produtos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar a tabela!\nErro: " + e.getMessage());
        }
    }

    private void atualizarBusca(ArrayList listaProdutos) {
        try {
            String[] titulos = {"Código", "Produto(s)", "Qtde.", "Valor unit.", "Selecionar"};
            tbItens.setModel(new DefaultTableModel(titulos, 0) {

                @Override
                public Class getColumnClass(int col) {
                    if (col == 4) {
                        return Boolean.class;
                    } else {
                        return String.class;
                    }
                }

                @Override
                public boolean isCellEditable(int l, int c) {
                    return (c == 4) || (c == 2);
                }
            });

            DefaultTableModel dtm = (DefaultTableModel) tbItens.getModel();
            listaProdutos.stream().forEach((var) -> {
                dtm.addRow(((ArrayList) var).toArray());
            });
            spItens.setBorder(null);
            ((DefaultTableCellRenderer) tbItens.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbItens.setDefaultRenderer(Object.class, new CellRenderer());
            tbItens.setColumnSelectionAllowed(false);
            tbItens.getTableHeader().setReorderingAllowed(false);
            tbItens.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbItens.getColumnModel().getColumn(0).setResizable(false);
            tbItens.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbItens.getColumnModel().getColumn(0).setMaxWidth(60);
            tbItens.getColumnModel().getColumn(1).setResizable(false);
            tbItens.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbItens.getColumnModel().getColumn(2).setResizable(false);

            tbItens.getColumnModel().getColumn(3).setResizable(false);
            tbItens.getColumnModel().getColumn(4).setResizable(false);
            tbItens.setCursor(new Cursor(Cursor.HAND_CURSOR));

            int linhas = tbItens.getRowCount();
            JTextField tfquantidade = new JTextField();
            tfquantidade.setMargin(new Insets(0, 25, 0, 0));
            for (int i = 0; i < linhas; i++) {
                produtoto = (ProdutoTO) produtodao.buscarId(Integer.parseInt(tbItens.getValueAt(i, 0).toString()));
                if (produtoto.getUnidade().equals("UN")) {
                    tfquantidade.setDocument(mascaras.somenteNumero());
                    tbItens.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(tfquantidade));
                } else {
                    tfquantidade.setDocument(mascaras.permiteVirgula());
                    tbItens.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(tfquantidade));
                }
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JPanel();
        pnCorpo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbCodigoPedido = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbDataHora = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbSituacao = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbFuncionario = new javax.swing.JLabel();
        lbValorPedido = new javax.swing.JLabel();
        lbDesconto = new javax.swing.JLabel();
        spItens = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        lbValorTotal = new javax.swing.JLabel();
        lbTipoConta = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        btAjuda = new javax.swing.JToggleButton();
        pnAjuda = new javax.swing.JPanel();
        lbAjuda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cancelamento de pedido");
        setModal(true);
        setResizable(false);

        pnCorpo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Pedido:");

        lbCodigoPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCodigoPedido.setText("000");

        jLabel2.setText("Data/hora:");

        lbDataHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDataHora.setText("00/00/00 00:00");

        jLabel3.setText("Situação:");

        lbSituacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSituacao.setText("SITUAÇÃO");

        jLabel7.setText("Desconto:");

        jLabel6.setText("Valor do pedido:");

        jLabel4.setText("Operador:");

        lbFuncionario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbFuncionario.setText("FUNCIONÁRIO");
        lbFuncionario.setMaximumSize(new java.awt.Dimension(218, 14));

        lbValorPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbValorPedido.setText("R$ 0,00");

        lbDesconto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDesconto.setText("R$ 0,00");

        spItens.setBackground(new java.awt.Color(255, 255, 255));
        spItens.setBorder(null);
        spItens.setForeground(new java.awt.Color(255, 255, 255));

        tbItens.setAutoCreateRowSorter(true);
        tbItens.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbItens.setGridColor(new java.awt.Color(255, 255, 255));
        tbItens.setShowHorizontalLines(false);
        tbItens.setShowVerticalLines(false);
        spItens.setViewportView(tbItens);

        lbValorTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbValorTotal.setForeground(new java.awt.Color(0, 102, 0));
        lbValorTotal.setText("R$ 0,00");

        lbTipoConta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTipoConta.setText("FORMA em CONTA");

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addComponent(spItens)
                        .addContainerGap())
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCodigoPedido)
                            .addComponent(lbDataHora)
                            .addComponent(lbSituacao))
                        .addGap(26, 26, 26)
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCorpoLayout.createSequentialGroup()
                                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbValorPedido)
                                    .addComponent(lbDesconto))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lbFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(64, 64, 64))
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addComponent(lbTipoConta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
                        .addComponent(lbValorTotal)
                        .addContainerGap())))
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbCodigoPedido)
                    .addComponent(jLabel4)
                    .addComponent(lbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbDataHora)
                    .addComponent(jLabel6)
                    .addComponent(lbValorPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbSituacao)
                    .addComponent(jLabel7)
                    .addComponent(lbDesconto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spItens, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipoConta)
                    .addComponent(lbValorTotal)))
        );

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        btAjuda.setText("Exibir ajuda");
        btAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjudaActionPerformed(evt);
            }
        });

        pnAjuda.setBorder(javax.swing.BorderFactory.createTitledBorder("Dicas quentes"));

        lbAjuda.setText("<html>• Selecione apenas os produtos que retornarão ao estoque;<br>\n• No caso de um produto composto, os produtos que o compõem retornarão ao estoque;<br>\n• Você pode alterar a quantidade diretamente na tabela, se necessário;<br>\n• Ao clicar em confirmar você decidirá se haverá estorno de caixa e a quantia a ser devolvida.</html>");

        javax.swing.GroupLayout pnAjudaLayout = new javax.swing.GroupLayout(pnAjuda);
        pnAjuda.setLayout(pnAjudaLayout);
        pnAjudaLayout.setHorizontalGroup(
            pnAjudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAjudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAjuda)
                .addContainerGap())
        );
        pnAjudaLayout.setVerticalGroup(
            pnAjudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAjudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnAjuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addComponent(btAjuda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)))
                .addContainerGap())
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAjuda)
                    .addComponent(btConfirmar)
                    .addComponent(btCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        try {
            int linhas = tbItens.getRowCount();
            ArrayList selecionados = new ArrayList();
            ArrayList qtde = new ArrayList();
            double valorItens = 0;
            for (int i = 0; i < linhas; i++) {
                if (tbItens.getValueAt(i, 4) != null) {
                    if (tbItens.getValueAt(i, 2).toString().length() <= 0) {
                        JOptionPane.showMessageDialog(null, "Informe a quantidade do produto # " + tbItens.getValueAt(i, 0).toString() + "!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (Double.parseDouble(tbItens.getValueAt(i, 2).toString().replace(",", ".")) > ItensPedidoDAO.retornaQtd(Integer.parseInt(tbItens.getValueAt(i, 0).toString()), pedido.getIdPedido())) {
                        JOptionPane.showMessageDialog(null, "Quantidade do produto " + tbItens.getValueAt(i, 0).toString() + " maior que a da venda!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    selecionados.add(Integer.valueOf(tbItens.getValueAt(i, 0).toString()));
                    qtde.add(Double.valueOf(tbItens.getValueAt(i, 2).toString().replace(",", ".")));
                    valorItens = valorItens + (ReplaceMoedaRTA.moedaToDouble(tbItens.getValueAt(i, 3).toString()) * Double.parseDouble(tbItens.getValueAt(i, 2).toString().replace(",", ".")));
                }
            }
            ConfirmaCancelarPedidoGUI gui = new ConfirmaCancelarPedidoGUI(this, pedido, finan, selecionados, qtde, valorItens);
            gui.setVisible(true);
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Erro ao cancelar pedido!\nErro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cancelar pedido!\nErro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjudaActionPerformed
        if (btAjuda.isSelected()) {
            this.setSize(524, 465);
            btAjuda.setText("Ocultar ajuda");
        } else {
            this.setSize(524, 360);
            btAjuda.setText("Exibir ajuda");
        }
    }//GEN-LAST:event_btAjudaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btAjuda;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbAjuda;
    private javax.swing.JLabel lbCodigoPedido;
    private javax.swing.JLabel lbDataHora;
    private javax.swing.JLabel lbDesconto;
    private javax.swing.JLabel lbFuncionario;
    private javax.swing.JLabel lbSituacao;
    private javax.swing.JLabel lbTipoConta;
    private javax.swing.JLabel lbValorPedido;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JPanel pnAjuda;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JScrollPane spItens;
    private javax.swing.JTable tbItens;
    // End of variables declaration//GEN-END:variables
}
