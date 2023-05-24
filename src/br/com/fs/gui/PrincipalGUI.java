package br.com.fs.gui;

import br.com.fs.dao.LoginDAO;
import br.com.fs.dao.PedidoDAO;
import br.com.fs.dao.ThreadProducao;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.Mascaras;
import br.com.fs.rta.MascarasDouble;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.tm.PedidoTableModel;
import br.com.fs.to.PedidoTO;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class PrincipalGUI extends javax.swing.JFrame {

    private final Mascaras mascara = new Mascaras();
    private final Calendar cal = new GregorianCalendar();

    public PrincipalGUI() {
        initComponents();
        this.construtor();
    }
    
    private void construtor() {
        tfBuscaPedidoDe.setDocument(mascara.somenteNumero());
        tfBuscaPedidoAo.setDocument(mascara.somenteNumero());
        tfBuscaSenha.setDocument(mascara.somenteNumero());
        tfBuscaValorDe.setDocument(new MascarasDouble(9));
        tfBuscaValorAte.setDocument(new MascarasDouble(9));
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -7);
        dcBuscaDe.setDate(cal.getTime());
        dcBuscaAte.setDate(new Date());
        pnConsulta.setVisible(false);
        lbUser.setText(LoginDAO.operador.getNome());
        carregaTabela();
        ThreadProducao thread = new ThreadProducao();
        thread.start();
        setDefaultCloseOperation(PrincipalGUI.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (PedidosGUI.getInstancia().isVisible()) {
                    JOptionPane.showMessageDialog(null, "Antes de sair finalize a operação de pedido!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmar saída", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    repaint();
                }
            }
        });
    }

    public static void carregaTabela() {
        try {
            PedidoTableModel p = (PedidoTableModel) tbPedidos.getModel();
            tbPedidos.setRowHeight(40);
            tbPedidos.getTableHeader().setReorderingAllowed(false);
            tbPedidos.setColumnSelectionAllowed(false);
            tbPedidos.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbPedidos.getColumnModel().getColumn(0).setResizable(false);
            tbPedidos.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbPedidos.getColumnModel().getColumn(0).setMaxWidth(70);
            tbPedidos.getColumnModel().getColumn(1).setResizable(false);
            tbPedidos.getColumnModel().getColumn(1).setPreferredWidth(60);
            tbPedidos.getColumnModel().getColumn(1).setMaxWidth(60);
            tbPedidos.getColumnModel().getColumn(2).setResizable(false);
            tbPedidos.getColumnModel().getColumn(2).setPreferredWidth(110);
            tbPedidos.getColumnModel().getColumn(3).setResizable(false);
            tbPedidos.getColumnModel().getColumn(4).setResizable(false);
            tbPedidos.getColumnModel().getColumn(5).setResizable(false);
            tbPedidos.getColumnModel().getColumn(6).setResizable(false);
            tbPedidos.getColumnModel().getColumn(7).setResizable(false);
            tbPedidos.getColumnModel().getColumn(8).setResizable(false);
            tbPedidos.getColumnModel().getColumn(9).setResizable(false);
            tbPedidos.getColumnModel().getColumn(9).setPreferredWidth(60);
            tbPedidos.getColumnModel().getColumn(9).setMaxWidth(60);
            tbPedidos.getColumnModel().getColumn(10).setResizable(false);
            tbPedidos.getColumnModel().getColumn(10).setPreferredWidth(60);
            tbPedidos.getColumnModel().getColumn(10).setMaxWidth(60);
            tbPedidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((DefaultTableCellRenderer) tbPedidos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbPedidos.setDefaultRenderer(Object.class, new CellRenderer());
            PedidoDAO dao = new PedidoDAO();
            p.setDados(dao.buscarPedidos());
            lbEstimativaFila.setText("Total de pedidos: " + String.valueOf(tbPedidos.getRowCount()) + " | Fila de espera aproximada: " + dao.estimativaFilaPedidos());
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaTabelaFiltro(String filtro) {
        try {
            PedidoTableModel p = (PedidoTableModel) tbPedidos.getModel();
            tbPedidos.setRowHeight(40);
            tbPedidos.getTableHeader().setReorderingAllowed(false);
            tbPedidos.setColumnSelectionAllowed(false);
            tbPedidos.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbPedidos.getColumnModel().getColumn(0).setResizable(false);
            tbPedidos.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbPedidos.getColumnModel().getColumn(0).setMaxWidth(70);
            tbPedidos.getColumnModel().getColumn(1).setResizable(false);
            tbPedidos.getColumnModel().getColumn(1).setPreferredWidth(60);
            tbPedidos.getColumnModel().getColumn(1).setMaxWidth(60);
            tbPedidos.getColumnModel().getColumn(2).setResizable(false);
            tbPedidos.getColumnModel().getColumn(2).setPreferredWidth(110);
            tbPedidos.getColumnModel().getColumn(3).setResizable(false);
            tbPedidos.getColumnModel().getColumn(4).setResizable(false);
            tbPedidos.getColumnModel().getColumn(5).setResizable(false);
            tbPedidos.getColumnModel().getColumn(6).setResizable(false);
            tbPedidos.getColumnModel().getColumn(7).setResizable(false);
            tbPedidos.getColumnModel().getColumn(8).setResizable(false);
            tbPedidos.getColumnModel().getColumn(9).setResizable(false);
            tbPedidos.getColumnModel().getColumn(9).setPreferredWidth(60);
            tbPedidos.getColumnModel().getColumn(9).setMaxWidth(60);
            tbPedidos.getColumnModel().getColumn(10).setResizable(false);
            tbPedidos.getColumnModel().getColumn(10).setPreferredWidth(60);
            tbPedidos.getColumnModel().getColumn(10).setMaxWidth(60);
            tbPedidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((DefaultTableCellRenderer) tbPedidos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbPedidos.setDefaultRenderer(Object.class, new CellRenderer());
            PedidoDAO dao = new PedidoDAO();
            p.setDados(dao.filtroPedidos(filtro));
            lbEstimativaFila.setText("Total de pedidos: " + String.valueOf(tbPedidos.getRowCount()) + " | Fila de espera aproximada: " + dao.estimativaFilaPedidos());
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpCorpo = new javax.swing.JDesktopPane();
        tpPedidos = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btCancelar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btReceber = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btConsultar = new javax.swing.JButton();
        pnPrincipal = new javax.swing.JPanel();
        spPrincipal = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        pnConsulta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfBuscaPedidoDe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfBuscaPedidoAo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfBuscaSenha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfBuscaValorDe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfBuscaValorAte = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbBuscaTipo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbBuscaSituacao = new javax.swing.JComboBox();
        btBuscaBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        dcBuscaDe = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        dcBuscaAte = new com.toedter.calendar.JDateChooser();
        tpEstoque = new javax.swing.JToolBar();
        btProdutos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btFormulas = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btProducao = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btPerca = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        btBalanco = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btPromocoes = new javax.swing.JButton();
        tpFinanceiro = new javax.swing.JToolBar();
        btCaixa = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btContas = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btFormasPgto = new javax.swing.JButton();
        tpUsuario = new javax.swing.JToolBar();
        btOperadores = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        lbUser = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        btLogoff = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btSair = new javax.swing.JButton();
        lbEstimativaFila = new javax.swing.JLabel();
        mbMenu = new javax.swing.JMenuBar();
        mCadastrosConsultas = new javax.swing.JMenu();
        miBalanco = new javax.swing.JMenuItem();
        miCaixa = new javax.swing.JMenuItem();
        miCidades = new javax.swing.JMenuItem();
        miContas = new javax.swing.JMenuItem();
        miFormasPgto = new javax.swing.JMenuItem();
        miFormulas = new javax.swing.JMenuItem();
        miFuncionarios = new javax.swing.JMenuItem();
        miPerca = new javax.swing.JMenuItem();
        miProducao = new javax.swing.JMenuItem();
        miProdutos = new javax.swing.JMenuItem();
        miPromocoes = new javax.swing.JMenuItem();
        jmRelatorios = new javax.swing.JMenu();
        miGerarRelatorios = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        miBackupRestore = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miInformacoes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FAST FOOD v1.0");
        setExtendedState(PrincipalGUI.MAXIMIZED_BOTH);
        setPreferredSize(new java.awt.Dimension(1366, 750));
        getContentPane().setLayout(new java.awt.BorderLayout());

        dpCorpo.setBackground(new java.awt.Color(240, 240, 240));
        dpCorpo.setForeground(new java.awt.Color(255, 255, 255));

        tpPedidos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Pedidos", 2, 0, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        tpPedidos.setRollover(true);
        tpPedidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/add_file.png"))); // NOI18N
        btNovo.setText("Novo pedido");
        btNovo.setFocusable(false);
        btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        tpPedidos.add(btNovo);
        tpPedidos.add(jSeparator4);

        btCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/cancel.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setFocusable(false);
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        tpPedidos.add(btCancelar);
        tpPedidos.add(jSeparator5);

        btReceber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/cash_receiving.png"))); // NOI18N
        btReceber.setText("Receber");
        btReceber.setFocusable(false);
        btReceber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btReceber.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
            }
        });
        tpPedidos.add(btReceber);
        tpPedidos.add(jSeparator6);

        btConsultar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/search.png"))); // NOI18N
        btConsultar.setText("Consultar");
        btConsultar.setFocusable(false);
        btConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });
        tpPedidos.add(btConsultar);

        spPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        spPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tbPedidos.setAutoCreateRowSorter(true);
        tbPedidos.setBackground(getBackground());
        tbPedidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbPedidos.setModel(new PedidoTableModel());
        tbPedidos.setGridColor(new java.awt.Color(255, 255, 255));
        spPrincipal.setViewportView(tbPedidos);

        pnConsulta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        jLabel1.setText("Do pedido:");

        tfBuscaPedidoDe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscaPedidoDeFocusLost(evt);
            }
        });

        jLabel2.setText("ao:");

        jLabel3.setText("Senha:");

        jLabel4.setText("De (R$):");

        tfBuscaValorDe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscaValorDeFocusLost(evt);
            }
        });

        jLabel5.setText("até:");

        jLabel6.setText("Tipo:");

        cbBuscaTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "LOCAL", "DELIVERY" }));

        jLabel7.setText("Situação:");

        cbBuscaSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "ABERTO", "PAGO", "FINALIZADO", "CANCELADO" }));

        btBuscaBuscar.setText("Buscar");
        btBuscaBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaBuscarActionPerformed(evt);
            }
        });

        jLabel8.setText("De:");

        jLabel9.setText("até:");

        javax.swing.GroupLayout pnConsultaLayout = new javax.swing.GroupLayout(pnConsulta);
        pnConsulta.setLayout(pnConsultaLayout);
        pnConsultaLayout.setHorizontalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscaPedidoDe, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscaPedidoAo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscaValorDe, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscaValorAte, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbBuscaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbBuscaSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcBuscaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcBuscaAte, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btBuscaBuscar)
                .addContainerGap())
        );
        pnConsultaLayout.setVerticalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcBuscaAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tfBuscaPedidoDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(tfBuscaPedidoAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(tfBuscaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(tfBuscaValorDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(tfBuscaValorAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(cbBuscaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(cbBuscaSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBuscaBuscar)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addComponent(dcBuscaDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1293, Short.MAX_VALUE)
            .addComponent(pnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalLayout.createSequentialGroup()
                .addComponent(pnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
        );

        tpEstoque.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Estoque", 2, 0, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        tpEstoque.setRollover(true);
        tpEstoque.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/humburger.png"))); // NOI18N
        btProdutos.setText("Produtos");
        btProdutos.setFocusable(false);
        btProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btProdutos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutosActionPerformed(evt);
            }
        });
        tpEstoque.add(btProdutos);
        tpEstoque.add(jSeparator1);

        btFormulas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btFormulas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/ingredientslist.png"))); // NOI18N
        btFormulas.setText("Fórmulas");
        btFormulas.setFocusable(false);
        btFormulas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFormulas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFormulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFormulasActionPerformed(evt);
            }
        });
        tpEstoque.add(btFormulas);
        tpEstoque.add(jSeparator7);

        btProducao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btProducao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/coffe_maker.png"))); // NOI18N
        btProducao.setText("Produção");
        btProducao.setFocusable(false);
        btProducao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btProducao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btProducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProducaoActionPerformed(evt);
            }
        });
        tpEstoque.add(btProducao);
        tpEstoque.add(jSeparator2);

        btPerca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btPerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/trash.png"))); // NOI18N
        btPerca.setText(" Perca ");
        btPerca.setFocusable(false);
        btPerca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPerca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPercaActionPerformed(evt);
            }
        });
        tpEstoque.add(btPerca);
        tpEstoque.add(jSeparator13);

        btBalanco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btBalanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/compare.png"))); // NOI18N
        btBalanco.setText("Balanço");
        btBalanco.setFocusable(false);
        btBalanco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btBalanco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btBalanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBalancoActionPerformed(evt);
            }
        });
        tpEstoque.add(btBalanco);
        tpEstoque.add(jSeparator3);

        btPromocoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btPromocoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/sale.png"))); // NOI18N
        btPromocoes.setText("Promoções");
        btPromocoes.setFocusable(false);
        btPromocoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPromocoes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPromocoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPromocoesActionPerformed(evt);
            }
        });
        tpEstoque.add(btPromocoes);

        tpFinanceiro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Financeiro", 2, 0, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        tpFinanceiro.setRollover(true);
        tpFinanceiro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btCaixa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/bank.png"))); // NOI18N
        btCaixa.setText("Caixa");
        btCaixa.setFocusable(false);
        btCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCaixa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCaixaActionPerformed(evt);
            }
        });
        tpFinanceiro.add(btCaixa);
        tpFinanceiro.add(jSeparator8);

        btContas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/money_bag.png"))); // NOI18N
        btContas.setText("Contas");
        btContas.setFocusable(false);
        btContas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btContas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btContasActionPerformed(evt);
            }
        });
        tpFinanceiro.add(btContas);
        tpFinanceiro.add(jSeparator9);

        btFormasPgto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btFormasPgto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/card_in_use.png"))); // NOI18N
        btFormasPgto.setText("Formas pgto");
        btFormasPgto.setFocusable(false);
        btFormasPgto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFormasPgto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFormasPgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFormasPgtoActionPerformed(evt);
            }
        });
        tpFinanceiro.add(btFormasPgto);

        tpUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Usuário", 2, 0, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        tpUsuario.setRollover(true);
        tpUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btOperadores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btOperadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/conference_call.png"))); // NOI18N
        btOperadores.setText("Operadores");
        btOperadores.setFocusable(false);
        btOperadores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btOperadores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btOperadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOperadoresActionPerformed(evt);
            }
        });
        tpUsuario.add(btOperadores);
        tpUsuario.add(jSeparator10);

        lbUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUser.setText("USUÁRIO");
        lbUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbUser.setMaximumSize(new java.awt.Dimension(220, 17));
        lbUser.setPreferredSize(new java.awt.Dimension(220, 17));
        tpUsuario.add(lbUser);
        tpUsuario.add(jSeparator12);

        btLogoff.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/logout.png"))); // NOI18N
        btLogoff.setText("Logoff");
        btLogoff.setFocusable(false);
        btLogoff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btLogoff.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoffActionPerformed(evt);
            }
        });
        tpUsuario.add(btLogoff);
        tpUsuario.add(jSeparator11);

        btSair.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/close_window.png"))); // NOI18N
        btSair.setText("Fechar");
        btSair.setFocusable(false);
        btSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        tpUsuario.add(btSair);

        lbEstimativaFila.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEstimativaFila.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbEstimativaFila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fs/img/timer.png"))); // NOI18N
        lbEstimativaFila.setText("00h00m00s");
        lbEstimativaFila.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbEstimativaFila.setIconTextGap(5);

        dpCorpo.setLayer(tpPedidos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpCorpo.setLayer(pnPrincipal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpCorpo.setLayer(tpEstoque, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpCorpo.setLayer(tpFinanceiro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpCorpo.setLayer(tpUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpCorpo.setLayer(lbEstimativaFila, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dpCorpoLayout = new javax.swing.GroupLayout(dpCorpo);
        dpCorpo.setLayout(dpCorpoLayout);
        dpCorpoLayout.setHorizontalGroup(
            dpCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dpCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dpCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dpCorpoLayout.createSequentialGroup()
                        .addComponent(tpPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tpEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tpFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tpUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(pnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dpCorpoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbEstimativaFila)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        dpCorpoLayout.setVerticalGroup(
            dpCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dpCorpoLayout.createSequentialGroup()
                .addGroup(dpCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tpPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tpEstoque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tpFinanceiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tpUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(lbEstimativaFila)
                .addContainerGap())
        );

        getContentPane().add(dpCorpo, java.awt.BorderLayout.CENTER);

        mCadastrosConsultas.setText("Cadastros e consultas");

        miBalanco.setText("Balanço");
        miBalanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBalancoActionPerformed(evt);
            }
        });
        mCadastrosConsultas.add(miBalanco);

        miCaixa.setText("Caixa");
        miCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCaixaActionPerformed(evt);
            }
        });
        mCadastrosConsultas.add(miCaixa);

        miCidades.setText("Cidades");
        miCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCidadesActionPerformed(evt);
            }
        });
        mCadastrosConsultas.add(miCidades);

        miContas.setText("Contas");
        miContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miContasActionPerformed(evt);
            }
        });
        mCadastrosConsultas.add(miContas);

        miFormasPgto.setText("Formas de pgto");
        miFormasPgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFormasPgtoActionPerformed(evt);
            }
        });
        mCadastrosConsultas.add(miFormasPgto);

        miFormulas.setText("Fórmulas");
        miFormulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFormulasActionPerformed(evt);
            }
        });
        mCadastrosConsultas.add(miFormulas);

        miFuncionarios.setText("Operadores");
        miFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFuncionariosActionPerformed(evt);
            }
        });
        mCadastrosConsultas.add(miFuncionarios);

        miPerca.setText("Perca");
        miPerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPercaActionPerformed(evt);
            }
        });
        mCadastrosConsultas.add(miPerca);

        miProducao.setText("Produção");
        miProducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProducaoActionPerformed(evt);
            }
        });
        mCadastrosConsultas.add(miProducao);

        miProdutos.setText("Produtos");
        miProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProdutosActionPerformed(evt);
            }
        });
        mCadastrosConsultas.add(miProdutos);

        miPromocoes.setText("Promoções");
        miPromocoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPromocoesActionPerformed(evt);
            }
        });
        mCadastrosConsultas.add(miPromocoes);

        mbMenu.add(mCadastrosConsultas);

        jmRelatorios.setText("Relatórios");

        miGerarRelatorios.setText("Gerar relatórios");
        miGerarRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGerarRelatoriosActionPerformed(evt);
            }
        });
        jmRelatorios.add(miGerarRelatorios);

        mbMenu.add(jmRelatorios);

        jMenu1.setText("Manutenção");

        miBackupRestore.setText("Backup do sistema");
        miBackupRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBackupRestoreActionPerformed(evt);
            }
        });
        jMenu1.add(miBackupRestore);

        mbMenu.add(jMenu1);

        jMenu2.setText("Sobre");

        miInformacoes.setText("Informações do sistema");
        miInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInformacoesActionPerformed(evt);
            }
        });
        jMenu2.add(miInformacoes);

        mbMenu.add(jMenu2);

        setJMenuBar(mbMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        PedidosGUI pedidos = new PedidosGUI().getInstancia();
        dpCorpo.remove(pedidos.getInstancia());
        dpCorpo.add(pedidos.getInstancia());
        pedidos.getInstancia().setVisible(true);
        pedidos.getInstancia().setLocation(275, 90);
        pedidos.getInstancia().toFront();
    }//GEN-LAST:event_btNovoActionPerformed

    private void miBalancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBalancoActionPerformed
        AjusteEstoqueGUI ae = new AjusteEstoqueGUI().getInstancia();
        dpCorpo.remove(ae.getInstancia());
        dpCorpo.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(470, 110);
        ae.getInstancia().toFront();
    }//GEN-LAST:event_miBalancoActionPerformed

    private void miCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCaixaActionPerformed
        FluxoFinanGUI cr = new FluxoFinanGUI().getInstancia();
        dpCorpo.remove(cr.getInstancia());
        dpCorpo.add(cr.getInstancia());
        cr.getInstancia().setVisible(true);
        cr.getInstancia().setLocation(277, 85);
        cr.getInstancia().toFront();
    }//GEN-LAST:event_miCaixaActionPerformed

    private void miCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCidadesActionPerformed
        CidadesGUI cidade = new CidadesGUI().getInstancia();
        dpCorpo.remove(cidade.getInstancia());
        dpCorpo.add(cidade.getInstancia());
        cidade.getInstancia().setVisible(true);
        cidade.getInstancia().setLocation(470, 90);
        cidade.getInstancia().toFront();
    }//GEN-LAST:event_miCidadesActionPerformed

    private void miContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miContasActionPerformed
        ContasGUI gui = new ContasGUI().getInstancia();
        dpCorpo.remove(gui.getInstancia());
        dpCorpo.add(gui.getInstancia());
        gui.getInstancia().setVisible(true);
        gui.getInstancia().setLocation(470, 140);
        gui.getInstancia().toFront();
    }//GEN-LAST:event_miContasActionPerformed

    private void miFormasPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFormasPgtoActionPerformed
        TiposPgtoGUI tipos = new TiposPgtoGUI().getInstancia();
        dpCorpo.remove(tipos.getInstancia());
        dpCorpo.add(tipos.getInstancia());
        tipos.getInstancia().setVisible(true);
        tipos.getInstancia().setLocation(470, 110);
        tipos.getInstancia().toFront();
    }//GEN-LAST:event_miFormasPgtoActionPerformed

    private void miFormulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFormulasActionPerformed
        FormulasGUI formulas = new FormulasGUI().getInstancia();
        dpCorpo.remove(formulas.getInstancia());
        dpCorpo.add(formulas.getInstancia());
        formulas.getInstancia().setVisible(true);
        formulas.getInstancia().setLocation(460, 90);
        formulas.getInstancia().toFront();
    }//GEN-LAST:event_miFormulasActionPerformed

    private void miFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFuncionariosActionPerformed
        FuncionariosGUI funcionarios = new FuncionariosGUI().getInstancia();
        dpCorpo.remove(funcionarios.getInstancia());
        dpCorpo.add(funcionarios.getInstancia());
        funcionarios.getInstancia().setVisible(true);
        funcionarios.getInstancia().setLocation(350, 90);
        funcionarios.getInstancia().toFront();
    }//GEN-LAST:event_miFuncionariosActionPerformed

    private void miProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProdutosActionPerformed
        ProdutosGUI produtos = new ProdutosGUI().getInstancia();
        dpCorpo.remove(produtos.getInstancia());
        dpCorpo.add(produtos.getInstancia());
        produtos.getInstancia().setVisible(true);
        produtos.getInstancia().setLocation(435, 100);
        produtos.getInstancia().toFront();
    }//GEN-LAST:event_miProdutosActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        int row = tbPedidos.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Nenhum pedido selecionado!");
            return;
        }
        int codigo = Integer.parseInt(tbPedidos.getValueAt(row, 0).toString());
        String situacao = String.valueOf(tbPedidos.getValueAt(row, 8).toString());
        switch (situacao) {
            case "FINALIZADO":
                JOptionPane.showMessageDialog(null, "Este pedido foi finalizado e não pode ser cancelado!");
                return;
            case "CANCELADO":
                JOptionPane.showMessageDialog(null, "Este pedido já foi cancelado!");
                return;
            default:
                CancelarPedidoGUI con = new CancelarPedidoGUI(codigo);
                con.setVisible(true);
                break;
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutosActionPerformed
        ProdutosGUI produtos = new ProdutosGUI().getInstancia();
        dpCorpo.remove(produtos.getInstancia());
        dpCorpo.add(produtos.getInstancia());
        produtos.getInstancia().setVisible(true);
        produtos.getInstancia().setLocation(435, 100);
        produtos.getInstancia().toFront();
    }//GEN-LAST:event_btProdutosActionPerformed

    private void btFormulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFormulasActionPerformed
        FormulasGUI formulas = new FormulasGUI().getInstancia();
        dpCorpo.remove(formulas.getInstancia());
        dpCorpo.add(formulas.getInstancia());
        formulas.getInstancia().setVisible(true);
        formulas.getInstancia().setLocation(460, 90);
        formulas.getInstancia().toFront();
    }//GEN-LAST:event_btFormulasActionPerformed

    private void btProducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProducaoActionPerformed
        ProducaoGUI ae = new ProducaoGUI().getInstancia();
        dpCorpo.remove(ae.getInstancia());
        dpCorpo.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(470, 110);
        ae.getInstancia().toFront();
    }//GEN-LAST:event_btProducaoActionPerformed

    private void btBalancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBalancoActionPerformed
        AjusteEstoqueGUI ae = new AjusteEstoqueGUI().getInstancia();
        dpCorpo.remove(ae.getInstancia());
        dpCorpo.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(470, 110);
        ae.getInstancia().toFront();
    }//GEN-LAST:event_btBalancoActionPerformed

    private void btCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCaixaActionPerformed
        FluxoFinanGUI cr = new FluxoFinanGUI().getInstancia();
        dpCorpo.remove(cr.getInstancia());
        dpCorpo.add(cr.getInstancia());
        cr.getInstancia().setVisible(true);
        cr.getInstancia().setLocation(277, 85);
        cr.getInstancia().toFront();
    }//GEN-LAST:event_btCaixaActionPerformed

    private void btContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btContasActionPerformed
        ContasGUI gui = new ContasGUI().getInstancia();
        dpCorpo.remove(gui.getInstancia());
        dpCorpo.add(gui.getInstancia());
        gui.getInstancia().setVisible(true);
        gui.getInstancia().setLocation(470, 140);
        gui.getInstancia().toFront();
    }//GEN-LAST:event_btContasActionPerformed

    private void btFormasPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFormasPgtoActionPerformed
        TiposPgtoGUI tipos = new TiposPgtoGUI().getInstancia();
        dpCorpo.remove(tipos.getInstancia());
        dpCorpo.add(tipos.getInstancia());
        tipos.getInstancia().setVisible(true);
        tipos.getInstancia().setLocation(470, 110);
        tipos.getInstancia().toFront();
    }//GEN-LAST:event_btFormasPgtoActionPerformed

    private void btOperadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOperadoresActionPerformed
        FuncionariosGUI funcionarios = new FuncionariosGUI().getInstancia();
        dpCorpo.remove(funcionarios.getInstancia());
        dpCorpo.add(funcionarios.getInstancia());
        funcionarios.getInstancia().setVisible(true);
        funcionarios.getInstancia().setLocation(350, 90);
        funcionarios.getInstancia().toFront();
    }//GEN-LAST:event_btOperadoresActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        if (PedidosGUI.getInstancia().isVisible()) {
            JOptionPane.showMessageDialog(null, "Antes de sair finalize a operação de pedido!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmar saída", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            repaint();
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void btLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoffActionPerformed
        if (PedidosGUI.getInstancia().isVisible()) {
            JOptionPane.showMessageDialog(null, "Antes de sair finalize a operação de pedido!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fazer logoff?", "Confirmar logoff", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
            LoginDAO.operador.setIdFuncionario(0);
            new LoginGUI().setVisible(true);
        } else {
            repaint();
        }
    }//GEN-LAST:event_btLogoffActionPerformed

    private void btReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceberActionPerformed
        int row = tbPedidos.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Nenhum pedido selecionado!");
            return;
        }
        int codigo = Integer.parseInt(tbPedidos.getValueAt(row, 0).toString());
        String situacao = String.valueOf(tbPedidos.getValueAt(row, 8).toString());
        switch (situacao) {
            case "PAGO":
            case "FINALIZADO":
                JOptionPane.showMessageDialog(null, "Pedido já recebido, checar o caixa!");
                return;
            case "CANCELADO":
                JOptionPane.showMessageDialog(null, "Este pedido foi cancelado e não pode ser alterado!");
                return;
            default:
                RecebePedidoEntregaGUI con = new RecebePedidoEntregaGUI(this, codigo);
                con.setVisible(true);
                break;
        }
    }//GEN-LAST:event_btReceberActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        if (pnConsulta.isVisible()) {
            tfBuscaPedidoDe.setText("");
            tfBuscaPedidoAo.setText("");
            tfBuscaSenha.setText("");
            tfBuscaValorDe.setText("");
            tfBuscaValorAte.setText("");
            cbBuscaSituacao.setSelectedIndex(0);
            cbBuscaTipo.setSelectedIndex(0);
            dcBuscaDe.setDate(cal.getTime());
            dcBuscaAte.setDate(new Date());
            pnConsulta.setVisible(false);
            carregaTabela();
        } else {
            pnConsulta.setVisible(true);
        }
    }

    private void tfBuscaPedidoDeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscaPedidoDeFocusLost
        tfBuscaPedidoAo.setText(tfBuscaPedidoDe.getText());
    }

    private void tfBuscaValorDeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscaValorDeFocusLost
        tfBuscaValorAte.setText(tfBuscaValorDe.getText());
    }

    private void btBuscaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaBuscarActionPerformed
        double valorde = ReplaceMoedaRTA.moedaToDouble(tfBuscaValorDe.getText());
        double valorate = ReplaceMoedaRTA.moedaToDouble(tfBuscaValorAte.getText());
        if (valorde > valorate) {
            JOptionPane.showMessageDialog(null, "Valor inicial não pode ser maior que o valor final!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfBuscaValorDe.requestFocus();
            return;
        }
        if (dcBuscaDe.getDate().compareTo(dcBuscaAte.getDate()) == 1) {
            JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
            dcBuscaDe.requestFocus();
            return;
        }

        String datade = new SimpleDateFormat("yyyy-MM-dd").format(dcBuscaDe.getDate());
        String dataate = new SimpleDateFormat("yyyy-MM-dd").format(dcBuscaAte.getDate());

        PedidoTO to = new PedidoTO();

        try {
            to.setQuery(tfBuscaPedidoDe.getText(), " and id between '" + tfBuscaPedidoDe.getText() + "' and '" + tfBuscaPedidoAo.getText() + "' ");
            if (tfBuscaSenha.getText().length() > 0) {
                to.setQuery(tfBuscaSenha.getText(), " and senha = '" + tfBuscaSenha.getText() + "'");
            }
            to.setQuery(datade, " and date(datahorapedido) between '" + datade + "' and '" + dataate + "' ");
            switch (cbBuscaSituacao.getSelectedIndex()) {
                case 1:
                    to.setQuery(cbBuscaSituacao.getSelectedItem().toString(), " and situacao = 'A'");
                    break;
                case 2:
                    to.setQuery(cbBuscaSituacao.getSelectedItem().toString(), " and situacao = 'P'");
                    break;
                case 3:
                    to.setQuery(cbBuscaSituacao.getSelectedItem().toString(), " and situacao = 'F'");
                    break;
                case 4:
                    to.setQuery(cbBuscaSituacao.getSelectedItem().toString(), " and situacao = 'C'");
                    break;
            }
            if (valorde > 0) {
                to.setQuery(String.valueOf(valorde), " and valortotal between " + valorde + " and " + valorate);
            }
            switch (cbBuscaTipo.getSelectedIndex()) {
                case 1:
                    to.setQuery(cbBuscaTipo.getSelectedItem().toString(), " and tipopedido = 'L'");
                    break;
                case 2:
                    to.setQuery(cbBuscaTipo.getSelectedItem().toString(), " and tipopedido = 'E'");
                    break;
            }

            if (to.getQuery().trim().length() < 5) {
                to.setQuery("where", " and 1 = 1");
            }

            this.carregaTabelaFiltro(to.getQuery());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void miProducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProducaoActionPerformed
        ProducaoGUI ae = new ProducaoGUI().getInstancia();
        dpCorpo.remove(ae.getInstancia());
        dpCorpo.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(470, 110);
        ae.getInstancia().toFront();
    }

    private void btPromocoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPromocoesActionPerformed
        PromocaoGUI ae = new PromocaoGUI().getInstancia();
        dpCorpo.remove(ae.getInstancia());
        dpCorpo.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(470, 110);
        ae.getInstancia().toFront();
    }

    private void miPromocoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPromocoesActionPerformed
        PromocaoGUI ae = new PromocaoGUI().getInstancia();
        dpCorpo.remove(ae.getInstancia());
        dpCorpo.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(470, 110);
        ae.getInstancia().toFront();
    }

    private void miGerarRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGerarRelatoriosActionPerformed
        GeraRelatoriosGUI ae = new GeraRelatoriosGUI().getInstancia();
        dpCorpo.remove(ae.getInstancia());
        dpCorpo.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(450, 110);
        ae.getInstancia().toFront();
    }

    private void btPercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPercaActionPerformed
        PercaGUI ae = new PercaGUI().getInstancia();
        dpCorpo.remove(ae.getInstancia());
        dpCorpo.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(470, 110);
        ae.getInstancia().toFront();
    }

    private void miPercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPercaActionPerformed
        PercaGUI ae = new PercaGUI().getInstancia();
        dpCorpo.remove(ae.getInstancia());
        dpCorpo.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(470, 110);
        ae.getInstancia().toFront();
    }

    private void miBackupRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBackupRestoreActionPerformed
        ManutencaoBDGUI ae = new ManutencaoBDGUI().getInstancia();
        dpCorpo.remove(ae.getInstancia());
        dpCorpo.add(ae.getInstancia());
        ae.getInstancia().setVisible(true);
        ae.getInstancia().setLocation(400, 110);
        ae.getInstancia().toFront();
    }

    private void miInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInformacoesActionPerformed
        InformacoesGUI gui = new InformacoesGUI(this, true);
        gui.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBalanco;
    private javax.swing.JButton btBuscaBuscar;
    private javax.swing.JButton btCaixa;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btContas;
    private javax.swing.JButton btFormasPgto;
    private javax.swing.JButton btFormulas;
    private javax.swing.JButton btLogoff;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btOperadores;
    private javax.swing.JButton btPerca;
    private javax.swing.JButton btProducao;
    private javax.swing.JButton btProdutos;
    private javax.swing.JButton btPromocoes;
    private javax.swing.JButton btReceber;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox cbBuscaSituacao;
    private javax.swing.JComboBox cbBuscaTipo;
    private com.toedter.calendar.JDateChooser dcBuscaAte;
    private com.toedter.calendar.JDateChooser dcBuscaDe;
    public static javax.swing.JDesktopPane dpCorpo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JMenu jmRelatorios;
    public static javax.swing.JLabel lbEstimativaFila;
    private javax.swing.JLabel lbUser;
    private javax.swing.JMenu mCadastrosConsultas;
    private javax.swing.JMenuBar mbMenu;
    private javax.swing.JMenuItem miBackupRestore;
    private javax.swing.JMenuItem miBalanco;
    private javax.swing.JMenuItem miCaixa;
    private javax.swing.JMenuItem miCidades;
    private javax.swing.JMenuItem miContas;
    private javax.swing.JMenuItem miFormasPgto;
    private javax.swing.JMenuItem miFormulas;
    private javax.swing.JMenuItem miFuncionarios;
    private javax.swing.JMenuItem miGerarRelatorios;
    private javax.swing.JMenuItem miInformacoes;
    private javax.swing.JMenuItem miPerca;
    private javax.swing.JMenuItem miProducao;
    private javax.swing.JMenuItem miProdutos;
    private javax.swing.JMenuItem miPromocoes;
    private javax.swing.JPanel pnConsulta;
    private javax.swing.JPanel pnPrincipal;
    public static javax.swing.JScrollPane spPrincipal;
    public static javax.swing.JTable tbPedidos;
    private javax.swing.JTextField tfBuscaPedidoAo;
    private javax.swing.JTextField tfBuscaPedidoDe;
    private javax.swing.JTextField tfBuscaSenha;
    private javax.swing.JTextField tfBuscaValorAte;
    private javax.swing.JTextField tfBuscaValorDe;
    private javax.swing.JToolBar tpEstoque;
    private javax.swing.JToolBar tpFinanceiro;
    private javax.swing.JToolBar tpPedidos;
    private javax.swing.JToolBar tpUsuario;
    // End of variables declaration//GEN-END:variables
}
