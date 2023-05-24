package br.com.fs.gui;

import br.com.fs.dao.ProdutoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.GeraPdfRTA;
import br.com.fs.rta.ImprimeRTA;
import br.com.fs.rta.RelatorioRTA;
import br.com.fs.tm.ConsultaProdutosTableModel;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class AlertaEstoqueGUI extends javax.swing.JDialog {

    public AlertaEstoqueGUI() {
        super();
        initComponents();
        this.construtor();
    }

    private void construtor() {
        this.setLocationRelativeTo(null);
        this.carregaTabela();
    }

    private void carregaTabela() {
        try {
            ConsultaProdutosTableModel p = (ConsultaProdutosTableModel) tbBusca.getModel();
            tbBusca.setRowHeight(25);
            spBusca.setBorder(null);
            tbBusca.setBorder(null);
            tbBusca.getTableHeader().setReorderingAllowed(false);
            tbBusca.setColumnSelectionAllowed(false);
            tbBusca.setRowSelectionAllowed(false);
            tbBusca.getColumnModel().getColumn(0).setResizable(false);
            tbBusca.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbBusca.getColumnModel().getColumn(0).setMaxWidth(60);
            tbBusca.getColumnModel().getColumn(1).setResizable(false);
            tbBusca.getColumnModel().getColumn(1).setPreferredWidth(350);
            ((DefaultTableCellRenderer) tbBusca.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbBusca.setDefaultRenderer(Object.class, new CellRenderer());
            ProdutoDAO dao = new ProdutoDAO();
            p.setDados(dao.buscarProdutosBaixoEstoque());
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCorpo = new javax.swing.JPanel();
        pnProdutos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spBusca = new javax.swing.JScrollPane();
        tbBusca = new javax.swing.JTable();
        btOk = new javax.swing.JButton();
        cbRelatorio = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atenção com seu estoque");
        setModal(true);

        pnProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Estes produtos estão com estoque baixo e requerem sua atenção!");

        spBusca.setForeground(getForeground());

        tbBusca.setAutoCreateRowSorter(true);
        tbBusca.setBackground(pnCorpo.getBackground());
        tbBusca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbBusca.setModel(new ConsultaProdutosTableModel());
        tbBusca.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbBusca.setGridColor(new java.awt.Color(255, 255, 255));
        tbBusca.setRowSelectionAllowed(false);
        tbBusca.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbBusca.setShowVerticalLines(false);
        spBusca.setViewportView(tbBusca);

        javax.swing.GroupLayout pnProdutosLayout = new javax.swing.GroupLayout(pnProdutos);
        pnProdutos.setLayout(pnProdutosLayout);
        pnProdutosLayout.setHorizontalGroup(
            pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProdutosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnProdutosLayout.setVerticalGroup(
            pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btOk.setText("Ok, entendi");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        cbRelatorio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a ação", "Visualizar", "Imprimir", "Gerar PDF" }));
        cbRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addComponent(cbRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btOk)))
                .addContainerGap())
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOk)
                    .addComponent(cbRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnCorpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_btOkActionPerformed

    private void cbRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRelatorioActionPerformed
        try {
            if (cbRelatorio.getSelectedIndex() == 1) {
                this.setVisible(false);
                this.dispose();
                String arquivo = "AlertaEstoque";
                HashMap parametros = new HashMap();
                new RelatorioRTA(arquivo, parametros);
            } else if (cbRelatorio.getSelectedIndex() == 2) {
                this.setVisible(false);
                this.dispose();
                String arquivo = "AlertaEstoque";
                HashMap parametros = new HashMap();
                new ImprimeRTA(arquivo, parametros);
            } else if (cbRelatorio.getSelectedIndex() == 3) {
                this.setVisible(false);
                this.dispose();
                String arquivo = "AlertaEstoque";
                HashMap parametros = new HashMap();
                new GeraPdfRTA(arquivo, parametros);
            } else {
                repaint();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + ex.getMessage());
        }
    }//GEN-LAST:event_cbRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOk;
    private javax.swing.JComboBox cbRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnProdutos;
    private javax.swing.JScrollPane spBusca;
    private javax.swing.JTable tbBusca;
    // End of variables declaration//GEN-END:variables
}
