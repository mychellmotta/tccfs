package br.com.fs.gui;

import br.com.fs.dao.ContasDAO;
import br.com.fs.dao.FuncionarioDAO;
import br.com.fs.dao.TiposPgtoDAO;
import br.com.fs.rta.Mascaras;
import br.com.fs.rta.MascarasDouble;
import java.beans.PropertyVetoException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RelatorioPedidosGUI extends javax.swing.JInternalFrame {

    private static RelatorioPedidosGUI instancia = null;
    private final Mascaras mascara = new Mascaras();
    private final Calendar cal = new GregorianCalendar();

    public RelatorioPedidosGUI() {
        initComponents();
        this.construtor();
    }

    private void construtor() {
        tfCodDe.setDocument(mascara.somenteNumero());
        tfCodAte.setDocument(mascara.somenteNumero());
        tfValorDe.setDocument(new MascarasDouble(9));
        tfValorAte.setDocument(new MascarasDouble(9));
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -30);
        dcDataDe.setDate(cal.getTime());
        dcDataAte.setDate(new Date());
        carregaComboContas();
        carregaComboTipos();
        carregaComboOperadores();
        tfCodDe.setText("1");
        tfCodAte.setText("1");
        tfValorDe.setText("0,00");
        tfValorAte.setText("0,00");
    }

    public static void carregaComboTipos() {
        cbFormaPgto.adicionaValor(TiposPgtoDAO.montaCombo());
        cbFormaPgto.repaint();
    }

    public static void carregaComboContas() {
        cbConta.adicionaValor(ContasDAO.montaCombo());
        cbConta.repaint();
    }

    public static void carregaComboOperadores() {
        cbOperador.adicionaValor(FuncionarioDAO.montaCombo());
        cbOperador.repaint();
    }

    public static void setInstanciaNull() {
        instancia = null;
    }

    public static RelatorioPedidosGUI getInstancia() {
        if (instancia == null) {
            instancia = new RelatorioPedidosGUI();
        }
        if (instancia.isIcon) {
            try {
                instancia.setIcon(false);
                instancia.toFront();
            } catch (PropertyVetoException e) {
                System.out.println(e.getMessage());
            }
        }
        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCodDe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfCodAte = new javax.swing.JTextField();
        chbCodigo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        tfValorDe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfValorAte = new javax.swing.JTextField();
        chbValor = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        dcDataDe = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dcDataAte = new com.toedter.calendar.JDateChooser();
        chbData = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        cbTipoPedido = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cbConta = new br.com.fs.rta.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cbFormaPgto = new br.com.fs.rta.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbSituacao = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cbOperador = new br.com.fs.rta.JComboBox();

        setClosable(true);
        setTitle("Pedidos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("Código:");

        jLabel2.setText("até:");

        chbCodigo.setText("Todos");
        chbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbCodigoActionPerformed(evt);
            }
        });

        jLabel3.setText("De (R$):");

        jLabel4.setText("até:");

        chbValor.setText("Todos");
        chbValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbValorActionPerformed(evt);
            }
        });

        jLabel5.setText("De:");

        jLabel6.setText("até:");

        chbData.setText("Todos");
        chbData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbDataActionPerformed(evt);
            }
        });

        jLabel10.setText("Tipo:");

        cbTipoPedido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "DELIVERY", "LOCAL" }));

        jLabel11.setText("Conta:");

        jLabel12.setText("Pgto:");

        jLabel7.setText("Situação:");

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "ABERTO", "CANCELADO", "FINALIZADO", "PAGO" }));

        jLabel8.setText("Operador:");

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7))
                        .addGap(10, 10, 10)
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dcDataDe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfValorDe, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCodDe, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfCodAte, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                        .addComponent(tfValorAte))
                                    .addComponent(dcDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chbValor, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chbCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chbData, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbTipoPedido, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbFormaPgto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbSituacao, 0, 254, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCodDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfCodAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfValorDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfValorAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(dcDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(dcDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbTipoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void chbDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbDataActionPerformed
        if (chbData.isSelected()) {
            dcDataDe.setDate(null);
            dcDataAte.setDate(null);
            dcDataDe.setEnabled(false);
            dcDataAte.setEnabled(false);
        } else {
            dcDataDe.setDate(cal.getTime());
            dcDataAte.setDate(new Date());
            dcDataDe.setEnabled(true);
            dcDataAte.setEnabled(true);
        }
    }//GEN-LAST:event_chbDataActionPerformed

    private void chbValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbValorActionPerformed
        if (chbValor.isSelected()) {
            tfValorDe.setText("");
            tfValorAte.setText("");
            tfValorDe.setEnabled(false);
            tfValorAte.setEnabled(false);
        } else {
            tfValorDe.setEnabled(true);
            tfValorAte.setEnabled(true);
            tfValorDe.setText("0,00");
            tfValorAte.setText("0,00");
        }
    }//GEN-LAST:event_chbValorActionPerformed

    private void chbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbCodigoActionPerformed
        if (chbCodigo.isSelected()) {
            tfCodDe.setText("");
            tfCodAte.setText("");
            tfCodDe.setEnabled(false);
            tfCodAte.setEnabled(false);
        } else {
            tfCodDe.setEnabled(true);
            tfCodAte.setEnabled(true);
            tfCodDe.setText("1");
            tfCodAte.setText("1");
        }
    }//GEN-LAST:event_chbCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static br.com.fs.rta.JComboBox cbConta;
    public static br.com.fs.rta.JComboBox cbFormaPgto;
    public static br.com.fs.rta.JComboBox cbOperador;
    public static javax.swing.JComboBox cbSituacao;
    public static javax.swing.JComboBox cbTipoPedido;
    public static javax.swing.JCheckBox chbCodigo;
    public static javax.swing.JCheckBox chbData;
    public static javax.swing.JCheckBox chbValor;
    public static com.toedter.calendar.JDateChooser dcDataAte;
    public static com.toedter.calendar.JDateChooser dcDataDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel pnPrincipal;
    public static javax.swing.JTextField tfCodAte;
    public static javax.swing.JTextField tfCodDe;
    public static javax.swing.JTextField tfValorAte;
    public static javax.swing.JTextField tfValorDe;
    // End of variables declaration//GEN-END:variables
}
