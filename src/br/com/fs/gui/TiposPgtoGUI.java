package br.com.fs.gui;

import br.com.fs.dao.TiposPgtoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.tm.TiposPgtoTableModel;
import br.com.fs.to.TiposPgtoTO;
import java.awt.Cursor;
import java.beans.PropertyVetoException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class TiposPgtoGUI extends javax.swing.JInternalFrame {

    private static TiposPgtoGUI instancia = null;

    public TiposPgtoGUI() {
        initComponents();
        this.construtor();
    }

    public static TiposPgtoGUI getInstancia() {
        if (instancia == null) {
            instancia = new TiposPgtoGUI();
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
        pnDetalhes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbSituacao = new javax.swing.JComboBox();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        pnConsulta = new javax.swing.JPanel();
        spTabela = new javax.swing.JScrollPane();
        tbTipos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Formas de pagamento");
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

        pnDetalhes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Código:");

        lbCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCodigo.setText("000");

        jLabel3.setText("Nome:");

        jLabel4.setText("Descrição:");

        jLabel5.setText("Situação:");

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "INATIVO" }));

        javax.swing.GroupLayout pnDetalhesLayout = new javax.swing.GroupLayout(pnDetalhes);
        pnDetalhes.setLayout(pnDetalhesLayout);
        pnDetalhesLayout.setHorizontalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCodigo)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDetalhesLayout.setVerticalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        pnConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tbTipos.setModel(new TiposPgtoTableModel());
        tbTipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTiposMouseClicked(evt);
            }
        });
        spTabela.setViewportView(tbTipos);

        javax.swing.GroupLayout pnConsultaLayout = new javax.swing.GroupLayout(pnConsulta);
        pnConsulta.setLayout(pnConsultaLayout);
        pnConsultaLayout.setHorizontalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );
        pnConsultaLayout.setVerticalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar))
                    .addComponent(pnConsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btExcluir)
                    .addComponent(btSalvar)
                    .addComponent(btNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void construtor() {
        bloqueiaFormulario(true);
        this.carregaTabela();
    }

    public void carregaTabela() {
        try {
            TiposPgtoTableModel p = (TiposPgtoTableModel) tbTipos.getModel();
            tbTipos.getTableHeader().setReorderingAllowed(false);
            tbTipos.setColumnSelectionAllowed(false);
            tbTipos.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbTipos.getColumnModel().getColumn(0).setResizable(false); //não permite alterar largura coluna
            tbTipos.getColumnModel().getColumn(0).setPreferredWidth(60); //define largura da coluna
            tbTipos.getColumnModel().getColumn(0).setMaxWidth(60);
            tbTipos.getColumnModel().getColumn(1).setResizable(false);
            tbTipos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbTipos.setCursor(new Cursor(Cursor.HAND_CURSOR)); //define o cursor
            ((DefaultTableCellRenderer) tbTipos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbTipos.setDefaultRenderer(Object.class, new CellRenderer());
            TiposPgtoDAO dao = new TiposPgtoDAO();
            p.setDados(dao.buscarTodos());
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (tfNome.getText().trim().length() <= 1) {
            JOptionPane.showMessageDialog(this, "Informe a forma de pagamento!", "Alerta", JOptionPane.WARNING_MESSAGE);
            tfNome.requestFocus();
            return;
        } else if (tfNome.getText().trim().length() > 60) {
            JOptionPane.showMessageDialog(this, "A forma de pagamento não pode passar de 60 letras!", "Alerta", JOptionPane.WARNING_MESSAGE);
            tfNome.requestFocus();
            return;
        }
        if (tfDescricao.getText().trim().length() > 40) {
            JOptionPane.showMessageDialog(this, "A descrição não pode passar de 40 letras!", "Alerta", JOptionPane.WARNING_MESSAGE);
            tfDescricao.requestFocus();
            return;
        }
        try {
            if (TiposPgtoDAO.verificaExiste(tfNome.getText().trim(), Integer.parseInt(lbCodigo.getText()))) {
                JOptionPane.showMessageDialog(this, "Esta forma já está cadastrada!", "Atenção", JOptionPane.WARNING_MESSAGE);
                tfNome.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
        try {
            TiposPgtoDAO dao = new TiposPgtoDAO();
            TiposPgtoTO to = new TiposPgtoTO();
            try {
                to.setIdTipoPgto(lbCodigo.getText().trim());
                to.setTipo(tfNome.getText().trim());
                to.setDescricao(tfDescricao.getText().trim());
                if (cbSituacao.getSelectedItem().toString().equals("ATIVO")) {
                    to.setSituacao("A");
                } else {
                    to.setSituacao("I");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(),
                        "Erro ao salvar forma de pagamento!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Object obj = to;
            if (to.getIdTipoPgto() == 000) {
                dao.inserir(obj);
            } else {
                dao.alterar(obj);
            }

            JOptionPane.showMessageDialog(this, "Forma de pagamento salva com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.carregaTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(),
                    "Erro ao salvar forma de pagamento!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        bloqueiaFormulario(true);
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        bloqueiaFormulario(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        bloqueiaFormulario(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tbTiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTiposMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tbTipos.getSelectedRow();
            int codigo = Integer.parseInt(tbTipos.getValueAt(row, 0).toString());

            if (codigo == 1) {
                JOptionPane.showMessageDialog(this, "Forma de pagamento fixa, não pode ser alterada!",
                        "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                TiposPgtoDAO dao = new TiposPgtoDAO();
                TiposPgtoTO to = (TiposPgtoTO) dao.buscarId(codigo);
                lbCodigo.setText(String.valueOf(to.getIdTipoFormatado(to.getIdTipoPgto())));
                tfNome.setText(to.getTipo());
                tfDescricao.setText(to.getDescricao());
                cbSituacao.setSelectedItem(to.getSituacao());
                bloqueiaFormulario(false);
            } catch (Exception e) {
                JOptionPane.showInternalMessageDialog(this, "Erro ao consultar!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tbTiposMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int q = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?", "Atenção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (q == JOptionPane.YES_OPTION) {
            try {
                TiposPgtoDAO dao = new TiposPgtoDAO();
                TiposPgtoTO to = new TiposPgtoTO();
                to.setIdTipoPgto(lbCodigo.getText());
                Object obj = to;

                if (!dao.validarDelete(to.getIdTipoPgto())) {
                    dao.excluir(obj);

                    carregaTabela();

                    JOptionPane.showMessageDialog(this,
                            "Forma de pagamento excluída com sucesso!", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "<html><body><p align='center'>"
                            + "Esta forma de pagamento está associada a algum movimento de caixa<br>"
                            + "e não pôde ser excluída!</p></body></html>", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(),
                        "Erro ao excluir!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            bloqueiaFormulario(true);
        } else {
            bloqueiaFormulario(false);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void limparCampos() {
        lbCodigo.setText("000");
        tfNome.setText("");
        tfDescricao.setText("");
        cbSituacao.setSelectedItem("ATIVO");
    }

    private void bloqueiaFormulario(boolean controle) {
        if (controle) {
            limparCampos();
            tfNome.setEnabled(false);
            tfDescricao.setEnabled(false);
            cbSituacao.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btNovo.setEnabled(true);
            btNovo.requestFocus();
        } else {
            tfNome.setEnabled(true);
            tfDescricao.setEnabled(true);
            cbSituacao.setEnabled(true);
            if (lbCodigo.getText().equalsIgnoreCase("000")) {
                btExcluir.setEnabled(false);
            } else {
                btExcluir.setEnabled(true);
            }
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btNovo.setEnabled(false);
            tfNome.requestFocus();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JPanel pnConsulta;
    private javax.swing.JPanel pnDetalhes;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JScrollPane spTabela;
    private javax.swing.JTable tbTipos;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
