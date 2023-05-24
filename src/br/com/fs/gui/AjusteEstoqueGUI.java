package br.com.fs.gui;

import br.com.fs.dao.LoginDAO;
import br.com.fs.dao.ProdutoDAO;
import br.com.fs.rta.Mascaras;
import br.com.fs.to.ProdutoTO;
import java.awt.Component;
import java.beans.PropertyVetoException;
import javax.swing.JOptionPane;

public class AjusteEstoqueGUI extends javax.swing.JInternalFrame {

    private static AjusteEstoqueGUI instancia = null;
    Mascaras mascara = new Mascaras();

    public AjusteEstoqueGUI() {
        initComponents();
        this.construtor();
    }

    public static AjusteEstoqueGUI getInstancia() {
        if (instancia == null) {
            instancia = new AjusteEstoqueGUI();
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

    private void construtor() {
        tfCodProduto2.setDocument(mascara.somenteNumero());
        tfCodProduto3.setDocument(mascara.somenteNumero());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JTabbedPane();
        pnBalanco = new javax.swing.JPanel();
        pnDetailsBalanco = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfCodProduto2 = new javax.swing.JTextField();
        btBuscarProduto2 = new javax.swing.JButton();
        tfNomeProduto2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfQuantidade2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lbEstoque2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbUnidade2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbEstoqueAtualizado2 = new javax.swing.JLabel();
        btAjustarEstoqueBalanco = new javax.swing.JButton();
        btCancelar2 = new javax.swing.JButton();
        pnZerar = new javax.swing.JPanel();
        pnDetailsZerar = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        tfCodProduto3 = new javax.swing.JTextField();
        btBuscarProduto3 = new javax.swing.JButton();
        tfNomeProduto3 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lbEstoque3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbUnidade3 = new javax.swing.JLabel();
        btAjustarEstoqueZerar = new javax.swing.JButton();
        btCancelar3 = new javax.swing.JButton();
        chZerarTodos = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ajuste de estoque");
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

        pnDetailsBalanco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes do balanço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel11.setText("Selecionar produto:");

        tfCodProduto2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodProduto2FocusLost(evt);
            }
        });

