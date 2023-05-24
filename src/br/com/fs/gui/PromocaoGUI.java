package br.com.fs.gui;

import br.com.fs.dao.ProdutoDAO;
import br.com.fs.dao.PromocaoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.Mascaras;
import br.com.fs.rta.MascarasDouble;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.tm.PromocaoTableModel;
import br.com.fs.to.ProdutoTO;
import br.com.fs.to.PromocaoTO;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class PromocaoGUI extends javax.swing.JInternalFrame {

    private static PromocaoGUI instancia = null;
    private final Mascaras mascara = new Mascaras();

    public PromocaoGUI() {
        initComponents();
        this.construtor();
    }

    private void construtor() {
        this.bloqueiaFormulario(true);
        this.carregaTabela(" AND prom.situacao = 'A'");
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -30);
        dcBuscaInicio.setDate(cal.getTime());
        dcBuscaTermino.setDate(new Date());
        tfCodProduto.setDocument(mascara.somenteNumero());
        tfBuscaCodigo.setDocument(mascara.somenteNumero());
        tfValorVenda.setDocument(new MascarasDouble(9));
    }

    public static PromocaoGUI getInstancia() {
        if (instancia == null) {
            instancia = new PromocaoGUI();
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

    public void carregaTabela(String query) {
        try {
            PromocaoTableModel p = (PromocaoTableModel) tbBusca.getModel();
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
            PromocaoDAO dao = new PromocaoDAO();
            p.setDados(dao.buscarTodos(query));
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnAbas = new javax.swing.JTabbedPane();
        pnConsulta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dcBuscaInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        dcBuscaTermino = new com.toedter.calendar.JDateChooser();
        tfBuscaCodigo = new javax.swing.JTextField();
        tfBuscaNome = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        cbBuscaSituacao = new javax.swing.JComboBox();
        spBusca = new javax.swing.JScrollPane();
        tbBusca = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        pnCadastro = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tfCodProduto = new javax.swing.JTextField();
        btBuscarProduto = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbPrecoCusto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbPrecoVenda = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbEstoqueAtual = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbUnidade = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbCodPromocao = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dcInicio = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        dcTermino = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        tfValorVenda = new javax.swing.JTextField();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btNova = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Promoções");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parâmetros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("De:");

        jLabel2.setText("Até:");

        tfBuscaCodigo.setToolTipText("Código do produto");
        tfBuscaCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBuscaCodigoKeyPressed(evt);
            }
        });

        tfBuscaNome.setToolTipText("Nome do produto");
        tfBuscaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBuscaNomeKeyPressed(evt);
            }
        });

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        cbBuscaSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "ATIVA", "FINALIZADA" }));
        cbBuscaSituacao.setToolTipText("Situação da promoção");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfBuscaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcBuscaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcBuscaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbBuscaSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(dcBuscaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcBuscaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfBuscaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBuscar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(cbBuscaSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tbBusca.setModel(new PromocaoTableModel());
        tbBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBuscaMouseClicked(evt);
            }
        });
        spBusca.setViewportView(tbBusca);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Resultado:");

        javax.swing.GroupLayout pnConsultaLayout = new javax.swing.GroupLayout(pnConsulta);
        pnConsulta.setLayout(pnConsultaLayout);
        pnConsultaLayout.setHorizontalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnConsultaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnConsultaLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(spBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        pnConsultaLayout.setVerticalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnAbas.addTab("consulta", pnConsulta);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes do produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tfCodProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfCodProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodProdutoFocusLost(evt);
            }
        });

        btBuscarProduto.setText("...");
        btBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProdutoActionPerformed(evt);
            }
        });

        tfNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfNome.setEnabled(false);

        jLabel4.setText("Preço de custo:");

        lbPrecoCusto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPrecoCusto.setText("R$ 0,00");

        jLabel6.setText("Preço de venda:");

        lbPrecoVenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPrecoVenda.setText("R$ 0,00");

        jLabel5.setText("Estoque atual:");

        lbEstoqueAtual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEstoqueAtual.setText("0");

        jLabel8.setText("Unidade:");

        lbUnidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUnidade.setText("UN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPrecoVenda)
                            .addComponent(lbPrecoCusto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUnidade)
                            .addComponent(lbEstoqueAtual))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscarProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarProduto)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbPrecoCusto)
                    .addComponent(jLabel8)
                    .addComponent(lbUnidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbPrecoVenda)
                    .addComponent(jLabel5)
                    .addComponent(lbEstoqueAtual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes da promoção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel10.setText("Código:");

        lbCodPromocao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCodPromocao.setText("000");

        jLabel7.setText("Início da promoção:");

        jLabel9.setText("até:");

        jLabel12.setText("Preço promocional:");

        tfValorVenda.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCodPromocao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dcInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfValorVenda))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbCodPromocao))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(dcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(dcTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btNova.setText("Nova");
        btNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaActionPerformed(evt);
            }
        });

        btFinalizar.setText("Finalizar");
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastroLayout = new javax.swing.GroupLayout(pnCadastro);
        pnCadastro.setLayout(pnCadastroLayout);
        pnCadastroLayout.setHorizontalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastroLayout.createSequentialGroup()
                        .addComponent(btNova)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFinalizar)
                        .addGap(4, 4, 4)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)))
                .addContainerGap())
        );
        pnCadastroLayout.setVerticalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btExcluir)
                    .addComponent(btSalvar)
                    .addComponent(btNova)
                    .addComponent(btFinalizar))
                .addContainerGap())
        );

        pnAbas.addTab("cadastro", pnCadastro);

        getContentPane().add(pnAbas, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.bloqueiaFormulario(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaActionPerformed
        this.limparCampos();
        this.bloqueiaFormulario(false);
        dcInicio.setDate(new Date());
        dcTermino.setDate(new Date());
    }//GEN-LAST:event_btNovaActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if (dcBuscaInicio.getDate().compareTo(dcBuscaTermino.getDate()) == 1) {
            JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
            dcBuscaInicio.requestFocus();
            return;
        }

        String datade = new SimpleDateFormat("yyyy-MM-dd").format(dcBuscaInicio.getDate());
        String dataate = new SimpleDateFormat("yyyy-MM-dd").format(dcBuscaTermino.getDate());

        PromocaoTO to = new PromocaoTO();

        try {
            to.setQuery(tfBuscaCodigo.getText(), " and prom.idproduto = '" + tfBuscaCodigo.getText() + "'");
            to.setQuery(tfBuscaNome.getText(), " and prod.nome LIKE '%" + tfBuscaNome.getText() + "%'");
            switch (cbBuscaSituacao.getSelectedIndex()) {
                case 1:
                    to.setQuery(cbBuscaSituacao.getSelectedItem().toString(), " and prom.situacao = 'A'");
                    break;
                case 2:
                    to.setQuery(cbBuscaSituacao.getSelectedItem().toString(), " and prom.situacao = 'F'");
                    break;
            }
            to.setQuery(datade, " and prom.inicio >= '" + datade + "' and prom.termino <= '" + dataate + "' ");

            if (to.getQuery().trim().length() < 5) {
                to.setQuery("where", " and 1 = 1");
            }

            this.carregaTabela(to.getQuery());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tfCodProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodProdutoFocusLost
        if (tfCodProduto.getText().length() != 0) {
            try {
                ProdutoDAO dao = new ProdutoDAO();
                ProdutoTO to = (ProdutoTO) dao.buscarId(Integer.parseInt(tfCodProduto.getText()));
                if ((to.getIdProduto() != 000) && (to.getSituacao().equals("A")) && (to.getTipo().equals("F"))) {
                    this.carregaProduto(to.getIdProduto());
                } else {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    this.resetarProduto();
                    tfCodProduto.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar produto!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tfCodProdutoFocusLost

    private void resetarProduto() {
        tfCodProduto.setText("");
        tfNome.setText("");
        lbPrecoCusto.setText("");
        lbPrecoVenda.setText("");
        lbUnidade.setText("");
        lbEstoqueAtual.setText("");
    }

    private void btBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProdutoActionPerformed
        ConsultaProdutosPromocaoGUI gui = new ConsultaProdutosPromocaoGUI(this);
        gui.setVisible(true);
    }//GEN-LAST:event_btBuscarProdutoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (tfNome.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Selecione o produto!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfCodProduto.requestFocus();
            return;
        }
        try {
            if (PromocaoDAO.verificaExiste(Integer.parseInt(tfCodProduto.getText().trim()), Integer.parseInt(lbCodPromocao.getText().trim()))) {
                JOptionPane.showMessageDialog(this, "Este produto já está em promoção!", "Atenção", JOptionPane.WARNING_MESSAGE);
                this.resetarProduto();
                tfCodProduto.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao verificar se já existe promoção!\n" + e.getMessage());
        }
        if (dcInicio.getDate().compareTo(dcTermino.getDate()) == 1) {
            JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
            dcInicio.requestFocus();
            return;
        }
        if (ReplaceMoedaRTA.moedaToDouble(tfValorVenda.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Insira o valor de venda promocional!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfValorVenda.requestFocus();
            return;
        }

        try {
            PromocaoDAO dao = new PromocaoDAO();
            PromocaoTO to = new PromocaoTO();
            ProdutoTO produto = new ProdutoTO();

            produto.setIdProduto(tfCodProduto.getText().trim());
            produto.setNome(tfNome.getText().trim());
            to.setIdPromocao(lbCodPromocao.getText());
            to.setValorVenda(ReplaceMoedaRTA.moedaToDouble(lbPrecoVenda.getText()));
            to.setValorPromocao(ReplaceMoedaRTA.moedaToDouble(tfValorVenda.getText()));
            to.setProduto(produto);
            to.setInicio(dcInicio.getDate());
            to.setTermino(dcTermino.getDate());

            if (to.getIdPromocao() == 000) {
                dao.inserir(to);
                JOptionPane.showMessageDialog(this, "Promoção salva com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dao.alterar(to);
                JOptionPane.showMessageDialog(this, "Promoção alterada com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }

            this.carregaTabela(" AND prom.situacao = 'A'");
            pnAbas.setSelectedIndex(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar promoção!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        bloqueiaFormulario(true);
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tbBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBuscaMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tbBusca.getSelectedRow();
            int codigo = Integer.parseInt(tbBusca.getValueAt(row, 0).toString());

            try {
                PromocaoDAO dao = new PromocaoDAO();
                PromocaoTO to = dao.buscarId(codigo);
                if (to.getSituacao().equals("F")) {
                    lbCodPromocao.setText(String.valueOf(to.getIdPromoFormatado(to.getIdPromocao())));
                    tfValorVenda.setText(String.valueOf(to.getValorPromocao()));
                    dcInicio.setDate(to.getInicio());
                    dcTermino.setDate(to.getTermino());
                    this.carregaProduto(to.getProduto().getIdProduto());
                    this.exibeBloqueado();
                } else {
                    lbCodPromocao.setText(String.valueOf(to.getIdPromoFormatado(to.getIdPromocao())));
                    tfValorVenda.setText(String.valueOf(to.getValorPromocao()));
                    dcInicio.setDate(to.getInicio());
                    dcTermino.setDate(to.getTermino());
                    this.carregaProduto(to.getProduto().getIdProduto());
                    this.bloqueiaFormulario(false);
                    tfValorVenda.requestFocus();
                }
                tfCodProduto.setEnabled(false);
                btBuscarProduto.setEnabled(false);
                pnAbas.setSelectedIndex(1);
            } catch (Exception e) {
                JOptionPane.showInternalMessageDialog(this, "Erro ao consultar!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tbBuscaMouseClicked

    private void exibeBloqueado() {
        tfValorVenda.setEnabled(false);
        dcInicio.setEnabled(false);
        dcTermino.setEnabled(false);
        btNova.setEnabled(true);
        btSalvar.setEnabled(false);
        btExcluir.setEnabled(true);
        btCancelar.setEnabled(true);
    }

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int q = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?", "Atenção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (q == JOptionPane.YES_OPTION) {
            try {
                PromocaoDAO dao = new PromocaoDAO();
                PromocaoTO to = new PromocaoTO();
                ProdutoTO produto = new ProdutoTO();

                produto.setIdProduto(tfCodProduto.getText());
                to.setIdPromocao(lbCodPromocao.getText());
                to.setProduto(produto);

                dao.excluir(to);

                JOptionPane.showMessageDialog(this,
                        "Promoção excluída com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Descrição do erro: " + e.getMessage(),
                        "Erro ao excluir promoção!", JOptionPane.ERROR_MESSAGE);
            }
            bloqueiaFormulario(true);
            this.carregaTabela(" AND prom.situacao = 'A'");
            pnAbas.setSelectedIndex(0);
        } else {
            repaint();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void tfBuscaCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            getRootPane().setDefaultButton(btBuscar);
            tfCodProduto.requestFocus();
        }
    }//GEN-LAST:event_tfBuscaCodigoKeyPressed

    private void tfBuscaNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            getRootPane().setDefaultButton(btBuscar);
            tfBuscaNome.requestFocus();
        }
    }//GEN-LAST:event_tfBuscaNomeKeyPressed

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        int q = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja finalizar esta promoção?", "Atenção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (q == JOptionPane.YES_OPTION) {
            try {
                PromocaoDAO dao = new PromocaoDAO();
                PromocaoTO to = new PromocaoTO();
                ProdutoTO produto = new ProdutoTO();

                produto.setIdProduto(tfCodProduto.getText());
                to.setIdPromocao(lbCodPromocao.getText());
                to.setProduto(produto);

                dao.finalizar(to);

                JOptionPane.showMessageDialog(this,
                        "Promoção finalizada com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Descrição do erro: " + e.getMessage(),
                        "Erro ao finalizar promoção!", JOptionPane.ERROR_MESSAGE);
            }
            bloqueiaFormulario(true);
            this.carregaTabela(" AND prom.situacao = 'A'");
            pnAbas.setSelectedIndex(0);
        } else {
            repaint();
        }
    }//GEN-LAST:event_btFinalizarActionPerformed

    public void carregaProduto(int idproduto) {
        try {
            ProdutoDAO produtodao = new ProdutoDAO();
            ProdutoTO to = (ProdutoTO) produtodao.buscarId(idproduto);
            tfCodProduto.setText(to.getIdProdFormatado(to.getIdProduto()));
            tfNome.setText(to.getNome());
            switch (String.valueOf(to.getUnidade())) {
                case "UN":
                    lbUnidade.setText("UNITÁRIO");
                    break;
                case "KG":
                    lbUnidade.setText("KG");
                    break;
                case "L":
                    lbUnidade.setText("LITRO");
                    break;
            }
            lbPrecoCusto.setText(ReplaceMoedaRTA.doubleToMoeda(to.getPrecocusto()));
            lbPrecoVenda.setText(ReplaceMoedaRTA.doubleToMoeda(to.getPrecovenda()));
            if (to.getComposto().equalsIgnoreCase("N")) {
                if (!to.getUnidade().equals("UN")) {
                    lbEstoqueAtual.setText(to.getQtdKGL(to.getQtd()));
                } else {
                    lbEstoqueAtual.setText(String.valueOf(to.getQtdUnidade(to.getQtd())));
                }
            } else {
                lbEstoqueAtual.setText(String.valueOf(produtodao.estoqueComposto(idproduto)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Descrição do erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        lbCodPromocao.setText("000");
        tfCodProduto.setText("");
        tfNome.setText("");
        lbUnidade.setText("");
        lbEstoqueAtual.setText("");
        lbPrecoCusto.setText("");
        lbPrecoVenda.setText("");
        tfValorVenda.setText("");
        dcInicio.setCalendar(null);
        dcTermino.setCalendar(null);
    }

    private void bloqueiaFormulario(boolean var) {
        if (var) {
            this.limparCampos();
            tfCodProduto.setEnabled(false);
            btBuscarProduto.setEnabled(false);
            tfValorVenda.setEnabled(false);
            dcInicio.setEnabled(false);
            dcTermino.setEnabled(false);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btExcluir.setEnabled(false);
            btFinalizar.setEnabled(false);
            btNova.setEnabled(true);
            btNova.requestFocus();
        } else {
            tfCodProduto.setEnabled(true);
            btBuscarProduto.setEnabled(true);
            tfValorVenda.setEnabled(true);
            dcInicio.setEnabled(true);
            dcTermino.setEnabled(true);
            if (lbCodPromocao.getText().equalsIgnoreCase("000")) {
                btExcluir.setEnabled(false);
                btFinalizar.setEnabled(false);
            } else {
                btExcluir.setEnabled(true);
                btFinalizar.setEnabled(true);
            }
            btCancelar.setEnabled(true);
            btSalvar.setEnabled(true);
            btNova.setEnabled(false);
            tfCodProduto.requestFocus();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btBuscarProduto;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btNova;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbBuscaSituacao;
    private com.toedter.calendar.JDateChooser dcBuscaInicio;
    private com.toedter.calendar.JDateChooser dcBuscaTermino;
    private com.toedter.calendar.JDateChooser dcInicio;
    private com.toedter.calendar.JDateChooser dcTermino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbCodPromocao;
    private javax.swing.JLabel lbEstoqueAtual;
    private javax.swing.JLabel lbPrecoCusto;
    private javax.swing.JLabel lbPrecoVenda;
    private javax.swing.JLabel lbUnidade;
    private javax.swing.JTabbedPane pnAbas;
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JPanel pnConsulta;
    private javax.swing.JScrollPane spBusca;
    private javax.swing.JTable tbBusca;
    private javax.swing.JTextField tfBuscaCodigo;
    private javax.swing.JTextField tfBuscaNome;
    private javax.swing.JTextField tfCodProduto;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfValorVenda;
    // End of variables declaration//GEN-END:variables
}
