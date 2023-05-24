package br.com.fs.gui;

import br.com.fs.dao.ProdutoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.Mascaras;
import br.com.fs.rta.MascarasDouble;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.tm.ProdutosTableModel;
import br.com.fs.to.ProdutoTO;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ProdutosGUI extends javax.swing.JInternalFrame {

    private static ProdutosGUI instancia = null;
    private int controlaRB;
    Mascaras mascara = new Mascaras();

    public ProdutosGUI() {
        initComponents();
        this.construtor();
    }

    public static ProdutosGUI getInstancia() {
        if (instancia == null) {
            instancia = new ProdutosGUI();
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
        atualizarBusca();
        bloqueiaFormulario(true);
        tfBuscaCod.setDocument(mascara.somenteNumero());
        tfPrecoCusto.setDocument(new MascarasDouble(8));
        tfPrecoVenda.setDocument(new MascarasDouble(8));
    }

    private void atualizarBusca() {
        try {
            ProdutosTableModel p = (ProdutosTableModel) tbBusca.getModel();
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
            p.setDados(dao.buscarTodos());
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarBusca(ArrayList busca) {
        try {
            ProdutosTableModel p = (ProdutosTableModel) tbBusca.getModel();
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

    private void limparCampos() {
        rbProdutoFinal.setSelected(true);
        chProdutoComposto.setSelected(false);
        tfCodigo.setText("000");
        tfNome.setText("");
        tfDescricao.setText("");
        tfPrecoCusto.setText("");
        tfPrecoVenda.setText("");
        tfQtde.setText("");
        cbUnidade.setSelectedItem("UN");
        cbSituacao.setSelectedItem("ATIVO");
        tfTempoProd.setText("00:00:00");
    }

    private void bloqueiaFormulario(boolean controle) {
        if (controle) {
            limparCampos();
            rbProdutoFinal.setEnabled(false);
            rbProdutoInacabado.setEnabled(false);
            chProdutoComposto.setEnabled(false);
            tfNome.setEnabled(false);
            tfDescricao.setEnabled(false);
            tfPrecoCusto.setEnabled(false);
            tfPrecoVenda.setEnabled(false);
            tfQtde.setEnabled(false);
            tfTempoProd.setEnabled(false);
            cbUnidade.setEnabled(false);
            cbSituacao.setEnabled(false);
            btFormula.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btCadastrar.setEnabled(true);
            btCadastrar.requestFocus();
            controlaRB = 0;
        } else {
            rbProdutoFinal.setEnabled(true);
            rbProdutoInacabado.setEnabled(true);
            chProdutoComposto.setEnabled(true);
            tfNome.setEnabled(true);
            tfDescricao.setEnabled(true);
            if (!chProdutoComposto.isSelected()) {
                tfPrecoCusto.setEnabled(true);
                tfQtde.setEnabled(true);
            }
            tfPrecoVenda.setEnabled(true);
            cbUnidade.setEnabled(true);
            cbSituacao.setEnabled(true);
            if (rbProdutoInacabado.isSelected()) {
                tfPrecoVenda.setEnabled(false);
            }
            if (tfCodigo.getText().equalsIgnoreCase("000")) {
                btExcluir.setEnabled(false);
            } else {
                btExcluir.setEnabled(true);
            }
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btCadastrar.setEnabled(false);
            tfNome.requestFocus();
            controlaRB = 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgProduto = new javax.swing.ButtonGroup();
        tbPrincipal = new javax.swing.JTabbedPane();
        pnConsulta = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbBusca = new javax.swing.JComboBox();
        tfBusca = new javax.swing.JTextField();
        cbBSituacao = new javax.swing.JComboBox();
        cbBTipo = new javax.swing.JComboBox();
        btBusca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfBuscaCod = new javax.swing.JTextField();
        spBusca = new javax.swing.JScrollPane();
        tbBusca = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        pnCadastro = new javax.swing.JPanel();
        pnTipoProduto = new javax.swing.JPanel();
        rbProdutoFinal = new javax.swing.JRadioButton();
        rbProdutoInacabado = new javax.swing.JRadioButton();
        chProdutoComposto = new javax.swing.JCheckBox();
        pnInformacoesProduto = new javax.swing.JPanel();
        jlCodigo = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jlUnidade = new javax.swing.JLabel();
        cbUnidade = new javax.swing.JComboBox();
        jlDescricao = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        jlQtde = new javax.swing.JLabel();
        tfQtde = new javax.swing.JTextField();
        jlPrecoCusto = new javax.swing.JLabel();
        tfPrecoCusto = new javax.swing.JTextField();
        jlPrecoVenda = new javax.swing.JLabel();
        tfPrecoVenda = new javax.swing.JTextField();
        jlSituacao = new javax.swing.JLabel();
        cbSituacao = new javax.swing.JComboBox();
        tfCodigo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTempoProd = new javax.swing.JFormattedTextField();
        btCadastrar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btFormula = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Produtos");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parâmetros de consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        cbBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NOME", "DESCRIÇÃO" }));

        tfBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBuscaKeyPressed(evt);
            }
        });

        cbBSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "ATIVOS", "INATIVOS" }));
        cbBSituacao.setToolTipText("");

        cbBTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "FINAL", "INGRED." }));
        cbBTipo.setToolTipText("");

        btBusca.setText("Buscar");
        btBusca.setPreferredSize(new java.awt.Dimension(39, 23));
        btBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar por:");

        jLabel3.setText("Situação:");

        jLabel4.setText("Tipo de produto:");

        jLabel6.setText("Cód.:");

        tfBuscaCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBuscaCodKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBSituacao, 0, 78, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBuscaCod, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbBSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfBuscaCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbBusca.setAutoCreateRowSorter(true);
        tbBusca.setModel(new ProdutosTableModel());
        tbBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBuscaMouseClicked(evt);
            }
        });
        spBusca.setViewportView(tbBusca);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Produtos disponíveis:");

        javax.swing.GroupLayout pnConsultaLayout = new javax.swing.GroupLayout(pnConsulta);
        pnConsulta.setLayout(pnConsultaLayout);
        pnConsultaLayout.setHorizontalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnConsultaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnConsultaLayout.createSequentialGroup()
                        .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spBusca))
                        .addContainerGap())))
        );
        pnConsultaLayout.setVerticalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbPrincipal.addTab("consulta", pnConsulta);

        pnTipoProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione o tipo do produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        bgProduto.add(rbProdutoFinal);
        rbProdutoFinal.setText("PRODUTO FINAL");
        rbProdutoFinal.setToolTipText("<html>Produto que será disponibilizado para venda<br>\nProdutos que contém ingredientes devem ter uma fórmula cadastrada");
        rbProdutoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProdutoFinalActionPerformed(evt);
            }
        });

        bgProduto.add(rbProdutoInacabado);
        rbProdutoInacabado.setText("INGREDIENTE");
        rbProdutoInacabado.setToolTipText("Produto que será utilizado para a produção de um produto final");
        rbProdutoInacabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProdutoInacabadoActionPerformed(evt);
            }
        });

        chProdutoComposto.setText("Este produto é composto");
        chProdutoComposto.setToolTipText("Marque se este produto possuir ingredientes");
        chProdutoComposto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chProdutoCompostoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTipoProdutoLayout = new javax.swing.GroupLayout(pnTipoProduto);
        pnTipoProduto.setLayout(pnTipoProdutoLayout);
        pnTipoProdutoLayout.setHorizontalGroup(
            pnTipoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTipoProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbProdutoFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbProdutoInacabado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chProdutoComposto)
                .addContainerGap())
        );
        pnTipoProdutoLayout.setVerticalGroup(
            pnTipoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTipoProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTipoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbProdutoFinal)
                    .addComponent(rbProdutoInacabado))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTipoProdutoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(chProdutoComposto))
        );

        pnInformacoesProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlCodigo.setText("Código:");

        jlNome.setText("Nome:");

        tfNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jlUnidade.setText("Unidade:");

        cbUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UN", "KG", "L" }));
        cbUnidade.setMinimumSize(new java.awt.Dimension(56, 20));
        cbUnidade.setPreferredSize(new java.awt.Dimension(56, 20));
        cbUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUnidadeActionPerformed(evt);
            }
        });

        jlDescricao.setText("Descrição:");

        tfDescricao.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jlQtde.setText("Qtde:");

        tfQtde.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jlPrecoCusto.setText("Preço de custo:");

        tfPrecoCusto.setToolTipText("Preço por unidade/kg/litro");
        tfPrecoCusto.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jlPrecoVenda.setText("Preço de venda:");

        tfPrecoVenda.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jlSituacao.setText("Situação:");

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "INATIVO" }));

        tfCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfCodigo.setText("000");

        jLabel5.setText("Tempo ap. p/ produção:");

        try {
            tfTempoProd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTempoProd.setText("00:00:00");
        tfTempoProd.setToolTipText("<html>Por unidade/kg/litro<br>\nEm horas, minutos e segundos<br>\nMantenha uma margem de erro de +15 segundos aproximadamente</html>");

        javax.swing.GroupLayout pnInformacoesProdutoLayout = new javax.swing.GroupLayout(pnInformacoesProduto);
        pnInformacoesProduto.setLayout(pnInformacoesProdutoLayout);
        pnInformacoesProdutoLayout.setHorizontalGroup(
            pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformacoesProdutoLayout.createSequentialGroup()
                .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInformacoesProdutoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCodigo)
                            .addComponent(jlNome)
                            .addComponent(jlDescricao)
                            .addComponent(jlUnidade)
                            .addComponent(jlPrecoCusto)
                            .addComponent(jlPrecoVenda)
                            .addComponent(jlSituacao)))
                    .addGroup(pnInformacoesProdutoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlQtde)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfCodigo)
                        .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfPrecoVenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(tfPrecoCusto, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInformacoesProdutoLayout.createSequentialGroup()
                            .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbSituacao, 0, 89, Short.MAX_VALUE)
                                .addComponent(cbUnidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(34, 34, 34)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTempoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnInformacoesProdutoLayout.setVerticalGroup(
            pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformacoesProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInformacoesProdutoLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDescricao)
                            .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnInformacoesProdutoLayout.createSequentialGroup()
                        .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCodigo)
                            .addComponent(tfCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlNome)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlUnidade)
                    .addComponent(cbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlQtde))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPrecoCusto)
                    .addComponent(tfPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPrecoVenda)
                    .addComponent(tfPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformacoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSituacao)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfTempoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btCadastrar.setText("Novo");
        btCadastrar.setPreferredSize(new java.awt.Dimension(100, 49));
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(100, 49));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.setPreferredSize(new java.awt.Dimension(100, 49));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.setPreferredSize(new java.awt.Dimension(100, 49));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btFormula.setText("Fórmula");
        btFormula.setToolTipText("Cadastrar ou checar ingredientes");
        btFormula.setPreferredSize(new java.awt.Dimension(81, 25));
        btFormula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFormulaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastroLayout = new javax.swing.GroupLayout(pnCadastro);
        pnCadastro.setLayout(pnCadastroLayout);
        pnCadastroLayout.setHorizontalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addComponent(btFormula, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnInformacoesProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTipoProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnCadastroLayout.setVerticalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnInformacoesProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tbPrincipal.addTab("cadastro", pnCadastro);

        getContentPane().add(tbPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            getRootPane().setDefaultButton(btBusca);
            tfBusca.requestFocus();
        }
    }//GEN-LAST:event_tfBuscaKeyPressed

    private void btBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaActionPerformed
        ProdutoDAO dao = new ProdutoDAO();
        ProdutoTO to = new ProdutoTO();
        try {
            to.setQuery(tfBuscaCod.getText(), " and id = '" + tfBuscaCod.getText() + "'");
            switch (cbBusca.getSelectedIndex()) {
                case 0:
                    to.setQuery(tfBusca.getText(), " and nome LIKE '%" + tfBusca.getText() + "%' ");
                    break;
                case 1:
                    to.setQuery(tfBusca.getText(), " and descricao LIKE '%" + tfBusca.getText() + "%' ");
                    break;
            }
            switch (cbBTipo.getSelectedIndex()) {
                case 1:
                    to.setQuery(cbBTipo.getSelectedItem().toString(), " and tipo = 'F'");
                    break;
                case 2:
                    to.setQuery(cbBTipo.getSelectedItem().toString(), " and tipo = 'I'");
                    break;
            }
            switch (cbBSituacao.getSelectedIndex()) {
                case 1:
                    to.setQuery(cbBSituacao.getSelectedItem().toString(), " and situacao = 'A'");
                    break;
                case 2:
                    to.setQuery(cbBSituacao.getSelectedItem().toString(), " and situacao = 'I'");
                    break;
            }
            if (to.getQuery().trim().length() < 5) {
                to.setQuery("where", " and 1 = 1");
            }

            this.atualizarBusca(dao.filtro(to.getQuery()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btBuscaActionPerformed

    private void tbBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBuscaMouseClicked
        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            int codigo = Integer.parseInt(target.getValueAt(row, 0).toString());

            try {
                ProdutoDAO dao = new ProdutoDAO();
                ProdutoTO to = (ProdutoTO) dao.buscarId(codigo);

                tfCodigo.setText(String.valueOf(to.getIdProdFormatado(to.getIdProduto())));
                tfNome.setText(to.getNome());
                tfDescricao.setText(to.getDescricao());
                switch (to.getTipo()) {
                    case "F":
                        rbProdutoFinal.setSelected(true);
                        tfTempoProd.setEnabled(true);
                        break;
                    case "I":
                        rbProdutoInacabado.setSelected(true);
                        tfTempoProd.setEnabled(false);
                        break;
                }
                switch (to.getComposto()) {
                    case "S":
                        this.checkboxAction(true);
                        chProdutoComposto.setSelected(true);
                        btFormula.setEnabled(true);
                        break;
                    case "N":
                        this.checkboxAction(false);
                        chProdutoComposto.setSelected(false);
                        btFormula.setEnabled(false);
                        break;
                }
                cbUnidade.setSelectedItem(to.getUnidade());
                if (!to.getUnidade().equals("UN")) {
                    tfQtde.setText(to.getQtdKGL(to.getQtd()));
                } else {
                    tfQtde.setText(String.valueOf(to.getQtdUnidade(to.getQtd())));
                }
                tfPrecoCusto.setText(String.valueOf(to.getPrecocusto()));
                if (to.getPrecovenda() == 0) {
                    tfPrecoVenda.setText("");
                } else {
                    tfPrecoVenda.setText(String.valueOf(to.getPrecovenda()));
                }
                switch (to.getSituacao()) {
                    case "A":
                        cbSituacao.setSelectedItem("ATIVO");
                        break;
                    case "I":
                        cbSituacao.setSelectedItem("INATIVO");
                        break;
                }
                tfTempoProd.setText(to.getDuracaoproducao());

                bloqueiaFormulario(false);

                if (dao.validarDeleteFormula(to.getIdProduto())) {
                    chProdutoComposto.setEnabled(false);
                }
                btExcluir.setEnabled(true);
                tbPrincipal.setSelectedComponent(pnCadastro);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao consultar!\n" + ex.getMessage(),
                        "Ops", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tbBuscaMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int q = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?", "Atenção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (q == JOptionPane.YES_OPTION) {
            try {
                ProdutoDAO dao = new ProdutoDAO();
                ProdutoTO to = new ProdutoTO();
                to.setIdProduto(tfCodigo.getText());
                Object obj = to;

                if (dao.validarDeleteFormula(to.getIdProduto())) {
                    JOptionPane.showMessageDialog(this, "Este produto tem uma fórmula cadastrada"
                            + " e não pode ser excluído!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (dao.validarDeleteFormulaIngrediente(to.getIdProduto())) {
                    JOptionPane.showMessageDialog(this, "Este produto é ingrediente de uma fórmula"
                            + " e não pode ser excluído!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (dao.validarDeleteProducao(to.getIdProduto())) {
                    JOptionPane.showMessageDialog(this, "Este produto está associado a uma rotina de produção"
                            + " e não pode ser excluído!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (dao.validarDeletePromocao(to.getIdProduto())) {
                    JOptionPane.showMessageDialog(this, "Este produto está associado a uma promoção"
                            + " e não pode ser excluído!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (dao.validarDeletePedido(to.getIdProduto())) {
                    JOptionPane.showMessageDialog(this, "Este produto está associado a um pedido"
                            + " e não pode ser excluído!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (dao.validarDeletePerca(to.getIdProduto())) {
                    JOptionPane.showMessageDialog(this, "Este produto tem uma perca registrada"
                            + " e não pode ser excluído!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    dao.excluir(obj);
                    atualizarBusca();
                    JOptionPane.showMessageDialog(this,
                            "Produto excluído com sucesso!", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Descrição do erro: " + e.getMessage(),
                        "Erro ao excluir produto!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            bloqueiaFormulario(true);
        } else {
            bloqueiaFormulario(false);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        bloqueiaFormulario(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (tfNome.getText().trim().length() < 1) {
            JOptionPane.showMessageDialog(this, "Informe o nome do produto!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfNome.requestFocus();
            return;
        } else if (tfNome.getText().trim().length() > 60) {
            JOptionPane.showMessageDialog(this, "O nome do produto não pode passar de 60 letras!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfNome.requestFocus();
            return;
        }
        try {
            if (ProdutoDAO.verificaExiste(tfNome.getText().trim(), Integer.parseInt(tfCodigo.getText()))) {
                JOptionPane.showMessageDialog(this, "Já existe um produto com este nome!", "Atenção", JOptionPane.WARNING_MESSAGE);
                tfNome.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
        if ((tfQtde.getText().trim().length() < 1) && (!chProdutoComposto.isSelected())) {
            JOptionPane.showMessageDialog(this, "Informe a quantidade!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfQtde.requestFocus();
            return;
        }
        if (tfPrecoCusto.getText().trim().length() < 1) {
            JOptionPane.showMessageDialog(this, "Informe o preço de custo!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfPrecoCusto.requestFocus();
            return;
        }
        if (rbProdutoFinal.isSelected()) {
            if (ReplaceMoedaRTA.moedaToDouble(tfPrecoVenda.getText()) == 0) {
                JOptionPane.showMessageDialog(this, "Informe o preço de venda!", "Atenção", JOptionPane.WARNING_MESSAGE);
                tfPrecoVenda.requestFocus();
                return;
            }
        }
        try {
            SimpleDateFormat paraTime = new SimpleDateFormat("HH:mm:ss");
            paraTime.parse(tfTempoProd.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Informe o tempo de produção!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfTempoProd.requestFocus();
            return;
        }

        try {
            ProdutoDAO dao = new ProdutoDAO();
            ProdutoTO to = new ProdutoTO();
            try {
                to.setIdProduto(tfCodigo.getText().trim());
                to.setNome(tfNome.getText().trim());
                to.setDescricao(tfDescricao.getText().trim());
                if (!tfQtde.getText().equals("")) {
                    to.setQtd(Double.parseDouble(tfQtde.getText().trim().replace(",", ".")));
                } else {
                    to.setQtd(0);
                }
                to.setPrecocusto(ReplaceMoedaRTA.moedaToDouble(tfPrecoCusto.getText()));
                if (!tfPrecoVenda.getText().equals("")) {
                    to.setPrecovenda(ReplaceMoedaRTA.moedaToDouble(tfPrecoVenda.getText()));
                }
                if (rbProdutoFinal.isSelected()) {
                    to.setTipo("F");
                } else if (rbProdutoInacabado.isSelected()) {
                    to.setTipo("I");
                }
                if (chProdutoComposto.isSelected()) {
                    to.setComposto("S");
                } else {
                    to.setComposto("N");
                }
                to.setUnidade(cbUnidade.getSelectedItem().toString());
                if (cbSituacao.getSelectedItem().toString().equals("ATIVO")) {
                    to.setSituacao("A");
                } else {
                    to.setSituacao("I");
                }
                to.setDuracaoproducao(tfTempoProd.getText());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Descrição do erro: " + e.getMessage(),
                        "Erro ao salvar produto!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Object obj = to;
            if (to.getIdProduto() == 000) {
                dao.inserir(obj);
                atualizarBusca();
                JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dao.alterar(obj);
                atualizarBusca();
                JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Descrição do erro: " + e.getMessage(),
                    "Erro ao salvar produto!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        bloqueiaFormulario(true);
        tbPrincipal.setSelectedComponent(pnConsulta);
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        bloqueiaFormulario(false);
        tfPrecoVenda.setEnabled(true);
        tfTempoProd.setEnabled(true);
        btExcluir.setEnabled(false);
        limparCampos();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btFormulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFormulaActionPerformed
        try {
            ProdutoDAO dao = new ProdutoDAO();
            ProdutoTO to = (ProdutoTO) dao.buscarId(Integer.parseInt(tfCodigo.getText()));
            FormulasGUI formulas = new FormulasGUI(to);
            PrincipalGUI.dpCorpo.remove(formulas);
            PrincipalGUI.dpCorpo.add(formulas);
            formulas.setVisible(true);
            formulas.setLocation(460, 90);
            formulas.toFront();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir fórmula!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btFormulaActionPerformed

    private void rbProdutoInacabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProdutoInacabadoActionPerformed
        if (controlaRB == 1) {
            tfPrecoVenda.setText("");
            tfPrecoVenda.setEnabled(false);
            tfTempoProd.setText("00:00:00");
            tfTempoProd.setEnabled(false);
        }
    }//GEN-LAST:event_rbProdutoInacabadoActionPerformed

    private void rbProdutoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProdutoFinalActionPerformed
        if (controlaRB == 1) {
            tfPrecoVenda.setEnabled(true);
            tfTempoProd.setEnabled(true);
        }
    }//GEN-LAST:event_rbProdutoFinalActionPerformed

    private void cbUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnidadeActionPerformed
        if (cbUnidade.getSelectedItem().equals("UN")) {
            tfQtde.setDocument(mascara.somenteNumero());
        } else if (cbUnidade.getSelectedItem().equals("KG")) {
            tfQtde.setDocument(mascara.permiteVirgula());
        } else {
            tfQtde.setDocument(mascara.permiteVirgula());
        }
    }//GEN-LAST:event_cbUnidadeActionPerformed

    private void checkboxAction(boolean controle) {
        if (controle == true) {
            tfQtde.setEnabled(false);
            tfPrecoCusto.setEnabled(false);
            tfQtde.setText("0");
            tfPrecoCusto.setText("0");
        } else {
            tfQtde.setEnabled(true);
            tfPrecoCusto.setEnabled(true);
            tfQtde.setText("");
            tfPrecoCusto.setText("");
        }
    }

    private void chProdutoCompostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chProdutoCompostoActionPerformed
        if (chProdutoComposto.isSelected()) {
            this.checkboxAction(true);
        } else {
            this.checkboxAction(false);
        }
    }//GEN-LAST:event_chProdutoCompostoActionPerformed

    private void tfBuscaCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaCodKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            getRootPane().setDefaultButton(btBusca);
            tfBuscaCod.requestFocus();
        }
    }//GEN-LAST:event_tfBuscaCodKeyPressed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgProduto;
    private javax.swing.JButton btBusca;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFormula;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbBSituacao;
    private javax.swing.JComboBox cbBTipo;
    private javax.swing.JComboBox cbBusca;
    private javax.swing.JComboBox cbSituacao;
    private javax.swing.JComboBox cbUnidade;
    private javax.swing.JCheckBox chProdutoComposto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlDescricao;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlPrecoCusto;
    private javax.swing.JLabel jlPrecoVenda;
    private javax.swing.JLabel jlQtde;
    private javax.swing.JLabel jlSituacao;
    private javax.swing.JLabel jlUnidade;
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JPanel pnConsulta;
    private javax.swing.JPanel pnInformacoesProduto;
    private javax.swing.JPanel pnTipoProduto;
    private javax.swing.JRadioButton rbProdutoFinal;
    private javax.swing.JRadioButton rbProdutoInacabado;
    private javax.swing.JScrollPane spBusca;
    private javax.swing.JTable tbBusca;
    private javax.swing.JTabbedPane tbPrincipal;
    private javax.swing.JTextField tfBusca;
    private javax.swing.JTextField tfBuscaCod;
    private javax.swing.JLabel tfCodigo;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPrecoCusto;
    private javax.swing.JTextField tfPrecoVenda;
    private javax.swing.JTextField tfQtde;
    private javax.swing.JFormattedTextField tfTempoProd;
    // End of variables declaration//GEN-END:variables
}
