package br.com.fs.gui;

import br.com.fs.dao.ContasDAO;
import br.com.fs.dao.FluxoFinanDAO;
import br.com.fs.dao.PedidoDAO;
import br.com.fs.dao.TiposPgtoDAO;
import br.com.fs.rta.ImprimeTicketRTA;
import br.com.fs.rta.MascarasDouble;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.to.ContaTO;
import br.com.fs.to.FluxoFinanTO;
import br.com.fs.to.PedidoTO;
import br.com.fs.to.TiposPgtoTO;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class RecebePedidoGUI extends javax.swing.JDialog {

    private PedidoTO pedidoTO = new PedidoTO();
    private PedidosGUI parent = new PedidosGUI();

    public RecebePedidoGUI(PedidosGUI pai, PedidoTO pedido) {
        super();
        initComponents();
        parent = pai;
        pedidoTO = pedido;
        this.setLocationRelativeTo(null);
        tfValorPago.setDocument(new MascarasDouble(9));
        tfValorPago.setText("0,00");
        lbValorTotal.setText(ReplaceMoedaRTA.doubleToMoeda(pedido.getValortotal()));
        lbCodigo.setText(pedido.getIdPedFormatado(pedido.getIdPedido()));
        carregaComboTipos();
        carregaComboContas();
    }

    public static void carregaComboTipos() {
        cbTipoPagamento.adicionaValor(TiposPgtoDAO.montaCombo());
        cbTipoPagamento.repaint();
    }

    public static void carregaComboContas() {
        cbConta.adicionaValor(ContasDAO.montaCombo());
        cbConta.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbValorTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbTipoPagamento = new br.com.fs.rta.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        lbTroco = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbConta = new br.com.fs.rta.JComboBox();
        tfValorPago = new javax.swing.JTextField();
        btVoltar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Receber");
        setModal(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes de pagamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Pedido:");

        lbCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCodigo.setText("000");

        jLabel2.setText("Valor total:");

        lbValorTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbValorTotal.setForeground(new java.awt.Color(0, 102, 0));
        lbValorTotal.setText("R$ 0,00");

        jLabel3.setText("Valor pago:");

        jLabel4.setText("Forma pgto:");

        jLabel5.setText("Troco:");

        lbTroco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTroco.setText("R$ 0,00");

        jLabel6.setText("Conta:");

        tfValorPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorPagoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbConta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addComponent(cbTipoPagamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValorTotal)
                            .addComponent(tfValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addComponent(jLabel5)
                        .addGap(24, 24, 24)
                        .addComponent(lbTroco)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbValorTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(lbTroco)
                    .addComponent(tfValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVoltar)))
                .addContainerGap())
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar)
                    .addComponent(btConfirmar))
                .addContainerGap())
        );

        getContentPane().add(pnPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tfValorPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorPagoFocusLost
        double total = ReplaceMoedaRTA.moedaToDouble(lbValorTotal.getText());
        double pago = ReplaceMoedaRTA.moedaToDouble(tfValorPago.getText());
        double troco = pago - total;
        lbTroco.setText(ReplaceMoedaRTA.doubleToMoeda(troco));
    }//GEN-LAST:event_tfValorPagoFocusLost

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        double total = ReplaceMoedaRTA.moedaToDouble(lbValorTotal.getText());
        double pago = ReplaceMoedaRTA.moedaToDouble(tfValorPago.getText());
        if (pago == 0) {
            JOptionPane.showMessageDialog(this, "Informe o valor pago!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            tfValorPago.requestFocus();
            return;
        }
        if (pago < total) {
            JOptionPane.showMessageDialog(this, "Pagamento menor que valor do pedido!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            tfValorPago.requestFocus();
            return;
        }

        if (cbTipoPagamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione a forma de pagamento!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            cbTipoPagamento.requestFocus();
            return;
        }
        if (cbConta.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione a conta!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            cbConta.requestFocus();
            return;
        }

        PedidoDAO pedidodao = new PedidoDAO();
        FluxoFinanDAO fluxodao = new FluxoFinanDAO();

        try {
            pedidodao.atualizarPedido(pedidoTO);

            FluxoFinanTO fluxoto = new FluxoFinanTO();
            TiposPgtoTO tipopgto = new TiposPgtoTO();
            ContaTO contato = new ContaTO();

            fluxoto.setPedido(pedidoTO);
            fluxoto.setTroco(ReplaceMoedaRTA.moedaToDouble(lbTroco.getText()));
            fluxoto.setDesconto(pedidoTO.getDesconto());
            fluxoto.setValorPago(ReplaceMoedaRTA.moedaToDouble(tfValorPago.getText()));
            fluxoto.setValorTotal(pedidoTO.getValortotal());
            fluxoto.setTipomovimentacao("E");
            fluxoto.setDatahora(new Date());
            fluxoto.setSituacao("P");
            tipopgto.setIdTipoPgto(cbTipoPagamento.getSelectedId());
            fluxoto.setTipoPgto(tipopgto);
            contato.setIdConta(cbConta.getSelectedId());
            fluxoto.setConta(contato);
            fluxodao.inserir(fluxoto);

            JOptionPane.showMessageDialog(this, "Pedido salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            parent.dispose();
            this.dispose();
            PrincipalGUI.carregaTabela();

            String arquivo = "Cupom";
            String arquivo2 = "CupomInterno";
            HashMap parametros = new HashMap();
            parametros.put("idpedido", pedidoTO.getIdPedido());
            new ImprimeTicketRTA(arquivo, parametros);
            new ImprimeTicketRTA(arquivo2, parametros);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao receber pedido!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btVoltar;
    private static br.com.fs.rta.JComboBox cbConta;
    private static br.com.fs.rta.JComboBox cbTipoPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbTroco;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JTextField tfValorPago;
    // End of variables declaration//GEN-END:variables
}
