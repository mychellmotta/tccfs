package br.com.fs.gui;

import br.com.fs.dao.ContasDAO;
import br.com.fs.dao.FluxoFinanDAO;
import br.com.fs.dao.ItensPedidoDAO;
import br.com.fs.dao.PedidoDAO;
import br.com.fs.dao.PedidoEntregaDAO;
import br.com.fs.dao.TiposPgtoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.GeraPdfRTA;
import br.com.fs.rta.ImprimeRTA;
import br.com.fs.rta.Mascaras;
import br.com.fs.rta.MascarasDouble;
import br.com.fs.rta.RelatorioRTA;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.tm.FluxoFinanTableModel;
import br.com.fs.tm.ItensPedidoDetalhesFluxoFinanTableModel;
import br.com.fs.to.FluxoFinanTO;
import br.com.fs.to.PedidoEntregaTO;
import br.com.fs.to.PedidoTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class FluxoFinanGUI extends javax.swing.JInternalFrame {

    private static FluxoFinanGUI instancia = null;
    ArrayList<FluxoFinanTO> arr;

    public FluxoFinanGUI() {
        this.arr = new ArrayList<>();
        initComponents();
        this.construtor();
    }

    public static FluxoFinanGUI getInstancia() {
        if (instancia == null) {
            instancia = new FluxoFinanGUI();
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
        tfValorDe.setDocument(new MascarasDouble(9));
        tfValorAte.setDocument(new MascarasDouble(9));
        tfValorDe.setText("0,00");
        tfValorAte.setText("0,00");
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -7);
        dcDataDe.setDate(cal.getTime());
        dcDataAte.setDate(new Date());
        Mascaras mascara = new Mascaras();
        tfCodPedido.setDocument(mascara.somenteNumero());
        carregaComboContas();
        carregaComboTipos();
        pnPrincipal.setEnabledAt(1, false);
        try {
            Date date = new Date();
            String data = new SimpleDateFormat("yyyy-MM-dd").format(date);

            FluxoFinanDAO dao = new FluxoFinanDAO();

            arr = dao.buscarTodos(" and date(f.datahora) >= '" + data + "'");
            atualizarBusca();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(this, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarBusca() {
        try {
            FluxoFinanTableModel p = (FluxoFinanTableModel) tbBusca.getModel();
            tbBusca.setBorder(null);
            tbBusca.getTableHeader().setReorderingAllowed(false);
            tbBusca.setColumnSelectionAllowed(false);
            tbBusca.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbBusca.getColumnModel().getColumn(0).setResizable(false);
            tbBusca.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbBusca.getColumnModel().getColumn(0).setMaxWidth(60);
            tbBusca.getColumnModel().getColumn(1).setResizable(false);
            tbBusca.getColumnModel().getColumn(1).setPreferredWidth(60);
            tbBusca.getColumnModel().getColumn(1).setMaxWidth(60);
            tbBusca.getColumnModel().getColumn(2).setResizable(false);
            tbBusca.getColumnModel().getColumn(2).setPreferredWidth(120);
            tbBusca.getColumnModel().getColumn(2).setMaxWidth(120);
            tbBusca.getColumnModel().getColumn(5).setResizable(false);
            tbBusca.getColumnModel().getColumn(5).setPreferredWidth(70);
            tbBusca.getColumnModel().getColumn(5).setMaxWidth(70);
            tbBusca.getColumnModel().getColumn(6).setResizable(false);
            tbBusca.getColumnModel().getColumn(6).setPreferredWidth(70);
            tbBusca.getColumnModel().getColumn(6).setMaxWidth(70);
            tbBusca.getColumnModel().getColumn(7).setResizable(false);
            tbBusca.getColumnModel().getColumn(7).setPreferredWidth(70);
            tbBusca.getColumnModel().getColumn(7).setMaxWidth(70);
            tbBusca.getColumnModel().getColumn(8).setResizable(false);
            tbBusca.getColumnModel().getColumn(8).setPreferredWidth(70);
            tbBusca.getColumnModel().getColumn(8).setMaxWidth(70);
            tbBusca.getColumnModel().getColumn(9).setResizable(false);
            tbBusca.getColumnModel().getColumn(9).setPreferredWidth(70);
            tbBusca.getColumnModel().getColumn(9).setMaxWidth(70);
            tbBusca.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((DefaultTableCellRenderer) tbBusca.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbBusca.setDefaultRenderer(Object.class, new CellRenderer());

            lbSaldo.setText("R$ 0,00");
            lbPendente.setText("R$ 0,00");

            FluxoFinanDAO dao = new FluxoFinanDAO();

            p.setDados(arr);

            double saldoPeriodo = 0;
            double pendente = 0;

            double troco = dao.buscarTrocoEntrega();
            lbTrocoDelivery.setText(ReplaceMoedaRTA.doubleToMoeda(troco));
            double emcaixa = dao.caixaTotal() - troco;
            lbEmCaixa.setText(ReplaceMoedaRTA.doubleToMoeda(emcaixa));

            for (int i = 0; i < arr.size(); i++) {
                double valorEntrada = 0;
                double valorSaida = 0;
                if (!tbBusca.getValueAt(i, 8).toString().equals("SAÍDA")) {
                    valorEntrada = valorEntrada + ReplaceMoedaRTA.moedaToDouble(tbBusca.getValueAt(i, 7).toString());

                } else {
                    valorSaida = valorSaida + ReplaceMoedaRTA.moedaToDouble(tbBusca.getValueAt(i, 7).toString());
                }
                double total = valorEntrada - valorSaida;
                saldoPeriodo = saldoPeriodo + total;
                lbSaldo.setText(ReplaceMoedaRTA.doubleToMoeda(saldoPeriodo));

                if (tbBusca.getValueAt(i, 9).toString().equals("ABERTO")) {
                    pendente = pendente + valorEntrada;
                    lbPendente.setText(ReplaceMoedaRTA.doubleToMoeda(pendente));
                }
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void carregaComboTipos() {
        cbFormaPgto.adicionaValor(TiposPgtoDAO.montaCombo());
        cbFormaPgto.repaint();
    }

    public static void carregaComboContas() {
        cbConta.adicionaValor(ContasDAO.montaCombo());
        cbConta.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JTabbedPane();
        pnConsulta = new javax.swing.JPanel();
        pnParametros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCodPedido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dcDataAte = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfValorDe = new javax.swing.JTextField();
        tfValorAte = new javax.swing.JTextField();
        dcDataDe = new com.toedter.calendar.JDateChooser();
        btBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbFormaPgto = new br.com.fs.rta.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cbConta = new br.com.fs.rta.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cbSituacao = new javax.swing.JComboBox();
        pnResultado = new javax.swing.JPanel();
        spBusca = new javax.swing.JScrollPane();
        tbBusca = new javax.swing.JTable();
        lbSaldo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbPendente = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbTrocoDelivery = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbEmCaixa = new javax.swing.JLabel();
        pnDetalhes = new javax.swing.JPanel();
        pnPedido = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lbCodPedido = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbDataPedido = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbTipoPedido = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbSenhaPedido = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbFuncPedido = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbValorPedido = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbDescontoPedido = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbTotalPedido = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbSituacaoPedido = new javax.swing.JLabel();
        pnEndereco = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        lbLogradouro = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbContato = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lbTrocoSolicitado = new javax.swing.JLabel();
        pnProdutos = new javax.swing.JPanel();
        spProdutos = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        pnFinanceiro = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        lbFormaPgto = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lbConta = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        lbTotalFinan = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        lbDataHoraFinan = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbTipoFinan = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbSituacaoFinan = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbCodFinanceiro = new javax.swing.JLabel();
        btReceber = new javax.swing.JButton();
        btTransferir = new javax.swing.JButton();
        cbRelatorio = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Caixa");
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

        pnParametros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parâmetros de busca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Pedido:");

        jLabel2.setText("De:");

        jLabel3.setText("Até:");

        jLabel4.setText("Tipo:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "DELIVERY", "LOCAL" }));

        jLabel5.setText("(R$) De:");

        jLabel6.setText("Até:");

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel7.setText("Forma pgto:");

        jLabel8.setText("Conta:");

        jLabel10.setText("Situação:");

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "RECEBIDO", "ABERTO", "ESTORNO" }));

        javax.swing.GroupLayout pnParametrosLayout = new javax.swing.GroupLayout(pnParametros);
        pnParametros.setLayout(pnParametrosLayout);
        pnParametrosLayout.setHorizontalGroup(
            pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnParametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnParametrosLayout.createSequentialGroup()
                        .addComponent(tfCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(pnParametrosLayout.createSequentialGroup()
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbConta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btBuscar))
                    .addGroup(pnParametrosLayout.createSequentialGroup()
                        .addComponent(tfValorDe, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorAte, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnParametrosLayout.setVerticalGroup(
            pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnParametrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcDataAte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tfCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(dcDataDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(tfValorDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfValorAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBuscar)
                    .addComponent(jLabel7)
                    .addComponent(cbFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnResultado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        spBusca.setBackground(new java.awt.Color(255, 255, 255));
        spBusca.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spBusca.setForeground(new java.awt.Color(255, 255, 255));

        tbBusca.setAutoCreateRowSorter(true);
        tbBusca.setModel(new FluxoFinanTableModel());
        tbBusca.setGridColor(new java.awt.Color(204, 204, 204));
        tbBusca.setShowVerticalLines(false);
        tbBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBuscaMouseClicked(evt);
            }
        });
        spBusca.setViewportView(tbBusca);

        javax.swing.GroupLayout pnResultadoLayout = new javax.swing.GroupLayout(pnResultado);
        pnResultado.setLayout(pnResultadoLayout);
        pnResultadoLayout.setHorizontalGroup(
            pnResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spBusca)
        );
        pnResultadoLayout.setVerticalGroup(
            pnResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );

        lbSaldo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbSaldo.setForeground(new java.awt.Color(0, 153, 0));
        lbSaldo.setText("R$ 0,00");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Saldo no período:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Pendente:");

        lbPendente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPendente.setForeground(new java.awt.Color(0, 0, 204));
        lbPendente.setText("R$ 0,00");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Em delivery:");

        lbTrocoDelivery.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrocoDelivery.setForeground(new java.awt.Color(204, 51, 0));
        lbTrocoDelivery.setText("R$ 0,00");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Em caixa:");

        lbEmCaixa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEmCaixa.setForeground(new java.awt.Color(0, 153, 0));
        lbEmCaixa.setText("R$ 0,00");

        javax.swing.GroupLayout pnConsultaLayout = new javax.swing.GroupLayout(pnConsulta);
        pnConsulta.setLayout(pnConsultaLayout);
        pnConsultaLayout.setHorizontalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnConsultaLayout.createSequentialGroup()
                        .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEmCaixa)
                            .addComponent(lbPendente)
                            .addComponent(lbTrocoDelivery))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSaldo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnConsultaLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(90, 90, 90))))
                    .addComponent(pnParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnConsultaLayout.setVerticalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnParametros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnConsultaLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSaldo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnConsultaLayout.createSequentialGroup()
                        .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lbTrocoDelivery))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lbPendente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lbEmCaixa))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnPrincipal.addTab("consulta", pnConsulta);

        pnPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel14.setText("Código:");

        lbCodPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCodPedido.setText("000");

        jLabel16.setText("Data/hora:");

        lbDataPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDataPedido.setText("00/00/0000 às 00:00");

        jLabel18.setText("Tipo:");

        lbTipoPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTipoPedido.setText("TIPO");

        jLabel20.setText("Senha:");

        lbSenhaPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSenhaPedido.setText("000");

        jLabel22.setText("Operador:");

        lbFuncPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbFuncPedido.setText("FUNCIONÁRIO");

        jLabel24.setText("Valor do pedido:");

        lbValorPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbValorPedido.setText("R$ 0,00");

        jLabel26.setText("Desconto:");

        lbDescontoPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDescontoPedido.setText("R$ 0,00");

        jLabel28.setText("Valor total:");

        lbTotalPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTotalPedido.setText("R$ 0,00");

        jLabel30.setText("Situação:");

        lbSituacaoPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSituacaoPedido.setText("SITUAÇÃO");

        pnEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel32.setText("Logradouro:");

        lbLogradouro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbLogradouro.setText("RUA 1 DE ABRIL");

        jLabel34.setText("Número:");

        lbNumero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNumero.setText("1002");

        jLabel36.setText("Cliente:");

        lbCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCliente.setText("CLIENTE");

        jLabel38.setText("Contato:");

        lbContato.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbContato.setText("(44) 0000-0000");

        jLabel40.setText("Troco solicitado:");

        lbTrocoSolicitado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTrocoSolicitado.setText("RS 0,00");

        javax.swing.GroupLayout pnEnderecoLayout = new javax.swing.GroupLayout(pnEndereco);
        pnEndereco.setLayout(pnEnderecoLayout);
        pnEnderecoLayout.setHorizontalGroup(
            pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnEnderecoLayout.createSequentialGroup()
                                .addComponent(lbCliente)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnEnderecoLayout.createSequentialGroup()
                                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                                        .addComponent(lbContato)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel40))
                                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                                        .addComponent(lbLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel34)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTrocoSolicitado)
                                    .addComponent(lbNumero))
                                .addGap(16, 16, 16))))
                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnEnderecoLayout.setVerticalGroup(
            pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lbLogradouro)
                    .addComponent(jLabel34)
                    .addComponent(lbNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(lbCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(lbContato)
                    .addComponent(jLabel40)
                    .addComponent(lbTrocoSolicitado))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produto(s)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tbProdutos.setAutoCreateRowSorter(true);
        tbProdutos.setModel(new ItensPedidoDetalhesFluxoFinanTableModel());
        spProdutos.setViewportView(tbProdutos);

        javax.swing.GroupLayout pnProdutosLayout = new javax.swing.GroupLayout(pnProdutos);
        pnProdutos.setLayout(pnProdutosLayout);
        pnProdutosLayout.setHorizontalGroup(
            pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnProdutosLayout.setVerticalGroup(
            pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnPedidoLayout = new javax.swing.GroupLayout(pnPedido);
        pnPedido.setLayout(pnPedidoLayout);
        pnPedidoLayout.setHorizontalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14)))
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel26))
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel28))
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel30))
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel24))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDataPedido)
                            .addComponent(lbSenhaPedido)
                            .addComponent(lbCodPedido)
                            .addComponent(lbValorPedido)
                            .addComponent(lbFuncPedido)
                            .addComponent(lbTipoPedido)
                            .addComponent(lbDescontoPedido)
                            .addComponent(lbTotalPedido)
                            .addComponent(lbSituacaoPedido)))
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnPedidoLayout.setVerticalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(lbCodPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(lbSenhaPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lbDataPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(lbTipoPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(lbFuncPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(lbValorPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(lbDescontoPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(lbTotalPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(lbSituacaoPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnFinanceiro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Financeiro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel42.setText("Forma de pagamento:");

        lbFormaPgto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbFormaPgto.setText("DINHEIRO");

        jLabel44.setText("Conta:");

        lbConta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbConta.setText("CAIXA");

        jLabel46.setText("Valor total:");

        lbTotalFinan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTotalFinan.setText("R$ 0,00");

        jLabel48.setText("Data/hora:");

        lbDataHoraFinan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDataHoraFinan.setText("00/00/0000 às 00:00");

        jLabel15.setText("Tipo:");

        lbTipoFinan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTipoFinan.setText("TIPO");

        jLabel19.setText("Situação:");

        lbSituacaoFinan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSituacaoFinan.setText("SITUAÇÃO");

        jLabel17.setText("Código:");

        lbCodFinanceiro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCodFinanceiro.setText("000");

        javax.swing.GroupLayout pnFinanceiroLayout = new javax.swing.GroupLayout(pnFinanceiro);
        pnFinanceiro.setLayout(pnFinanceiroLayout);
        pnFinanceiroLayout.setHorizontalGroup(
            pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFinanceiroLayout.createSequentialGroup()
                        .addGroup(pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbDataHoraFinan)
                            .addGroup(pnFinanceiroLayout.createSequentialGroup()
                                .addComponent(lbTotalFinan)
                                .addGap(76, 76, 76)))
                        .addGap(131, 131, 131)
                        .addGroup(pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel44))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnFinanceiroLayout.createSequentialGroup()
                        .addGroup(pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17))
                        .addGap(22, 22, 22)
                        .addGroup(pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnFinanceiroLayout.createSequentialGroup()
                                .addComponent(lbCodFinanceiro)
                                .addGap(3, 3, 3))
                            .addGroup(pnFinanceiroLayout.createSequentialGroup()
                                .addComponent(lbTipoFinan, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbFormaPgto)
                    .addComponent(lbSituacaoFinan)
                    .addComponent(lbConta))
                .addContainerGap(356, Short.MAX_VALUE))
        );
        pnFinanceiroLayout.setVerticalGroup(
            pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lbCodFinanceiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbTipoFinan)
                    .addComponent(lbFormaPgto)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(lbTotalFinan)
                    .addComponent(lbConta)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(lbDataHoraFinan)
                    .addComponent(jLabel19)
                    .addComponent(lbSituacaoFinan))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btReceber.setText("Receber pedido");
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
            }
        });

        btTransferir.setText("Transferir de conta");
        btTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTransferirActionPerformed(evt);
            }
        });

        cbRelatorio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a ação", "Visualizar", "Imprimir", "Gerar PDF" }));
        cbRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDetalhesLayout = new javax.swing.GroupLayout(pnDetalhes);
        pnDetalhes.setLayout(pnDetalhesLayout);
        pnDetalhesLayout.setHorizontalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnFinanceiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetalhesLayout.createSequentialGroup()
                        .addComponent(cbRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btTransferir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btReceber)))
                .addContainerGap())
        );
        pnDetalhesLayout.setVerticalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btReceber)
                    .addComponent(btTransferir)
                    .addComponent(cbRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnPrincipal.addTab("detalhes", pnDetalhes);

        getContentPane().add(pnPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if (dcDataDe.getDate().compareTo(dcDataAte.getDate()) == 1) {
            JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
            dcDataDe.requestFocus();
            return;
        }

        double valorde = ReplaceMoedaRTA.moedaToDouble(tfValorDe.getText());
        double valorate = ReplaceMoedaRTA.moedaToDouble(tfValorAte.getText());

        if (valorde > valorate) {
            JOptionPane.showMessageDialog(this, "Valor de início maior que valor de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfValorAte.requestFocus();
            return;
        }

        String datade = new SimpleDateFormat("yyyy-MM-dd").format(dcDataDe.getDate());
        String dataate = new SimpleDateFormat("yyyy-MM-dd").format(dcDataAte.getDate());

        FluxoFinanTO f = new FluxoFinanTO();

        try {
            FluxoFinanDAO dao = new FluxoFinanDAO();

            f.setQuery(tfCodPedido.getText(), " and f.idpedido = " + tfCodPedido.getText());
            f.setQuery(datade, " and date(f.datahora) between '" + datade + "' and '" + dataate + "' ");

            switch (cbTipo.getSelectedIndex()) {
                case 1:
                    f.setQuery(cbTipo.getSelectedItem().toString(), " and p.tipopedido = 'E'");
                    break;
                case 2:
                    f.setQuery(cbTipo.getSelectedItem().toString(), " and p.tipopedido = 'L'");
                    break;
            }
            switch (cbSituacao.getSelectedIndex()) {
                case 1:
                    f.setQuery(cbSituacao.getSelectedItem().toString(), " and f.situacao = 'P'");
                    break;
                case 2:
                    f.setQuery(cbSituacao.getSelectedItem().toString(), " and f.situacao = 'A'");
                    break;
                case 3:
                    f.setQuery(cbSituacao.getSelectedItem().toString(), " and f.situacao = 'E'");
                    break;
            }
            if (valorde > 0) {
                f.setQuery(String.valueOf(valorde), " and f.valortotal between " + valorde + " and " + valorate);
            }

            if (cbFormaPgto.getSelectedIndex() > 0) {
                f.setQuery(cbFormaPgto.getSelectedItem().toString(), " and t.tipo =  '" + cbFormaPgto.getSelectedItem().toString() + "'");
            }

            if (cbConta.getSelectedIndex() > 0) {
                f.setQuery(cbConta.getSelectedItem().toString(), " and c.nome =  '" + cbConta.getSelectedItem().toString() + "'");
            }

            if (f.getQuery().trim().length() < 5) {
                f.setQuery("where", " and 1 = 1");
            }

            arr = dao.buscarTodos(f.getQuery());

            atualizarBusca();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tbBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBuscaMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tbBusca.getSelectedRow();
            int pedido = Integer.parseInt(tbBusca.getValueAt(row, 1).toString());
            int financeiro = Integer.parseInt(tbBusca.getValueAt(row, 0).toString());
            try {
                detalhesPedido(pedido);
                tbProdutos(pedido);
                detalhesFinanceiro(financeiro);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao detalhar!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            pnPrincipal.setSelectedComponent(pnDetalhes);
        }
    }//GEN-LAST:event_tbBuscaMouseClicked

    public void atualizarDetalhes() {
        this.construtor();
        pnPrincipal.setSelectedIndex(0);
    }

    private void btReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceberActionPerformed
        RecebePedidoEntregaGUI gui = new RecebePedidoEntregaGUI(this, Integer.parseInt(lbCodPedido.getText()));
        gui.setVisible(true);
    }//GEN-LAST:event_btReceberActionPerformed

    private void btTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTransferirActionPerformed
        TransferenciaDeContaGUI gui = new TransferenciaDeContaGUI(this, Integer.parseInt(lbCodPedido.getText()));
        gui.setVisible(true);
    }//GEN-LAST:event_btTransferirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void cbRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRelatorioActionPerformed
        try {
            if (cbRelatorio.getSelectedIndex() == 1) {
                String arquivo = "";
                if (lbTipoPedido.getText().equals("LOCAL")) {
                    arquivo = "DetalhesFinanceiro";
                } else {
                    arquivo = "DetalhesFinanceiroEntrega";
                }
                HashMap parametros = new HashMap();
                parametros.put("id", Integer.valueOf(lbCodFinanceiro.getText()));
                new RelatorioRTA(arquivo, parametros);
            } else if (cbRelatorio.getSelectedIndex() == 2) {
                String arquivo = "";
                if (lbTipoPedido.getText().equals("LOCAL")) {
                    arquivo = "DetalhesFinanceiro";
                } else {
                    arquivo = "DetalhesFinanceiroEntrega";
                }
                HashMap parametros = new HashMap();
                parametros.put("id", Integer.parseInt(lbCodFinanceiro.getText()));
                new ImprimeRTA(arquivo, parametros);
            } else if (cbRelatorio.getSelectedIndex() == 3) {
                String arquivo = "";
                if (lbTipoPedido.getText().equals("LOCAL")) {
                    arquivo = "DetalhesFinanceiro";
                } else {
                    arquivo = "DetalhesFinanceiroEntrega";
                }
                HashMap parametros = new HashMap();
                parametros.put("id", Integer.parseInt(lbCodFinanceiro.getText()));
                new GeraPdfRTA(arquivo, parametros);
            } else {
                repaint();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + ex.getMessage());
        }
    }//GEN-LAST:event_cbRelatorioActionPerformed

    private void detalhesFinanceiro(int id) {
        try {
            FluxoFinanDAO dao = new FluxoFinanDAO();
            FluxoFinanTO to = dao.detalhaPedidoFluxo(id);
            lbCodFinanceiro.setText(to.getIdFluxoFormatado(to.getIdFluxo()));
            lbFormaPgto.setText(to.getTipoPgto().getTipo());
            lbConta.setText(to.getConta().getNome());
            lbTotalFinan.setText(ReplaceMoedaRTA.doubleToMoeda(to.getValorTotal()));
            lbDataHoraFinan.setText(to.getDataHoraForm());
            lbTipoFinan.setText(to.getTipomovimentacao());
            lbSituacaoFinan.setText(to.getSituacao());

            if (to.getTipomovimentacao().equals("SAÍDA")) {
                btTransferir.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao detalhar financeiro!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void detalhesPedido(int id) {
        try {
            PedidoDAO dao = new PedidoDAO();
            PedidoTO to = dao.detalhaPedido(id);
            lbCodPedido.setText(to.getIdPedFormatado(to.getIdPedido()));
            lbSenhaPedido.setText(to.getSenhaFormatado(to.getSenha()));
            lbDataPedido.setText(to.getDataHoraForm());
            lbTipoPedido.setText(to.getTipoPedido());
            lbFuncPedido.setText(to.getFuncionario().getNome());
            lbValorPedido.setText(ReplaceMoedaRTA.doubleToMoeda(to.getValorPedido()));
            lbDescontoPedido.setText(ReplaceMoedaRTA.doubleToMoeda(to.getDesconto()));
            lbTotalPedido.setText(ReplaceMoedaRTA.doubleToMoeda(to.getValortotal()));
            lbSituacaoPedido.setText(to.getSituacao());

            if (to.getTipoPedido().equals("DELIVERY")) {
                pnEndereco.setEnabled(true);
                for (Component cp : pnEndereco.getComponents()) {
                    cp.setEnabled(true);
                }
                PedidoEntregaDAO deliverydao = new PedidoEntregaDAO();
                PedidoEntregaTO deliveryto = deliverydao.detalhaPedidoSimples(id);
                lbLogradouro.setText(deliveryto.getLogradouro());
                lbCliente.setText(deliveryto.getNomecliente());
                lbNumero.setText(deliveryto.getNumero());
                lbTrocoSolicitado.setText(ReplaceMoedaRTA.doubleToMoeda(deliveryto.getValortroco()));
                lbContato.setText(deliveryto.getContatoFormatado());
                if (!to.getSituacao().equals("ABERTO")) {
                    btTransferir.setEnabled(true);
                    btReceber.setEnabled(false);
                } else {
                    btTransferir.setEnabled(false);
                    btReceber.setEnabled(true);
                }
            } else {
                pnEndereco.setEnabled(false);
                for (Component cp : pnEndereco.getComponents()) {
                    cp.setEnabled(false);
                }
                lbLogradouro.setText("   ");
                lbCliente.setText("   ");
                lbNumero.setText("   ");
                lbTrocoSolicitado.setText("   ");
                lbContato.setText("   ");
                btTransferir.setEnabled(true);
                btReceber.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar informações do pedido: "
                    + id + "\nIdentificação do erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tbProdutos(int id) {
        try {
            ItensPedidoDetalhesFluxoFinanTableModel p = (ItensPedidoDetalhesFluxoFinanTableModel) tbProdutos.getModel();
            tbProdutos.setGridColor(Color.white);
            spProdutos.setBorder(null);
            tbProdutos.setBorder(null);
            tbProdutos.getTableHeader().setReorderingAllowed(false);
            tbProdutos.setColumnSelectionAllowed(false);
            tbProdutos.setRowSelectionAllowed(false);
            tbProdutos.getColumnModel().getColumn(1).setResizable(false);
            tbProdutos.getColumnModel().getColumn(1).setPreferredWidth(60);
            tbProdutos.getColumnModel().getColumn(1).setMaxWidth(60);
            ((DefaultTableCellRenderer) tbProdutos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbProdutos.setDefaultRenderer(Object.class, new CellRenderer());
            ItensPedidoDAO dao = new ItensPedidoDAO();
            p.setDados(dao.detalhaItensPedido(id));
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btReceber;
    private javax.swing.JButton btTransferir;
    public static br.com.fs.rta.JComboBox cbConta;
    public static br.com.fs.rta.JComboBox cbFormaPgto;
    private javax.swing.JComboBox cbRelatorio;
    private javax.swing.JComboBox cbSituacao;
    private javax.swing.JComboBox cbTipo;
    private com.toedter.calendar.JDateChooser dcDataAte;
    private com.toedter.calendar.JDateChooser dcDataDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbCodFinanceiro;
    private javax.swing.JLabel lbCodPedido;
    private javax.swing.JLabel lbConta;
    private javax.swing.JLabel lbContato;
    private javax.swing.JLabel lbDataHoraFinan;
    private javax.swing.JLabel lbDataPedido;
    private javax.swing.JLabel lbDescontoPedido;
    private javax.swing.JLabel lbEmCaixa;
    private javax.swing.JLabel lbFormaPgto;
    private javax.swing.JLabel lbFuncPedido;
    private javax.swing.JLabel lbLogradouro;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbPendente;
    private javax.swing.JLabel lbSaldo;
    private javax.swing.JLabel lbSenhaPedido;
    private javax.swing.JLabel lbSituacaoFinan;
    private javax.swing.JLabel lbSituacaoPedido;
    private javax.swing.JLabel lbTipoFinan;
    private javax.swing.JLabel lbTipoPedido;
    private javax.swing.JLabel lbTotalFinan;
    private javax.swing.JLabel lbTotalPedido;
    private javax.swing.JLabel lbTrocoDelivery;
    private javax.swing.JLabel lbTrocoSolicitado;
    private javax.swing.JLabel lbValorPedido;
    private javax.swing.JPanel pnConsulta;
    private javax.swing.JPanel pnDetalhes;
    private javax.swing.JPanel pnEndereco;
    private javax.swing.JPanel pnFinanceiro;
    private javax.swing.JPanel pnParametros;
    private javax.swing.JPanel pnPedido;
    private javax.swing.JTabbedPane pnPrincipal;
    private javax.swing.JPanel pnProdutos;
    private javax.swing.JPanel pnResultado;
    private javax.swing.JScrollPane spBusca;
    private javax.swing.JScrollPane spProdutos;
    private javax.swing.JTable tbBusca;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField tfCodPedido;
    private javax.swing.JTextField tfValorAte;
    private javax.swing.JTextField tfValorDe;
    // End of variables declaration//GEN-END:variables
}