        btBuscarProduto2.setText("...");
        btBuscarProduto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProduto2ActionPerformed(evt);
            }
        });

        tfNomeProduto2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfNomeProduto2.setEnabled(false);

        jLabel12.setText("Quantidade total ajustada deste produto:");

        tfQuantidade2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfQuantidade2FocusLost(evt);
            }
        });

        jLabel13.setText("Estoque atual:");

        lbEstoque2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEstoque2.setText("0");

        jLabel14.setText("Unidade:");

        lbUnidade2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUnidade2.setText("UN");

        jLabel15.setText("Estoque atualizado:");

        lbEstoqueAtualizado2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEstoqueAtualizado2.setText("0");

        javax.swing.GroupLayout pnDetailsBalancoLayout = new javax.swing.GroupLayout(pnDetailsBalanco);
        pnDetailsBalanco.setLayout(pnDetailsBalancoLayout);
        pnDetailsBalancoLayout.setHorizontalGroup(
            pnDetailsBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailsBalancoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailsBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetailsBalancoLayout.createSequentialGroup()
                        .addComponent(tfQuantidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEstoqueAtualizado2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(pnDetailsBalancoLayout.createSequentialGroup()
                        .addGroup(pnDetailsBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetailsBalancoLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbEstoque2)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbUnidade2))
                            .addComponent(jLabel12)
                            .addGroup(pnDetailsBalancoLayout.createSequentialGroup()
                                .addGroup(pnDetailsBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11)
                                    .addGroup(pnDetailsBalancoLayout.createSequentialGroup()
                                        .addComponent(tfCodProduto2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btBuscarProduto2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNomeProduto2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        pnDetailsBalancoLayout.setVerticalGroup(
            pnDetailsBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailsBalancoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetailsBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodProduto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarProduto2)
                    .addComponent(tfNomeProduto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDetailsBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbEstoque2)
                    .addComponent(jLabel14)
                    .addComponent(lbUnidade2))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetailsBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQuantidade2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(lbEstoqueAtualizado2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btAjustarEstoqueBalanco.setText("Ajustar estoque");
        btAjustarEstoqueBalanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjustarEstoqueBalancoActionPerformed(evt);
            }
        });

        btCancelar2.setText("Cancelar");
        btCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBalancoLayout = new javax.swing.GroupLayout(pnBalanco);
        pnBalanco.setLayout(pnBalancoLayout);
        pnBalancoLayout.setHorizontalGroup(
            pnBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBalancoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDetailsBalanco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBalancoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btAjustarEstoqueBalanco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar2)))
                .addContainerGap())
        );
        pnBalancoLayout.setVerticalGroup(
            pnBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBalancoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnDetailsBalanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBalancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar2)
                    .addComponent(btAjustarEstoqueBalanco))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnPrincipal.addTab("balanço", pnBalanco);

        pnDetailsZerar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes do produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel16.setText("Selecionar produto:");

        tfCodProduto3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodProduto3FocusLost(evt);
            }
        });

        btBuscarProduto3.setText("...");
        btBuscarProduto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProduto3ActionPerformed(evt);
            }
        });

        tfNomeProduto3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfNomeProduto3.setEnabled(false);

        jLabel18.setText("Estoque atual:");

        lbEstoque3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEstoque3.setText("0");

        jLabel19.setText("Unidade:");

        lbUnidade3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUnidade3.setText("UN");

        javax.swing.GroupLayout pnDetailsZerarLayout = new javax.swing.GroupLayout(pnDetailsZerar);
        pnDetailsZerar.setLayout(pnDetailsZerarLayout);
        pnDetailsZerarLayout.setHorizontalGroup(
            pnDetailsZerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailsZerarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailsZerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailsZerarLayout.createSequentialGroup()
                        .addGroup(pnDetailsZerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addGroup(pnDetailsZerarLayout.createSequentialGroup()
                                .addComponent(tfCodProduto3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btBuscarProduto3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeProduto3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDetailsZerarLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEstoque3)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUnidade3)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnDetailsZerarLayout.setVerticalGroup(
            pnDetailsZerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailsZerarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetailsZerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodProduto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarProduto3)
                    .addComponent(tfNomeProduto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDetailsZerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lbEstoque3)
                    .addComponent(jLabel19)
                    .addComponent(lbUnidade3))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        btAjustarEstoqueZerar.setText("Ajustar estoque");
        btAjustarEstoqueZerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjustarEstoqueZerarActionPerformed(evt);
            }
        });

        btCancelar3.setText("Cancelar");
        btCancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar3ActionPerformed(evt);
            }
        });

        chZerarTodos.setText("Zerar todos os produtos");
        chZerarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chZerarTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnZerarLayout = new javax.swing.GroupLayout(pnZerar);
        pnZerar.setLayout(pnZerarLayout);
        pnZerarLayout.setHorizontalGroup(
            pnZerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnZerarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnZerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDetailsZerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnZerarLayout.createSequentialGroup()
                        .addComponent(chZerarTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAjustarEstoqueZerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar3)))
                .addContainerGap())
        );
        pnZerarLayout.setVerticalGroup(
            pnZerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnZerarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnDetailsZerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnZerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar3)
                    .addComponent(btAjustarEstoqueZerar)
                    .addComponent(chZerarTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnPrincipal.addTab("zerar estoque", pnZerar);

        getContentPane().add(pnPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void chZerarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chZerarTodosActionPerformed
        if (chZerarTodos.isSelected()) {
            for (Component cp : pnDetailsZerar.getComponents()) {
                cp.setEnabled(false);
                tfNomeProduto3.setText("");
                tfCodProduto3.setText("");
                lbUnidade3.setText("UN");
                lbEstoque3.setText("0");
            }
        } else {
            for (Component cp : pnDetailsZerar.getComponents()) {
                cp.setEnabled(true);
                tfNomeProduto3.setEnabled(false);
            }
        }
    }//GEN-LAST:event_chZerarTodosActionPerformed

    private void btCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelar3ActionPerformed

    private void btAjustarEstoqueZerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjustarEstoqueZerarActionPerformed
        if (LoginDAO.operador.getIdFuncionario() == 1) {
            if (chZerarTodos.isSelected()) {
                int i = JOptionPane.showConfirmDialog(null, "Isso deixará todos os produtos com estoque 0 (zero). Continuar?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    try {
                        ProdutoDAO dao = new ProdutoDAO();
                        dao.zerarEstoque();

                        JOptionPane.showMessageDialog(this, "Estoque zerado com sucesso!",
                                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro ao zerar estoque!\n" + e.getMessage(),
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    repaint();
                    for (Component cp : pnDetailsZerar.getComponents()) {
                        cp.setEnabled(true);
                        tfNomeProduto3.setEnabled(false);
                    }
                }
            } else {
                if (tfCodProduto3.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Selecione um produto!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    btBuscarProduto3.requestFocus();
                    return;
                }
                try {
                    ProdutoDAO dao = new ProdutoDAO();
                    int idproduto = Integer.parseInt(tfCodProduto3.getText());

                    dao.zerarEstoque(idproduto);

                    JOptionPane.showMessageDialog(this, "Estoque zerado com sucesso!",
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro ao zerar estoque!\n" + e.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            this.resetZerar();
        } else {
            SenhaSupervisorGUI gui = new SenhaSupervisorGUI(this);
            gui.setVisible(true);
            if (gui.retorno()) {
                if (chZerarTodos.isSelected()) {
                    int i = JOptionPane.showConfirmDialog(null, "Isso deixará todos os produtos com estoque 0 (zero). Continuar?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (i == JOptionPane.YES_OPTION) {
                        try {
                            ProdutoDAO dao = new ProdutoDAO();
                            dao.zerarEstoque();

                            JOptionPane.showMessageDialog(this, "Estoque zerado com sucesso!",
                                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Erro ao zerar estoque!\n" + e.getMessage(),
                                    "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        repaint();
                        for (Component cp : pnDetailsZerar.getComponents()) {
                            cp.setEnabled(true);
                            tfNomeProduto3.setEnabled(false);
                        }
                    }
                } else {
                    if (tfCodProduto3.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Selecione um produto!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                        btBuscarProduto3.requestFocus();
                        return;
                    }
                    try {
                        ProdutoDAO dao = new ProdutoDAO();
                        int idproduto = Integer.parseInt(tfCodProduto3.getText());

                        dao.zerarEstoque(idproduto);

                        JOptionPane.showMessageDialog(this, "Estoque zerado com sucesso!",
                                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro ao zerar estoque!\n" + e.getMessage(),
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                this.resetZerar();
            } else {
                JOptionPane.showMessageDialog(null, "Senha de supervisor inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
            gui.dispose();
        }
    }//GEN-LAST:event_btAjustarEstoqueZerarActionPerformed

    private void btBuscarProduto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProduto3ActionPerformed
        ConsultaAjusteEstoqueGUI gui = new ConsultaAjusteEstoqueGUI(this, 4);
        gui.setVisible(true);
    }//GEN-LAST:event_btBuscarProduto3ActionPerformed

    private void tfCodProduto3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodProduto3FocusLost
        if (tfCodProduto3.getText().length() != 0) {
            try {
                ProdutoDAO dao = new ProdutoDAO();
                ProdutoTO to = (ProdutoTO) dao.buscarId(Integer.parseInt(tfCodProduto3.getText()));
                if ((to.getIdProduto() != 000) && (to.getSituacao().equals("A"))) {
                    this.carregaInformaçõesZerar(to);
                } else {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    this.resetZerar();
                    tfCodProduto3.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar produto!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tfCodProduto3FocusLost

    private void btCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelar2ActionPerformed

    private void btAjustarEstoqueBalancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjustarEstoqueBalancoActionPerformed
        if (tfCodProduto2.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecione um produto!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            btBuscarProduto2.requestFocus();
            return;
        }
        if (tfQuantidade2.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Informe a quantidade!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            tfQuantidade2.requestFocus();
            return;
        }

        try {
            ProdutoDAO dao = new ProdutoDAO();
            int idproduto = Integer.parseInt(tfCodProduto2.getText());
            double qtd = Double.parseDouble(tfQuantidade2.getText().replace(",", "."));

            dao.ajustarEstoqueBalanco(idproduto, qtd);

            JOptionPane.showMessageDialog(this, "Estoque ajustado com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao ajustar estoque!\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.resetBalanco();
    }//GEN-LAST:event_btAjustarEstoqueBalancoActionPerformed

    private void tfQuantidade2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantidade2FocusLost
        lbEstoqueAtualizado2.setText(tfQuantidade2.getText());
    }//GEN-LAST:event_tfQuantidade2FocusLost

    private void btBuscarProduto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProduto2ActionPerformed
        ConsultaAjusteEstoqueGUI gui = new ConsultaAjusteEstoqueGUI(this, 3);
        gui.setVisible(true);
    }//GEN-LAST:event_btBuscarProduto2ActionPerformed

    private void tfCodProduto2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodProduto2FocusLost
        if (tfCodProduto2.getText().length() != 0) {
            try {
                ProdutoDAO dao = new ProdutoDAO();
                ProdutoTO to = (ProdutoTO) dao.buscarId(Integer.parseInt(tfCodProduto2.getText()));
                if ((to.getIdProduto() != 000) && (to.getSituacao().equals("A"))) {
                    this.carregaInformaçõesBalanco(to);
                } else {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    this.resetBalanco();
                    tfCodProduto2.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar produto!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tfCodProduto2FocusLost

    private void resetBalanco() {
        tfCodProduto2.setText("");
        tfNomeProduto2.setText("");
        lbEstoque2.setText("0");
        lbUnidade2.setText("UN");
        lbEstoqueAtualizado2.setText("0");
        tfQuantidade2.setText("");
    }

    private void resetZerar() {
        tfCodProduto3.setText("");
        tfNomeProduto3.setText("");
        lbEstoque3.setText("0");
        lbUnidade3.setText("UN");
        chZerarTodos.setSelected(false);
    }

    protected void carregaInformaçõesBalanco(ProdutoTO produto) {
        tfCodProduto2.setText(produto.getIdProdFormatado(produto.getIdProduto()));
        tfNomeProduto2.setText(produto.getNome());
        switch (String.valueOf(produto.getUnidade())) {
            case "UN":
                lbUnidade2.setText("UNITÁRIO");
                lbEstoque2.setText(String.valueOf(produto.getQtdUnidade(produto.getQtd())));
                tfQuantidade2.setDocument(mascara.somenteNumero());
                break;
            case "KG":
                lbUnidade2.setText("KG");
                lbEstoque2.setText(produto.getQtdKGL(produto.getQtd()));
                tfQuantidade2.setDocument(mascara.permiteVirgula());
                break;
            case "L":
                lbUnidade2.setText("LITRO");
                lbEstoque2.setText(produto.getQtdKGL(produto.getQtd()));
                tfQuantidade2.setDocument(mascara.permiteVirgula());
                break;
        }
        lbEstoqueAtualizado2.setText(lbEstoque2.getText());
    }

    protected void carregaInformaçõesZerar(ProdutoTO produto) {
        tfCodProduto3.setText(produto.getIdProdFormatado(produto.getIdProduto()));
        tfNomeProduto3.setText(produto.getNome());
        switch (String.valueOf(produto.getUnidade())) {
            case "UN":
                lbUnidade3.setText("UNITÁRIO");
                lbEstoque3.setText(String.valueOf(produto.getQtdUnidade(produto.getQtd())));
                break;
            case "KG":
                lbUnidade3.setText("KG");
                lbEstoque3.setText(produto.getQtdKGL(produto.getQtd()));
                break;
            case "L":
                lbUnidade3.setText("LITRO");
                lbEstoque3.setText(produto.getQtdKGL(produto.getQtd()));
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAjustarEstoqueBalanco;
    private javax.swing.JButton btAjustarEstoqueZerar;
    private javax.swing.JButton btBuscarProduto2;
    private javax.swing.JButton btBuscarProduto3;
    private javax.swing.JButton btCancelar2;
    private javax.swing.JButton btCancelar3;
    private javax.swing.JCheckBox chZerarTodos;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel lbEstoque2;
    private javax.swing.JLabel lbEstoque3;
    private javax.swing.JLabel lbEstoqueAtualizado2;
    private javax.swing.JLabel lbUnidade2;
    private javax.swing.JLabel lbUnidade3;
    private javax.swing.JPanel pnBalanco;
    private javax.swing.JPanel pnDetailsBalanco;
    private javax.swing.JPanel pnDetailsZerar;
    private javax.swing.JTabbedPane pnPrincipal;
    private javax.swing.JPanel pnZerar;
    private javax.swing.JTextField tfCodProduto2;
    private javax.swing.JTextField tfCodProduto3;
    private javax.swing.JTextField tfNomeProduto2;
    private javax.swing.JTextField tfNomeProduto3;
    private javax.swing.JTextField tfQuantidade2;
    // End of variables declaration//GEN-END:variables
}
