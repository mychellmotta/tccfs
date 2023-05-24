package br.com.fs.gui;

import br.com.fs.dao.ProdutoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.tm.ConsultaProdutosTableModel;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ConsultaProdutosGUI extends javax.swing.JDialog {

    private final FormulasGUI parent;

    public ConsultaProdutosGUI(FormulasGUI pai) {
        super();
        parent = pai;
        initComponents();
        this.construtor();
    }

    private void construtor() {
        this.setLocationRelativeTo(null);
        this.atualizarBusca();
    }

    private void atualizarBusca() {
        try {
            ConsultaProdutosTableModel p = (ConsultaProdutosTableModel) tbBusca.getModel();
            tbBusca.getTableHeader().setReorderingAllowed(false);
            tbBusca.setColumnSelectionAllowed(false);
            tbBusca.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbBusca.getColumnModel().getColumn(0).setResizable(false);
            tbBusca.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbBusca.getColumnModel().getColumn(0).setMaxWidth(60);
            tbBusca.getColumnModel().getColumn(1).setResizable(false);
            tbBusca.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbBusca.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((DefaultTableCellRenderer) tbBusca.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbBusca.setDefaultRenderer(Object.class, new CellRenderer());
            ProdutoDAO dao = new ProdutoDAO();
            p.setDados(dao.buscarProdutosCompostos());
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarBusca(ArrayList busca) {
        try {
            ConsultaProdutosTableModel p = (ConsultaProdutosTableModel) tbBusca.getModel();
            tbBusca.getTableHeader().setReorderingAllowed(false);
            tbBusca.setColumnSelectionAllowed(false);
            tbBusca.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbBusca.getColumnModel().getColumn(0).setResizable(false);
            tbBusca.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbBusca.getColumnModel().getColumn(0).setMaxWidth(60);
            tbBusca.getColumnModel().getColumn(1).setResizable(false);
            tbBusca.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbBusca.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((DefaultTableCellRenderer) tbBusca.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbBusca.setDefaultRenderer(Object.class, new CellRenderer());
            p.setDados(busca);
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCorpo = new javax.swing.JPanel();
        pnParametros = new javax.swing.JPanel();
        jlNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        lbCabecalhoTabela = new javax.swing.JLabel();
        spBusca = new javax.swing.JScrollPane();
        tbBusca = new javax.swing.JTable();
        btCancelar = new javax.swing.JButton();
        btSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de produtos");
        setModal(true);
        setResizable(false);

        pnParametros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parâmetro de busca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlNome.setText("Nome:");

        tfNome.setMinimumSize(new java.awt.Dimension(6, 25));
        tfNome.setPreferredSize(new java.awt.Dimension(6, 25));
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeKeyPressed(evt);
            }
        });

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/Busca.png"))); // NOI18N
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnParametrosLayout = new javax.swing.GroupLayout(pnParametros);
        pnParametros.setLayout(pnParametrosLayout);
        pnParametrosLayout.setHorizontalGroup(
            pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnParametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnParametrosLayout.setVerticalGroup(
            pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnParametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlNome)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbCabecalhoTabela.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCabecalhoTabela.setText("Produtos disponíveis:");

        tbBusca.setModel(new ConsultaProdutosTableModel());
        tbBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBuscaMouseClicked(evt);
            }
        });
        spBusca.setViewportView(tbBusca);

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

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbCabecalhoTabela)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spBusca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCorpoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSelecionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addContainerGap())
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnParametros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCabecalhoTabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btSelecionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnCorpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            getRootPane().setDefaultButton(btBuscar);
            tfNome.requestFocus();
        }
    }//GEN-LAST:event_tfNomeKeyPressed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        ProdutoDAO dao = new ProdutoDAO();
        String nome = tfNome.getText().trim();

        if (nome.length() == 0) {

            try {
                atualizarBusca();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                atualizarBusca(dao.filtroProdutosCompostos(nome));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tbBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBuscaMouseClicked
        int row = tbBusca.getSelectedRow();
        int codigo = Integer.parseInt(tbBusca.getValueAt(row, 0).toString());
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            parent.carregaProduto(codigo);
            this.dispose();
        }
    }//GEN-LAST:event_tbBuscaMouseClicked

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        int row = tbBusca.getSelectedRow();
        int codigo = Integer.parseInt(tbBusca.getValueAt(row, 0).toString());
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado!");
        } else {
            parent.carregaProduto(codigo);
            this.dispose();
        }
    }//GEN-LAST:event_btSelecionarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel lbCabecalhoTabela;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnParametros;
    private javax.swing.JScrollPane spBusca;
    private javax.swing.JTable tbBusca;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
