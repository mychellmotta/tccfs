package br.com.fs.gui;

import br.com.fs.dao.CidadeDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.to.CidadeTO;
import java.awt.Cursor;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CidadesGUI extends javax.swing.JInternalFrame {

    private static CidadesGUI instancia = null;
    private ArrayList cidadesBusca = new ArrayList();
    private FuncionariosGUI f = null;

    public CidadesGUI() {
        initComponents();
        this.construtor();
    }

    public CidadesGUI(FuncionariosGUI f) {
        this.f = f;
        initComponents();
        this.construtor();
    }

    public static CidadesGUI getInstancia() {
        if (instancia == null) {
            instancia = new CidadesGUI();
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
            CidadeDAO t = new CidadeDAO();
            cidadesBusca = t.buscarTodos();
            atualizarBusca(cidadesBusca);
            bloqueiaFormulario(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Descrição: " + e.getMessage(),
                    "Erro ao carregar os produtos!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarBusca(ArrayList cidadesBusca) {
        //configuração da tabela
        String[] titulos = {"Código", "Nome", "Estado", "Situação"};
        tbBusca.setModel(new DefaultTableModel(titulos, 0) {
            //banco de colunas da tabela
            @Override
            public Class getColumnClass(int columnIndex) {
                return String.class;
            }

            //editaveis sim ou nao
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });

        //atribui valores a tabela
        DefaultTableModel dtm = (DefaultTableModel) tbBusca.getModel();
        cidadesBusca.stream().forEach((cidadesBusca1) -> {
            dtm.addRow(((ArrayList) cidadesBusca1).toArray());
        });
        ((DefaultTableCellRenderer) tbBusca.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        tbBusca.setDefaultRenderer(Object.class, new CellRenderer());
        tbBusca.setColumnSelectionAllowed(false); //selecionar toda a coluna
        tbBusca.getTableHeader().setReorderingAllowed(false); //ordenar a coluna
        spBusca.setViewportView(tbBusca); //joga a tabela dentro do scroll panel
        tbBusca.getColumnModel().getSelectionModel().
                setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION); //somente seleciona uma linha por vez
        tbBusca.getColumnModel().getColumn(0).setResizable(false); //não permite alterar largura coluna
        tbBusca.getColumnModel().getColumn(0).setPreferredWidth(60); //define largura da coluna
        tbBusca.getColumnModel().getColumn(0).setMaxWidth(60);
        tbBusca.getColumnModel().getColumn(1).setResizable(false);
        tbBusca.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbBusca.setCursor(new Cursor(Cursor.HAND_CURSOR)); //define o cursor
    }

    private void bloqueiaFormulario(boolean controle) {
        if (controle) {
            limparCampos();
            tfNome.setEnabled(false);
            cbUf.setEnabled(false);
            cbCadSituacao.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btNovo.setEnabled(true);
            btNovo.requestFocus();
        } else {
            tfNome.setEnabled(true);
            cbUf.setEnabled(true);
            cbCadSituacao.setEnabled(true);
            if (tfCodigo.getText().equalsIgnoreCase("000")) {
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

    private void limparCampos() {
        tfCodigo.setText("000");
        tfNome.setText("");
        cbUf.setSelectedItem("PR");
        cbCadSituacao.setSelectedItem("ATIVO");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCorpo = new javax.swing.JPanel();
        pnCadastro = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jlUf = new javax.swing.JLabel();
        cbUf = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cbCadSituacao = new javax.swing.JComboBox();
        tfCodigo = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        pnConsulta = new javax.swing.JPanel();
        tfConsulta = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        spBusca = new javax.swing.JScrollPane();
        tbBusca = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cidades");
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

        pnCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações da cidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lbCodigo.setText("Código:");

        lbNome.setText("Nome:");

        tfNome.setPreferredSize(new java.awt.Dimension(59, 20));

        jlUf.setText("UF:");

        cbUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PR", "SC", "RS", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PE", "PI", "RJ", "RN", "RO", "RR", "SP", "SE", "TO" }));
        cbUf.setMaximumSize(new java.awt.Dimension(32767, 25));
        cbUf.setMinimumSize(new java.awt.Dimension(56, 20));
        cbUf.setPreferredSize(new java.awt.Dimension(56, 20));

        jLabel1.setText("Situação:");

        cbCadSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "INATIVO" }));
        cbCadSituacao.setMinimumSize(new java.awt.Dimension(56, 20));
        cbCadSituacao.setPreferredSize(new java.awt.Dimension(56, 20));

        tfCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfCodigo.setText("000");

        javax.swing.GroupLayout pnCadastroLayout = new javax.swing.GroupLayout(pnCadastro);
        pnCadastro.setLayout(pnCadastroLayout);
        pnCadastroLayout.setHorizontalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbUf, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCodigo)
                    .addComponent(jlUf)
                    .addComponent(tfCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lbNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCadSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnCadastroLayout.setVerticalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(lbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlUf)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCadSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

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

        pnConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta de cidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/Busca.png"))); // NOI18N
        btBuscar.setMaximumSize(new java.awt.Dimension(49, 20));
        btBuscar.setMinimumSize(new java.awt.Dimension(49, 20));
        btBuscar.setPreferredSize(new java.awt.Dimension(33, 20));
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        tbBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBuscaMouseClicked(evt);
            }
        });
        spBusca.setViewportView(tbBusca);

        javax.swing.GroupLayout pnConsultaLayout = new javax.swing.GroupLayout(pnConsulta);
        pnConsulta.setLayout(pnConsultaLayout);
        pnConsultaLayout.setHorizontalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(spBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );
        pnConsultaLayout.setVerticalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(spBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnCadastro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnCorpoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)))
                .addContainerGap())
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnCorpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        bloqueiaFormulario(false);
        btExcluir.setEnabled(false);
        limparCampos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        bloqueiaFormulario(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (Integer.parseInt(tfCodigo.getText()) == 1) {
                JOptionPane.showMessageDialog(this, "Cidade fixa, pode apenas ser alterada!",
                        "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
        
        int q = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?", "Atenção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (q == JOptionPane.YES_OPTION) {
            try {
                CidadeDAO dao = new CidadeDAO();
                CidadeTO to = new CidadeTO();
                to.setIdCidade(tfCodigo.getText());
                Object obj = to;

                if (!dao.validarDelete(to.getIdCidade())) {
                    dao.excluir(obj);

                    cidadesBusca = dao.buscarTodos();
                    atualizarBusca(cidadesBusca);

                    JOptionPane.showMessageDialog(this,
                            "Cidade excluída com sucesso!", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Esta cidade não pôde ser excluída pois está associada a um operador!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Descrição: " + e.getMessage(),
                        "Erro ao excluir cidade!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            bloqueiaFormulario(true);
        } else {
            bloqueiaFormulario(false);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (tfNome.getText().trim().length() <= 1) {
            JOptionPane.showMessageDialog(this, "Informe o nome do funcionário!", "Alerta", JOptionPane.WARNING_MESSAGE);
            tfNome.requestFocus();
            return;
        } else if (tfNome.getText().trim().length() > 60) {
            JOptionPane.showMessageDialog(this, "O nome do funcionário não pode passar de 60 letras!", "Alerta", JOptionPane.WARNING_MESSAGE);
            tfNome.requestFocus();
            return;
        }
        try {
            if (CidadeDAO.verificaExiste(tfNome.getText().trim(), cbUf.getSelectedItem().toString(), Integer.parseInt(tfCodigo.getText()))) {
                JOptionPane.showMessageDialog(this, "Esta cidade já está cadastrada!", "Atenção", JOptionPane.WARNING_MESSAGE);
                tfNome.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar cidade!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            CidadeDAO dao = new CidadeDAO();
            CidadeTO to = new CidadeTO();
            try {

                to.setIdCidade(tfCodigo.getText().trim());
                to.setNome(tfNome.getText().trim());
                to.setUf(cbUf.getSelectedItem().toString());
                if (cbCadSituacao.getSelectedItem().toString().equals("ATIVO")) {
                    to.setSituacao("A");
                } else {
                    to.setSituacao("I");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Descrição: " + e.getMessage(),
                        "Erro ao salvar cidade!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Object obj = to;
            if (to.getIdCidade() == 000) {
                dao.inserir(obj);
            } else {
                dao.alterar(obj);
            }

            cidadesBusca = dao.buscarTodos();
            atualizarBusca(cidadesBusca);
            JOptionPane.showMessageDialog(this, "Cidade salva com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Descrição: " + e.getMessage(),
                    "Erro ao salvar cidade!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        bloqueiaFormulario(true);
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tbBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBuscaMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed() && f != null) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            int codigo = Integer.parseInt(target.getValueAt(row, 0).toString());
            try {
                CidadeDAO dao = new CidadeDAO();
                CidadeTO to = (CidadeTO) dao.buscarId(codigo);
                if (to.getSituacao().equals("I")) {
                    JOptionPane.showMessageDialog(this, "Está cidade está inativada!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                f.carregaCidade(to);
                this.dispose();
                this.f = null;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao consultar!\nDescrição: " + ex.getMessage(),
                        "Ops", JOptionPane.ERROR_MESSAGE);
            }
        } else if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            int codigo = Integer.parseInt(target.getValueAt(row, 0).toString());

            try {
                CidadeDAO dao = new CidadeDAO();
                CidadeTO to = (CidadeTO) dao.buscarId(codigo);

                tfCodigo.setText(String.valueOf(to.getIdCidadeFormatado(to.getIdCidade())));
                tfNome.setText(to.getNome());
                cbUf.setSelectedItem(to.getUf());
                switch (to.getSituacao()) {
                    case "A":
                        cbCadSituacao.setSelectedItem("ATIVO");
                        break;
                    case "I":
                        cbCadSituacao.setSelectedItem("INATIVO");
                        break;
                }

                bloqueiaFormulario(false);
                btExcluir.setEnabled(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao consultar!\nDescrição: " + ex.getMessage(),
                        "Ops", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tbBuscaMouseClicked

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        CidadeDAO cidadeDAO = new CidadeDAO();
        String consulta = tfConsulta.getText().trim();
        if (consulta.length() == 0) {
            try {
                atualizarBusca(cidadeDAO.buscarTodos());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Descrição: " + e.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                atualizarBusca(cidadeDAO.filtro(consulta));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Descrição: " + e.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbCadSituacao;
    private javax.swing.JComboBox cbUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlUf;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbNome;
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JPanel pnConsulta;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JScrollPane spBusca;
    private javax.swing.JTable tbBusca;
    private javax.swing.JLabel tfCodigo;
    private javax.swing.JTextField tfConsulta;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
