package br.com.fs.gui;

import br.com.fs.rta.Mascaras;
import java.beans.PropertyVetoException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RelatorioExtrasGUI extends javax.swing.JInternalFrame {

    private static RelatorioExtrasGUI instancia = null;
    private final Mascaras mascara = new Mascaras();
    private final Calendar cal = new GregorianCalendar();
    
    public RelatorioExtrasGUI() {
        initComponents();
        this.construtor();
    }

    private void construtor(){
        tfLimite.setDocument(mascara.somenteNumero());
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -30);
        dcDataDe.setDate(cal.getTime());
        dcDataAte.setDate(new Date());
        tfLimite.setText("20");
        rbProdutosVenda.setSelected(true);
        rbDecrescente.setSelected(true);
        rbDecrescente.setText("Produtos mais vendidos");
        rbCrescente.setText("Produtos menos vendidos");
    }
    
    public static void setInstanciaNull() {
        instancia = null;
    }
    
    public static RelatorioExtrasGUI getInstancia() {
        if (instancia == null) {
            instancia = new RelatorioExtrasGUI();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnPrincipal = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dcDataDe = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dcDataAte = new com.toedter.calendar.JDateChooser();
        chbData = new javax.swing.JCheckBox();
        rbProdutosVenda = new javax.swing.JRadioButton();
        rbProdutosPromocao = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rbDecrescente = new javax.swing.JRadioButton();
        rbCrescente = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        tfLimite = new javax.swing.JTextField();
        chbLimite = new javax.swing.JCheckBox();
        rbPercas = new javax.swing.JRadioButton();

        setClosable(true);
        setTitle("Extras por período");
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

        jLabel5.setText("De:");

        jLabel6.setText("até:");

        chbData.setText("Todos");
        chbData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbDataActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbProdutosVenda);
        rbProdutosVenda.setText("Agrupamento de produtos por venda no período");
        rbProdutosVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProdutosVendaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbProdutosPromocao);
        rbProdutosPromocao.setText("Produtos na promoção no período");
        rbProdutosPromocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProdutosPromocaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Ordenar de forma:");

        buttonGroup2.add(rbDecrescente);
        rbDecrescente.setText("Decrescente");

        buttonGroup2.add(rbCrescente);
        rbCrescente.setText("Crescente");

        jLabel2.setText("Limite de registros:");

        chbLimite.setText("Todos");
        chbLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbLimiteActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbPercas);
        rbPercas.setText("Percas de produtos no período");
        rbPercas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPercasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rbProdutosVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbData, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbProdutosPromocao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(rbDecrescente, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(rbCrescente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfLimite))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chbLimite))
                    .addComponent(rbPercas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(dcDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(dcDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbData))
                .addGap(18, 18, 18)
                .addComponent(rbProdutosVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbProdutosPromocao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPercas)
                .addGap(12, 12, 12)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDecrescente)
                    .addComponent(tfLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbLimite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbCrescente)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(pnPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void chbDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbDataActionPerformed
        if (chbData.isSelected()){
            dcDataDe.setDate(null);
            dcDataAte.setDate(null);
            dcDataDe.setEnabled(false);
            dcDataAte.setEnabled(false);
        } else{
            dcDataDe.setDate(cal.getTime());
            dcDataAte.setDate(new Date());
            dcDataDe.setEnabled(true);
            dcDataAte.setEnabled(true);
        }
    }//GEN-LAST:event_chbDataActionPerformed

    private void chbLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbLimiteActionPerformed
        if (chbLimite.isSelected()){
            tfLimite.setText("");
            tfLimite.setEnabled(false);
        } else{
            tfLimite.setText("20");
            tfLimite.setEnabled(true);
        }
    }//GEN-LAST:event_chbLimiteActionPerformed

    private void rbProdutosVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProdutosVendaActionPerformed
        rbDecrescente.setText("Produtos mais vendidos");
        rbCrescente.setText("Produtos menos vendidos");
    }//GEN-LAST:event_rbProdutosVendaActionPerformed

    private void rbProdutosPromocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProdutosPromocaoActionPerformed
        rbDecrescente.setText("Decrescente");
        rbCrescente.setText("Crescente");
    }//GEN-LAST:event_rbProdutosPromocaoActionPerformed

    private void rbPercasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPercasActionPerformed
        rbDecrescente.setText("Decrescente");
        rbCrescente.setText("Crescente");
    }//GEN-LAST:event_rbPercasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public static javax.swing.JCheckBox chbData;
    public static javax.swing.JCheckBox chbLimite;
    public static com.toedter.calendar.JDateChooser dcDataAte;
    public static com.toedter.calendar.JDateChooser dcDataDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pnPrincipal;
    public static javax.swing.JRadioButton rbCrescente;
    public static javax.swing.JRadioButton rbDecrescente;
    public static javax.swing.JRadioButton rbPercas;
    public static javax.swing.JRadioButton rbProdutosPromocao;
    public static javax.swing.JRadioButton rbProdutosVenda;
    public static javax.swing.JTextField tfLimite;
    // End of variables declaration//GEN-END:variables
}
