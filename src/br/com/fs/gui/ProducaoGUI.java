package br.com.fs.gui;

import br.com.fs.dao.FormulaDAO;
import br.com.fs.dao.LogProducaoDAO;
import br.com.fs.dao.ProducaoDAO;
import br.com.fs.dao.ProdutoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.Mascaras;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.tm.FormulasTableModel;
import br.com.fs.tm.LogProducaoTableModel;
import br.com.fs.tm.ProducaoTableModel;
import br.com.fs.to.ProducaoTO;
import br.com.fs.to.ProdutoTO;
import java.awt.Cursor;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ProducaoGUI extends javax.swing.JInternalFrame {

    private static ProducaoGUI instancia = null;
    Mascaras mascara = new Mascaras();

    public ProducaoGUI() {
        initComponents();
        this.construtor();
    }

    public static ProducaoGUI getInstancia() {
        if (instancia == null) {
            instancia = new ProducaoGUI();
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
        tfCodProduto.setDocument(mascara.somenteNumero());
        tfCodProduto1.setDocument(mascara.somenteNumero());
        this.bloqueiaFormulario(true);
        btCancelar.requestFocus();
        lbCodigoProducao.setVisible(false);
        this.carregaItensFormula(0);
        this.carregaItensFormulaRotina(0);
        tfProducaoDe.setDocument(mascara.somenteNumero());
        tfProducaoAte.setDocument(mascara.somenteNumero());
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -30);
        dcFiltroDe.setDate(cal.getTime());
        dcFiltroAte.setDate(new Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbAbas = new javax.swing.JTabbedPane();
        pnCorpo = new javax.swing.JPanel();
        pnDetalhes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCodProduto = new javax.swing.JTextField();
        btBuscarProduto = new javax.swing.JButton();
        tfNomeProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbEstoque = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbUnidade = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbEstoqueAtualizado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbPrecoCusto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spItensFormula = new javax.swing.JScrollPane();
        tbItensFormula = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lbLimite = new javax.swing.JLabel();
        lbUnidade2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        pnRotina = new javax.swing.JPanel();
        pnDetalhes1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tfCodProduto1 = new javax.swing.JTextField();
        btBuscarProduto1 = new javax.swing.JButton();
        tfNomeProduto1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lbEstoque1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbUnidade1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfQuantidade1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lbPrecoCusto1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        spItensFormula1 = new javax.swing.JScrollPane();
        tbItensFormula1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        dcDataDe = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        dcDataAte = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        chSegunda = new javax.swing.JCheckBox();
        chTerca = new javax.swing.JCheckBox();
        chQuarta = new javax.swing.JCheckBox();
        chQuinta = new javax.swing.JCheckBox();
        chSexta = new javax.swing.JCheckBox();
        chSabado = new javax.swing.JCheckBox();
        chDomingo = new javax.swing.JCheckBox();
        lbCodigoProducao = new javax.swing.JLabel();
        btCancelar1 = new javax.swing.JButton();
        btConfirmar1 = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        btNova = new javax.swing.JButton();
        pnRotinasCadastradas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tfBusca = new javax.swing.JTextField();
        btBusca = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        spBusca = new javax.swing.JScrollPane();
        tbBusca = new javax.swing.JTable();
        pnLogs = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        tfProducaoDe = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tfProducaoAte = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tfBuscaProduto = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        dcFiltroDe = new com.toedter.calendar.JDateChooser();
        dcFiltroAte = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        spLogs = new javax.swing.JScrollPane();
        tbLogs = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Produção");
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnDetalhes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes da produção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Selecionar produto:");

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

        tfNomeProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfNomeProduto.setEnabled(false);

        jLabel3.setText("Estoque atual:");

        lbEstoque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEstoque.setText("0");

        jLabel5.setText("Unidade:");

        lbUnidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUnidade.setText("UN");

        jLabel2.setText("Quantidade total produzida deste produto:");

        tfQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfQuantidadeFocusLost(evt);
            }
        });

        jLabel4.setText("Estoque atualizado:");

        lbEstoqueAtualizado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEstoqueAtualizado.setText("0");

        jLabel6.setText("Preço de custo:");

        lbPrecoCusto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPrecoCusto.setText("R$ 0,00");

        jLabel7.setText("Itens da fórmula:");

        spItensFormula.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbItensFormula.setAutoCreateRowSorter(true);
        tbItensFormula.setModel(new FormulasTableModel());
        tbItensFormula.setShowHorizontalLines(false);
        tbItensFormula.setShowVerticalLines(false);
        spItensFormula.setViewportView(tbItensFormula);

        jLabel8.setText("Você tem estoque para produzir");

        lbLimite.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLimite.setText("0");

        lbUnidade2.setText("UN");

        jLabel11.setText("deste produto.");

        javax.swing.GroupLayout pnDetalhesLayout = new javax.swing.GroupLayout(pnDetalhes);
        pnDetalhes.setLayout(pnDetalhesLayout);
        pnDetalhesLayout.setHorizontalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetalhesLayout.createSequentialGroup()
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(spItensFormula, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDetalhesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetalhesLayout.createSequentialGroup()
                                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                                        .addComponent(tfCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNomeProduto))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetalhesLayout.createSequentialGroup()
                                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                                        .addComponent(lbPrecoCusto)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbUnidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE))
                                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                                        .addComponent(lbEstoque)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDetalhesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLimite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUnidade2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEstoqueAtualizado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDetalhesLayout.setVerticalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarProduto)
                    .addComponent(tfNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbUnidade)
                    .addComponent(jLabel6)
                    .addComponent(lbPrecoCusto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbEstoque))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spItensFormula, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbLimite)
                    .addComponent(lbUnidade2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbEstoqueAtualizado))
                .addGap(20, 20, 20))
        );

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)))
                .addContainerGap())
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btConfirmar))
                .addContainerGap())
        );

        tbAbas.addTab("produção manual", pnCorpo);

        pnDetalhes1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes da produção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel9.setText("Selecionar produto:");

        tfCodProduto1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodProduto1FocusLost(evt);
            }
        });

        btBuscarProduto1.setText("...");
        btBuscarProduto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProduto1ActionPerformed(evt);
            }
        });

        tfNomeProduto1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfNomeProduto1.setEnabled(false);

        jLabel10.setText("Estoque atual:");

        lbEstoque1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEstoque1.setText("0");

        jLabel12.setText("Unidade:");

        lbUnidade1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUnidade1.setText("UN");

        jLabel13.setText("Quantidade total produzida deste produto:");

        jLabel15.setText("Preço de custo:");

        lbPrecoCusto1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPrecoCusto1.setText("R$ 0,00");

        jLabel16.setText("Itens da fórmula:");

        spItensFormula1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbItensFormula1.setAutoCreateRowSorter(true);
        tbItensFormula1.setModel(new FormulasTableModel());
        tbItensFormula1.setShowHorizontalLines(false);
        tbItensFormula1.setShowVerticalLines(false);
        spItensFormula1.setViewportView(tbItensFormula1);

        jLabel14.setText("Período:");

        jLabel17.setText("até");

        jLabel18.setText("Dias:");

        chSegunda.setText("Segunda");

        chTerca.setText("Terça");

        chQuarta.setText("Quarta");

        chQuinta.setText("Quinta");

        chSexta.setText("Sexta");

        chSabado.setText("Sábado");

        chDomingo.setText("Domingo");

        lbCodigoProducao.setText("000");

        javax.swing.GroupLayout pnDetalhes1Layout = new javax.swing.GroupLayout(pnDetalhes1);
        pnDetalhes1.setLayout(pnDetalhes1Layout);
        pnDetalhes1Layout.setHorizontalGroup(
            pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhes1Layout.createSequentialGroup()
                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetalhes1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(spItensFormula1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(pnDetalhes1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                        .addComponent(tfCodProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btBuscarProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNomeProduto1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetalhes1Layout.createSequentialGroup()
                                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                        .addComponent(lbEstoque1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                        .addComponent(lbPrecoCusto1)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                                .addComponent(lbCodigoProducao)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                                .addComponent(lbUnidade1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE))))))))
                    .addGroup(pnDetalhes1Layout.createSequentialGroup()
                        .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel16))
                            .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chQuarta)
                                            .addComponent(chTerca)
                                            .addComponent(chSegunda))
                                        .addGap(36, 36, 36)
                                        .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chSabado)
                                            .addComponent(chSexta)
                                            .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                                .addComponent(chQuinta)
                                                .addGap(37, 37, 37)
                                                .addComponent(chDomingo))))
                                    .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dcDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDetalhes1Layout.createSequentialGroup()
                                            .addGap(149, 149, 149)
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(dcDataAte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(pnDetalhes1Layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tfQuantidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnDetalhes1Layout.setVerticalGroup(
            pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarProduto1)
                    .addComponent(tfNomeProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbUnidade1)
                    .addComponent(jLabel15)
                    .addComponent(lbPrecoCusto1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbEstoque1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbCodigoProducao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spItensFormula1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfQuantidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(dcDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(chSegunda)
                    .addComponent(chQuinta)
                    .addComponent(chDomingo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chTerca)
                    .addComponent(chSexta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalhes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chQuarta)
                    .addComponent(chSabado))
                .addContainerGap())
        );

        btCancelar1.setText("Cancelar");
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });

        btConfirmar1.setText("Confirmar");
        btConfirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmar1ActionPerformed(evt);
            }
        });

        btFinalizar.setText("Finalizar");
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });

        btNova.setText("Nova rotina");
        btNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnRotinaLayout = new javax.swing.GroupLayout(pnRotina);
        pnRotina.setLayout(pnRotinaLayout);
        pnRotinaLayout.setHorizontalGroup(
            pnRotinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRotinaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRotinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnDetalhes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnRotinaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btNova)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btConfirmar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar1)))
                .addContainerGap())
        );
        pnRotinaLayout.setVerticalGroup(
            pnRotinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRotinaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnDetalhes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnRotinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar1)
                    .addComponent(btConfirmar1)
                    .addComponent(btFinalizar)
                    .addComponent(btNova))
                .addContainerGap())
        );

        tbAbas.addTab("rotina de produção", pnRotina);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta por produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        btBusca.setText("Buscar");
        btBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBusca)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBusca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Listagem:");

        tbBusca.setModel(new ProducaoTableModel());
        tbBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBuscaMouseClicked(evt);
            }
        });
        spBusca.setViewportView(tbBusca);

        javax.swing.GroupLayout pnRotinasCadastradasLayout = new javax.swing.GroupLayout(pnRotinasCadastradas);
        pnRotinasCadastradas.setLayout(pnRotinasCadastradasLayout);
        pnRotinasCadastradasLayout.setHorizontalGroup(
            pnRotinasCadastradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRotinasCadastradasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRotinasCadastradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnRotinasCadastradasLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel19))
                    .addComponent(spBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        pnRotinasCadastradasLayout.setVerticalGroup(
            pnRotinasCadastradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRotinasCadastradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbAbas.addTab("rotinas cadastradas", pnRotinasCadastradas);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel20.setText("Cód:");

        tfProducaoDe.setToolTipText("Código inicial da produção");
        tfProducaoDe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfProducaoDeFocusLost(evt);
            }
        });

        jLabel21.setText("até:");

        tfProducaoAte.setToolTipText("Código final da produção");

        jLabel22.setText("Produto:");

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel23.setText("Data:");

        dcFiltroDe.setToolTipText("Data inicial do log de produção");

        dcFiltroAte.setToolTipText("Data final do log de produção");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfProducaoDe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfProducaoAte, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dcFiltroDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFiltroAte, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBuscaProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btBuscar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(tfProducaoDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(tfProducaoAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addComponent(dcFiltroDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcFiltroAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(tfBuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Logs");

        tbLogs.setModel(new LogProducaoTableModel());
        tbLogs.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLogsMouseClicked(evt);
            }
        });
        spLogs.setViewportView(tbLogs);

        javax.swing.GroupLayout pnLogsLayout = new javax.swing.GroupLayout(pnLogs);
        pnLogs.setLayout(pnLogsLayout);
        pnLogsLayout.setHorizontalGroup(
            pnLogsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLogsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLogsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLogsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel24)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLogsLayout.createSequentialGroup()
                        .addGroup(pnLogsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spLogs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnLogsLayout.setVerticalGroup(
            pnLogsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLogsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spLogs, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbAbas.addTab("logs", pnLogs);

        getContentPane().add(tbAbas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCodProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodProdutoFocusLost
        if (tfCodProduto.getText().length() != 0) {
            try {
                ProdutoDAO dao = new ProdutoDAO();
                ProdutoTO to = dao.ajusteEstoqueProdFocusLost(Integer.parseInt(tfCodProduto.getText()));
                if (to.getIdProduto() != 000) {
                    this.carregaInformações(to);
                } else {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    this.resetProd();
                    tfCodProduto.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar produto!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tfCodProdutoFocusLost

    protected void carregaInformações(ProdutoTO produto) {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            tfCodProduto.setText(produto.getIdProdFormatado(produto.getIdProduto()));
            tfNomeProduto.setText(produto.getNome());
            switch (String.valueOf(produto.getUnidade())) {
                case "UN":
                    lbUnidade.setText("UN");
                    lbUnidade2.setText("unidade(s)");
                    lbEstoque.setText(String.valueOf(produto.getQtdUnidade(produto.getQtd())));
                    tfQuantidade.setDocument(mascara.somenteNumero());
                    break;
                case "KG":
                    lbUnidade.setText("KG");
                    lbUnidade2.setText("kg(s)");
                    lbEstoque.setText(produto.getQtdKGL(produto.getQtd()));
                    tfQuantidade.setDocument(mascara.permiteVirgula());
                    break;
                case "L":
                    lbUnidade.setText("L");
                    lbUnidade2.setText("L(s)");
                    lbEstoque.setText(produto.getQtdKGL(produto.getQtd()));
                    tfQuantidade.setDocument(mascara.permiteVirgula());
                    break;
            }
            this.carregaItensFormula(produto.getIdProduto());
            lbLimite.setText(String.valueOf(dao.estoqueComposto(produto.getIdProduto())));
            lbPrecoCusto.setText(ReplaceMoedaRTA.doubleToMoeda(produto.getPrecocusto()));
            lbEstoqueAtualizado.setText(lbEstoque.getText());
            tfQuantidade.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar informações do produto!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void carregaInformaçõesRotina(ProdutoTO produto) {
        try {
            tfCodProduto1.setText(produto.getIdProdFormatado(produto.getIdProduto()));
            tfNomeProduto1.setText(produto.getNome());
            switch (String.valueOf(produto.getUnidade())) {
                case "UN":
                    lbUnidade1.setText("UN");
                    lbEstoque1.setText(String.valueOf(produto.getQtdUnidade(produto.getQtd())));
                    tfQuantidade1.setDocument(mascara.somenteNumero());
                    break;
                case "KG":
                    lbUnidade1.setText("KG");
                    lbEstoque1.setText(produto.getQtdKGL(produto.getQtd()));
                    tfQuantidade1.setDocument(mascara.permiteVirgula());
                    break;
                case "L":
                    lbUnidade1.setText("L");
                    lbEstoque1.setText(produto.getQtdKGL(produto.getQtd()));
                    tfQuantidade1.setDocument(mascara.permiteVirgula());
                    break;
            }
            this.carregaItensFormulaRotina(produto.getIdProduto());
            lbPrecoCusto1.setText(ReplaceMoedaRTA.doubleToMoeda(produto.getPrecocusto()));
            tfQuantidade1.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar informações do produto!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaLogs(String query) {
        try {
            LogProducaoTableModel p = (LogProducaoTableModel) tbLogs.getModel();
            tbLogs.getTableHeader().setReorderingAllowed(false);
            tbLogs.setColumnSelectionAllowed(false);
            tbLogs.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbLogs.getColumnModel().getColumn(0).setResizable(false);
            tbLogs.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbLogs.getColumnModel().getColumn(0).setMaxWidth(60);
            tbLogs.getColumnModel().getColumn(1).setResizable(false);
            tbLogs.getColumnModel().getColumn(1).setPreferredWidth(60);
            tbLogs.getColumnModel().getColumn(1).setMaxWidth(60);
            tbLogs.getColumnModel().getColumn(2).setResizable(false);
            tbLogs.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbLogs.getColumnModel().getColumn(2).setMaxWidth(80);
            tbLogs.getColumnModel().getColumn(3).setResizable(false);
            tbLogs.getColumnModel().getColumn(3).setPreferredWidth(200);
            tbLogs.getColumnModel().getColumn(3).setMaxWidth(200);
            tbLogs.getColumnModel().getColumn(4).setResizable(false);
            tbLogs.getColumnModel().getColumn(4).setPreferredWidth(60);
            tbLogs.getColumnModel().getColumn(4).setMaxWidth(60);
            tbLogs.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((DefaultTableCellRenderer) tbLogs.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbLogs.setDefaultRenderer(Object.class, new CellRenderer());
            LogProducaoDAO dao = new LogProducaoDAO();
            p.setDados(dao.buscarLogs(query));
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados dos logs!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaItensFormula(int idproduto) {
        try {
            FormulasTableModel p = (FormulasTableModel) tbItensFormula.getModel();
            tbItensFormula.getTableHeader().setReorderingAllowed(false);
            tbItensFormula.setColumnSelectionAllowed(false);
            tbItensFormula.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbItensFormula.getColumnModel().getColumn(0).setResizable(false);
            tbItensFormula.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbItensFormula.getColumnModel().getColumn(0).setMaxWidth(60);
            tbItensFormula.getColumnModel().getColumn(1).setResizable(false);
            tbItensFormula.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbItensFormula.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((DefaultTableCellRenderer) tbItensFormula.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbItensFormula.setDefaultRenderer(Object.class, new CellRenderer());
            FormulaDAO dao = new FormulaDAO();
            p.setDados(dao.buscarIngredientes(idproduto));
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados da fórmula!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaItensFormulaRotina(int idproduto) {
        try {
            FormulasTableModel p = (FormulasTableModel) tbItensFormula1.getModel();
            tbItensFormula1.getTableHeader().setReorderingAllowed(false);
            tbItensFormula1.setColumnSelectionAllowed(false);
            tbItensFormula1.getColumnModel().getSelectionModel().
                    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tbItensFormula1.getColumnModel().getColumn(0).setResizable(false);
            tbItensFormula1.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbItensFormula1.getColumnModel().getColumn(0).setMaxWidth(60);
            tbItensFormula1.getColumnModel().getColumn(1).setResizable(false);
            tbItensFormula1.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbItensFormula1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((DefaultTableCellRenderer) tbItensFormula1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbItensFormula1.setDefaultRenderer(Object.class, new CellRenderer());
            FormulaDAO dao = new FormulaDAO();
            p.setDados(dao.buscarIngredientes(idproduto));
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados da fórmula!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetProd() {
        tfCodProduto.setText("");
        tfNomeProduto.setText("");
        lbEstoque.setText("0");
        lbUnidade.setText("UN");
        lbUnidade2.setText("UN");
        lbPrecoCusto.setText("R$ 0,00");
        lbEstoqueAtualizado.setText("0");
        tfQuantidade.setText("");
        lbLimite.setText("0");
        this.carregaItensFormula(0);
    }

    private void resetProdRotina() {
        lbCodigoProducao.setText("0");
        tfCodProduto1.setText("");
        tfNomeProduto1.setText("");
        lbEstoque1.setText("0");
        lbUnidade1.setText("UN");
        lbPrecoCusto1.setText("R$ 0,00");
        tfQuantidade1.setText("");
        dcDataDe.setDate(new Date());
        dcDataAte.setDate(new Date());
        chSegunda.setSelected(false);
        chTerca.setSelected(false);
        chQuarta.setSelected(false);
        chQuinta.setSelected(false);
        chSexta.setSelected(false);
        chSabado.setSelected(false);
        chDomingo.setSelected(false);
        this.carregaItensFormulaRotina(0);
    }

    private void btBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProdutoActionPerformed
        ConsultaAjusteEstoqueGUI con = new ConsultaAjusteEstoqueGUI(this, 1);
        con.setVisible(true);
    }//GEN-LAST:event_btBuscarProdutoActionPerformed

    private void tfQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantidadeFocusLost
        if (tfQuantidade.getText().length() != 0) {
            double quantidade = Double.parseDouble(tfQuantidade.getText().replace(",", "."));
            if (lbUnidade.getText().equals("UN")) {
                double estoqueatual = Double.parseDouble(lbEstoque.getText());
                double estoqueatualizado = estoqueatual + quantidade;
                lbEstoqueAtualizado.setText(String.valueOf((int) estoqueatualizado));
            } else {
                double estoqueatual = Double.parseDouble(lbEstoque.getText().replace(",", "."));
                double estoqueatualizado = estoqueatual + quantidade;
                lbEstoqueAtualizado.setText(String.valueOf(estoqueatualizado).replace(".", ","));
            }
        }
    }//GEN-LAST:event_tfQuantidadeFocusLost

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        instancia = null;
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        if (tfCodProduto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecione um produto!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            btBuscarProduto.requestFocus();
            return;
        }
        if ((tfQuantidade.getText().equals("")) || (Integer.parseInt(tfQuantidade.getText()) == 0)) {
            JOptionPane.showMessageDialog(this, "Informe a quantidade!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            tfQuantidade.setText("");
            tfQuantidade.requestFocus();
            return;
        }
        String estoqueAtual = lbEstoque.getText();
        double limite = Double.parseDouble(lbLimite.getText());
        double quantidade = Double.parseDouble(tfQuantidade.getText().replace(",", "."));
        if (limite < quantidade) {
            JOptionPane.showMessageDialog(null, "Você não tem estoque para produzir esta quantidade!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfQuantidade.setText("");
            lbEstoqueAtualizado.setText(estoqueAtual);
            tfQuantidade.requestFocus();
            return;
        }

        try {
            ProdutoDAO dao = new ProdutoDAO();
            int idproduto = Integer.parseInt(tfCodProduto.getText());
            double qtd = Double.parseDouble(tfQuantidade.getText().replace(",", "."));
            dao.ajustarEstoqueItens(idproduto, qtd);
            dao.ajustarEstoqueProd(idproduto, qtd);
            JOptionPane.showMessageDialog(this, "Estoque ajustado com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao produzir!\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.resetProd();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void tfCodProduto1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodProduto1FocusLost
        if (tfCodProduto1.getText().length() != 0) {
            try {
                ProdutoDAO dao = new ProdutoDAO();
                ProdutoTO to = dao.ajusteEstoqueProdFocusLost(Integer.parseInt(tfCodProduto1.getText()));
                if (to.getIdProduto() != 000) {
                    this.carregaInformaçõesRotina(to);
                } else {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    this.resetProdRotina();
                    tfCodProduto1.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar produto!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tfCodProduto1FocusLost

    private void btBuscarProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProduto1ActionPerformed
        ConsultaAjusteEstoqueGUI con = new ConsultaAjusteEstoqueGUI(this, 5);
        con.setVisible(true);
    }//GEN-LAST:event_btBuscarProduto1ActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        bloqueiaFormulario(true);
    }//GEN-LAST:event_btCancelar1ActionPerformed

    private void btConfirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmar1ActionPerformed
        if (tfCodProduto1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecione um produto!", "Atenção", JOptionPane.WARNING_MESSAGE);
            btBuscarProduto1.requestFocus();
            return;
        }
        if ((tfQuantidade1.getText().equals("")) || (Integer.parseInt(tfQuantidade1.getText()) == 0)) {
            JOptionPane.showMessageDialog(this, "Informe a quantidade!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfQuantidade1.setText("");
            tfQuantidade1.requestFocus();
            return;
        }
        
        if (dcDataDe.getDate().compareTo(dcDataAte.getDate()) == 1) {
            JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
            dcDataDe.requestFocus();
            return;
        }

        try {
            int idproduto = Integer.parseInt(tfCodProduto1.getText());
            double qtd = Double.parseDouble(tfQuantidade1.getText().replace(",", "."));
            ProdutoDAO produtodao = new ProdutoDAO();
            ProducaoTO to = new ProducaoTO();
            ProdutoTO produtoto = (ProdutoTO) produtodao.buscarId(idproduto);
            ProducaoDAO dao = new ProducaoDAO();

            to.setIdproducao(Integer.parseInt(lbCodigoProducao.getText()));
            to.setDatainicio(dcDataDe.getDate());
            to.setDatatermino(dcDataAte.getDate());
            to.setQtd(qtd);
            to.setProduto(produtoto);
            to.setSituacao("A");
            to.setSegunda(chSegunda.isSelected());
            to.setTerca(chTerca.isSelected());
            to.setQuarta(chQuarta.isSelected());
            to.setQuinta(chQuinta.isSelected());
            to.setSexta(chSexta.isSelected());
            to.setSabado(chSabado.isSelected());
            to.setDomingo(chDomingo.isSelected());

            if (dao.verifica(idproduto, Integer.parseInt(lbCodigoProducao.getText())) == true) {
                JOptionPane.showMessageDialog(this, "Este produto já tem uma rotina cadastrada!", "Atenção", JOptionPane.WARNING_MESSAGE);
                tfCodProduto1.requestFocus();
                return;
            }

            if (!chSegunda.isSelected() && !chTerca.isSelected() && !chQuarta.isSelected()
                    && !chQuinta.isSelected() && !chSexta.isSelected() && !chSabado.isSelected()
                    && !chDomingo.isSelected()) {
                JOptionPane.showMessageDialog(this, "Selecione pelo menos um dia!", "Atenção", JOptionPane.WARNING_MESSAGE);
                chSegunda.requestFocus();
                return;
            }

            if (to.getIdproducao() == 0) {
                dao.inserir(to);
            } else {
                dao.alterar(to);
            }

            JOptionPane.showMessageDialog(this, "Rotina gravada com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao gravar rotina!\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.bloqueiaFormulario(true);
        this.carregaTabela("");
    }//GEN-LAST:event_btConfirmar1ActionPerformed

    private void btBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaActionPerformed
        this.carregaTabela(tfBusca.getText().trim());
    }//GEN-LAST:event_btBuscaActionPerformed

    private void tbBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBuscaMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tbBusca.getSelectedRow();
            int codigo = Integer.parseInt(tbBusca.getValueAt(row, 0).toString());

            try {
                ProducaoDAO dao = new ProducaoDAO();
                ProducaoTO to = dao.buscarId(codigo);
                this.carregaInfoProducao(to);
                if (to.getSituacao().equals("ATIVA")) {
                    bloqueiaFormulario(false);
                } else {
                    listaBloqueado();
                }
            } catch (Exception e) {
                JOptionPane.showInternalMessageDialog(this, "Erro ao consultar!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tbBuscaMouseClicked

    private void listaBloqueado() {
        tfCodProduto1.setEnabled(false);
        btBuscarProduto1.setEnabled(false);
        tfQuantidade1.setEnabled(false);
        btCancelar1.setEnabled(true);
        btConfirmar1.setEnabled(false);
        btFinalizar.setEnabled(false);
        btNova.setEnabled(true);
        chDomingo.setEnabled(false);
        chSabado.setEnabled(false);
        chSegunda.setEnabled(false);
        chTerca.setEnabled(false);
        chQuarta.setEnabled(false);
        chQuinta.setEnabled(false);
        chSexta.setEnabled(false);
        dcDataAte.setEnabled(false);
        dcDataDe.setEnabled(false);
    }

    private void btNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaActionPerformed
        this.resetProdRotina();
        this.bloqueiaFormulario(false);
    }//GEN-LAST:event_btNovaActionPerformed

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        try {
            int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja finalizar esta rotina?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                ProducaoDAO dao = new ProducaoDAO();
                dao.finalizar(Integer.parseInt(lbCodigoProducao.getText()));
                JOptionPane.showMessageDialog(null, "Rotina finalizada com sucesso!");
                bloqueiaFormulario(true);
                this.carregaTabela("");
            } else {
                repaint();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao finalizar rotina!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if (dcFiltroDe.getDate().compareTo(dcFiltroAte.getDate()) == 1) {
            JOptionPane.showMessageDialog(this, "Data de início maior que data de término!", "Atenção", JOptionPane.WARNING_MESSAGE);
            dcFiltroDe.requestFocus();
            return;
        }

        String query = "";
        if ((tfProducaoDe.getText().trim().length() <= 0) && (tfProducaoAte.getText().trim().length() <= 0)) {
            query += "";
        }
        if ((tfProducaoDe.getText().trim().length() > 0) && (tfProducaoAte.getText().trim().length() <= 0)) {
            query += " AND l.idproducao >= " + tfProducaoDe.getText().trim() + " ";
        }
        if ((tfProducaoDe.getText().trim().length() <= 0) && (tfProducaoAte.getText().trim().length() > 0)) {
            query += " AND l.idproducao <= " + tfProducaoAte.getText().trim() + " ";
        }
        if ((tfProducaoDe.getText().trim().length() > 0) && (tfProducaoAte.getText().trim().length() > 0)) {
            query += " AND l.idproducao BETWEEN " + tfProducaoDe.getText().trim() + " AND " + tfProducaoAte.getText().trim() + " ";
        }

        String datade = new SimpleDateFormat("yyyy-MM-dd").format(dcFiltroDe.getDate());
        String dataate = new SimpleDateFormat("yyyy-MM-dd").format(dcFiltroAte.getDate());

        query += " AND date(l.diaproducao) BETWEEN '" + datade + "' AND '" + dataate + "' ";
        query += " AND p.nome LIKE '%" + tfBuscaProduto.getText().trim() + "%' ";

        this.carregaLogs(query);
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tfProducaoDeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfProducaoDeFocusLost
        tfProducaoAte.setText(tfProducaoDe.getText().trim());
    }//GEN-LAST:event_tfProducaoDeFocusLost

    private void tbLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLogsMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tbLogs.getSelectedRow();
            int codigo = Integer.parseInt(tbLogs.getValueAt(row, 1).toString());

            try {
                ProducaoDAO dao = new ProducaoDAO();
                ProducaoTO to = dao.buscarId(codigo);
                this.carregaInfoProducao(to);
                if (to.getSituacao().equals("ATIVA")) {
                    bloqueiaFormulario(false);
                } else {
                    listaBloqueado();
                }
            } catch (Exception e) {
                JOptionPane.showInternalMessageDialog(this, "Erro ao consultar!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tbLogsMouseClicked

    private void carregaInfoProducao(ProducaoTO to) {
        this.carregaInformaçõesRotina(to.getProduto());
        tbAbas.setSelectedIndex(1);
        lbCodigoProducao.setText(String.valueOf(to.getIdproducao()));
        dcDataDe.setDate(to.getDatainicio());
        dcDataAte.setDate(to.getDatatermino());
        chSabado.setSelected(to.isSabado());
        chSegunda.setSelected(to.isSegunda());
        chTerca.setSelected(to.isTerca());
        chQuarta.setSelected(to.isQuarta());
        chQuinta.setSelected(to.isQuinta());
        chSexta.setSelected(to.isSexta());
        chDomingo.setSelected(to.isDomingo());
        if (to.getProduto().getUnidade().equals("UN")) {
            tfQuantidade1.setDocument(mascara.somenteNumero());
            tfQuantidade1.setText(String.valueOf(to.getQtdUnidade(to.getQtd())));
        } else {
            tfQuantidade1.setDocument(mascara.permiteVirgula());
            tfQuantidade1.setText(to.getQtdKGL(to.getQtd()));
        }
    }

    private void carregaTabela(String query) {
        try {
            ProducaoTableModel p = (ProducaoTableModel) tbBusca.getModel();
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
            ProducaoDAO dao = new ProducaoDAO();
            p.setDados(dao.buscarProducoes(query));
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void bloqueiaFormulario(boolean i) {
        if (i) {
            this.resetProdRotina();
            tfCodProduto1.setEnabled(false);
            btBuscarProduto1.setEnabled(false);
            tfQuantidade1.setEnabled(false);
            dcDataDe.setEnabled(false);
            dcDataAte.setEnabled(false);
            chSegunda.setEnabled(false);
            chTerca.setEnabled(false);
            chQuarta.setEnabled(false);
            chQuinta.setEnabled(false);
            chSexta.setEnabled(false);
            chSabado.setEnabled(false);
            chDomingo.setEnabled(false);
            btCancelar1.setEnabled(false);
            btConfirmar1.setEnabled(false);
            btFinalizar.setEnabled(false);
            btNova.setEnabled(true);
            btNova.requestFocus();
        } else {
            tfCodProduto1.setEnabled(true);
            btBuscarProduto1.setEnabled(true);
            dcDataDe.setEnabled(true);
            dcDataAte.setEnabled(true);
            chSegunda.setEnabled(true);
            chTerca.setEnabled(true);
            chQuarta.setEnabled(true);
            chQuinta.setEnabled(true);
            chSexta.setEnabled(true);
            chSabado.setEnabled(true);
            chDomingo.setEnabled(true);
            tfQuantidade1.setEnabled(true);
            btConfirmar1.setEnabled(true);
            btCancelar1.setEnabled(true);
            if (Integer.parseInt(lbCodigoProducao.getText()) == 0) {
                btFinalizar.setEnabled(false);
            } else {
                btFinalizar.setEnabled(true);
            }
            btNova.setEnabled(false);
            tfCodProduto1.requestFocus();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBusca;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btBuscarProduto;
    private javax.swing.JButton btBuscarProduto1;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btConfirmar1;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btNova;
    private javax.swing.JCheckBox chDomingo;
    private javax.swing.JCheckBox chQuarta;
    private javax.swing.JCheckBox chQuinta;
    private javax.swing.JCheckBox chSabado;
    private javax.swing.JCheckBox chSegunda;
    private javax.swing.JCheckBox chSexta;
    private javax.swing.JCheckBox chTerca;
    private com.toedter.calendar.JDateChooser dcDataAte;
    private com.toedter.calendar.JDateChooser dcDataDe;
    private com.toedter.calendar.JDateChooser dcFiltroAte;
    private com.toedter.calendar.JDateChooser dcFiltroDe;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbCodigoProducao;
    private javax.swing.JLabel lbEstoque;
    private javax.swing.JLabel lbEstoque1;
    private javax.swing.JLabel lbEstoqueAtualizado;
    private javax.swing.JLabel lbLimite;
    private javax.swing.JLabel lbPrecoCusto;
    private javax.swing.JLabel lbPrecoCusto1;
    private javax.swing.JLabel lbUnidade;
    private javax.swing.JLabel lbUnidade1;
    private javax.swing.JLabel lbUnidade2;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnDetalhes;
    private javax.swing.JPanel pnDetalhes1;
    private javax.swing.JPanel pnLogs;
    private javax.swing.JPanel pnRotina;
    private javax.swing.JPanel pnRotinasCadastradas;
    private javax.swing.JScrollPane spBusca;
    private javax.swing.JScrollPane spItensFormula;
    private javax.swing.JScrollPane spItensFormula1;
    private javax.swing.JScrollPane spLogs;
    private javax.swing.JTabbedPane tbAbas;
    private javax.swing.JTable tbBusca;
    private javax.swing.JTable tbItensFormula;
    private javax.swing.JTable tbItensFormula1;
    private javax.swing.JTable tbLogs;
    private javax.swing.JTextField tfBusca;
    private javax.swing.JTextField tfBuscaProduto;
    private javax.swing.JTextField tfCodProduto;
    private javax.swing.JTextField tfCodProduto1;
    private javax.swing.JTextField tfNomeProduto;
    private javax.swing.JTextField tfNomeProduto1;
    private javax.swing.JTextField tfProducaoAte;
    private javax.swing.JTextField tfProducaoDe;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfQuantidade1;
    // End of variables declaration//GEN-END:variables
}
