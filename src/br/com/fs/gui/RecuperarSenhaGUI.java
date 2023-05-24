package br.com.fs.gui;

import br.com.fs.dao.LoginDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RecuperarSenhaGUI extends javax.swing.JDialog {

    private LoginGUI framepai = new LoginGUI();

    public RecuperarSenhaGUI(LoginGUI parent) {
        super();
        framepai = parent;
        initComponents();
        this.setLocationRelativeTo(null);
        btOK.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBuscar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCPF = new javax.swing.JFormattedTextField();
        btBuscarSenha = new javax.swing.JButton();
        pnUsuarioSenha = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        btOK = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recuperar senha");
        setModal(true);

        pnBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Informe seu CPF:");

        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout pnBuscarLayout = new javax.swing.GroupLayout(pnBuscar);
        pnBuscar.setLayout(pnBuscarLayout);
        pnBuscarLayout.setHorizontalGroup(
            pnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBuscarLayout.setVerticalGroup(
            pnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btBuscarSenha.setText("Buscar senha");
        btBuscarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarSenhaActionPerformed(evt);
            }
        });

        pnUsuarioSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seu usuário e senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Usuário:");

        lbUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUsuario.setText("USUÁRIO");

        jLabel4.setText("Senha:");

        lbSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSenha.setText("SENHA");

        javax.swing.GroupLayout pnUsuarioSenhaLayout = new javax.swing.GroupLayout(pnUsuarioSenha);
        pnUsuarioSenha.setLayout(pnUsuarioSenhaLayout);
        pnUsuarioSenhaLayout.setHorizontalGroup(
            pnUsuarioSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUsuarioSenhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnUsuarioSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnUsuarioSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsuario)
                    .addComponent(lbSenha))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        pnUsuarioSenhaLayout.setVerticalGroup(
            pnUsuarioSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUsuarioSenhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnUsuarioSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnUsuarioSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbSenha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btOK.setText("Ok");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnUsuarioSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btBuscarSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCancelar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscarSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnUsuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOK)
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        framepai.preencheUserPw(lbUsuario.getText(), lbSenha.getText());
        this.dispose();
    }//GEN-LAST:event_btOKActionPerformed

    private void btBuscarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarSenhaActionPerformed
        SenhaSupervisorGUI gui = new SenhaSupervisorGUI(this);
        gui.setVisible(true);
        if (gui.retorno()) {
            String cpf = tfCPF.getText().trim();
            try {
                ArrayList arr = LoginDAO.recuperaSenha(cpf);
                lbUsuario.setText(arr.get(0).toString());
                lbSenha.setText(arr.get(1).toString());
                btOK.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "CPF não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
                btOK.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senha de supervisor inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
            btOK.setEnabled(false);
        }
        gui.dispose();
    }//GEN-LAST:event_btBuscarSenhaActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarSenha;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel pnBuscar;
    private javax.swing.JPanel pnUsuarioSenha;
    private javax.swing.JFormattedTextField tfCPF;
    // End of variables declaration//GEN-END:variables
}
