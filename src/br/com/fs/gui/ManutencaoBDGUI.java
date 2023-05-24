package br.com.fs.gui;

import br.com.fs.dao.Conexao;
import java.awt.HeadlessException;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ManutencaoBDGUI extends javax.swing.JInternalFrame {

    private static ManutencaoBDGUI instancia = null;
    private String caminhoMySQL = "";

    public ManutencaoBDGUI() {
        initComponents();
        this.construtor();
    }

    public static ManutencaoBDGUI getInstancia() {
        if (instancia == null) {
            instancia = new ManutencaoBDGUI();
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
        try {
            Conexao c = new Conexao();
            String sql = "select @@basedir as diretorio";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                caminhoMySQL = rs.getString("diretorio");
            }
            fcBackup.setVisible(false);
            c.getCon().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados!\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbAbas = new javax.swing.JTabbedPane();
        pnBackup = new javax.swing.JPanel();
        fcBackup = new javax.swing.JFileChooser();
        btBackup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Manutenção da base de dados");
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

        fcBackup.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fcBackup.setCurrentDirectory(new java.io.File("C:\\"));
            fcBackup.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione o caminho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

            btBackup.setText("Selecionar diretório para backup");
            btBackup.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btBackupActionPerformed(evt);
                }
            });

            jLabel1.setText("Dica: realize backups periódicos do seu sistema. Diariamente, se possível.");

            javax.swing.GroupLayout pnBackupLayout = new javax.swing.GroupLayout(pnBackup);
            pnBackup.setLayout(pnBackupLayout);
            pnBackupLayout.setHorizontalGroup(
                pnBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnBackupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                    .addComponent(fcBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            pnBackupLayout.setVerticalGroup(
                pnBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBackupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fcBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btBackup, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addContainerGap())
            );

            tbAbas.addTab("backup", pnBackup);

            getContentPane().add(tbAbas, java.awt.BorderLayout.CENTER);

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackupActionPerformed
        try {
            String arquivo = null;

            fcBackup.setVisible(true);

            int result = fcBackup.showSaveDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                arquivo = fcBackup.getSelectedFile().getAbsolutePath() + ".sql";

                File file = new File(arquivo);

                if (file.exists()) {
                    Object[] options = {"Sim", "Não"};
                    int opcao = JOptionPane.showOptionDialog(null, "Este arquivo já existe, deseja sobreescreve-lo?", "Atenção!",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (opcao == JOptionPane.YES_OPTION) {
                        Runtime.getRuntime().exec(caminhoMySQL + "bin\\mysqldump.exe -v -v -v --host=localhost --user=root --password=root --port=3306 --protocol=tcp --force --allow-keywords --compress  --add-drop-table --default-character-set=utf8 --hex-blob  --result-file=" + arquivo + " --routines --databases dbfastfood");
                        JOptionPane.showMessageDialog(null, "Backup realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        btBackupActionPerformed(evt);
                    }
                } else {
                    Runtime.getRuntime().exec(caminhoMySQL + "bin\\mysqldump.exe -v -v -v --host=localhost --user=root --password=root --port=3306 --protocol=tcp --force --allow-keywords --compress  --add-drop-table --default-character-set=utf8 --hex-blob  --result-file=" + arquivo + " --databases dbfastfood");
                    JOptionPane.showMessageDialog(null, "Backup realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar backup!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btBackupActionPerformed
    

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBackup;
    private javax.swing.JFileChooser fcBackup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnBackup;
    private javax.swing.JTabbedPane tbAbas;
    // End of variables declaration//GEN-END:variables
}
