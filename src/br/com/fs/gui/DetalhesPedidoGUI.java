package br.com.fs.gui;

import br.com.fs.dao.FluxoFinanDAO;
import br.com.fs.dao.ItensPedidoDAO;
import br.com.fs.dao.PedidoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.ImprimeTicketRTA;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.tm.ItensPedidoDetalhesTableModel;
import br.com.fs.to.FluxoFinanTO;
import br.com.fs.to.PedidoTO;
import java.awt.Color;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;

public class DetalhesPedidoGUI extends javax.swing.JDialog {

    private PedidoTO pedidoTO = new PedidoTO();
    private FluxoFinanTO finanTO = new FluxoFinanTO();

    public DetalhesPedidoGUI(int codigo) {
        super();
        initComponents();
        try {
            PedidoDAO dao = new PedidoDAO();
            pedidoTO = (PedidoTO) dao.detalhaPedido(codigo);
            finanTO = (FluxoFinanTO) FluxoFinanDAO.detalhaPedido(codigo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao detalhar pedido!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.construtor();
    }

    private void construtor() {
        this.setLocationRelativeTo(null);
        this.carregaTabela();
        lbCodigoPedido.setText(pedidoTO.getIdPedFormatado(pedidoTO.getIdPedido()) + " - " + pedidoTO.getSenhaFormatado(pedidoTO.getSenha()));
        lbFuncionario.setText(pedidoTO.getFuncionario().getNome());
        lbSituacao.setText(pedidoTO.getSituacao());
        lbValorPedido.setText(ReplaceMoedaRTA.doubleToMoeda(pedidoTO.getValorPedido()));
        try {
            lbDataHora.setText(pedidoTO.getDataHoraForm());
        } catch (Exception ex) {
            Logger.getLogger(DetalhesPedidoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbTipoConta.setText(finanTO.getTipoPgto().getTipo() + " em " + finanTO.getConta().getNome());
        lbDesconto.setText(ReplaceMoedaRTA.doubleToMoeda(finanTO.getDesconto()));
        lbValorTotal.setText(ReplaceMoedaRTA.doubleToMoeda(finanTO.getValorTotal()));
    }

    private void carregaTabela() {
        try {
            ItensPedidoDetalhesTableModel p = (ItensPedidoDetalhesTableModel) tbItens.getModel();
            tbItens.setGridColor(Color.white);
            spItens.setBorder(null);
            tbItens.setBorder(null);
            tbItens.getTableHeader().setReorderingAllowed(false);
            tbItens.setColumnSelectionAllowed(false);
            tbItens.setRowSelectionAllowed(false);
            tbItens.getColumnModel().getColumn(0).setResizable(false);
            tbItens.getColumnModel().getColumn(1).setResizable(false); //não permite alterar largura coluna
            tbItens.getColumnModel().getColumn(1).setPreferredWidth(60); //define largura da coluna
            tbItens.getColumnModel().getColumn(1).setMaxWidth(60);
            tbItens.getColumnModel().getColumn(2).setResizable(false);
            tbItens.getColumnModel().getColumn(2).setPreferredWidth(90);
            tbItens.getColumnModel().getColumn(2).setMaxWidth(90);
            ((DefaultTableCellRenderer) tbItens.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbItens.setDefaultRenderer(Object.class, new CellRenderer());
            ItensPedidoDAO dao = new ItensPedidoDAO();
            p.setDados(dao.detalhaItensPedido(pedidoTO.getIdPedido()));
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCorpo = new javax.swing.JPanel();
        pnInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbCodigoPedido = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbDataHora = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbSituacao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbFuncionario = new javax.swing.JLabel();
        spItens = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        lbValorTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbValorPedido = new javax.swing.JLabel();
        lbDesconto = new javax.swing.JLabel();
        lbTipoConta = new javax.swing.JLabel();
        btFechar = new javax.swing.JButton();
        btTicket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes do pedido");
        setModal(true);
        setResizable(false);

        pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Pedido:");

        lbCodigoPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCodigoPedido.setText("000");

        jLabel2.setText("Data/hora:");

        lbDataHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDataHora.setText("00/00/00 00:00");

        jLabel3.setText("Situação:");

        lbSituacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSituacao.setText("SITUAÇÃO");

        jLabel4.setText("Operador:");

        lbFuncionario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbFuncionario.setText("FUNCIONÁRIO");
        lbFuncionario.setMaximumSize(new java.awt.Dimension(218, 14));

        spItens.setBackground(new java.awt.Color(255, 255, 255));
        spItens.setBorder(null);
        spItens.setForeground(new java.awt.Color(255, 255, 255));

        tbItens.setAutoCreateRowSorter(true);
        tbItens.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbItens.setModel(new ItensPedidoDetalhesTableModel());
        tbItens.setGridColor(new java.awt.Color(255, 255, 255));
        tbItens.setShowHorizontalLines(false);
        tbItens.setShowVerticalLines(false);
        spItens.setViewportView(tbItens);

        lbValorTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbValorTotal.setForeground(new java.awt.Color(0, 102, 0));
        lbValorTotal.setText("R$ 0,00");

        jLabel6.setText("Valor do pedido:");

        jLabel7.setText("Desconto:");

        lbValorPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbValorPedido.setText("R$ 0,00");

        lbDesconto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDesconto.setText("R$ 0,00");

        lbTipoConta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTipoConta.setText("FORMA em CONTA");

        javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
        pnInfo.setLayout(pnInfoLayout);
        pnInfoLayout.setHorizontalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spItens, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addGroup(pnInfoLayout.createSequentialGroup()
                        .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCodigoPedido)
                            .addComponent(lbDataHora)
                            .addComponent(lbSituacao))
                        .addGap(26, 26, 26)
                        .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnInfoLayout.createSequentialGroup()
                                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbValorPedido)
                                    .addComponent(lbDesconto))
                                .addGap(0, 167, Short.MAX_VALUE))
                            .addComponent(lbFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInfoLayout.createSequentialGroup()
                        .addComponent(lbTipoConta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbValorTotal)))
                .addContainerGap())
        );
        pnInfoLayout.setVerticalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbCodigoPedido)
                    .addComponent(jLabel4)
                    .addComponent(lbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbDataHora)
                    .addComponent(jLabel6)
                    .addComponent(lbValorPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbSituacao)
                    .addComponent(jLabel7)
                    .addComponent(lbDesconto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spItens, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValorTotal)
                    .addComponent(lbTipoConta))
                .addGap(5, 5, 5))
        );

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        btTicket.setText("Reimprimir ticket");
        btTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTicketActionPerformed(evt);
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
                        .addComponent(btTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btFechar)))
                .addContainerGap())
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFechar)
                    .addComponent(btTicket))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnCorpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTicketActionPerformed
        try {
            String arquivo = "Cupom";
            String arquivo2 = "CupomInterno";
            HashMap parametros = new HashMap();
            parametros.put("idpedido", pedidoTO.getIdPedido());
            new ImprimeTicketRTA(arquivo, parametros);
            new ImprimeTicketRTA(arquivo2, parametros);
        } catch (JRException ex) {
            Logger.getLogger(DetalhesPedidoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DetalhesPedidoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btTicketActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbCodigoPedido;
    private javax.swing.JLabel lbDataHora;
    private javax.swing.JLabel lbDesconto;
    private javax.swing.JLabel lbFuncionario;
    private javax.swing.JLabel lbSituacao;
    private javax.swing.JLabel lbTipoConta;
    private javax.swing.JLabel lbValorPedido;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JScrollPane spItens;
    private javax.swing.JTable tbItens;
    // End of variables declaration//GEN-END:variables
}
