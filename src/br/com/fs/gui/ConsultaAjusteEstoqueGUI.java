package br.com.fs.gui;

import br.com.fs.dao.ProdutoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.tm.ConsultaAjusteProdTableModel;
import br.com.fs.to.ProdutoTO;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ConsultaAjusteEstoqueGUI extends javax.swing.JDialog {

    private ProdutoTO produto = new ProdutoTO();
    private AjusteEstoqueGUI ajusteGUI;
    private ProducaoGUI producaoGUI;
    private PercaGUI percaGUI;
    private int tipoajuste = 0;

    public ConsultaAjusteEstoqueGUI(AjusteEstoqueGUI parent, int i) {
        super();
        initComponents();
        ajusteGUI = parent;
        tipoajuste = i;
        this.construtor();
    }

    public ConsultaAjusteEstoqueGUI(ProducaoGUI parent, int i) {
        super();
        initComponents();
        producaoGUI = parent;
        tipoajuste = i;
        this.construtor();
    }

    public ConsultaAjusteEstoqueGUI(PercaGUI parent, int i) {
        super();
        initComponents();
        percaGUI = parent;
        tipoajuste = i;
        this.construtor();
    }

    private void construtor() {
        this.setLocationRelativeTo(null);
        this.carregaTabela();
        btSelecionar.setEnabled(false);
    }

    private void carregaTabela() {
        try {
            ConsultaAjusteProdTableModel citm = (ConsultaAjusteProdTableModel) tbBusca.getModel();
            tbBusca.getTableHeader().setReorderingAllowed(false);
            tbBusca.setColumnSelectionAllowed(false);
            tbBusca.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbBusca.getColumnModel().getColumn(0).setResizable(false); //não permite alterar largura coluna
            tbBusca.getColumnModel().getColumn(0).setPreferredWidth(60); //define largura da coluna
            tbBusca.getColumnModel().getColumn(0).setMaxWidth(60);
            tbBusca.getColumnModel().getColumn(1).setResizable(false);
            tbBusca.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbBusca.setCursor(new Cursor(Cursor.HAND_CURSOR)); //define o cursor
            ((DefaultTableCellRenderer) tbBusca.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbBusca.setDefaultRenderer(Object.class, new CellRenderer());
            ProdutoDAO dao = new ProdutoDAO();
            if ((tipoajuste == 1) || (tipoajuste == 5)) {
                citm.setDados(dao.ajusteEstoqueProducao());
            }
            if ((tipoajuste == 2) || (tipoajuste == 3) || (tipoajuste == 4)) {
                citm.setDados(dao.ajusteEstoquePerca());
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(this, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaTabelaFiltro() {
        try {
            ConsultaAjusteProdTableModel tm = (ConsultaAjusteProdTableModel) tbBusca.getModel();
            tbBusca.getTableHeader().setReorderingAllowed(false);
            tbBusca.setColumnSelectionAllowed(false);
            tbBusca.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbBusca.getColumnModel().getColumn(0).setResizable(false); //não permite alterar largura coluna
            tbBusca.getColumnModel().getColumn(0).setPreferredWidth(60); //define largura da coluna
            tbBusca.getColumnModel().getColumn(0).setMaxWidth(60);
            tbBusca.getColumnModel().getColumn(1).setResizable(false);
            tbBusca.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbBusca.setCursor(new Cursor(Cursor.HAND_CURSOR)); //define o cursor
            ((DefaultTableCellRenderer) tbBusca.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbBusca.setDefaultRenderer(Object.class, new CellRenderer());
            ProdutoDAO dao = new ProdutoDAO();
            if ((tipoajuste == 1) || (tipoajuste == 5)) {
                tm.setDados(dao.filtroAjusteEstoqueProducao(tfBusca.getText()));
            }
            if ((tipoajuste == 2) || (tipoajuste == 3) || (tipoajuste == 4)) {
                tm.setDados(dao.filtroAjusteEstoquePerca(tfBusca.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(this, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JPanel();
        pnBusca = new javax.swing.JPanel();
        tfBusca = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        spBusca = new javax.swing.JScrollPane();
        tbBusca = new javax.swing.JTable();
        btCancelar = new javax.swing.JButton();
        btSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar produto");
        setModal(true);

        pnBusca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecionar produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tfBusca.setMinimumSize(new java.awt.Dimension(6, 25));
        tfBusca.setPreferredSize(new java.awt.Dimension(59, 25));
        tfBusca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscaFocusLost(evt);
            }
        });
        tfBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBuscaKeyPressed(evt);
            }
        });

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/Busca.png"))); // NOI18N
        btBuscar.setMaximumSize(new java.awt.Dimension(65, 25));
        btBuscar.setMinimumSize(new java.awt.Dimension(65, 25));
        btBuscar.setPreferredSize(new java.awt.Dimension(65, 25));
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        tbBusca.setAutoCreateRowSorter(true);
        tbBusca.setModel(new ConsultaAjusteProdTableModel());
        tbBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBuscaMouseClicked(evt);
            }
        });
        spBusca.setViewportView(tbBusca);

        javax.swing.GroupLayout pnBuscaLayout = new javax.swing.GroupLayout(pnBusca);
        pnBusca.setLayout(pnBuscaLayout);
        pnBuscaLayout.setHorizontalGroup(
            pnBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(spBusca)
        );
        pnBuscaLayout.setVerticalGroup(
            pnBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
        );

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSelecionar.setText("Selecionar");
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnBusca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalLayout.createSequentialGroup()
                        .addComponent(btSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)))
                .addContainerGap())
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btSelecionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnPrincipal, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBuscaMouseClicked
        btSelecionar.setEnabled(true);
        if (evt.getClickCount() == 2) {
            int row = tbBusca.getSelectedRow();
            int codigo = Integer.parseInt(tbBusca.getValueAt(row, 0).toString());
            try {
                ProdutoDAO dao = new ProdutoDAO();
                ProdutoTO to = (ProdutoTO) dao.buscarId(codigo);
                produto = to;
                if (tipoajuste == 1) {
                    producaoGUI.carregaInformações(produto);
                }
                if (tipoajuste == 2) {
                    percaGUI.carregaInformações(produto);
                }
                if (tipoajuste == 3) {
                    ajusteGUI.carregaInformaçõesBalanco(produto);
                }
                if (tipoajuste == 4) {
                    ajusteGUI.carregaInformaçõesZerar(produto);
                }
                if (tipoajuste == 5) {
                    producaoGUI.carregaInformaçõesRotina(produto);
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao consultar!\n" + ex.getMessage(), "Ops",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tbBuscaMouseClicked

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if (!tfBusca.getText().equals("")) {
            this.carregaTabelaFiltro();
        } else {
            this.carregaTabela();
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tfBuscaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscaFocusLost
        if (!tfBusca.getText().equals("")) {
            this.carregaTabelaFiltro();
        } else {
            this.carregaTabela();
        }
    }//GEN-LAST:event_tfBuscaFocusLost

    private void tfBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            getRootPane().setDefaultButton(btBuscar);
            tfBusca.requestFocus();
        }
    }//GEN-LAST:event_tfBuscaKeyPressed

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        int row = tbBusca.getSelectedRow();
        int codigo = Integer.parseInt(tbBusca.getValueAt(row, 0).toString());
        try {
            ProdutoDAO dao = new ProdutoDAO();
            ProdutoTO to = (ProdutoTO) dao.buscarId(codigo);
            produto = to;
            if (tipoajuste == 1) {
                producaoGUI.carregaInformações(produto);
            }
            if (tipoajuste == 2) {
                percaGUI.carregaInformações(produto);
            }
            if (tipoajuste == 3) {
                ajusteGUI.carregaInformaçõesBalanco(produto);
            }
            if (tipoajuste == 4) {
                ajusteGUI.carregaInformaçõesZerar(produto);
            }
            if (tipoajuste == 5) {
                producaoGUI.carregaInformaçõesRotina(produto);
            }
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar!\n" + ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSelecionarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JPanel pnBusca;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JScrollPane spBusca;
    private javax.swing.JTable tbBusca;
    private javax.swing.JTextField tfBusca;
    // End of variables declaration//GEN-END:variables
}
