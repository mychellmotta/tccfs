package br.com.fs.gui;

import br.com.fs.rta.GeraPdfRTA;
import br.com.fs.rta.ImprimeRTA;
import br.com.fs.rta.RelatorioRTA;
import br.com.fs.rta.ReplaceMoedaRTA;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class GeraRelatoriosGUI extends javax.swing.JInternalFrame {

    private static GeraRelatoriosGUI instancia = null;

    public GeraRelatoriosGUI() {
        initComponents();
    }

    public static GeraRelatoriosGUI getInstancia() {
        if (instancia == null) {
            instancia = new GeraRelatoriosGUI();
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

        bgModulo = new javax.swing.ButtonGroup();
        pnCorpo = new javax.swing.JPanel();
        pnModulos = new javax.swing.JPanel();
        rbCaixa = new javax.swing.JRadioButton();
        rbPedidos = new javax.swing.JRadioButton();
        rbEstoque = new javax.swing.JRadioButton();
        rbExtras = new javax.swing.JRadioButton();
        btCancelar = new javax.swing.JButton();
        btImprimir = new javax.swing.JButton();
        btVisualizar = new javax.swing.JButton();
        btGerarPDF = new javax.swing.JButton();
        dpFiltros = new javax.swing.JDesktopPane();

        setClosable(true);
        setIconifiable(true);
        setTitle("Relatórios");
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

        pnModulos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione o módulo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        bgModulo.add(rbCaixa);
        rbCaixa.setText("Caixa");
        rbCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCaixaActionPerformed(evt);
            }
        });

        bgModulo.add(rbPedidos);
        rbPedidos.setText("Pedidos");
        rbPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPedidosActionPerformed(evt);
            }
        });

        bgModulo.add(rbEstoque);
        rbEstoque.setText("Estoque");
        rbEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEstoqueActionPerformed(evt);
            }
        });

        bgModulo.add(rbExtras);
        rbExtras.setText("Extras");
        rbExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbExtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnModulosLayout = new javax.swing.GroupLayout(pnModulos);
        pnModulos.setLayout(pnModulosLayout);
        pnModulosLayout.setHorizontalGroup(
            pnModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnModulosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(rbExtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnModulosLayout.setVerticalGroup(
            pnModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnModulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbCaixa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbEstoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbExtras)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        btVisualizar.setText("Visualizar");
        btVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisualizarActionPerformed(evt);
            }
        });

        btGerarPDF.setText("Gerar PDF");
        btGerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarPDFActionPerformed(evt);
            }
        });

        dpFiltros.setBackground(getBackground());
        dpFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtre as informações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout dpFiltrosLayout = new javax.swing.GroupLayout(dpFiltros);
        dpFiltros.setLayout(dpFiltrosLayout);
        dpFiltrosLayout.setHorizontalGroup(
            dpFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );
        dpFiltrosLayout.setVerticalGroup(
            dpFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnModulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addComponent(btGerarPDF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVisualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar))
                    .addComponent(dpFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnModulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addComponent(dpFiltros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCancelar)
                            .addComponent(btImprimir)
                            .addComponent(btVisualizar)
                            .addComponent(btGerarPDF))))
                .addContainerGap())
        );

        getContentPane().add(pnCorpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        instancia = null;
        RelatorioCaixaGUI.setInstanciaNull();
        RelatorioPedidosGUI.setInstanciaNull();
        RelatorioEstoqueGUI.setInstanciaNull();
        RelatorioExtrasGUI.setInstanciaNull();
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        RelatorioCaixaGUI.setInstanciaNull();
        RelatorioPedidosGUI.setInstanciaNull();
        RelatorioEstoqueGUI.setInstanciaNull();
        RelatorioExtrasGUI.setInstanciaNull();
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        String query = " 1 = 1 ";
        if (rbCaixa.isSelected()) {
            if (!RelatorioCaixaGUI.chbCodigo.isSelected()) {
                if (Integer.parseInt(RelatorioCaixaGUI.tfCodDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfCodDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioCaixaGUI.tfCodAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfCodAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioCaixaGUI.tfCodAte.getText())) < (Integer.parseInt(RelatorioCaixaGUI.tfCodDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfCodDe.requestFocus();
                    return;
                }
                query += " AND fluxofinan.`id` BETWEEN " + RelatorioCaixaGUI.tfCodDe.getText() + " AND " + RelatorioCaixaGUI.tfCodAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioCaixaGUI.chbValor.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfValorAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfValorDe.requestFocus();
                    return;
                }
                query += " AND fluxofinan.`valortotal` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioCaixaGUI.chbData.isSelected()) {
                if (RelatorioCaixaGUI.dcDataDe.getDate().compareTo(RelatorioCaixaGUI.dcDataAte.getDate()) == 1) {
                    JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.dcDataDe.requestFocus();
                    return;
                }
                String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioCaixaGUI.dcDataDe.getDate());
                String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioCaixaGUI.dcDataAte.getDate());
                query += " AND date(fluxofinan.`datahora`) BETWEEN '" + datade + "' AND '" + dataate + "' ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioCaixaGUI.chbPedido.isSelected()) {
                if (Integer.parseInt(RelatorioCaixaGUI.tfPedidoDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código do pedido inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfPedidoDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioCaixaGUI.tfPedidoAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código do pedido final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfPedidoAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioCaixaGUI.tfPedidoAte.getText())) < (Integer.parseInt(RelatorioCaixaGUI.tfPedidoDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfPedidoDe.requestFocus();
                    return;
                }
                query += " AND fluxofinan.`idpedido` BETWEEN " + RelatorioCaixaGUI.tfPedidoDe.getText() + " AND " + RelatorioCaixaGUI.tfPedidoAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (RelatorioCaixaGUI.cbTipo.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioCaixaGUI.cbTipo.getSelectedIndex() == 1) {
                query += " AND fluxofinan.`tipomovimentacao` = 'E' ";
            } else {
                query += " AND fluxofinan.`tipomovimentacao` = 'S' ";
            }
            if (RelatorioCaixaGUI.cbTipoPedido.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioCaixaGUI.cbTipoPedido.getSelectedIndex() == 1) {
                query += " AND pedido.`tipopedido` = 'E' ";
            } else {
                query += " AND pedido.`tipopedido` = 'L' ";
            }
            if (RelatorioCaixaGUI.cbConta.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idconta` = " + RelatorioCaixaGUI.cbConta.getSelectedId() + " ";
            }
            if (RelatorioCaixaGUI.cbFormaPgto.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idtipospgto` = " + RelatorioCaixaGUI.cbFormaPgto.getSelectedId() + " ";
            }

            query += " ORDER BY fluxofinan.`id` ASC ";

            String arquivo = "Caixa";
            HashMap parametros = new HashMap();
            parametros.put("query", query);
            try {
                new ImprimeRTA(arquivo, parametros);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            }
        }
        if (rbPedidos.isSelected()) {
            if (!RelatorioPedidosGUI.chbCodigo.isSelected()) {
                if (Integer.parseInt(RelatorioPedidosGUI.tfCodDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfCodDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioPedidosGUI.tfCodAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfCodAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioPedidosGUI.tfCodAte.getText())) < (Integer.parseInt(RelatorioPedidosGUI.tfCodDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfCodDe.requestFocus();
                    return;
                }
                query += " AND pedido.`id` BETWEEN " + RelatorioPedidosGUI.tfCodDe.getText() + " AND " + RelatorioPedidosGUI.tfCodAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioPedidosGUI.chbValor.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfValorAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfValorDe.requestFocus();
                    return;
                }
                query += " AND pedido.`valortotal` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioPedidosGUI.chbData.isSelected()) {
                if (RelatorioPedidosGUI.dcDataDe.getDate().compareTo(RelatorioPedidosGUI.dcDataAte.getDate()) == 1) {
                    JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.dcDataDe.requestFocus();
                    return;
                }
                String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioPedidosGUI.dcDataDe.getDate());
                String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioPedidosGUI.dcDataAte.getDate());
                query += " AND date(pedido.`datahorapedido`) BETWEEN '" + datade + "' AND '" + dataate + "' ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (RelatorioPedidosGUI.cbTipoPedido.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioPedidosGUI.cbTipoPedido.getSelectedIndex() == 1) {
                query += " AND pedido.`tipopedido` = 'E' ";
            } else {
                query += " AND pedido.`tipopedido` = 'L' ";
            }
            if (RelatorioPedidosGUI.cbConta.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idconta` = " + RelatorioPedidosGUI.cbConta.getSelectedId() + " ";
            }
            if (RelatorioPedidosGUI.cbFormaPgto.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idtipospgto` = " + RelatorioPedidosGUI.cbFormaPgto.getSelectedId() + " ";
            }
            if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 1) {
                query += " AND pedido.`situacao` = 'A' ";
            } else if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 2) {
                query += " AND pedido.`situacao` = 'C' ";
            } else if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 3) {
                query += " AND pedido.`situacao` = 'F' ";
            } else {
                query += " AND pedido.`situacao` = 'P' ";
            }
            if (RelatorioPedidosGUI.cbOperador.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND funcionario.`id` = " + RelatorioPedidosGUI.cbOperador.getSelectedId() + " ";
            }

            query += " ORDER BY pedido.`id` ASC ";

            String arquivo = "Pedidos";
            HashMap parametros = new HashMap();
            parametros.put("query", query);
            try {
                new ImprimeRTA(arquivo, parametros);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            }
        }
        if (rbEstoque.isSelected()) {
            if (!RelatorioEstoqueGUI.chbCodigo.isSelected()) {
                if (Integer.parseInt(RelatorioEstoqueGUI.tfCodDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCodDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioEstoqueGUI.tfCodAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCodAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioEstoqueGUI.tfCodAte.getText())) < (Integer.parseInt(RelatorioEstoqueGUI.tfCodDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCodDe.requestFocus();
                    return;
                }
                query += " AND produto.`id` BETWEEN " + RelatorioEstoqueGUI.tfCodDe.getText() + " AND " + RelatorioEstoqueGUI.tfCodAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbNome.isSelected()) {
                query += " AND produto.`nome` LIKE '%" + RelatorioEstoqueGUI.tfNome.getText().trim() + "%' ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbCusto.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor de custo final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCustoAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCustoDe.requestFocus();
                    return;
                }
                query += " AND produto.`precocusto` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbVenda.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor de venda final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfVendaAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfVendaDe.requestFocus();
                    return;
                }
                query += " AND produto.`precovenda` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbEstoque.isSelected()) {
                if (Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueAte.getText().replace(",", ".")) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe a quantidade final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfEstoqueAte.requestFocus();
                    return;
                }
                if ((Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueAte.getText().replace(",", "."))) < (Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueDe.getText().replace(",", ".")))) {
                    JOptionPane.showMessageDialog(null, "Quantidade inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfEstoqueDe.requestFocus();
                    return;
                }
                query += " AND produto.`qtd` BETWEEN " + Double.valueOf(RelatorioEstoqueGUI.tfEstoqueDe.getText().replace(",", ".")) + " AND " + Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueAte.getText().replace(",", ".")) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (RelatorioEstoqueGUI.cbUnidade.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbUnidade.getSelectedIndex() == 1) {
                query += " AND produto.`unidade` = 'UN' ";
            } else if (RelatorioEstoqueGUI.cbUnidade.getSelectedIndex() == 2) {
                query += " AND produto.`unidade` = 'KG' ";
            } else {
                query += " AND produto.`unidade` = 'L' ";
            }
            if (RelatorioEstoqueGUI.cbTipo.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbTipo.getSelectedIndex() == 1) {
                query += " AND produto.`tipo` = 'F' ";
            } else {
                query += " AND produto.`tipo` = 'I' ";
            }
            if (RelatorioEstoqueGUI.cbComposto.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbComposto.getSelectedIndex() == 1) {
                query += " AND produto.`composto` = 'S' ";
            } else {
                query += " AND produto.`composto` = 'N' ";
            }
            if (RelatorioEstoqueGUI.cbSituacao.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbSituacao.getSelectedIndex() == 1) {
                query += " AND produto.`situacao` = 'A' ";
            } else {
                query += " AND produto.`situacao` = 'I' ";
            }

            query += " ORDER BY produto.`id` ASC ";

            String arquivo = "Estoque";
            HashMap parametros = new HashMap();
            parametros.put("query", query);
            try {
                new ImprimeRTA(arquivo, parametros);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            }
        }
        if (rbExtras.isSelected()) {
            if (RelatorioExtrasGUI.rbProdutosVenda.isSelected()) {
                String arquivo = "ProdutosVendidosNoPeriodo";
                HashMap parametros = new HashMap();

                if (!RelatorioExtrasGUI.chbData.isSelected()) {
                    if (RelatorioExtrasGUI.dcDataDe.getDate().compareTo(RelatorioExtrasGUI.dcDataAte.getDate()) == 1) {
                        JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.dcDataDe.requestFocus();
                        return;
                    }
                    String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    query += " AND date(pe.datahorapedido) BETWEEN '" + datade + "' AND '" + dataate + "' ";

                    String datade2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    parametros.put("dtini", datade2);
                    parametros.put("dtfim", dataate2);
                } else {
                    query += " AND 1 = 1 ";
                }

                query += " GROUP BY p.nome ";

                if (RelatorioExtrasGUI.rbDecrescente.isSelected()) {
                    query += " ORDER BY totalvendidos DESC ";
                    parametros.put("ordenacao", "PRODUTOS MAIS VENDIDOS");
                } else {
                    query += " ORDER BY totalvendidos ASC ";
                    parametros.put("ordenacao", "PRODUTOS MENOS VENDIDOS");
                }

                if (!RelatorioExtrasGUI.chbLimite.isSelected()) {
                    if (RelatorioExtrasGUI.tfLimite.getText().length() <= 0){
                        JOptionPane.showMessageDialog(this, "Informe o limite de registros!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.tfLimite.requestFocus();
                        return;
                    }
                    query += " LIMIT " + RelatorioExtrasGUI.tfLimite.getText().trim() + " ";
                    parametros.put("registros", RelatorioExtrasGUI.tfLimite.getText().trim());
                } else {
                    query += " ";
                }

                parametros.put("query", query);

                try {
                    new ImprimeRTA(arquivo, parametros);
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                }
            }
            if (RelatorioExtrasGUI.rbProdutosPromocao.isSelected()) {
                String arquivo = "ProdutosPromocaoNoPeriodo";
                HashMap parametros = new HashMap();

                if (!RelatorioExtrasGUI.chbData.isSelected()) {
                    if (RelatorioExtrasGUI.dcDataDe.getDate().compareTo(RelatorioExtrasGUI.dcDataAte.getDate()) == 1) {
                        JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.dcDataDe.requestFocus();
                        return;
                    }
                    String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    query += " AND prom.inicio >= '" + datade + "' AND prom.termino <= '" + dataate + "' ";

                    String datade2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    parametros.put("dtini", datade2);
                    parametros.put("dtfim", dataate2);
                } else {
                    query += " AND 1 = 1 ";
                }

                if (RelatorioExtrasGUI.rbDecrescente.isSelected()) {
                    query += " ORDER BY prod.id DESC ";
                    parametros.put("ordenacao", "DECRESCENTE");
                } else {
                    query += " ORDER BY prod.id ASC ";
                    parametros.put("ordenacao", "CRESCENTE");
                }

                if (!RelatorioExtrasGUI.chbLimite.isSelected()) {
                    if (RelatorioExtrasGUI.tfLimite.getText().length() <= 0){
                        JOptionPane.showMessageDialog(this, "Informe o limite de registros!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.tfLimite.requestFocus();
                        return;
                    }
                    query += " LIMIT " + RelatorioExtrasGUI.tfLimite.getText().trim() + " ";
                    parametros.put("registros", RelatorioExtrasGUI.tfLimite.getText().trim());
                } else {
                    query += " ";
                }

                parametros.put("query", query);

                try {
                    new ImprimeRTA(arquivo, parametros);
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                }
            }
            if (RelatorioExtrasGUI.rbPercas.isSelected()) {
                String arquivo = "PercasProdutosNoPeriodo";
                HashMap parametros = new HashMap();

                if (!RelatorioExtrasGUI.chbData.isSelected()) {
                    if (RelatorioExtrasGUI.dcDataDe.getDate().compareTo(RelatorioExtrasGUI.dcDataAte.getDate()) == 1) {
                        JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.dcDataDe.requestFocus();
                        return;
                    }
                    String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    query += " AND date(per.dataperca) BETWEEN '" + datade + "' AND '" + dataate + "' ";

                    String datade2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    parametros.put("dtini", datade2);
                    parametros.put("dtfim", dataate2);
                } else {
                    query += " AND 1 = 1 ";
                }

                if (RelatorioExtrasGUI.rbDecrescente.isSelected()) {
                    query += " ORDER BY p.id DESC ";
                    parametros.put("ordenacao", "DECRESCENTE");
                } else {
                    query += " ORDER BY p.id ASC ";
                    parametros.put("ordenacao", "CRESCENTE");
                }

                if (!RelatorioExtrasGUI.chbLimite.isSelected()) {
                    if (RelatorioExtrasGUI.tfLimite.getText().length() <= 0){
                        JOptionPane.showMessageDialog(this, "Informe o limite de registros!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.tfLimite.requestFocus();
                        return;
                    }
                    query += " LIMIT " + RelatorioExtrasGUI.tfLimite.getText().trim() + " ";
                    parametros.put("registros", RelatorioExtrasGUI.tfLimite.getText().trim());
                } else {
                    query += " ";
                }

                parametros.put("query", query);

                try {
                    new ImprimeRTA(arquivo, parametros);
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btImprimirActionPerformed

    private void rbCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCaixaActionPerformed
        RelatorioPedidosGUI.getInstancia().setVisible(false);
        RelatorioPedidosGUI.setInstanciaNull();

        RelatorioEstoqueGUI.getInstancia().setVisible(false);
        RelatorioEstoqueGUI.setInstanciaNull();

        RelatorioExtrasGUI.getInstancia().setVisible(false);
        RelatorioExtrasGUI.setInstanciaNull();

        RelatorioCaixaGUI ae = new RelatorioCaixaGUI().getInstancia();
        dpFiltros.remove(ae.getInstancia());
        dpFiltros.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(50, 20);
        ae.getInstancia().toFront();
    }//GEN-LAST:event_rbCaixaActionPerformed

    private void btVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisualizarActionPerformed
        String query = " 1 = 1 ";
        if (rbCaixa.isSelected()) {
            if (!RelatorioCaixaGUI.chbCodigo.isSelected()) {
                if (Integer.parseInt(RelatorioCaixaGUI.tfCodDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfCodDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioCaixaGUI.tfCodAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfCodAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioCaixaGUI.tfCodAte.getText())) < (Integer.parseInt(RelatorioCaixaGUI.tfCodDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfCodDe.requestFocus();
                    return;
                }
                query += " AND fluxofinan.`id` BETWEEN " + RelatorioCaixaGUI.tfCodDe.getText() + " AND " + RelatorioCaixaGUI.tfCodAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioCaixaGUI.chbValor.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfValorAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfValorDe.requestFocus();
                    return;
                }
                query += " AND fluxofinan.`valortotal` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioCaixaGUI.chbData.isSelected()) {
                if (RelatorioCaixaGUI.dcDataDe.getDate().compareTo(RelatorioCaixaGUI.dcDataAte.getDate()) == 1) {
                    JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.dcDataDe.requestFocus();
                    return;
                }
                String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioCaixaGUI.dcDataDe.getDate());
                String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioCaixaGUI.dcDataAte.getDate());
                query += " AND date(fluxofinan.`datahora`) BETWEEN '" + datade + "' AND '" + dataate + "' ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioCaixaGUI.chbPedido.isSelected()) {
                if (Integer.parseInt(RelatorioCaixaGUI.tfPedidoDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código do pedido inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfPedidoDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioCaixaGUI.tfPedidoAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código do pedido final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfPedidoAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioCaixaGUI.tfPedidoAte.getText())) < (Integer.parseInt(RelatorioCaixaGUI.tfPedidoDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfPedidoDe.requestFocus();
                    return;
                }
                query += " AND fluxofinan.`idpedido` BETWEEN " + RelatorioCaixaGUI.tfPedidoDe.getText() + " AND " + RelatorioCaixaGUI.tfPedidoAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (RelatorioCaixaGUI.cbTipo.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioCaixaGUI.cbTipo.getSelectedIndex() == 1) {
                query += " AND fluxofinan.`tipomovimentacao` = 'E' ";
            } else {
                query += " AND fluxofinan.`tipomovimentacao` = 'S' ";
            }
            if (RelatorioCaixaGUI.cbTipoPedido.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioCaixaGUI.cbTipoPedido.getSelectedIndex() == 1) {
                query += " AND pedido.`tipopedido` = 'E' ";
            } else {
                query += " AND pedido.`tipopedido` = 'L' ";
            }
            if (RelatorioCaixaGUI.cbConta.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idconta` = " + RelatorioCaixaGUI.cbConta.getSelectedId() + " ";
            }
            if (RelatorioCaixaGUI.cbFormaPgto.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idtipospgto` = " + RelatorioCaixaGUI.cbFormaPgto.getSelectedId() + " ";
            }

            query += " ORDER BY fluxofinan.`id` ASC ";

            String arquivo = "Caixa";
            HashMap parametros = new HashMap();
            parametros.put("query", query);
            try {
                new RelatorioRTA(arquivo, parametros);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            }
        }
        if (rbPedidos.isSelected()) {
            if (!RelatorioPedidosGUI.chbCodigo.isSelected()) {
                if (Integer.parseInt(RelatorioPedidosGUI.tfCodDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfCodDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioPedidosGUI.tfCodAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfCodAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioPedidosGUI.tfCodAte.getText())) < (Integer.parseInt(RelatorioPedidosGUI.tfCodDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfCodDe.requestFocus();
                    return;
                }
                query += " AND pedido.`id` BETWEEN " + RelatorioPedidosGUI.tfCodDe.getText() + " AND " + RelatorioPedidosGUI.tfCodAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioPedidosGUI.chbValor.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfValorAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfValorDe.requestFocus();
                    return;
                }
                query += " AND pedido.`valortotal` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioPedidosGUI.chbData.isSelected()) {
                if (RelatorioPedidosGUI.dcDataDe.getDate().compareTo(RelatorioPedidosGUI.dcDataAte.getDate()) == 1) {
                    JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.dcDataDe.requestFocus();
                    return;
                }
                String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioPedidosGUI.dcDataDe.getDate());
                String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioPedidosGUI.dcDataAte.getDate());
                query += " AND date(pedido.`datahorapedido`) BETWEEN '" + datade + "' AND '" + dataate + "' ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (RelatorioPedidosGUI.cbTipoPedido.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioPedidosGUI.cbTipoPedido.getSelectedIndex() == 1) {
                query += " AND pedido.`tipopedido` = 'E' ";
            } else {
                query += " AND pedido.`tipopedido` = 'L' ";
            }
            if (RelatorioPedidosGUI.cbConta.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idconta` = " + RelatorioPedidosGUI.cbConta.getSelectedId() + " ";
            }
            if (RelatorioPedidosGUI.cbFormaPgto.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idtipospgto` = " + RelatorioPedidosGUI.cbFormaPgto.getSelectedId() + " ";
            }
            if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 1) {
                query += " AND pedido.`situacao` = 'A' ";
            } else if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 2) {
                query += " AND pedido.`situacao` = 'C' ";
            } else if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 3) {
                query += " AND pedido.`situacao` = 'F' ";
            } else {
                query += " AND pedido.`situacao` = 'P' ";
            }
            if (RelatorioPedidosGUI.cbOperador.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND funcionario.`id` = " + RelatorioPedidosGUI.cbOperador.getSelectedId() + " ";
            }

            query += " ORDER BY pedido.`id` ASC ";

            String arquivo = "Pedidos";
            HashMap parametros = new HashMap();
            parametros.put("query", query);
            try {
                new RelatorioRTA(arquivo, parametros);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            }
        }
        if (rbEstoque.isSelected()) {
            if (!RelatorioEstoqueGUI.chbCodigo.isSelected()) {
                if (Integer.parseInt(RelatorioEstoqueGUI.tfCodDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCodDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioEstoqueGUI.tfCodAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCodAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioEstoqueGUI.tfCodAte.getText())) < (Integer.parseInt(RelatorioEstoqueGUI.tfCodDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCodDe.requestFocus();
                    return;
                }
                query += " AND produto.`id` BETWEEN " + RelatorioEstoqueGUI.tfCodDe.getText() + " AND " + RelatorioEstoqueGUI.tfCodAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbNome.isSelected()) {
                query += " AND produto.`nome` LIKE '%" + RelatorioEstoqueGUI.tfNome.getText().trim() + "%' ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbCusto.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor de custo final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCustoAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCustoDe.requestFocus();
                    return;
                }
                query += " AND produto.`precocusto` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbVenda.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor de venda final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfVendaAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfVendaDe.requestFocus();
                    return;
                }
                query += " AND produto.`precovenda` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbEstoque.isSelected()) {
                if (Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueAte.getText().replace(",", ".")) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe a quantidade final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfEstoqueAte.requestFocus();
                    return;
                }
                if ((Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueAte.getText().replace(",", "."))) < (Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueDe.getText().replace(",", ".")))) {
                    JOptionPane.showMessageDialog(null, "Quantidade inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfEstoqueDe.requestFocus();
                    return;
                }
                query += " AND produto.`qtd` BETWEEN " + Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueDe.getText().replace(",", ".")) + " AND " + Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueAte.getText().replace(",", ".")) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (RelatorioEstoqueGUI.cbUnidade.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbUnidade.getSelectedIndex() == 1) {
                query += " AND produto.`unidade` = 'UN' ";
            } else if (RelatorioEstoqueGUI.cbUnidade.getSelectedIndex() == 2) {
                query += " AND produto.`unidade` = 'KG' ";
            } else {
                query += " AND produto.`unidade` = 'L' ";
            }
            if (RelatorioEstoqueGUI.cbTipo.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbTipo.getSelectedIndex() == 1) {
                query += " AND produto.`tipo` = 'F' ";
            } else {
                query += " AND produto.`tipo` = 'I' ";
            }
            if (RelatorioEstoqueGUI.cbComposto.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbComposto.getSelectedIndex() == 1) {
                query += " AND produto.`composto` = 'S' ";
            } else {
                query += " AND produto.`composto` = 'N' ";
            }
            if (RelatorioEstoqueGUI.cbSituacao.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbSituacao.getSelectedIndex() == 1) {
                query += " AND produto.`situacao` = 'A' ";
            } else {
                query += " AND produto.`situacao` = 'I' ";
            }

            query += " ORDER BY produto.`id` ASC ";

            String arquivo = "Estoque";
            HashMap parametros = new HashMap();
            parametros.put("query", query);
            try {
                new RelatorioRTA(arquivo, parametros);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            }
        }
        if (rbExtras.isSelected()) {
            if (RelatorioExtrasGUI.rbProdutosVenda.isSelected()) {
                String arquivo = "ProdutosVendidosNoPeriodo";
                HashMap parametros = new HashMap();

                if (!RelatorioExtrasGUI.chbData.isSelected()) {
                    if (RelatorioExtrasGUI.dcDataDe.getDate().compareTo(RelatorioExtrasGUI.dcDataAte.getDate()) == 1) {
                        JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.dcDataDe.requestFocus();
                        return;
                    }
                    String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    query += " AND date(pe.datahorapedido) BETWEEN '" + datade + "' AND '" + dataate + "' ";

                    String datade2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    parametros.put("dtini", datade2);
                    parametros.put("dtfim", dataate2);
                } else {
                    query += " AND 1 = 1 ";
                }

                query += " GROUP BY p.nome ";

                if (RelatorioExtrasGUI.rbDecrescente.isSelected()) {
                    query += " ORDER BY totalvendidos DESC ";
                    parametros.put("ordenacao", "PRODUTOS MAIS VENDIDOS");
                } else {
                    query += " ORDER BY totalvendidos ASC ";
                    parametros.put("ordenacao", "PRODUTOS MENOS VENDIDOS");
                }

                if (!RelatorioExtrasGUI.chbLimite.isSelected()) {
                    if (RelatorioExtrasGUI.tfLimite.getText().length() <= 0){
                        JOptionPane.showMessageDialog(this, "Informe o limite de registros!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.tfLimite.requestFocus();
                        return;
                    }
                    query += " LIMIT " + RelatorioExtrasGUI.tfLimite.getText().trim() + " ";
                    parametros.put("registros", RelatorioExtrasGUI.tfLimite.getText().trim());
                } else {
                    query += " ";
                }

                parametros.put("query", query);

                try {
                    new RelatorioRTA(arquivo, parametros);
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                }
            }
            if (RelatorioExtrasGUI.rbProdutosPromocao.isSelected()) {
                String arquivo = "ProdutosPromocaoNoPeriodo";
                HashMap parametros = new HashMap();

                if (!RelatorioExtrasGUI.chbData.isSelected()) {
                    if (RelatorioExtrasGUI.dcDataDe.getDate().compareTo(RelatorioExtrasGUI.dcDataAte.getDate()) == 1) {
                        JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.dcDataDe.requestFocus();
                        return;
                    }
                    String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    query += " AND prom.inicio >= '" + datade + "' AND prom.termino <= '" + dataate + "' ";

                    String datade2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    parametros.put("dtini", datade2);
                    parametros.put("dtfim", dataate2);
                } else {
                    query += " AND 1 = 1 ";
                }

                if (RelatorioExtrasGUI.rbDecrescente.isSelected()) {
                    query += " ORDER BY prod.id DESC ";
                    parametros.put("ordenacao", "DECRESCENTE");
                } else {
                    query += " ORDER BY prod.id ASC ";
                    parametros.put("ordenacao", "CRESCENTE");
                }

                if (!RelatorioExtrasGUI.chbLimite.isSelected()) {
                    if (RelatorioExtrasGUI.tfLimite.getText().length() <= 0){
                        JOptionPane.showMessageDialog(this, "Informe o limite de registros!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.tfLimite.requestFocus();
                        return;
                    }
                    query += " LIMIT " + RelatorioExtrasGUI.tfLimite.getText().trim() + " ";
                    parametros.put("registros", RelatorioExtrasGUI.tfLimite.getText().trim());
                } else {
                    query += " ";
                }

                parametros.put("query", query);

                try {
                    new RelatorioRTA(arquivo, parametros);
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                }
            }
            if (RelatorioExtrasGUI.rbPercas.isSelected()) {
                String arquivo = "PercasProdutosNoPeriodo";
                HashMap parametros = new HashMap();

                if (!RelatorioExtrasGUI.chbData.isSelected()) {
                    if (RelatorioExtrasGUI.dcDataDe.getDate().compareTo(RelatorioExtrasGUI.dcDataAte.getDate()) == 1) {
                        JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.dcDataDe.requestFocus();
                        return;
                    }
                    String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    query += " AND date(per.dataperca) BETWEEN '" + datade + "' AND '" + dataate + "' ";

                    String datade2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    parametros.put("dtini", datade2);
                    parametros.put("dtfim", dataate2);
                } else {
                    query += " AND 1 = 1 ";
                }

                if (RelatorioExtrasGUI.rbDecrescente.isSelected()) {
                    query += " ORDER BY p.id DESC ";
                    parametros.put("ordenacao", "DECRESCENTE");
                } else {
                    query += " ORDER BY p.id ASC ";
                    parametros.put("ordenacao", "CRESCENTE");
                }

                if (!RelatorioExtrasGUI.chbLimite.isSelected()) {
                    if (RelatorioExtrasGUI.tfLimite.getText().length() <= 0){
                        JOptionPane.showMessageDialog(this, "Informe o limite de registros!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.tfLimite.requestFocus();
                        return;
                    }
                    query += " LIMIT " + RelatorioExtrasGUI.tfLimite.getText().trim() + " ";
                    parametros.put("registros", RelatorioExtrasGUI.tfLimite.getText().trim());
                } else {
                    query += " ";
                }

                parametros.put("query", query);

                try {
                    new RelatorioRTA(arquivo, parametros);
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btVisualizarActionPerformed

    private void btGerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarPDFActionPerformed
        String query = " 1 = 1 ";
        if (rbCaixa.isSelected()) {
            if (!RelatorioCaixaGUI.chbCodigo.isSelected()) {
                if (Integer.parseInt(RelatorioCaixaGUI.tfCodDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfCodDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioCaixaGUI.tfCodAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfCodAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioCaixaGUI.tfCodAte.getText())) < (Integer.parseInt(RelatorioCaixaGUI.tfCodDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfCodDe.requestFocus();
                    return;
                }
                query += " AND fluxofinan.`id` BETWEEN " + RelatorioCaixaGUI.tfCodDe.getText() + " AND " + RelatorioCaixaGUI.tfCodAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioCaixaGUI.chbValor.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfValorAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfValorDe.requestFocus();
                    return;
                }
                query += " AND fluxofinan.`valortotal` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioCaixaGUI.tfValorAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioCaixaGUI.chbData.isSelected()) {
                if (RelatorioCaixaGUI.dcDataDe.getDate().compareTo(RelatorioCaixaGUI.dcDataAte.getDate()) == 1) {
                    JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.dcDataDe.requestFocus();
                    return;
                }
                String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioCaixaGUI.dcDataDe.getDate());
                String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioCaixaGUI.dcDataAte.getDate());
                query += " AND date(fluxofinan.`datahora`) BETWEEN '" + datade + "' AND '" + dataate + "' ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioCaixaGUI.chbPedido.isSelected()) {
                if (Integer.parseInt(RelatorioCaixaGUI.tfPedidoDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código do pedido inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfPedidoDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioCaixaGUI.tfPedidoAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código do pedido final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfPedidoAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioCaixaGUI.tfPedidoAte.getText())) < (Integer.parseInt(RelatorioCaixaGUI.tfPedidoDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioCaixaGUI.tfPedidoDe.requestFocus();
                    return;
                }
                query += " AND fluxofinan.`idpedido` BETWEEN " + RelatorioCaixaGUI.tfPedidoDe.getText() + " AND " + RelatorioCaixaGUI.tfPedidoAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (RelatorioCaixaGUI.cbTipo.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioCaixaGUI.cbTipo.getSelectedIndex() == 1) {
                query += " AND fluxofinan.`tipomovimentacao` = 'E' ";
            } else {
                query += " AND fluxofinan.`tipomovimentacao` = 'S' ";
            }
            if (RelatorioCaixaGUI.cbTipoPedido.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioCaixaGUI.cbTipoPedido.getSelectedIndex() == 1) {
                query += " AND pedido.`tipopedido` = 'E' ";
            } else {
                query += " AND pedido.`tipopedido` = 'L' ";
            }
            if (RelatorioCaixaGUI.cbConta.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idconta` = " + RelatorioCaixaGUI.cbConta.getSelectedId() + " ";
            }
            if (RelatorioCaixaGUI.cbFormaPgto.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idtipospgto` = " + RelatorioCaixaGUI.cbFormaPgto.getSelectedId() + " ";
            }

            query += " ORDER BY fluxofinan.`id` ASC ";

            String arquivo = "Caixa";
            HashMap parametros = new HashMap();
            parametros.put("query", query);
            try {
                new GeraPdfRTA(arquivo, parametros);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            }
        }
        if (rbPedidos.isSelected()) {
            if (!RelatorioPedidosGUI.chbCodigo.isSelected()) {
                if (Integer.parseInt(RelatorioPedidosGUI.tfCodDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfCodDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioPedidosGUI.tfCodAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfCodAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioPedidosGUI.tfCodAte.getText())) < (Integer.parseInt(RelatorioPedidosGUI.tfCodDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfCodDe.requestFocus();
                    return;
                }
                query += " AND pedido.`id` BETWEEN " + RelatorioPedidosGUI.tfCodDe.getText() + " AND " + RelatorioPedidosGUI.tfCodAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioPedidosGUI.chbValor.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfValorAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.tfValorDe.requestFocus();
                    return;
                }
                query += " AND pedido.`valortotal` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioPedidosGUI.tfValorAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioPedidosGUI.chbData.isSelected()) {
                if (RelatorioPedidosGUI.dcDataDe.getDate().compareTo(RelatorioPedidosGUI.dcDataAte.getDate()) == 1) {
                    JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioPedidosGUI.dcDataDe.requestFocus();
                    return;
                }
                String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioPedidosGUI.dcDataDe.getDate());
                String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioPedidosGUI.dcDataAte.getDate());
                query += " AND date(pedido.`datahorapedido`) BETWEEN '" + datade + "' AND '" + dataate + "' ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (RelatorioPedidosGUI.cbTipoPedido.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioPedidosGUI.cbTipoPedido.getSelectedIndex() == 1) {
                query += " AND pedido.`tipopedido` = 'E' ";
            } else {
                query += " AND pedido.`tipopedido` = 'L' ";
            }
            if (RelatorioPedidosGUI.cbConta.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idconta` = " + RelatorioPedidosGUI.cbConta.getSelectedId() + " ";
            }
            if (RelatorioPedidosGUI.cbFormaPgto.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND fluxofinan.`idtipospgto` = " + RelatorioPedidosGUI.cbFormaPgto.getSelectedId() + " ";
            }
            if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 1) {
                query += " AND pedido.`situacao` = 'A' ";
            } else if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 2) {
                query += " AND pedido.`situacao` = 'C' ";
            } else if (RelatorioPedidosGUI.cbSituacao.getSelectedIndex() == 3) {
                query += " AND pedido.`situacao` = 'F' ";
            } else {
                query += " AND pedido.`situacao` = 'P' ";
            }
            if (RelatorioPedidosGUI.cbOperador.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else {
                query += " AND funcionario.`id` = " + RelatorioPedidosGUI.cbOperador.getSelectedId() + " ";
            }

            query += " ORDER BY pedido.`id` ASC ";

            String arquivo = "Pedidos";
            HashMap parametros = new HashMap();
            parametros.put("query", query);
            try {
                new GeraPdfRTA(arquivo, parametros);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            }
        }
        if (rbEstoque.isSelected()) {
            if (!RelatorioEstoqueGUI.chbCodigo.isSelected()) {
                if (Integer.parseInt(RelatorioEstoqueGUI.tfCodDe.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código inicial!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCodDe.requestFocus();
                    return;
                }
                if (Integer.parseInt(RelatorioEstoqueGUI.tfCodAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o código final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCodAte.requestFocus();
                    return;
                }
                if ((Integer.parseInt(RelatorioEstoqueGUI.tfCodAte.getText())) < (Integer.parseInt(RelatorioEstoqueGUI.tfCodDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Código inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCodDe.requestFocus();
                    return;
                }
                query += " AND produto.`id` BETWEEN " + RelatorioEstoqueGUI.tfCodDe.getText() + " AND " + RelatorioEstoqueGUI.tfCodAte.getText() + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbNome.isSelected()) {
                query += " AND produto.`nome` LIKE '%" + RelatorioEstoqueGUI.tfNome.getText().trim() + "%' ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbCusto.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor de custo final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCustoAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfCustoDe.requestFocus();
                    return;
                }
                query += " AND produto.`precocusto` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfCustoAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbVenda.isSelected()) {
                if (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaAte.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o valor de venda final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfVendaAte.requestFocus();
                    return;
                }
                if ((ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaAte.getText())) < (ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaDe.getText()))) {
                    JOptionPane.showMessageDialog(null, "Valor inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfVendaDe.requestFocus();
                    return;
                }
                query += " AND produto.`precovenda` BETWEEN " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaDe.getText()) + " AND " + ReplaceMoedaRTA.moedaToDouble(RelatorioEstoqueGUI.tfVendaAte.getText()) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (!RelatorioEstoqueGUI.chbEstoque.isSelected()) {
                if (Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueAte.getText().replace(",", ".")) == 0) {
                    JOptionPane.showMessageDialog(null, "Informe a quantidade final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfEstoqueAte.requestFocus();
                    return;
                }
                if ((Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueAte.getText().replace(",", "."))) < (Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueDe.getText().replace(",", ".")))) {
                    JOptionPane.showMessageDialog(null, "Quantidade inicial maior que final!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    RelatorioEstoqueGUI.tfEstoqueDe.requestFocus();
                    return;
                }
                query += " AND produto.`qtd` BETWEEN " + Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueDe.getText().replace(",", ".")) + " AND " + Double.parseDouble(RelatorioEstoqueGUI.tfEstoqueAte.getText().replace(",", ".")) + " ";
            } else {
                query += " AND 1 = 1 ";
            }
            if (RelatorioEstoqueGUI.cbUnidade.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbUnidade.getSelectedIndex() == 1) {
                query += " AND produto.`unidade` = 'UN' ";
            } else if (RelatorioEstoqueGUI.cbUnidade.getSelectedIndex() == 2) {
                query += " AND produto.`unidade` = 'KG' ";
            } else {
                query += " AND produto.`unidade` = 'L' ";
            }
            if (RelatorioEstoqueGUI.cbTipo.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbTipo.getSelectedIndex() == 1) {
                query += " AND produto.`tipo` = 'F' ";
            } else {
                query += " AND produto.`tipo` = 'I' ";
            }
            if (RelatorioEstoqueGUI.cbComposto.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbComposto.getSelectedIndex() == 1) {
                query += " AND produto.`composto` = 'S' ";
            } else {
                query += " AND produto.`composto` = 'N' ";
            }
            if (RelatorioEstoqueGUI.cbSituacao.getSelectedIndex() == 0) {
                query += " AND 1 = 1 ";
            } else if (RelatorioEstoqueGUI.cbSituacao.getSelectedIndex() == 1) {
                query += " AND produto.`situacao` = 'A' ";
            } else {
                query += " AND produto.`situacao` = 'I' ";
            }

            query += " ORDER BY produto.`id` ASC ";

            String arquivo = "Estoque";
            HashMap parametros = new HashMap();
            parametros.put("query", query);
            try {
                new GeraPdfRTA(arquivo, parametros);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
            }
        }
        if (rbExtras.isSelected()) {
            if (RelatorioExtrasGUI.rbProdutosVenda.isSelected()) {
                String arquivo = "ProdutosVendidosNoPeriodo";
                HashMap parametros = new HashMap();

                if (!RelatorioExtrasGUI.chbData.isSelected()) {
                    if (RelatorioExtrasGUI.dcDataDe.getDate().compareTo(RelatorioExtrasGUI.dcDataAte.getDate()) == 1) {
                        JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.dcDataDe.requestFocus();
                        return;
                    }
                    String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    query += " AND date(pe.datahorapedido) BETWEEN '" + datade + "' AND '" + dataate + "' ";

                    String datade2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    parametros.put("dtini", datade2);
                    parametros.put("dtfim", dataate2);
                } else {
                    query += " AND 1 = 1 ";
                }

                query += " GROUP BY p.nome ";

                if (RelatorioExtrasGUI.rbDecrescente.isSelected()) {
                    query += " ORDER BY totalvendidos DESC ";
                    parametros.put("ordenacao", "PRODUTOS MAIS VENDIDOS");
                } else {
                    query += " ORDER BY totalvendidos ASC ";
                    parametros.put("ordenacao", "PRODUTOS MENOS VENDIDOS");
                }

                if (!RelatorioExtrasGUI.chbLimite.isSelected()) {
                    if (RelatorioExtrasGUI.tfLimite.getText().length() <= 0){
                        JOptionPane.showMessageDialog(this, "Informe o limite de registros!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.tfLimite.requestFocus();
                        return;
                    }
                    query += " LIMIT " + RelatorioExtrasGUI.tfLimite.getText().trim() + " ";
                    parametros.put("registros", RelatorioExtrasGUI.tfLimite.getText().trim());
                } else {
                    query += " ";
                }

                parametros.put("query", query);

                try {
                    new GeraPdfRTA(arquivo, parametros);
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                }
            }
            if (RelatorioExtrasGUI.rbProdutosPromocao.isSelected()) {
                String arquivo = "ProdutosPromocaoNoPeriodo";
                HashMap parametros = new HashMap();

                if (!RelatorioExtrasGUI.chbData.isSelected()) {
                    if (RelatorioExtrasGUI.dcDataDe.getDate().compareTo(RelatorioExtrasGUI.dcDataAte.getDate()) == 1) {
                        JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.dcDataDe.requestFocus();
                        return;
                    }
                    String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    query += " AND prom.inicio >= '" + datade + "' AND prom.termino <= '" + dataate + "' ";

                    String datade2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    parametros.put("dtini", datade2);
                    parametros.put("dtfim", dataate2);
                } else {
                    query += " AND 1 = 1 ";
                }

                if (RelatorioExtrasGUI.rbDecrescente.isSelected()) {
                    query += " ORDER BY prod.id DESC ";
                    parametros.put("ordenacao", "DECRESCENTE");
                } else {
                    query += " ORDER BY prod.id ASC ";
                    parametros.put("ordenacao", "CRESCENTE");
                }

                if (!RelatorioExtrasGUI.chbLimite.isSelected()) {
                    if (RelatorioExtrasGUI.tfLimite.getText().length() <= 0) {
                        JOptionPane.showMessageDialog(this, "Informe o limite de registros!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.tfLimite.requestFocus();
                        return;
                    }
                    query += " LIMIT " + RelatorioExtrasGUI.tfLimite.getText().trim() + " ";
                    parametros.put("registros", RelatorioExtrasGUI.tfLimite.getText().trim());
                } else {
                    query += " ";
                }

                parametros.put("query", query);

                try {
                    new GeraPdfRTA(arquivo, parametros);
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                }
            }
            if (RelatorioExtrasGUI.rbPercas.isSelected()) {
                String arquivo = "PercasProdutosNoPeriodo";
                HashMap parametros = new HashMap();

                if (!RelatorioExtrasGUI.chbData.isSelected()) {
                    if (RelatorioExtrasGUI.dcDataDe.getDate().compareTo(RelatorioExtrasGUI.dcDataAte.getDate()) == 1) {
                        JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.dcDataDe.requestFocus();
                        return;
                    }
                    String datade = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate = new SimpleDateFormat("yyyy-MM-dd").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    query += " AND date(per.dataperca) BETWEEN '" + datade + "' AND '" + dataate + "' ";

                    String datade2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataDe.getDate());
                    String dataate2 = new SimpleDateFormat("dd/MM/yyyy").format(RelatorioExtrasGUI.dcDataAte.getDate());
                    parametros.put("dtini", datade2);
                    parametros.put("dtfim", dataate2);
                } else {
                    query += " AND 1 = 1 ";
                }

                if (RelatorioExtrasGUI.rbDecrescente.isSelected()) {
                    query += " ORDER BY p.id DESC ";
                    parametros.put("ordenacao", "DECRESCENTE");
                } else {
                    query += " ORDER BY p.id ASC ";
                    parametros.put("ordenacao", "CRESCENTE");
                }

                if (!RelatorioExtrasGUI.chbLimite.isSelected()) {
                    if (RelatorioExtrasGUI.tfLimite.getText().length() <= 0) {
                        JOptionPane.showMessageDialog(this, "Informe o limite de registros!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        RelatorioExtrasGUI.tfLimite.requestFocus();
                        return;
                    }
                    query += " LIMIT " + RelatorioExtrasGUI.tfLimite.getText().trim() + " ";
                    parametros.put("registros", RelatorioExtrasGUI.tfLimite.getText().trim());
                } else {
                    query += " ";
                }

                parametros.put("query", query);

                try {
                    new GeraPdfRTA(arquivo, parametros);
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n" + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btGerarPDFActionPerformed

    private void rbPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPedidosActionPerformed
        RelatorioCaixaGUI.getInstancia().setVisible(false);
        RelatorioCaixaGUI.setInstanciaNull();

        RelatorioEstoqueGUI.getInstancia().setVisible(false);
        RelatorioEstoqueGUI.setInstanciaNull();

        RelatorioExtrasGUI.getInstancia().setVisible(false);
        RelatorioExtrasGUI.setInstanciaNull();

        RelatorioPedidosGUI ae = new RelatorioPedidosGUI().getInstancia();
        dpFiltros.remove(ae.getInstancia());
        dpFiltros.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(50, 20);
        ae.getInstancia().toFront();
    }//GEN-LAST:event_rbPedidosActionPerformed

    private void rbEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEstoqueActionPerformed
        RelatorioCaixaGUI.getInstancia().setVisible(false);
        RelatorioCaixaGUI.setInstanciaNull();

        RelatorioPedidosGUI.getInstancia().setVisible(false);
        RelatorioPedidosGUI.setInstanciaNull();

        RelatorioExtrasGUI.getInstancia().setVisible(false);
        RelatorioExtrasGUI.setInstanciaNull();

        RelatorioEstoqueGUI ae = new RelatorioEstoqueGUI().getInstancia();
        dpFiltros.remove(ae.getInstancia());
        dpFiltros.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(50, 20);
        ae.getInstancia().toFront();
    }//GEN-LAST:event_rbEstoqueActionPerformed

    private void rbExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbExtrasActionPerformed
        RelatorioCaixaGUI.getInstancia().setVisible(false);
        RelatorioCaixaGUI.setInstanciaNull();

        RelatorioPedidosGUI.getInstancia().setVisible(false);
        RelatorioPedidosGUI.setInstanciaNull();

        RelatorioEstoqueGUI.getInstancia().setVisible(false);
        RelatorioEstoqueGUI.setInstanciaNull();

        RelatorioExtrasGUI ae = new RelatorioExtrasGUI().getInstancia();
        dpFiltros.remove(ae.getInstancia());
        dpFiltros.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(50, 20);
        ae.getInstancia().toFront();
    }//GEN-LAST:event_rbExtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgModulo;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGerarPDF;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btVisualizar;
    private javax.swing.JDesktopPane dpFiltros;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnModulos;
    private javax.swing.JRadioButton rbCaixa;
    private javax.swing.JRadioButton rbEstoque;
    private javax.swing.JRadioButton rbExtras;
    private javax.swing.JRadioButton rbPedidos;
    // End of variables declaration//GEN-END:variables
}
