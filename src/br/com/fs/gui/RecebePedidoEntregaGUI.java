package br.com.fs.gui;

import br.com.fs.dao.FluxoFinanDAO;
import br.com.fs.dao.PedidoDAO;
import br.com.fs.dao.PedidoEntregaDAO;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.to.PedidoEntregaTO;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class RecebePedidoEntregaGUI extends javax.swing.JDialog {

    private PedidoEntregaTO pedidoTO = new PedidoEntregaTO();
    private DetalhesPedidoEntregaGUI parent;
    private FluxoFinanGUI parent2;
    private PrincipalGUI parent3;

    public RecebePedidoEntregaGUI(DetalhesPedidoEntregaGUI pai, PedidoEntregaTO pedido) {
        super();
        initComponents();
        parent = pai;
        pedidoTO = pedido;
        this.setLocationRelativeTo(null);
        this.construtor();
    }

    public RecebePedidoEntregaGUI(FluxoFinanGUI pai, int pedido) {
        super();
        initComponents();
        parent2 = pai;
        try {
            PedidoEntregaDAO dao = new PedidoEntregaDAO();
            pedidoTO = dao.detalhaPedido(pedido);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.setLocationRelativeTo(null);
        this.construtor();
    }

    public RecebePedidoEntregaGUI(PrincipalGUI pai, int pedido) {
        super();
        initComponents();
        parent3 = pai;
        try {
            PedidoEntregaDAO dao = new PedidoEntregaDAO();
            pedidoTO = dao.detalhaPedido(pedido);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.setLocationRelativeTo(null);
        this.construtor();
    }

    public RecebePedidoEntregaGUI(int pedido) {
        super();
        initComponents();
        try {
            PedidoEntregaDAO dao = new PedidoEntregaDAO();
            pedidoTO = dao.detalhaPedido(pedido);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.setLocationRelativeTo(null);
        this.construtor();
    }

    private void construtor() {
        lbCodPedido.setText(pedidoTO.getPedido().getIdPedFormatado(pedidoTO.getPedido().getIdPedido()));
        lbValorTotal.setText(ReplaceMoedaRTA.doubleToMoeda(pedidoTO.getPedido().getValortotal()));
        lbTrocoLevado.setText(ReplaceMoedaRTA.doubleToMoeda(pedidoTO.getValortroco()));
        lbFinal.setText(ReplaceMoedaRTA.doubleToMoeda(pedidoTO.getValortroco() + pedidoTO.getPedido().getValortotal()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbCodPedido = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbValorTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbTrocoLevado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbFinal = new javax.swing.JLabel();
        btFechar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Receber pedido");
        setModal(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes de pagamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Pedido:");

        lbCodPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCodPedido.setText("000");

        jLabel2.setText("Valor total:");

        lbValorTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbValorTotal.setForeground(new java.awt.Color(0, 102, 0));
        lbValorTotal.setText("R$ 0,00");

        jLabel4.setText("Troco levado:");

        lbTrocoLevado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTrocoLevado.setForeground(new java.awt.Color(255, 0, 0));
        lbTrocoLevado.setText("R$ 0,00");

        jLabel5.setText("Adicionar ao caixa:");

        lbFinal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbFinal.setForeground(new java.awt.Color(0, 102, 0));
        lbFinal.setText("R$ 0,00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodPedido)
                    .addComponent(lbValorTotal)
                    .addComponent(lbTrocoLevado)
                    .addComponent(lbFinal))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbCodPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbValorTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbTrocoLevado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbFinal))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFechar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFechar)
                    .addComponent(btConfirmar))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        try {
            PedidoDAO pedidodao = new PedidoDAO();
            FluxoFinanDAO fluxodao = new FluxoFinanDAO();
            try {
                pedidodao.alterar("F", pedidoTO.getPedido().getIdPedido());
                fluxodao.alterar("P", pedidoTO.getPedido().getIdPedido(), pedidoTO.getValortroco(), pedidoTO.getPedido().getDesconto(), pedidoTO.getPedido().getValortotal(), ReplaceMoedaRTA.moedaToDouble(lbFinal.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao receber pedido: " + e.getMessage());
            }
            this.dispose();
            if (parent != null) {
                parent.dispose();
            } else if (parent2 != null) {
                parent2.atualizarDetalhes();
            } else if (parent3 != null) {
                parent3.repaint();
            }
            PrincipalGUI.carregaTabela();
            JOptionPane.showMessageDialog(null, "Transação concluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbCodPedido;
    private javax.swing.JLabel lbFinal;
    private javax.swing.JLabel lbTrocoLevado;
    private javax.swing.JLabel lbValorTotal;
    // End of variables declaration//GEN-END:variables
}
