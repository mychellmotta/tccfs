package br.com.fs.gui;

import br.com.fs.dao.CidadeDAO;
import br.com.fs.dao.FuncionarioDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.Mascaras;
import br.com.fs.rta.ValidaCPF;
import br.com.fs.to.CidadeTO;
import br.com.fs.to.FuncionarioTO;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FuncionariosGUI extends javax.swing.JInternalFrame {

    private static FuncionariosGUI instancia = null;
    private ArrayList funcionariosBusca = new ArrayList();

    public FuncionariosGUI() {
        initComponents();
        this.construtor();
    }

    public static FuncionariosGUI getInstancia() {
        if (instancia == null) {
            instancia = new FuncionariosGUI();
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
        Mascaras mascara = new Mascaras();
        tfBuscaCod.setDocument(mascara.somenteNumero());
        tfCodCidade.setDocument(mascara.somenteNumero());
        try {
            FuncionarioDAO t = new FuncionarioDAO();
            funcionariosBusca = t.buscarTodos();
            atualizarBusca(funcionariosBusca);
            bloqueiaFormulario(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Descrição: " + e.getMessage(),
                    "Erro ao carregar operadores!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        tfCodigo.setText("000");
        tfNome.setText("");
        tfRG.setText("");
        tfCpf.setText("");
        tfDatanasc.setCalendar(null);
        tfTelefone.setText("");
        tfCelular.setText("");
        tfEmail.setText("");
        tfLogradouro.setText("");
        tfNumero.setText("");
        tfBairro.setText("");
        tfCodCidade.setText("");
        tfCidade.setText("");
        tfUf.setText("");
        cbSexo.setSelectedItem("MASCULINO");
        tfCep.setText("");
        tfLogin.setText("");
        tfSenha.setText("");
        cbCadSituacao.setSelectedItem("ATIVO");
        tfDataadmissao.setCalendar(null);
        tfDatademissao.setCalendar(null);
        tfObservacao.setText("");
    }

    private void bloqueiaFormulario(boolean controle) {
        if (controle) {
            limparCampos();
            tfNome.setEnabled(false);
            tfRG.setEnabled(false);
            tfCpf.setEnabled(false);
            tfDatanasc.setEnabled(false);
            tfTelefone.setEnabled(false);
            tfCelular.setEnabled(false);
            tfEmail.setEnabled(false);
            cbSexo.setEnabled(false);
            tfLogradouro.setEnabled(false);
            tfNumero.setEnabled(false);
            tfCodCidade.setEnabled(false);
            tfBairro.setEnabled(false);
            btBuscarCidade.setEnabled(false);
            tfCep.setEnabled(false);
            tfLogin.setEnabled(false);
            tfSenha.setEnabled(false);
            tfDataadmissao.setEnabled(false);
            tfDatademissao.setEnabled(false);
            cbCadSituacao.setEnabled(false);
            tfObservacao.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btCadastrar.setEnabled(true);
            btCadastrar.requestFocus();
        } else {
            tfNome.setEnabled(true);
            tfRG.setEnabled(true);
            tfCpf.setEnabled(true);
            tfDatanasc.setEnabled(true);
            tfTelefone.setEnabled(true);
            tfCelular.setEnabled(true);
            tfEmail.setEnabled(true);
            cbSexo.setEnabled(true);
            tfLogradouro.setEnabled(true);
            tfNumero.setEnabled(true);
            tfCodCidade.setEnabled(true);
            tfBairro.setEnabled(true);
            btBuscarCidade.setEnabled(true);
            tfCep.setEnabled(true);
            tfLogin.setEnabled(true);
            tfSenha.setEnabled(true);
            tfDataadmissao.setEnabled(true);
            tfDatademissao.setEnabled(true);
            cbCadSituacao.setEnabled(true);
            tfObservacao.setEnabled(true);
            if (tfCodigo.getText().equalsIgnoreCase("000")) {
                btExcluir.setEnabled(false);
            } else {
                btExcluir.setEnabled(true);
            }
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btCadastrar.setEnabled(false);
            tfNome.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpPrincipal = new javax.swing.JTabbedPane();
        pnConsulta = new javax.swing.JPanel();
        pnParametros = new javax.swing.JPanel();
        cbBusca = new javax.swing.JComboBox();
        tfBusca = new javax.swing.JTextField();
        cbSituacao = new javax.swing.JComboBox();
        btBusca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfBuscaCod = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbBuscaSexo = new javax.swing.JComboBox();
        spBusca = new javax.swing.JScrollPane();
        tbBusca = new javax.swing.JTable();
        lbTituloTabela = new javax.swing.JLabel();
        pnCadastro = new javax.swing.JPanel();
        pnInformacoes = new javax.swing.JPanel();
        jlCodigo = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jlRG = new javax.swing.JLabel();
        tfRG = new javax.swing.JTextField();
        jlCPF = new javax.swing.JLabel();
        jlDatanasc = new javax.swing.JLabel();
        tfDatanasc = new com.toedter.calendar.JDateChooser();
        jlTelefone = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfCelular = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jlSexo = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox();
        tfCpf = new javax.swing.JFormattedTextField();
        tfCodigo = new javax.swing.JLabel();
        pnEndereco = new javax.swing.JPanel();
        jlLogradouro = new javax.swing.JLabel();
        tfLogradouro = new javax.swing.JTextField();
        jlNumero = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jlCidade = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        jlUf = new javax.swing.JLabel();
        jlCep = new javax.swing.JLabel();
        btBuscarCidade = new javax.swing.JButton();
        tfCodCidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        tfUf = new javax.swing.JTextField();
        tfCep = new javax.swing.JFormattedTextField();
        pnExtras = new javax.swing.JPanel();
        jlLogin = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        jlSenha = new javax.swing.JLabel();
        tfSenha = new javax.swing.JPasswordField();
        jlDataadmissao = new javax.swing.JLabel();
        tfDataadmissao = new com.toedter.calendar.JDateChooser();
        jlDatademissao = new javax.swing.JLabel();
        tfDatademissao = new com.toedter.calendar.JDateChooser();
        jlSituacao = new javax.swing.JLabel();
        cbCadSituacao = new javax.swing.JComboBox();
        jlObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfObservacao = new javax.swing.JTextPane();
        btCadastrar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Operadores");
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

        pnParametros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parâmetros de consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        cbBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NOME", "LOGRADOURO" }));

        tfBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBuscaKeyPressed(evt);
            }
        });

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "ATIVOS", "INATIVOS" }));
        cbSituacao.setMinimumSize(new java.awt.Dimension(56, 25));
        cbSituacao.setPreferredSize(new java.awt.Dimension(56, 20));

        btBusca.setText("Buscar");
        btBusca.setMinimumSize(new java.awt.Dimension(49, 23));
        btBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar por:");

        jLabel3.setText("Situação:");

        jLabel5.setText("Código:");

        tfBuscaCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBuscaCodKeyPressed(evt);
            }
        });

        jLabel6.setText("Sexo:");

        cbBuscaSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "MASCULINO", "FEMININO" }));

        javax.swing.GroupLayout pnParametrosLayout = new javax.swing.GroupLayout(pnParametros);
        pnParametros.setLayout(pnParametrosLayout);
        pnParametrosLayout.setHorizontalGroup(
            pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnParametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnParametrosLayout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBuscaCod, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBuscaSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnParametrosLayout.setVerticalGroup(
            pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnParametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnParametrosLayout.createSequentialGroup()
                        .addGroup(pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(cbBuscaSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnParametrosLayout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addGroup(pnParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBuscaCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap())
        );

        tbBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBuscaMouseClicked(evt);
            }
        });
        spBusca.setViewportView(tbBusca);

        lbTituloTabela.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTituloTabela.setText("Operadores cadastrados:");

        javax.swing.GroupLayout pnConsultaLayout = new javax.swing.GroupLayout(pnConsulta);
        pnConsulta.setLayout(pnConsultaLayout);
        pnConsultaLayout.setHorizontalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnConsultaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbTituloTabela)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnConsultaLayout.createSequentialGroup()
                        .addComponent(pnParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnConsultaLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(spBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnConsultaLayout.setVerticalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnParametros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTituloTabela)
                .addContainerGap(336, Short.MAX_VALUE))
            .addGroup(pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnConsultaLayout.createSequentialGroup()
                    .addContainerGap(145, Short.MAX_VALUE)
                    .addComponent(spBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        tpPrincipal.addTab("consulta", pnConsulta);

        pnInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlCodigo.setText("Cód.:");

        jlNome.setText("Nome:");

        tfNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jlRG.setText("RG:");

        tfRG.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfRG.setPreferredSize(new java.awt.Dimension(59, 20));

        jlCPF.setText("CPF:");

        jlDatanasc.setText("Data de nascimento:");

        tfDatanasc.setNextFocusableComponent(tfLogradouro);

        jlTelefone.setText("Telefone:");

        tfTelefone.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfTelefone.setPreferredSize(new java.awt.Dimension(59, 20));

        jLabel1.setText("Celular:");

        tfCelular.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfCelular.setPreferredSize(new java.awt.Dimension(59, 20));

        jlEmail.setText("E-mail:");

        tfEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfEmail.setPreferredSize(new java.awt.Dimension(59, 20));

        jlSexo.setText("Sexo:");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMININO" }));
        cbSexo.setMinimumSize(new java.awt.Dimension(56, 20));
        cbSexo.setPreferredSize(new java.awt.Dimension(56, 20));

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tfCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfCodigo.setText("000");

        javax.swing.GroupLayout pnInformacoesLayout = new javax.swing.GroupLayout(pnInformacoes);
        pnInformacoes.setLayout(pnInformacoesLayout);
        pnInformacoesLayout.setHorizontalGroup(
            pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInformacoesLayout.createSequentialGroup()
                        .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnInformacoesLayout.createSequentialGroup()
                                .addComponent(jlEmail)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(122, 122, 122))
                    .addGroup(pnInformacoesLayout.createSequentialGroup()
                        .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCodigo)
                            .addComponent(tfCodigo))
                        .addGap(22, 22, 22)
                        .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNome)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
                        .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlRG)
                            .addComponent(tfRG, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCPF)
                            .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlSexo)
                            .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDatanasc, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jlDatanasc))
                        .addContainerGap(14, Short.MAX_VALUE))))
        );
        pnInformacoesLayout.setVerticalGroup(
            pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformacoesLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInformacoesLayout.createSequentialGroup()
                        .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCodigo)
                            .addComponent(jlNome)
                            .addComponent(jlRG)
                            .addComponent(jlCPF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCodigo)))
                    .addGroup(pnInformacoesLayout.createSequentialGroup()
                        .addComponent(jlSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTelefone)
                    .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnInformacoesLayout.createSequentialGroup()
                            .addComponent(jlDatanasc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfDatanasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnInformacoesLayout.createSequentialGroup()
                            .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jlEmail))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlLogradouro.setText("Logradouro:");

        tfLogradouro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfLogradouro.setPreferredSize(new java.awt.Dimension(59, 20));

        jlNumero.setText("Nº:");

        tfNumero.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfNumero.setPreferredSize(new java.awt.Dimension(59, 20));

        jlCidade.setText("Cidade:");

        tfCidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfCidade.setEnabled(false);
        tfCidade.setPreferredSize(new java.awt.Dimension(59, 20));

        jlUf.setText("UF:");

        jlCep.setText("CEP:");

        btBuscarCidade.setText("...");
        btBuscarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarCidadeActionPerformed(evt);
            }
        });

        tfCodCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodCidadeFocusLost(evt);
            }
        });

        jLabel4.setText("Bairro:");

        tfUf.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfUf.setEnabled(false);

        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout pnEnderecoLayout = new javax.swing.GroupLayout(pnEndereco);
        pnEndereco.setLayout(pnEnderecoLayout);
        pnEnderecoLayout.setHorizontalGroup(
            pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnEnderecoLayout.createSequentialGroup()
                                .addComponent(jlLogradouro)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNumero)))
                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                        .addComponent(tfCodCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlCidade))
                .addGap(7, 7, 7)
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoLayout.createSequentialGroup()
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoLayout.createSequentialGroup()
                                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlUf)
                                    .addComponent(tfUf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                                        .addComponent(jlCep)
                                        .addGap(91, 91, 91))
                                    .addComponent(tfCep)))
                            .addComponent(tfBairro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        pnEnderecoLayout.setVerticalGroup(
            pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLogradouro)
                    .addComponent(jlNumero)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCidade)
                            .addComponent(jlCep)
                            .addComponent(jlUf))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCodCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBuscarCidade)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pnExtras.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Extras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlLogin.setText("Login:");

        tfLogin.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfLogin.setPreferredSize(new java.awt.Dimension(59, 20));

        jlSenha.setText("Senha:");

        tfSenha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfSenha.setPreferredSize(new java.awt.Dimension(111, 20));

        jlDataadmissao.setText("Data de admissão:");

        jlDatademissao.setText("Data de demissão:");

        jlSituacao.setText("Situação:");

        cbCadSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "INATIVO" }));
        cbCadSituacao.setMinimumSize(new java.awt.Dimension(56, 20));
        cbCadSituacao.setPreferredSize(new java.awt.Dimension(56, 20));

        jlObservacao.setText("Observação:");

        tfObservacao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tfObservacao);

        javax.swing.GroupLayout pnExtrasLayout = new javax.swing.GroupLayout(pnExtras);
        pnExtras.setLayout(pnExtrasLayout);
        pnExtrasLayout.setHorizontalGroup(
            pnExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnExtrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnExtrasLayout.createSequentialGroup()
                        .addGroup(pnExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlLogin))
                        .addGap(10, 10, 10)
                        .addGroup(pnExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDataadmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDataadmissao))
                        .addGap(12, 12, 12)
                        .addGroup(pnExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDatademissao, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDatademissao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnExtrasLayout.createSequentialGroup()
                                .addComponent(jlSituacao)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbCadSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnExtrasLayout.createSequentialGroup()
                        .addComponent(jlObservacao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        pnExtrasLayout.setVerticalGroup(
            pnExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnExtrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLogin)
                    .addComponent(jlSenha)
                    .addComponent(jlDataadmissao)
                    .addComponent(jlDatademissao)
                    .addComponent(jlSituacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfDataadmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDatademissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCadSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlObservacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        btCadastrar.setText("Novo");
        btCadastrar.setPreferredSize(new java.awt.Dimension(100, 23));
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(100, 23));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.setPreferredSize(new java.awt.Dimension(100, 23));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.setPreferredSize(new java.awt.Dimension(100, 23));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastroLayout = new javax.swing.GroupLayout(pnCadastro);
        pnCadastro.setLayout(pnCadastroLayout);
        pnCadastroLayout.setHorizontalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnExtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnCadastroLayout.setVerticalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnExtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tpPrincipal.addTab("cadastro", pnCadastro);

        getContentPane().add(tpPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (tfNome.getText().trim().length() <= 1) {
            JOptionPane.showMessageDialog(this, "Informe o nome do operador!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfNome.requestFocus();
            return;
        } else if (tfNome.getText().trim().length() > 60) {
            JOptionPane.showMessageDialog(this, "O nome do operador não pode passar de 60 letras!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfNome.requestFocus();
            return;
        }
        if (tfRG.getText().trim().length() > 9) {
            JOptionPane.showMessageDialog(this, "O RG do operador não pode conter mais que 9 caracteres!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfRG.requestFocus();
            return;
        }
        if (tfCpf.getText().trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Informe o CPF do operador!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfCpf.requestFocus();
            return;
        } else {
            if (tfCpf.getText().equals("111.111.111-11")
                    || tfCpf.getText().equals("222.222.222-22")
                    || tfCpf.getText().equals("333.333.333-33")
                    || tfCpf.getText().equals("444.444.444-44")
                    || tfCpf.getText().equals("555.555.555-55")
                    || tfCpf.getText().equals("666.666.666-66")
                    || tfCpf.getText().equals("777.777.777-77")
                    || tfCpf.getText().equals("888.888.888-88")
                    || tfCpf.getText().equals("999.999.999-99")
                    || tfCpf.getText().equals("000.000.000-00")) {
                JOptionPane.showMessageDialog(null, "Digite um CPF válido!", "Atenção", JOptionPane.WARNING_MESSAGE);
                tfCpf.requestFocus();
                return;
            } else {
                ValidaCPF cpf = new ValidaCPF();
                boolean validado = cpf.validacpf(tfCpf.getText().replace(".", "").replace("-", ""));
                if (!validado) {
                    JOptionPane.showMessageDialog(null, "Digite um CPF válido!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    tfCpf.requestFocus();
                    return;
                }
            }
        }
        try {
            if (FuncionarioDAO.verificaExiste("cpf", tfCpf.getText().trim(), Integer.parseInt(tfCodigo.getText()))) {
                JOptionPane.showMessageDialog(this, "Este CPF já existe!", "Atenção", JOptionPane.WARNING_MESSAGE);
                tfCpf.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
        if ((tfTelefone.getText().trim().length() < 1) && (tfCelular.getText().trim().length() < 1)) {
            JOptionPane.showMessageDialog(this, "Informe pelo menos um número para contato!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfCelular.requestFocus();
            return;
        } else if ((tfTelefone.getText().trim().length() > 11) || (tfCelular.getText().trim().length() > 11)) {
            JOptionPane.showMessageDialog(this, "O número para contato não pode conter mais de 12 dígitos!", "Atenção", JOptionPane.WARNING_MESSAGE);
            if (tfCelular.getText().equals("")) {
                tfTelefone.requestFocus();
                return;
            } else if (tfTelefone.getText().equals("")) {
                tfCelular.requestFocus();
                return;
            }
        }
        if (tfEmail.getText().trim().length() > 50) {
            JOptionPane.showMessageDialog(this, "O e-mail não pode conter mais que 50 caracteres!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfEmail.requestFocus();
            return;
        }
        if (tfDatanasc.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Informe a data de nascimento do operador!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfDatanasc.requestFocus();
            return;
        } else if (tfDatanasc.getDate().compareTo(new Date()) == 1) {
            JOptionPane.showMessageDialog(this, "Data de nascimento incorreta!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfDatanasc.requestFocus();
            return;
        }
        if (tfLogradouro.getText().trim().length() > 60) {
            JOptionPane.showMessageDialog(this, "O logradouro não pode conter mais que 60 caracteres!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfLogradouro.requestFocus();
            return;
        }
        if (tfNumero.getText().trim().length() > 5) {
            JOptionPane.showMessageDialog(this, "O número não pode conter mais que 5 caracteres!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfNumero.requestFocus();
            return;
        }
        if (tfBairro.getText().trim().length() > 60) {
            JOptionPane.showMessageDialog(this, "O bairro não pode conter mais que 60 caracteres!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfBairro.requestFocus();
            return;
        }
        if (tfCidade.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecione a cidade!", "Atenção", JOptionPane.WARNING_MESSAGE);
            btBuscarCidade.requestFocus();
            return;
        }
        if (tfCep.getText().trim().length() < 9) {
            JOptionPane.showMessageDialog(this, "O CEP deve conter 9 dígitos!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfCep.requestFocus();
            return;
        }
        if (tfLogin.getText().trim().length() < 1) {
            JOptionPane.showMessageDialog(this, "Por favor, digite o login para este operador!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfLogin.requestFocus();
            return;
        } else if (tfLogin.getText().trim().length() > 10) {
            JOptionPane.showMessageDialog(this, "O login do operador não pode conter mais que 10 caracteres!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfLogin.requestFocus();
            return;
        }
        try {
            if (FuncionarioDAO.verificaExiste("login", tfLogin.getText().trim(), Integer.parseInt(tfCodigo.getText()))) {
                JOptionPane.showMessageDialog(this, "Este login já está sendo usado!", "Atenção", JOptionPane.WARNING_MESSAGE);
                tfCpf.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
        if (tfSenha.getText().trim().length() > 10) {
            JOptionPane.showMessageDialog(this, "A senha do operador não pode conter mais que 10 caracteres!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfSenha.requestFocus();
            return;
        }
        if (tfDataadmissao.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Informe a data de admissão do operador!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfDataadmissao.requestFocus();
            return;
        } else if (tfDataadmissao.getDate().compareTo(new Date()) == 1) {
            JOptionPane.showMessageDialog(this, "Data de admissão incorreta!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfDataadmissao.requestFocus();
            return;
        }
        if (tfObservacao.getText().trim().length() > 200) {
            JOptionPane.showMessageDialog(this, "O campo 'observação' não pode conter mais que 200 caracteres!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfObservacao.requestFocus();
            return;
        }
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            FuncionarioTO to = new FuncionarioTO();
            try {
                to.setIdFuncionario(tfCodigo.getText().trim());
                to.setNome(tfNome.getText().trim());
                to.setRg(tfRG.getText().trim());
                to.setCpf(tfCpf.getText().trim());
                to.setTelefone(tfTelefone.getText().trim());
                to.setCelular(tfCelular.getText().trim());
                to.setEmail(tfEmail.getText().trim());
                if (cbSexo.getSelectedItem().toString().equals("MASCULINO")) {
                    to.setSexo("M");
                } else {
                    to.setSexo("F");
                }
                to.setDatanasc(tfDatanasc.getDate());
                to.setLogradouro(tfLogradouro.getText().trim());
                to.setNumero(tfNumero.getText().trim());
                to.setBairro(tfBairro.getText().trim());
                CidadeTO cidade = new CidadeTO();
                cidade.setIdCidade(tfCodCidade.getText().trim());
                to.setCidade(cidade);
                to.setCep(tfCep.getText().trim());
                to.setLogin(tfLogin.getText().trim());
                to.setSenha(tfSenha.getText().trim());
                to.setDataadmissao(tfDataadmissao.getDate());
                to.setDatademissao(tfDatademissao.getDate());
                to.setObservacao(tfObservacao.getText().trim());
                if (cbCadSituacao.getSelectedItem().toString().equals("ATIVO")) {
                    to.setSituacao("A");
                } else {
                    to.setSituacao("I");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Descrição do erro: " + e.getMessage(),
                        "Erro ao salvar operador!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Object obj = to;
            if (to.getIdFuncionario() == 000) {
                tfDatademissao.setEnabled(false);
                dao.inserir(obj);
            } else {
                dao.alterar(obj);
            }

            funcionariosBusca = dao.buscarTodos();
            atualizarBusca(funcionariosBusca);
            JOptionPane.showMessageDialog(this, "Operador salvo com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Descrição: " + e.getMessage(),
                    "Erro ao salvar operador!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        bloqueiaFormulario(true);
        tpPrincipal.setSelectedComponent(pnConsulta);
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (Integer.parseInt(tfCodigo.getText().trim()) == 1) {
            JOptionPane.showMessageDialog(this, "Operador administrador não pode ser excluído!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int q = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?", "Atenção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (q == JOptionPane.YES_OPTION) {
            try {
                FuncionarioDAO dao = new FuncionarioDAO();
                FuncionarioTO to = new FuncionarioTO();
                to.setIdFuncionario(tfCodigo.getText());
                Object obj = to;

                if (dao.validarDeletePedido(to.getIdFuncionario())) {
                    JOptionPane.showMessageDialog(this, "Este operador está associado a um pedido "
                            + "e não pode ser excluído!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (dao.validarDeletePerca(to.getIdFuncionario())) {
                    JOptionPane.showMessageDialog(this, "Este operador está associado a uma perca de produto "
                            + "e não pode ser excluído!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    dao.excluir(obj);
                    funcionariosBusca = dao.buscarTodos();
                    atualizarBusca(funcionariosBusca);
                    JOptionPane.showMessageDialog(this,
                            "Operador excluído com sucesso!", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Descrição do erro: " + e.getMessage(),
                        "Erro ao excluir operador!", JOptionPane.ERROR_MESSAGE);
            }
            bloqueiaFormulario(true);
            tpPrincipal.setSelectedIndex(0);
        } else {
            bloqueiaFormulario(true);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        bloqueiaFormulario(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        bloqueiaFormulario(false);
        btExcluir.setEnabled(false);
        limparCampos();
        tfDataadmissao.setDate(new Date());
        tfDatademissao.setEnabled(false);
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void tfBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            getRootPane().setDefaultButton(btBusca);
            tfBusca.requestFocus();
        }
    }//GEN-LAST:event_tfBuscaKeyPressed

    private void btBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaActionPerformed
        FuncionarioDAO dao = new FuncionarioDAO();
        FuncionarioTO to = new FuncionarioTO();

        try {
            to.setQuery(tfBuscaCod.getText(), " and id = '" + tfBuscaCod.getText() + "'");
            switch (cbBusca.getSelectedIndex()) {
                case 0:
                    to.setQuery(tfBusca.getText(), " and nome LIKE '%" + tfBusca.getText() + "%' ");
                    break;
                case 1:
                    to.setQuery(tfBusca.getText(), " and logradouro LIKE '%" + tfBusca.getText() + "%' ");
                    break;
            }
            switch (cbBuscaSexo.getSelectedIndex()) {
                case 1:
                    to.setQuery(cbBuscaSexo.getSelectedItem().toString(), " and sexo = 'M'");
                    break;
                case 2:
                    to.setQuery(cbBuscaSexo.getSelectedItem().toString(), " and sexo = 'F'");
                    break;
            }
            switch (cbSituacao.getSelectedIndex()) {
                case 1:
                    to.setQuery(cbSituacao.getSelectedItem().toString(), " and situacao = 'A'");
                    break;
                case 2:
                    to.setQuery(cbSituacao.getSelectedItem().toString(), " and situacao = 'I'");
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

            if (codigo == 1) {
                try {
                    FuncionarioDAO dao = new FuncionarioDAO();
                    FuncionarioTO to = (FuncionarioTO) dao.buscarId(codigo);

                    tfCodigo.setText(String.valueOf(to.getIdFuncFormatado(to.getIdFuncionario())));
                    tfNome.setText(to.getNome());
                    tfRG.setText(to.getRg());
                    tfCpf.setText(to.getCpf());
                    switch (to.getSexo()) {
                        case "M":
                            cbSexo.setSelectedItem("MASCULINO");
                            break;
                        case "F":
                            cbSexo.setSelectedItem("FEMININO");
                            break;
                    }
                    tfDatanasc.setDate(to.getDatanasc());
                    tfLogradouro.setText(to.getLogradouro());
                    tfNumero.setText(to.getNumero());
                    tfBairro.setText(to.getBairro());
                    tfCodCidade.setText(to.getCidade().getIdCidadeFormatado(to.getCidade().getIdCidade()));
                    tfCidade.setText(to.getCidade().getNome());
                    tfUf.setText(to.getCidade().getUf());
                    tfEmail.setText(to.getEmail());
                    tfLogin.setText(to.getLogin());
                    tfSenha.setText(to.getSenha());
                    tfCep.setText(to.getCep());
                    tfTelefone.setText(to.getTelefone());
                    tfCelular.setText(to.getCelular());
                    tfDataadmissao.setDate(to.getDataadmissao());
                    tfDatademissao.setDate(to.getDatademissao());
                    switch (to.getSituacao()) {
                        case "A":
                            cbCadSituacao.setSelectedItem("ATIVO");
                            break;
                        case "I":
                            cbCadSituacao.setSelectedItem("INATIVO");
                            break;
                    }
                    tfObservacao.setText(to.getObservacao());

                    this.listaAdministrador();
                    tpPrincipal.setSelectedComponent(pnCadastro);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao consultar!\nDescrição: " + ex.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try {
                    FuncionarioDAO dao = new FuncionarioDAO();
                    FuncionarioTO to = (FuncionarioTO) dao.buscarId(codigo);

                    tfCodigo.setText(String.valueOf(to.getIdFuncFormatado(to.getIdFuncionario())));
                    tfNome.setText(to.getNome());
                    tfRG.setText(to.getRg());
                    tfCpf.setText(to.getCpf());
                    switch (to.getSexo()) {
                        case "M":
                            cbSexo.setSelectedItem("MASCULINO");
                            break;
                        case "F":
                            cbSexo.setSelectedItem("FEMININO");
                            break;
                    }
                    tfDatanasc.setDate(to.getDatanasc());
                    tfLogradouro.setText(to.getLogradouro());
                    tfNumero.setText(to.getNumero());
                    tfBairro.setText(to.getBairro());
                    tfCodCidade.setText(to.getCidade().getIdCidadeFormatado(to.getCidade().getIdCidade()));
                    tfCidade.setText(to.getCidade().getNome());
                    tfUf.setText(to.getCidade().getUf());
                    tfEmail.setText(to.getEmail());
                    tfLogin.setText(to.getLogin());
                    tfSenha.setText(to.getSenha());
                    tfCep.setText(to.getCep());
                    tfTelefone.setText(to.getTelefone());
                    tfCelular.setText(to.getCelular());
                    tfDataadmissao.setDate(to.getDataadmissao());
                    tfDatademissao.setDate(to.getDatademissao());
                    switch (to.getSituacao()) {
                        case "A":
                            cbCadSituacao.setSelectedItem("ATIVO");
                            break;
                        case "I":
                            cbCadSituacao.setSelectedItem("INATIVO");
                            break;
                    }
                    tfObservacao.setText(to.getObservacao());

                    bloqueiaFormulario(false);
                    btExcluir.setEnabled(true);
                    tpPrincipal.setSelectedComponent(pnCadastro);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao consultar!\nDescrição: " + ex.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_tbBuscaMouseClicked

    private void listaAdministrador(){
        btExcluir.setEnabled(false);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
        btCadastrar.setEnabled(false);
        cbCadSituacao.setEnabled(false);
        tfObservacao.setEnabled(false);
        tfNome.setEnabled(true);
        tfLogin.setEnabled(true);
        tfSenha.setEnabled(true);
        tfNumero.setEnabled(true);
        tfBairro.setEnabled(true);
        tfCep.setEnabled(true);
        tfCelular.setEnabled(true);
        tfTelefone.setEnabled(true);
        cbSexo.setEnabled(true);
        tfDatademissao.setEnabled(false);
        tfDataadmissao.setEnabled(false);
        tfDatanasc.setEnabled(true);
        tfEmail.setEnabled(true);
        tfRG.setEnabled(true);
        tfCpf.setEnabled(true);
        tfCodCidade.setEnabled(true);
        tfCidade.setEnabled(false);
        tfUf.setEnabled(false);
        btBuscarCidade.setEnabled(true);
        tfLogradouro.setEnabled(true);
    }
    
    private void btBuscarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarCidadeActionPerformed
        CidadesGUI cidade = new CidadesGUI(this);
        PrincipalGUI.dpCorpo.remove(cidade);
        PrincipalGUI.dpCorpo.add(cidade);
        cidade.setVisible(true);
        cidade.setLocation(470, 90);
        cidade.toFront();
    }//GEN-LAST:event_btBuscarCidadeActionPerformed

    private void tfCodCidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodCidadeFocusLost
        if (tfCodCidade.getText().length() < 1) {
            tfCodCidade.setText("");
            tfCidade.setText("");
            tfUf.setText("");
            return;
        }
        try {
            CidadeDAO dao = new CidadeDAO();
            CidadeTO to = (CidadeTO) dao.buscarId(Integer.parseInt(tfCodCidade.getText()));
            if (to.getIdCidade() != 0) {
                if (to.getSituacao().equals("I")) {
                    JOptionPane.showMessageDialog(this, "Está cidade está inativada!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    tfCodCidade.setText("");
                    tfCidade.setText("");
                    tfUf.setText("");
                    tfCodCidade.requestFocus();
                    return;
                }
                this.carregaCidade(to);
            } else {
                JOptionPane.showMessageDialog(this, "Cidade não encontrada!", "Atenção", JOptionPane.WARNING_MESSAGE);
                tfCodCidade.setText("");
                tfCidade.setText("");
                tfUf.setText("");
                tfCodCidade.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar!\nDescrição: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tfCodCidadeFocusLost

    private void tfBuscaCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaCodKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            getRootPane().setDefaultButton(btBusca);
            tfBuscaCod.requestFocus();
        }
    }//GEN-LAST:event_tfBuscaCodKeyPressed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    public void carregaCidade(CidadeTO to) {
        try {
            tfCodCidade.setText(to.getIdCidadeFormatado(to.getIdCidade()));
            tfCidade.setText(to.getNome());
            tfUf.setText(to.getUf());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Descrição do erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarBusca(ArrayList funcionariosBusca) {
        String[] titulos = {"Código", "Nome", "Data de admissão", "Situação"};
        tbBusca.setModel(new DefaultTableModel(titulos, 0) {
            @Override
            public Class
                    getColumnClass(int columnIndex) {
                return String.class;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });

        DefaultTableModel dtm = (DefaultTableModel) tbBusca.getModel();
        funcionariosBusca.stream().forEach((funcionariosBusca1) -> {
            dtm.addRow(((ArrayList) funcionariosBusca1).toArray());
        });
        ((DefaultTableCellRenderer) tbBusca.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        tbBusca
                .setDefaultRenderer(Object.class, new CellRenderer());
        tbBusca.setColumnSelectionAllowed(
                false);
        tbBusca.getTableHeader()
                .setReorderingAllowed(false);
        spBusca.setViewportView(tbBusca);

        tbBusca.getColumnModel()
                .getSelectionModel().
                setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbBusca.getColumnModel()
                .getColumn(0).setResizable(false);
        tbBusca.getColumnModel()
                .getColumn(0).setPreferredWidth(60);
        tbBusca.getColumnModel()
                .getColumn(0).setMaxWidth(60);
        tbBusca.getColumnModel()
                .getColumn(1).setResizable(false);
        tbBusca.getColumnModel()
                .getColumn(1).setPreferredWidth(200);
        tbBusca.setCursor(
                new Cursor(Cursor.HAND_CURSOR));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBusca;
    private javax.swing.JButton btBuscarCidade;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbBusca;
    private javax.swing.JComboBox cbBuscaSexo;
    private javax.swing.JComboBox cbCadSituacao;
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JComboBox cbSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlCep;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlDataadmissao;
    private javax.swing.JLabel jlDatademissao;
    private javax.swing.JLabel jlDatanasc;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlLogin;
    private javax.swing.JLabel jlLogradouro;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlObservacao;
    private javax.swing.JLabel jlRG;
    private javax.swing.JLabel jlSenha;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JLabel jlSituacao;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JLabel jlUf;
    private javax.swing.JLabel lbTituloTabela;
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JPanel pnConsulta;
    private javax.swing.JPanel pnEndereco;
    private javax.swing.JPanel pnExtras;
    private javax.swing.JPanel pnInformacoes;
    private javax.swing.JPanel pnParametros;
    private javax.swing.JScrollPane spBusca;
    private javax.swing.JTable tbBusca;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfBusca;
    private javax.swing.JTextField tfBuscaCod;
    private javax.swing.JTextField tfCelular;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCodCidade;
    private javax.swing.JLabel tfCodigo;
    private javax.swing.JFormattedTextField tfCpf;
    private com.toedter.calendar.JDateChooser tfDataadmissao;
    private com.toedter.calendar.JDateChooser tfDatademissao;
    private com.toedter.calendar.JDateChooser tfDatanasc;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfLogradouro;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextPane tfObservacao;
    private javax.swing.JTextField tfRG;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JTextField tfUf;
    private javax.swing.JTabbedPane tpPrincipal;
    // End of variables declaration//GEN-END:variables
}
