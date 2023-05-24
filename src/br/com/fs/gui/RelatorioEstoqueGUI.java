package br.com.fs.gui;

import br.com.fs.rta.Mascaras;
import br.com.fs.rta.MascarasDouble;
import java.beans.PropertyVetoException;

public class RelatorioEstoqueGUI extends javax.swing.JInternalFrame {

    private static RelatorioEstoqueGUI instancia = null;
    private final Mascaras mascara = new Mascaras();

    public RelatorioEstoqueGUI() {
        initComponents();
        this.construtor();
    }

    private void construtor() {
        tfCodDe.setDocument(mascara.somenteNumero());
        tfCodAte.setDocument(mascara.somenteNumero());
        tfCustoDe.setDocument(new MascarasDouble(9));
        tfCustoAte.setDocument(new MascarasDouble(9));
        tfVendaDe.setDocument(new MascarasDouble(9));
        tfVendaAte.setDocument(new MascarasDouble(9));
        tfEstoqueDe.setDocument(mascara.permiteVirgula());
        tfEstoqueAte.setDocument(mascara.permiteVirgula());
        tfCodDe.setText("1");
        tfCodAte.setText("1");
        tfNome.setText("");
        tfCustoDe.setText("0,00");
        tfCustoAte.setText("0,00");
        tfVendaDe.setText("0,00");
        tfVendaAte.setText("0,00");
        tfEstoqueDe.setText("0");
        tfEstoqueAte.setText("1");
    }

    public static void setInstanciaNull() {
        instancia = null;
    }

    public static RelatorioEstoqueGUI getInstancia() {
        if (instancia == null) {
            instancia = new RelatorioEstoqueGUI();
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
        tfCustoDe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfCustoAte = new javax.swing.JTextField();
        chbCusto = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbSituacao = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tfVendaDe = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfVendaAte = new javax.swing.JTextField();
        chbVenda = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        cbUnidade = new javax.swing.JComboBox();
        tfEstoqueDe = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfEstoqueAte = new javax.swing.JTextField();
        chbEstoque = new javax.swing.JCheckBox();
        cbComposto = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        chbNome = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Estoque / produtos");
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

        jLabel3.setText("Custo (R$):");

        jLabel4.setText("até:");

        chbCusto.setText("Todos");
        chbCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbCustoActionPerformed(evt);
            }
        });

        jLabel10.setText("Tipo:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "PRODUTOS FINAIS", "INGREDIENTES" }));

        jLabel7.setText("Situação:");

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "ATIVOS", "INATIVOS" }));

        jLabel5.setText("Venda (R$):");

        jLabel6.setText("até:");

        chbVenda.setText("Todos");
        chbVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbVendaActionPerformed(evt);
            }
        });

        jLabel8.setText("Unidade:");

        cbUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "UNITÁRIO", "KG", "L" }));

        jLabel9.setText("Em estoque:");

        jLabel11.setText("até:");

        chbEstoque.setText("Todos");
        chbEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbEstoqueActionPerformed(evt);
            }
        });

        cbComposto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "COMPOSTOS", "NÃO COMPOSTOS" }));

        jLabel12.setText("Nome:");

        chbNome.setText("Todos");
        chbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfVendaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCustoDe, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEstoqueDe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalLayout.createSequentialGroup()
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfVendaAte)
                                    .addComponent(tfCustoAte)))
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEstoqueAte, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12))
                        .addGap(27, 27, 27)
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addComponent(tfCodDe, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCodAte))
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chbEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbCusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnPrincipalLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbComposto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jLabel12)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfCustoDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfCustoAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbCusto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfVendaDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfVendaAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbVenda))
                .addGap(6, 6, 6)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEstoqueDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(tfEstoqueAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbEstoque))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbComposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        getContentPane().add(pnPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void chbCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbCustoActionPerformed
        if (chbCusto.isSelected()) {
            tfCustoDe.setText("");
            tfCustoAte.setText("");
            tfCustoDe.setEnabled(false);
            tfCustoAte.setEnabled(false);
        } else {
            tfCustoDe.setEnabled(true);
            tfCustoAte.setEnabled(true);
            tfCustoDe.setText("0,00");
            tfCustoAte.setText("0,00");
        }
    }//GEN-LAST:event_chbCustoActionPerformed

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

    private void chbVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbVendaActionPerformed
        if (chbVenda.isSelected()) {
            tfVendaDe.setText("");
            tfVendaAte.setText("");
            tfVendaDe.setEnabled(false);
            tfVendaAte.setEnabled(false);
        } else {
            tfVendaDe.setEnabled(true);
            tfVendaAte.setEnabled(true);
            tfVendaDe.setText("0,00");
            tfVendaAte.setText("0,00");
        }
    }//GEN-LAST:event_chbVendaActionPerformed

    private void chbEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbEstoqueActionPerformed
        if (chbEstoque.isSelected()) {
            tfEstoqueDe.setText("");
            tfEstoqueAte.setText("");
            tfEstoqueDe.setEnabled(false);
            tfEstoqueAte.setEnabled(false);
        } else {
            tfEstoqueDe.setEnabled(true);
            tfEstoqueAte.setEnabled(true);
            tfEstoqueDe.setText("0");
            tfEstoqueAte.setText("1");
        }
    }//GEN-LAST:event_chbEstoqueActionPerformed

    private void chbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbNomeActionPerformed
        if (chbNome.isSelected()) {
            tfNome.setText("");
            tfNome.setEnabled(false);
        } else {
            tfNome.setEnabled(true);
            tfNome.setText("");
        }
    }//GEN-LAST:event_chbNomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox cbComposto;
    public static javax.swing.JComboBox cbSituacao;
    public static javax.swing.JComboBox cbTipo;
    public static javax.swing.JComboBox cbUnidade;
    public static javax.swing.JCheckBox chbCodigo;
    public static javax.swing.JCheckBox chbCusto;
    public static javax.swing.JCheckBox chbEstoque;
    public static javax.swing.JCheckBox chbNome;
    public static javax.swing.JCheckBox chbVenda;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnPrincipal;
    public static javax.swing.JTextField tfCodAte;
    public static javax.swing.JTextField tfCodDe;
    public static javax.swing.JTextField tfCustoAte;
    public static javax.swing.JTextField tfCustoDe;
    public static javax.swing.JTextField tfEstoqueAte;
    public static javax.swing.JTextField tfEstoqueDe;
    public static javax.swing.JTextField tfNome;
    public static javax.swing.JTextField tfVendaAte;
    public static javax.swing.JTextField tfVendaDe;
    // End of variables declaration//GEN-END:variables
}
