package br.com.fs.gui;

import br.com.fs.dao.FluxoFinanDAO;
import br.com.fs.dao.ItensPedidoDAO;
import br.com.fs.dao.PedidoEntregaDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.ImprimeTicketRTA;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.tm.ItensPedidoDetalhesTableModel;
import br.com.fs.to.FluxoFinanTO;
import br.com.fs.to.PedidoEntregaTO;
import java.awt.Color;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;

public class DetalhesPedidoEntregaGUI extends javax.swing.JDialog {

    private PedidoEntregaTO entregaTO = new PedidoEntregaTO();
    private FluxoFinanTO finanTO = new FluxoFinanTO();

    public DetalhesPedidoEntregaGUI(int codigo) {
        super();
        initComponents();
        try {
            PedidoEntregaDAO dao = new PedidoEntregaDAO();
            entregaTO = (PedidoEntregaTO) dao.detalhaPedido(codigo);
            finanTO = (FluxoFinanTO) FluxoFinanDAO.detalhaPedido(codigo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.construtor();
    }

    public DetalhesPedidoEntregaGUI() {
        super();
        initComponents();
    }

    private void construtor() {
        this.setLocationRelativeTo(null);
        this.carregaTabela();
        lbCodigoPedido.setText(entregaTO.getPedido().getIdPedFormatado(entregaTO.getPedido().getIdPedido()) + " - " + entregaTO.getPedido().getSenhaFormatado(entregaTO.getPedido().getSenha()));
        lbFuncionario.setText(entregaTO.getPedido().getFuncionario().getNome());
        lbSituacao.setText(entregaTO.getPedido().getSituacao());
        lbValorPedido.setText(ReplaceMoedaRTA.doubleToMoeda(entregaTO.getPedido().getValorPedido()));
        try {
            lbDataHora.setText(entregaTO.getPedido().getDataHoraForm());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        lbTipoConta.setText(finanTO.getTipoPgto().getTipo() + " em " + finanTO.getConta().getNome());
        lbDesconto.setText(ReplaceMoedaRTA.doubleToMoeda(entregaTO.getPedido().getDesconto()));
        lbValorTotal.setText(ReplaceMoedaRTA.doubleToMoeda(finanTO.getValorTotal()));
        lbCliente.setText(entregaTO.getNomecliente());
        lbContato.setText(entregaTO.getContato());
        lbLogradouro.setText(entregaTO.getLogradouro());
        lbNumero.setText(entregaTO.getNumero());
        lbBairro.setText(entregaTO.getBairro());
        lbComplemento.setText(entregaTO.getComplemento());
        lbReferencia.setText(entregaTO.getReferencia());
        lbTroco.setText(ReplaceMoedaRTA.doubleToMoeda(entregaTO.getValortroco()));
        lbObservacao.setText(entregaTO.getObservacao());
        if (!lbSituacao.getText().equals("ABERTO")) {
            btReceber.setEnabled(false);
        }
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
            tbItens.getColumnModel().getColumn(1).setResizable(false);
            tbItens.getColumnModel().getColumn(1).setPreferredWidth(60);
            tbItens.getColumnModel().getColumn(1).setMaxWidth(60);
            tbItens.getColumnModel().getColumn(2).setResizable(false);
            tbItens.getColumnModel().getColumn(2).setPreferredWidth(90);
            tbItens.getColumnModel().getColumn(2).setMaxWidth(90);
            ((DefaultTableCellRenderer) tbItens.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbItens.setDefaultRenderer(Object.class, new CellRenderer());
            ItensPedidoDAO dao = new ItensPedidoDAO();
            p.setDados(dao.detalhaItensPedido(entregaTO.getPedido().getIdPedido()));
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
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbLogradouro = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbContato = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbBairro = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbComplemento = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbReferencia = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbTroco = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbObservacao = new javax.swing.JTextPane();
        btReceber = new javax.swing.JButton();
        btTicket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes do pedido");
        setModal(true);
        setResizable(false);

        pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

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
        lbTipoConta.setText("FORMA DE PAGAMENTO em CONTA EM TAL BANCO");

        javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
        pnInfo.setLayout(pnInfoLayout);
        pnInfoLayout.setHorizontalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(lbValorPedido)
                            .addComponent(lbDesconto)
                            .addComponent(lbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnInfoLayout.createSequentialGroup()
                        .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spItens, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                            .addGroup(pnInfoLayout.createSequentialGroup()
                                .addComponent(lbTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbValorTotal)))
                        .addContainerGap())))
        );
        pnInfoLayout.setVerticalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbCodigoPedido)
                    .addComponent(jLabel4)
                    .addComponent(lbFuncionario))
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações de entrega", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel5.setText("Cliente:");

        lbCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCliente.setText("CLIENTE");

        jLabel8.setText("Logradouro:");

        lbLogradouro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbLogradouro.setText("LOGRADOURO");

        jLabel9.setText("Nº:");

        lbNumero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNumero.setText("0000");

        jLabel10.setText("Contato:");

        lbContato.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbContato.setText("CONTATO");

        jLabel11.setText("Bairro:");

        lbBairro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbBairro.setText("BAIRRO");

        jLabel12.setText("Complemento:");

        lbComplemento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbComplemento.setText("COMPLEMENTO");

        jLabel13.setText("Referência:");

        lbReferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbReferencia.setText("REFERÊNCIA");
        lbReferencia.setMaximumSize(new java.awt.Dimension(30, 14));
        lbReferencia.setMinimumSize(new java.awt.Dimension(30, 14));

        jLabel14.setText("Troco solicitado:");

        lbTroco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTroco.setText("R$ 0,00");

        jLabel15.setText("Observação:");

        jScrollPane1.setBorder(null);

        lbObservacao.setEditable(false);
        lbObservacao.setBackground(pnCorpo.getBackground());
        lbObservacao.setBorder(null);
        lbObservacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbObservacao.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jScrollPane1.setViewportView(lbObservacao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 33, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumero)
                    .addComponent(lbTroco)
                    .addComponent(lbContato, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbCliente)
                    .addComponent(jLabel10)
                    .addComponent(lbContato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbLogradouro)
                    .addComponent(jLabel9)
                    .addComponent(lbNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(lbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbComplemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(lbTroco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btReceber.setText("Receber");
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCorpoLayout.createSequentialGroup()
                        .addComponent(btTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btReceber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFechar)))
                .addContainerGap())
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFechar)
                    .addComponent(btReceber)
                    .addComponent(btTicket))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnCorpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceberActionPerformed
        RecebePedidoEntregaGUI gui = new RecebePedidoEntregaGUI(this, entregaTO);
        gui.setVisible(true);
    }//GEN-LAST:event_btReceberActionPerformed

    private void btTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTicketActionPerformed
        try {
            String arquivo = "CupomDelivery";
            String arquivo2 = "CupomInterno";
            HashMap parametros = new HashMap();
            parametros.put("idpedido", entregaTO.getPedido().getIdPedido());
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
    private javax.swing.JButton btReceber;
    private javax.swing.JButton btTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbCodigoPedido;
    private javax.swing.JLabel lbComplemento;
    private javax.swing.JLabel lbContato;
    private javax.swing.JLabel lbDataHora;
    private javax.swing.JLabel lbDesconto;
    private javax.swing.JLabel lbFuncionario;
    private javax.swing.JLabel lbLogradouro;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JTextPane lbObservacao;
    private javax.swing.JLabel lbReferencia;
    private javax.swing.JLabel lbSituacao;
    private javax.swing.JLabel lbTipoConta;
    private javax.swing.JLabel lbTroco;
    private javax.swing.JLabel lbValorPedido;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JScrollPane spItens;
    private javax.swing.JTable tbItens;
    // End of variables declaration//GEN-END:variables
}
