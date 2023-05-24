package br.com.fs.gui;

import br.com.fs.dao.ContasDAO;
import br.com.fs.dao.FluxoFinanDAO;
import br.com.fs.dao.LoginDAO;
import javax.swing.JOptionPane;

public class TransferenciaDeContaGUI extends javax.swing.JDialog {

    private final FluxoFinanGUI parent;
    private final int pedido;

    public TransferenciaDeContaGUI(FluxoFinanGUI pai, int codigo) {
        super();
        initComponents();
        parent = pai;
        pedido = codigo;
        this.setLocationRelativeTo(null);
        carregaComboContas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCorpo = new javax.swing.JPanel();
        pnConta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbConta = new br.com.fs.rta.JComboBox();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transferência de conta");
        setModal(true);

        pnConta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecionar conta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Conta:");

        javax.swing.GroupLayout pnContaLayout = new javax.swing.GroupLayout(pnConta);
        pnConta.setLayout(pnContaLayout);
        pnContaLayout.setHorizontalGroup(
            pnContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbConta, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        pnContaLayout.setVerticalGroup(
            pnContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
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
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)))
                .addContainerGap())
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        if (LoginDAO.operador.getIdFuncionario() == 1) {
            try {
                FluxoFinanDAO dao = new FluxoFinanDAO();
                dao.transfereConta(cbConta.getSelectedId(), pedido);
                JOptionPane.showMessageDialog(null, "Transferido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                parent.atualizarDetalhes();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao transferir de conta!\nErro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            SenhaSupervisorGUI gui = new SenhaSupervisorGUI(this);
            gui.setVisible(true);
            if (gui.retorno()) {
                try {
                    FluxoFinanDAO dao = new FluxoFinanDAO();
                    dao.transfereConta(cbConta.getSelectedId(), pedido);
                    JOptionPane.showMessageDialog(null, "Transferido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    parent.atualizarDetalhes();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao transferir de conta!\nErro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Senha de supervisor inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
            gui.dispose();
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    public static void carregaComboContas() {
        cbConta.adicionaValor(ContasDAO.montaCombo());
        cbConta.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    public static br.com.fs.rta.JComboBox cbConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnConta;
    private javax.swing.JPanel pnCorpo;
    // End of variables declaration//GEN-END:variables
}
