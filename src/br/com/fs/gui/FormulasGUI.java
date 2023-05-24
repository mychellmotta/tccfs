package br.com.fs.gui;

import br.com.fs.dao.FormulaDAO;
import br.com.fs.dao.ProdutoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.Mascaras;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.tm.FormulasTableModel;
import br.com.fs.tm.ProdutosComFormulaTableModel;
import br.com.fs.to.FormulaTO;
import br.com.fs.to.ProdutoTO;
import java.awt.Cursor;
import java.beans.PropertyVetoException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class FormulasGUI extends javax.swing.JInternalFrame {

    private static FormulasGUI instancia = null;
    private ProdutoTO produtoto;
    Mascaras mascara = new Mascaras();

    public FormulasGUI(ProdutoTO produtofinal) {
        initComponents();
        this.produtoto = produtofinal;
        this.construtor();
    }

    public FormulasGUI() {
        initComponents();
        this.construtor();
    }

    public static FormulasGUI getInstancia() {
        if (instancia == null) {
            instancia = new FormulasGUI();
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
        tfCodIngrediente.setDocument(mascara.somenteNumero());
        lbUnidadeIngrediente.setText("");
        try {
            if (produtoto == null) {
                lbProd.setText("SELECIONE UM PRODUTO");
            } else {
                lbCodProdFinal.setText(produtoto.getIdProdFormatado(produtoto.getIdProduto()));
                lbProd.setText(produtoto.getNome());
                switch (String.valueOf(produtoto.getUnidade())) {
                    case "UN":
                        lbUnidadeProdFinal.setText("UNITÁRIO");
                        break;
                    case "KG":
                        lbUnidadeProdFinal.setText("KG");
                        break;
                    case "L":
                        lbUnidadeProdFinal.setText("LITRO");
                        break;
                }
                lbCusto.setText(ReplaceMoedaRTA.doubleToMoeda(produtoto.getPrecocusto()));
                lbVenda.setText(ReplaceMoedaRTA.doubleToMoeda(produtoto.getPrecovenda()));
                this.carregaTabela();
            }
            bloqueiaFormulario(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao construir!\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaTabela() {
        try {
            FormulasTableModel p = (FormulasTableModel) tbIngredientes.getModel();
            tbIngredientes.getTableHeader().setReorderingAllowed(false);
            tbIngredientes.setColumnSelectionAllowed(false);
            tbIngredientes.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbIngredientes.getColumnModel().getColumn(0).setResizable(false);
            tbIngredientes.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbIngredientes.getColumnModel().getColumn(0).setMaxWidth(60);
            tbIngredientes.getColumnModel().getColumn(1).setResizable(false);
            tbIngredientes.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbIngredientes.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((DefaultTableCellRenderer) tbIngredientes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbIngredientes.setDefaultRenderer(Object.class, new CellRenderer());
            FormulaDAO dao = new FormulaDAO();
            p.setDados(dao.buscarIngredientes(produtoto.getIdProduto()));
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void carregaTabelaConsulta(String query) {
        try {
            ProdutosComFormulaTableModel p = (ProdutosComFormulaTableModel) tbBusca.getModel();
            tbBusca.getTableHeader().setReorderingAllowed(false);
            tbBusca.setColumnSelectionAllowed(false);
            tbBusca.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbBusca.getColumnModel().getColumn(0).setResizable(false);
            tbBusca.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbBusca.getColumnModel().getColumn(0).setMaxWidth(60);
            tbBusca.getColumnModel().getColumn(1).setResizable(false);
            tbBusca.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((DefaultTableCellRenderer) tbBusca.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbBusca.setDefaultRenderer(Object.class, new CellRenderer());
            FormulaDAO dao = new FormulaDAO();
            p.setDados(dao.buscarProdutosComFormula(query));
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpPrincipal = new javax.swing.JTabbedPane();
        pnCadastro = new javax.swing.JPanel();
        pnInformacoes = new javax.swing.JPanel();
        btBuscarProd = new javax.swing.JButton();
        lbCodigoTitulo = new javax.swing.JLabel();
        lbCodProdFinal = new javax.swing.JLabel();
        lbNomeTitulo = new javax.swing.JLabel();
        lbProd = new javax.swing.JLabel();
        lbUnidadeTitulo = new javax.swing.JLabel();
        lbUnidadeProdFinal = new javax.swing.JLabel();
        lbCustoTitulo = new javax.swing.JLabel();
        lbVendaTitulo = new javax.swing.JLabel();
        lbCusto = new javax.swing.JLabel();
        lbVenda = new javax.swing.JLabel();
        pnAdicionarIngrediente = new javax.swing.JPanel();
        btAdd = new javax.swing.JButton();
        tfIngrediente = new javax.swing.JTextField();
        jlQtde = new javax.swing.JLabel();
        tfQtde = new javax.swing.JTextField();
        lbCodFormula = new javax.swing.JLabel();
        lbIngrediente = new javax.swing.JLabel();
        tfCodIngrediente = new javax.swing.JTextField();
        lbCodigoIngrediente = new javax.swing.JLabel();
        lbUnidadeIngrediente = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jlTituloTabela = new javax.swing.JLabel();
        spIngredientes = new javax.swing.JScrollPane();
        tbIngredientes = new javax.swing.JTable();
        pnConsulta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfBusca = new javax.swing.JTextField();
        btBuscaFiltro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        spBusca = new javax.swing.JScrollPane();
        tbBusca = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Fórmulas");
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

        pnInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        btBuscarProd.setText("Buscar");
        btBuscarProd.setToolTipText("Buscar produto final");
        btBuscarProd.setPreferredSize(new java.awt.Dimension(45, 25));
        btBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProdActionPerformed(evt);
            }
        });

        lbCodigoTitulo.setText("Código:");

        lbCodProdFinal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCodProdFinal.setText("000");

        lbNomeTitulo.setText("Nome:");

        lbProd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbProd.setText("SELECIONE UM PRODUTO");
        lbProd.setMaximumSize(new java.awt.Dimension(212, 14));
        lbProd.setPreferredSize(new java.awt.Dimension(212, 14));

        lbUnidadeTitulo.setText("Unidade:");

        lbUnidadeProdFinal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbUnidadeProdFinal.setText("UNIDADE");

        lbCustoTitulo.setText("Custo:");

        lbVendaTitulo.setText("Venda:");

        lbCusto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCusto.setText("R$ 0,00");

        lbVenda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVenda.setText("R$ 0,00");

        javax.swing.GroupLayout pnInformacoesLayout = new javax.swing.GroupLayout(pnInformacoes);
        pnInformacoes.setLayout(pnInformacoesLayout);
        pnInformacoesLayout.setHorizontalGroup(
            pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInformacoesLayout.createSequentialGroup()
                        .addComponent(lbCustoTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btBuscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnInformacoesLayout.createSequentialGroup()
                        .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnInformacoesLayout.createSequentialGroup()
                                .addComponent(lbUnidadeTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCusto)
                                    .addComponent(lbUnidadeProdFinal)))
                            .addGroup(pnInformacoesLayout.createSequentialGroup()
                                .addComponent(lbCodigoTitulo)
                                .addGap(16, 16, 16)
                                .addComponent(lbCodProdFinal)
                                .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnInformacoesLayout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(lbVendaTitulo))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInformacoesLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbNomeTitulo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbVenda)
                                    .addComponent(lbProd, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnInformacoesLayout.setVerticalGroup(
            pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformacoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigoTitulo)
                    .addComponent(lbCodProdFinal)
                    .addComponent(lbNomeTitulo)
                    .addComponent(lbProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUnidadeTitulo)
                    .addComponent(lbUnidadeProdFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCustoTitulo)
                    .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCusto)
                        .addComponent(lbVendaTitulo)
                        .addComponent(lbVenda))))
        );

        pnAdicionarIngrediente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrediente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        btAdd.setText("...");
        btAdd.setMaximumSize(new java.awt.Dimension(73, 23));
        btAdd.setMinimumSize(new java.awt.Dimension(73, 23));
        btAdd.setPreferredSize(new java.awt.Dimension(73, 23));
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        tfIngrediente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfIngrediente.setEnabled(false);

        jlQtde.setText("Quantidade:");

        tfQtde.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfQtde.setPreferredSize(new java.awt.Dimension(59, 20));

        lbCodFormula.setText("Código:");

        lbIngrediente.setText("Ingrediente:");

        tfCodIngrediente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfCodIngrediente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodIngredienteFocusLost(evt);
            }
        });

        lbCodigoIngrediente.setText("000");

        lbUnidadeIngrediente.setText("UNIDADE");

        javax.swing.GroupLayout pnAdicionarIngredienteLayout = new javax.swing.GroupLayout(pnAdicionarIngrediente);
        pnAdicionarIngrediente.setLayout(pnAdicionarIngredienteLayout);
        pnAdicionarIngredienteLayout.setHorizontalGroup(
            pnAdicionarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAdicionarIngredienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAdicionarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlQtde)
                    .addComponent(lbCodFormula)
                    .addComponent(lbIngrediente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAdicionarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAdicionarIngredienteLayout.createSequentialGroup()
                        .addGroup(pnAdicionarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCodigoIngrediente)
                            .addComponent(tfCodIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(pnAdicionarIngredienteLayout.createSequentialGroup()
                        .addComponent(tfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbUnidadeIngrediente)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnAdicionarIngredienteLayout.setVerticalGroup(
            pnAdicionarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAdicionarIngredienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAdicionarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodFormula)
                    .addComponent(lbCodigoIngrediente))
                .addGap(8, 8, 8)
                .addGroup(pnAdicionarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIngrediente)
                    .addComponent(tfCodIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(pnAdicionarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlQtde)
                    .addComponent(lbUnidadeIngrediente)))
        );

        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(63, 32));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btAdicionar.setText("Adicionar");
        btAdicionar.setMaximumSize(new java.awt.Dimension(83, 32));
        btAdicionar.setMinimumSize(new java.awt.Dimension(83, 32));
        btAdicionar.setPreferredSize(new java.awt.Dimension(83, 32));
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.setMaximumSize(new java.awt.Dimension(83, 32));
        btCancelar.setMinimumSize(new java.awt.Dimension(83, 32));
        btCancelar.setPreferredSize(new java.awt.Dimension(83, 32));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btExcluir.setText("Remover");
        btExcluir.setMaximumSize(new java.awt.Dimension(83, 32));
        btExcluir.setMinimumSize(new java.awt.Dimension(83, 32));
        btExcluir.setPreferredSize(new java.awt.Dimension(83, 32));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jlTituloTabela.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlTituloTabela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTituloTabela.setText("Ingredientes deste produto:");

        tbIngredientes.setModel(new FormulasTableModel());
        tbIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbIngredientesMouseClicked(evt);
            }
        });
        spIngredientes.setViewportView(tbIngredientes);

        javax.swing.GroupLayout pnCadastroLayout = new javax.swing.GroupLayout(pnCadastro);
        pnCadastro.setLayout(pnCadastroLayout);
        pnCadastroLayout.setHorizontalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(pnInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnAdicionarIngrediente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCadastroLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jlTituloTabela))
                            .addGroup(pnCadastroLayout.createSequentialGroup()
                                .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnCadastroLayout.setVerticalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnAdicionarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlTituloTabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spIngredientes, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpPrincipal.addTab("cadastro", pnCadastro);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Produto:");

        btBuscaFiltro.setText("Buscar");
        btBuscaFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscaFiltro)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscaFiltro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Listagem");

        tbBusca.setModel(new ProdutosComFormulaTableModel());
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
                .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnConsultaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnConsultaLayout.createSequentialGroup()
                        .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spBusca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnConsultaLayout.setVerticalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpPrincipal.addTab("produtos com fórmula", pnConsulta);

        getContentPane().add(tpPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        ConsultaIngredientesGUI gui = new ConsultaIngredientesGUI(this);
        gui.setVisible(true);
    }//GEN-LAST:event_btAddActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (produtoto != null) {
            if (tfIngrediente.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Adicione um ingrediente!", "Alerta", JOptionPane.WARNING_MESSAGE);
                btAdd.requestFocus();
                return;
            }
            if (Integer.parseInt(tfCodIngrediente.getText()) == produtoto.getIdProduto()) {
                JOptionPane.showMessageDialog(this, "Um produto não pode estar em sua própria fórmula!", "Alerta", JOptionPane.WARNING_MESSAGE);
                tfCodIngrediente.requestFocus();
                return;
            }
            if (tfQtde.getText().trim().length() < 1) {
                JOptionPane.showMessageDialog(this, "Informe a quantidade!", "Alerta", JOptionPane.WARNING_MESSAGE);
                tfQtde.requestFocus();
                return;
            }
            try {
                FormulaDAO dao = new FormulaDAO();
                FormulaTO to = new FormulaTO();
                try {
                    ProdutoTO produtofinal = new ProdutoTO();
                    ProdutoTO ingrediente = new ProdutoTO();
                    produtofinal.setIdProduto(produtoto.getIdProduto());
                    ingrediente.setIdProduto(tfCodIngrediente.getText().trim());

                    to.setIdFormula(lbCodigoIngrediente.getText().trim());
                    to.setProdutofinal(produtofinal);
                    to.setIngrediente(ingrediente);
                    to.setQtd(Double.parseDouble(tfQtde.getText().trim().replace(",", ".")));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro ao adicionar ingrediente!" + e.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Object obj = to;

                if (dao.verificaExiste(to.getProdutofinal().getIdProduto(), to.getIngrediente().getIdProduto(), to.getIdFormula())) {
                    JOptionPane.showMessageDialog(this, "Este ingrediente já está na fórmula!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (to.getIdFormula() == 000) {
                    try {
                        dao.inserir(obj);
                        JOptionPane.showMessageDialog(this, "Ingrediente adicionado com sucesso!",
                                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    try {
                        dao.alterar(obj);
                        JOptionPane.showMessageDialog(this, "Ingrediente alterado com sucesso!",
                                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }

                this.carregaTabela();
                this.carregaProduto(produtoto.getIdProduto());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            bloqueiaFormulario(true);
        } else {
            JOptionPane.showMessageDialog(this, "Informe o produto final!");
            btBuscarProd.requestFocus();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        bloqueiaFormulario(false);
        btExcluir.setEnabled(false);
        limparCampos();
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        bloqueiaFormulario(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int q = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover?", "Atenção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (q == JOptionPane.YES_OPTION) {
            try {
                FormulaDAO formulaDAO = new FormulaDAO();
                FormulaTO formulaTO = new FormulaTO();
                formulaTO.setIdFormula(lbCodigoIngrediente.getText());
                Object obj = formulaTO;

                formulaDAO.removerIngrediente(obj);

                this.carregaTabela();

                JOptionPane.showMessageDialog(this,
                        "Ingrediente removido com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao remover ingrediente!\n" + e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
            bloqueiaFormulario(true);
            this.carregaProduto(produtoto.getIdProduto());
        } else {
            bloqueiaFormulario(false);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void tbIngredientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbIngredientesMouseClicked
        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            int codigo = Integer.parseInt(target.getValueAt(row, 0).toString());

            try {
                FormulaDAO dao = new FormulaDAO();
                FormulaTO to = (FormulaTO) dao.buscarId(codigo);

                lbCodigoIngrediente.setText(String.valueOf(to.getIdFormFormatado(to.getIdFormula())));
                tfCodIngrediente.setText(String.valueOf(to.getIngrediente().getIdProdFormatado(to.getIngrediente().getIdProduto())));
                tfIngrediente.setText(to.getIngrediente().getNome());
                if (to.getIngrediente().getUnidade().equalsIgnoreCase("UN")) {
                    tfQtde.setDocument(mascara.somenteNumero());
                    tfQtde.setText(String.valueOf(to.getQtdUnidade(to.getQtd())));
                    lbUnidadeIngrediente.setText("unidade(s)");
                } else {
                    tfQtde.setDocument(mascara.permiteVirgula());
                    tfQtde.setText(String.valueOf(to.getQtdKGL(to.getQtd())));
                    if(to.getIngrediente().getUnidade().equals("KG")){
                        lbUnidadeIngrediente.setText("KG(s)");
                    } else{
                        lbUnidadeIngrediente.setText("L(s)");
                    }
                }

                bloqueiaFormulario(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao consultar!: " + ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tbIngredientesMouseClicked

    private void btBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProdActionPerformed
        ConsultaProdutosGUI gui = new ConsultaProdutosGUI(this);
        gui.setVisible(true);
    }//GEN-LAST:event_btBuscarProdActionPerformed

    private void tfCodIngredienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodIngredienteFocusLost
        if (tfCodIngrediente.getText().length() < 1) {
            tfCodIngrediente.setText("");
            tfIngrediente.setText("");
            return;
        }
        try {
            ProdutoDAO dao = new ProdutoDAO();
            ProdutoTO to = (ProdutoTO) dao.buscarId(Integer.parseInt(tfCodIngrediente.getText()));
            if ((to.getIdProduto() != 0) && (to.getTipo().equals("I"))) {
                this.carregaIngrediente(to.getIdProduto());
            } else {
                JOptionPane.showMessageDialog(this, "Ingrediente não encontrado!", "Atenção", JOptionPane.WARNING_MESSAGE);
                tfCodIngrediente.setText("");
                tfIngrediente.setText("");
                tfCodIngrediente.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar!\nDescrição: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tfCodIngredienteFocusLost

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void btBuscaFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaFiltroActionPerformed
        this.carregaTabelaConsulta(" AND p.nome LIKE '%"+tfBusca.getText().trim()+"%' ");
    }//GEN-LAST:event_btBuscaFiltroActionPerformed

    private void tbBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBuscaMouseClicked
        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            int codigo = Integer.parseInt(target.getValueAt(row, 0).toString());

            this.carregaProduto(codigo);
            tpPrincipal.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tbBuscaMouseClicked

    private void bloqueiaFormulario(boolean controle) {
        if (controle) {
            limparCampos();
            tfCodIngrediente.setEnabled(false);
            tfQtde.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btAdicionar.setEnabled(true);
            btCancelar.setEnabled(false);
            btAdd.setEnabled(false);
            btAdicionar.requestFocus();
        } else {
            tfCodIngrediente.setEnabled(true);
            tfQtde.setEnabled(true);
            if (lbCodigoIngrediente.getText().equalsIgnoreCase("000")) {
                btExcluir.setEnabled(false);
            } else {
                btExcluir.setEnabled(true);
            }
            btCancelar.setEnabled(true);
            btAdd.setEnabled(true);
            btSalvar.setEnabled(true);
            btAdicionar.setEnabled(false);
            btAdd.requestFocus();
        }
    }

    private void limparCampos() {
        lbCodigoIngrediente.setText("000");
        tfCodIngrediente.setText("");
        tfIngrediente.setText("");
        tfQtde.setText("");
        lbUnidadeIngrediente.setText("");
    }

    public void carregaIngrediente(int idproduto) {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            ProdutoTO to = (ProdutoTO) dao.buscarId(idproduto);
            tfCodIngrediente.setText(to.getIdProdFormatado(to.getIdProduto()));
            tfIngrediente.setText(to.getNome());
            if (to.getUnidade().equals("UN")) {
                tfQtde.setDocument(mascara.somenteNumero());
                lbUnidadeIngrediente.setText("unidade(s)");
            } else {
                tfQtde.setDocument(mascara.permiteVirgula());
                if (to.getUnidade().equals("KG")) {
                    lbUnidadeIngrediente.setText("KG(s)");
                } else {
                    lbUnidadeIngrediente.setText("L(s)");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Descrição do erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void carregaProduto(int idproduto) {
        try {
            ProdutoDAO produtodao = new ProdutoDAO();
            ProdutoTO to = (ProdutoTO) produtodao.buscarId(idproduto);
            produtoto = to;
            lbCodProdFinal.setText(to.getIdProdFormatado(to.getIdProduto()));
            lbProd.setText(to.getNome());
            switch (String.valueOf(to.getUnidade())) {
                case "UN":
                    lbUnidadeProdFinal.setText("UNITÁRIO");
                    break;
                case "KG":
                    lbUnidadeProdFinal.setText("KG");
                    break;
                case "L":
                    lbUnidadeProdFinal.setText("LITRO");
                    break;
            }
            lbCusto.setText(ReplaceMoedaRTA.doubleToMoeda(to.getPrecocusto()));
            lbVenda.setText(ReplaceMoedaRTA.doubleToMoeda(to.getPrecovenda()));
            this.carregaTabela();
            bloqueiaFormulario(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Descrição do erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btBuscaFiltro;
    private javax.swing.JButton btBuscarProd;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlQtde;
    private javax.swing.JLabel jlTituloTabela;
    private javax.swing.JLabel lbCodFormula;
    private javax.swing.JLabel lbCodProdFinal;
    private javax.swing.JLabel lbCodigoIngrediente;
    private javax.swing.JLabel lbCodigoTitulo;
    private javax.swing.JLabel lbCusto;
    private javax.swing.JLabel lbCustoTitulo;
    private javax.swing.JLabel lbIngrediente;
    private javax.swing.JLabel lbNomeTitulo;
    private javax.swing.JLabel lbProd;
    private javax.swing.JLabel lbUnidadeIngrediente;
    private javax.swing.JLabel lbUnidadeProdFinal;
    private javax.swing.JLabel lbUnidadeTitulo;
    private javax.swing.JLabel lbVenda;
    private javax.swing.JLabel lbVendaTitulo;
    private javax.swing.JPanel pnAdicionarIngrediente;
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JPanel pnConsulta;
    private javax.swing.JPanel pnInformacoes;
    private javax.swing.JScrollPane spBusca;
    private javax.swing.JScrollPane spIngredientes;
    private javax.swing.JTable tbBusca;
    private javax.swing.JTable tbIngredientes;
    private javax.swing.JTextField tfBusca;
    private javax.swing.JTextField tfCodIngrediente;
    private javax.swing.JTextField tfIngrediente;
    private javax.swing.JTextField tfQtde;
    private javax.swing.JTabbedPane tpPrincipal;
    // End of variables declaration//GEN-END:variables
}
