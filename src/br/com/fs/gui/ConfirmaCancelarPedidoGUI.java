package br.com.fs.gui;

import br.com.fs.dao.FluxoFinanDAO;
import br.com.fs.dao.LoginDAO;
import br.com.fs.dao.PedidoDAO;
import br.com.fs.rta.MascarasDouble;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.to.FluxoFinanTO;
import br.com.fs.to.PedidoTO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ConfirmaCancelarPedidoGUI extends javax.swing.JDialog {

    private final CancelarPedidoGUI pai;
    private final PedidoTO pedidoto;
    private final FluxoFinanTO finanto;
    private final ArrayList produtosSelecionados;
    private final ArrayList quantidadeProdutos;
    private final double valorItensSelecionados;

    public ConfirmaCancelarPedidoGUI(CancelarPedidoGUI parent, PedidoTO pedido, FluxoFinanTO financeiro, ArrayList selecionados, ArrayList qtdes, double valorItens) {
        super();
        pai = parent;
        pedidoto = pedido;
        finanto = financeiro;
        produtosSelecionados = selecionados;
        quantidadeProdutos = qtdes;
        valorItensSelecionados = valorItens;
        initComponents();
        this.construtor();
    }

    private void construtor() {
        this.setLocationRelativeTo(null);
        tfRetorno.setDocument(new MascarasDouble(9));
        tfRetorno.setText("0,00");
        lbCodPedido.setText(pedidoto.getIdPedFormatado(pedidoto.getIdPedido()) + " - " + pedidoto.getSenhaFormatado(pedidoto.getSenha()));
        lbOperador.setText(pedidoto.getFuncionario().getNome());
        lbSituacao.setText(pedidoto.getSituacao());
        lbForma.setText(finanto.getTipoPgto().getTipo());
        lbConta.setText(finanto.getConta().getNome());
        lbValorPedido.setText(ReplaceMoedaRTA.doubleToMoeda(finanto.getValorTotal()));
        lbValorItens.setText(ReplaceMoedaRTA.doubleToMoeda(valorItensSelecionados));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCorpo = new javax.swing.JPanel();
        pnInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbCodPedido = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbSituacao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbValorPedido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbValorItens = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfRetorno = new javax.swing.JTextField();
        btValorPedido = new javax.swing.JButton();
        btValorItens = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbOperador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbForma = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbConta = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmar cancelamento de pedido");
        setModal(true);
        setResizable(false);

        pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Pedido:");

        lbCodPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCodPedido.setText("000 - 000");

        jLabel2.setText("Situação:");

        lbSituacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSituacao.setText("SITUAÇÃO");

        jLabel4.setText("Valor do pedido:");

        lbValorPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbValorPedido.setText("R$ 0,00");

        jLabel6.setText("Itens selecionados:");

        lbValorItens.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbValorItens.setText("R$ 0,00");

        jLabel8.setText("Devolver ao cliente:");

        btValorPedido.setText("...do pedido");
        btValorPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValorPedidoActionPerformed(evt);
            }
        });

        btValorItens.setText("...dos itens selecionados");
        btValorItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValorItensActionPerformed(evt);
            }
        });

        jLabel9.setText("Operador:");

        lbOperador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbOperador.setText("OPERADOR");

        jLabel3.setText("Forma pgto:");

        lbForma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbForma.setText("FORMA");

        jLabel7.setText("Conta:");

        lbConta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbConta.setText("CONTA");

        jLabel5.setText("Devolver valor:");

        javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
        pnInfo.setLayout(pnInfoLayout);
        pnInfoLayout.setHorizontalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnInfoLayout.createSequentialGroup()
                        .addComponent(btValorPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btValorItens))
                    .addComponent(lbValorItens)
                    .addComponent(lbValorPedido)
                    .addComponent(lbConta)
                    .addComponent(lbForma)
                    .addComponent(lbSituacao)
                    .addComponent(lbOperador)
                    .addComponent(lbCodPedido))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnInfoLayout.setVerticalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbCodPedido))
                .addGap(7, 7, 7)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbOperador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbSituacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbForma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbConta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbValorPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbValorItens))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btValorPedido)
                    .addComponent(btValorItens)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnCorpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
        pai.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        if (LoginDAO.operador.getIdFuncionario() == 1) {
            if (ReplaceMoedaRTA.moedaToDouble(tfRetorno.getText()) > ReplaceMoedaRTA.moedaToDouble(lbValorPedido.getText())) {
                JOptionPane.showMessageDialog(null, "Você não pode devolver um montante maior que o valor do pedido!", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                PedidoDAO dao = new PedidoDAO();
                FluxoFinanDAO fluxodao = new FluxoFinanDAO();
                double valor = ReplaceMoedaRTA.moedaToDouble(tfRetorno.getText());
                if (!produtosSelecionados.isEmpty()) {
                    for (int i = 0; i < produtosSelecionados.size(); i++) {
                        dao.voltarEstoquePedido((int) produtosSelecionados.get(i), (double) quantidadeProdutos.get(i));
                    }
                }
                dao.alterar("C", pedidoto.getIdPedido());
                if (valor != 0) {
                    finanto.setTipomovimentacao("S");
                    finanto.setPedido(pedidoto);
                    finanto.setDatahora(new Date());
                    finanto.setValorTotal(valor);
                    finanto.setValorPago(valor);
                    finanto.setSituacao("E");
                    fluxodao.cancelamentoPedido(finanto);
                }
                PrincipalGUI.carregaTabela();
                JOptionPane.showMessageDialog(null, "Pedido cancelado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                pai.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cancelar pedido!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            SenhaSupervisorGUI gui = new SenhaSupervisorGUI(this);
            gui.setVisible(true);
            if (gui.retorno()) {
                try {
                    PedidoDAO dao = new PedidoDAO();
                    FluxoFinanDAO fluxodao = new FluxoFinanDAO();
                    double valor = ReplaceMoedaRTA.moedaToDouble(tfRetorno.getText());
                    if (!produtosSelecionados.isEmpty()) {
                        for (int i = 0; i < produtosSelecionados.size(); i++) {
                            dao.voltarEstoquePedido((int) produtosSelecionados.get(i), (double) quantidadeProdutos.get(i));
                        }
                    }
                    dao.alterar("C", pedidoto.getIdPedido());
                    if (valor != 0) {
                        finanto.setTipomovimentacao("S");
                        finanto.setPedido(pedidoto);
                        finanto.setDatahora(new Date());
                        finanto.setValorTotal(valor);
                        finanto.setValorPago(valor);
                        finanto.setSituacao("E");
                        fluxodao.cancelamentoPedido(finanto);
                    }
                    PrincipalGUI.carregaTabela();
                    JOptionPane.showMessageDialog(null, "Pedido cancelado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    pai.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao cancelar pedido!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Senha de supervisor inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
            gui.dispose();
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btValorPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValorPedidoActionPerformed
        tfRetorno.setText(String.valueOf(ReplaceMoedaRTA.moedaToDouble(lbValorPedido.getText())));
    }//GEN-LAST:event_btValorPedidoActionPerformed

    private void btValorItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValorItensActionPerformed
        tfRetorno.setText(String.valueOf(ReplaceMoedaRTA.moedaToDouble(lbValorItens.getText())));
    }//GEN-LAST:event_btValorItensActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btValorItens;
    private javax.swing.JButton btValorPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbCodPedido;
    private javax.swing.JLabel lbConta;
    private javax.swing.JLabel lbForma;
    private javax.swing.JLabel lbOperador;
    private javax.swing.JLabel lbSituacao;
    private javax.swing.JLabel lbValorItens;
    private javax.swing.JLabel lbValorPedido;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JTextField tfRetorno;
    // End of variables declaration//GEN-END:variables
}
