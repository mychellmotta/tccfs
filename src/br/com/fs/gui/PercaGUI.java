package br.com.fs.gui;

import br.com.fs.dao.LoginDAO;
import br.com.fs.dao.PercaDAO;
import br.com.fs.dao.ProdutoDAO;
import br.com.fs.rta.Mascaras;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.to.PercaTO;
import br.com.fs.to.ProdutoTO;
import java.beans.PropertyVetoException;
import java.util.Date;
import javax.swing.JOptionPane;

public class PercaGUI extends javax.swing.JInternalFrame {

    private static PercaGUI instancia = null;
    Mascaras mascara = new Mascaras();

    public PercaGUI() {
        initComponents();
        this.construtor();
    }

    public static PercaGUI getInstancia() {
        if (instancia == null) {
            instancia = new PercaGUI();
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
        tfCodProduto.setDocument(mascara.somenteNumero());
        tfMotivo.setText("");
        btCancelar.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCorpo = new javax.swing.JPanel();
        pnDetalhes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCodProduto = new javax.swing.JTextField();
        btBuscarProduto = new javax.swing.JButton();
        tfNomeProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbEstoque = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbUnidade = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbEstoqueAtualizado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbPrecoCusto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfMotivo = new javax.swing.JTextArea();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Perca de produto");
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

        pnDetalhes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes da perca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Selecionar produto:");

        tfCodProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodProdutoFocusLost(evt);
            }
        });

        btBuscarProduto.setText("...");
        btBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProdutoActionPerformed(evt);
            }
        });

        tfNomeProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfNomeProduto.setEnabled(false);

        jLabel3.setText("Estoque atual:");

        lbEstoque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEstoque.setText("0");

        jLabel5.setText("Unidade:");

        lbUnidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUnidade.setText("UN");

        jLabel2.setText("Quantidade total perdida deste produto:");

        tfQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfQuantidadeFocusLost(evt);
            }
        });

        jLabel4.setText("Estoque atualizado:");

        lbEstoqueAtualizado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEstoqueAtualizado.setText("0");

        jLabel6.setText("Preço de custo:");

        lbPrecoCusto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPrecoCusto.setText("R$ 0,00");

        jLabel9.setText("Insira com suas palavras o motivo desta perca:");

        tfMotivo.setColumns(20);
        tfMotivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfMotivo.setRows(5);
        jScrollPane1.setViewportView(tfMotivo);

        javax.swing.GroupLayout pnDetalhesLayout = new javax.swing.GroupLayout(pnDetalhes);
        pnDetalhes.setLayout(pnDetalhesLayout);
        pnDetalhesLayout.setHorizontalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhesLayout.createSequentialGroup()
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetalhesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetalhesLayout.createSequentialGroup()
                                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                                        .addComponent(tfCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNomeProduto))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetalhesLayout.createSequentialGroup()
                                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                                        .addComponent(lbPrecoCusto)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbUnidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE))
                                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                                        .addComponent(lbEstoque)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(pnDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbEstoqueAtualizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        pnDetalhesLayout.setVerticalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarProduto)
                    .addComponent(tfNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbUnidade)
                    .addComponent(jLabel6)
                    .addComponent(lbPrecoCusto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbEstoque))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbEstoqueAtualizado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCorpoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)))
                .addContainerGap())
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnCorpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void carregaInformações(ProdutoTO produto) {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            tfCodProduto.setText(produto.getIdProdFormatado(produto.getIdProduto()));
            tfNomeProduto.setText(produto.getNome());
            switch (String.valueOf(produto.getUnidade())) {
                case "UN":
                    lbUnidade.setText("UN");
                    if (produto.getComposto().equals("S") && produto.getQtd() <= 0) {
                        lbEstoque.setText(String.valueOf(dao.estoqueComposto(produto.getIdProduto())));
                    } else {
                        lbEstoque.setText(String.valueOf(produto.getQtdUnidade(produto.getQtd())));
                    }
                    tfQuantidade.setDocument(mascara.somenteNumero());
                    break;
                case "KG":
                    lbUnidade.setText("KG");
                    if (produto.getComposto().equals("S") && produto.getQtd() <= 0) {
                        lbEstoque.setText(String.valueOf(dao.estoqueComposto(produto.getIdProduto())));
                    } else {
                        lbEstoque.setText(produto.getQtdKGL(produto.getQtd()));
                    }
                    tfQuantidade.setDocument(mascara.permiteVirgula());
                    break;
                case "L":
                    lbUnidade.setText("L");
                    if (produto.getComposto().equals("S") && produto.getQtd() <= 0) {
                        lbEstoque.setText(String.valueOf(dao.estoqueComposto(produto.getIdProduto())));
                    } else {
                        lbEstoque.setText(produto.getQtdKGL(produto.getQtd()));
                    }
                    tfQuantidade.setDocument(mascara.permiteVirgula());
                    break;
            }
            lbEstoqueAtualizado.setText(lbEstoque.getText());
            lbPrecoCusto.setText(ReplaceMoedaRTA.doubleToMoeda(produto.getPrecocusto()));
            tfQuantidade.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar informações do produto!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetProd() {
        tfCodProduto.setText("");
        tfNomeProduto.setText("");
        lbEstoque.setText("0");
        lbUnidade.setText("UN");
        lbPrecoCusto.setText("R$ 0,00");
        lbEstoqueAtualizado.setText("0");
        tfQuantidade.setText("");
        tfMotivo.setText("");
    }

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        if (tfCodProduto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecione um produto!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            btBuscarProduto.requestFocus();
            return;
        }
        if ((tfQuantidade.getText().equals("")) || (Double.parseDouble(tfQuantidade.getText().replace(",", ".")) == 0)) {
            JOptionPane.showMessageDialog(this, "Informe a quantidade!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            tfQuantidade.setText("");
            tfQuantidade.requestFocus();
            return;
        }
        if ((tfMotivo.getText().equals("")) || (tfMotivo.getText().length() <= 0)) {
            JOptionPane.showMessageDialog(this, "Informe o motivo da perca!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            tfMotivo.requestFocus();
            return;
        }

        try {
            ProdutoDAO produtodao = new ProdutoDAO();
            int idproduto = Integer.parseInt(tfCodProduto.getText());
            double qtd = Double.parseDouble(tfQuantidade.getText().replace(",", "."));
            double estoque = Double.parseDouble(lbEstoque.getText().replace(",", "."));
            ProdutoTO produtoto = (ProdutoTO) produtodao.buscarId(idproduto);
            PercaTO percato = new PercaTO();
            PercaDAO percadao = new PercaDAO();

            if (qtd > estoque) {
                JOptionPane.showMessageDialog(this, "Quantidade de perca maior que estoque!", "Atenção", JOptionPane.WARNING_MESSAGE);
                tfQuantidade.setText("");
                tfQuantidade.requestFocus();
                return;
            }

            percato.setProduto(produtoto);
            percato.setFuncionario(LoginDAO.operador);
            percato.setDataperca(new Date());
            percato.setQtdantes(Double.parseDouble(lbEstoque.getText().replace(",", ".")));
            percato.setQtdperca(Double.parseDouble(tfQuantidade.getText().replace(",", ".")));
            percato.setMotivo(tfMotivo.getText());

            percadao.inserir(percato);

            JOptionPane.showMessageDialog(this, "Estoque ajustado com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao ajustar estoque!\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        this.resetProd();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        instancia = null;
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantidadeFocusLost
        if (tfQuantidade.getText().length() != 0) {
            double quantidade = Double.parseDouble(tfQuantidade.getText().replace(",", "."));
            if (lbUnidade.getText().equals("UN")) {
                double estoqueatual = Double.parseDouble(lbEstoque.getText());
                double estoqueatualizado = estoqueatual - quantidade;
                lbEstoqueAtualizado.setText(String.valueOf((int) estoqueatualizado));
            } else {
                double estoqueatual = Double.parseDouble(lbEstoque.getText().replace(",", "."));
                double estoqueatualizado = estoqueatual - quantidade;
                lbEstoqueAtualizado.setText(String.valueOf(estoqueatualizado).replace(".", ","));
            }
        }
    }//GEN-LAST:event_tfQuantidadeFocusLost

    private void btBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProdutoActionPerformed
        ConsultaAjusteEstoqueGUI con = new ConsultaAjusteEstoqueGUI(this, 2);
        con.setVisible(true);
    }//GEN-LAST:event_btBuscarProdutoActionPerformed

    private void tfCodProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodProdutoFocusLost
        if (tfCodProduto.getText().length() != 0) {
            try {
                ProdutoDAO dao = new ProdutoDAO();
                ProdutoTO to = (ProdutoTO) dao.buscarId(Integer.parseInt(tfCodProduto.getText()));
                if ((to.getIdProduto() != 000) && (to.getSituacao().equals("A"))) {
                    this.carregaInformações(to);
                } else {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    this.resetProd();
                    tfCodProduto.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar produto!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tfCodProdutoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarProduto;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEstoque;
    private javax.swing.JLabel lbEstoqueAtualizado;
    private javax.swing.JLabel lbPrecoCusto;
    private javax.swing.JLabel lbUnidade;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnDetalhes;
    private javax.swing.JTextField tfCodProduto;
    private javax.swing.JTextArea tfMotivo;
    private javax.swing.JTextField tfNomeProduto;
    private javax.swing.JTextField tfQuantidade;
    // End of variables declaration//GEN-END:variables
}
