package br.com.fs.gui;

import br.com.fs.dao.FluxoFinanDAO;
import br.com.fs.dao.ItensPedidoDAO;
import br.com.fs.dao.LoginDAO;
import br.com.fs.dao.PedidoDAO;
import br.com.fs.dao.PedidoEntregaDAO;
import br.com.fs.dao.ProdutoDAO;
import br.com.fs.dao.PromocaoDAO;
import br.com.fs.rta.CellRenderer;
import br.com.fs.rta.ImprimeTicketRTA;
import br.com.fs.rta.Mascaras;
import br.com.fs.rta.MascarasDouble;
import br.com.fs.rta.ReplaceMoedaRTA;
import br.com.fs.tm.ItensPedidoTableModel;
import br.com.fs.to.ContaTO;
import br.com.fs.to.FluxoFinanTO;
import br.com.fs.to.ItensPedidoTO;
import br.com.fs.to.PedidoEntregaTO;
import br.com.fs.to.PedidoTO;
import br.com.fs.to.ProdutoTO;
import br.com.fs.to.TiposPgtoTO;
import java.awt.Component;
import java.beans.PropertyVetoException;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class PedidosGUI extends javax.swing.JInternalFrame {

    private static PedidosGUI instancia = null;
    Mascaras mascara = new Mascaras();
    private final PedidoTO PEDIDO = new PedidoTO();

    public PedidosGUI() {
        initComponents();
        this.construtor();
    }

    public static PedidosGUI getInstancia() {
        if (instancia == null) {
            instancia = new PedidosGUI();
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
        tfDesconto.setDocument(new MascarasDouble(8));
        tfDesconto.setText("0,00");
        rbPedidoLocal.setSelected(true);
        this.bloqueiaEntrega(true);
        dtDataHora.setDate(new Date());
        tfContato.setDocument(mascara.somenteNumero());
        tfTroco.setDocument(new MascarasDouble(8));
        tfTroco.setText("0,00");
        lbPromocao.setText("");
        this.carregaTabelaItens();
        btConfirmarItem.setEnabled(false);
        btRemoverItem.setEnabled(false);
        btAlterarItem.setEnabled(false);
    }

    private void carregaTabelaItens() {
        try {
            ItensPedidoTableModel p = (ItensPedidoTableModel) tbItens.getModel();
            tbItens.getTableHeader().setReorderingAllowed(false);
            tbItens.setColumnSelectionAllowed(false);
            tbItens.getColumnModel().getColumn(0).setResizable(false);
            tbItens.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbItens.getColumnModel().getColumn(0).setMaxWidth(60);
            tbItens.getColumnModel().getColumn(2).setResizable(false);
            tbItens.getColumnModel().getColumn(2).setPreferredWidth(60);
            tbItens.getColumnModel().getColumn(2).setMaxWidth(60);
            tbItens.getColumnModel().getColumn(3).setResizable(false);
            tbItens.getColumnModel().getColumn(3).setPreferredWidth(90);
            tbItens.getColumnModel().getColumn(3).setMaxWidth(90);
            ((DefaultTableCellRenderer) tbItens.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            tbItens.setDefaultRenderer(Object.class, new CellRenderer());
            ItensPedidoDAO dao = new ItensPedidoDAO();
            p.setDados(dao.detalhaItensPedido(PEDIDO.getIdPedido()));

            this.valorTotal();
            this.limparCamposItem();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao recuperar dados! \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void bloqueiaCampos() {
        this.limparCamposItem();
        dtDataHora.setDate(new Date());
        tfNomeCliente.setText("");
        tfContato.setText("");
        tfLogradouro.setText("");
        tfNumero.setText("");
        tfComplemento.setText("");
        tfBairro.setText("");
        tfReferencia.setText("");
        tfObservacao.setText("");
        lbValorTotal.setText("R$ 0,00");
        rbPedidoLocal.setSelected(true);
        bloqueiaEntrega(true);
    }

    private void valorTotal() {
        double valor = 0;
        if (tbItens.getRowCount() <= 0) {
            lbValorPedido.setText(ReplaceMoedaRTA.doubleToMoeda(valor));
            lbValorTotal.setText(ReplaceMoedaRTA.doubleToMoeda(valor));
        }
        for (int i = 0; i < tbItens.getRowCount(); i++) {
            double vlUnit = ReplaceMoedaRTA.moedaToDouble(tbItens.getValueAt(i, 3).toString());
            double qtda = Double.parseDouble(tbItens.getValueAt(i, 2).toString().replace(",", "."));
            valor = valor + (vlUnit * qtda);
            lbValorPedido.setText(ReplaceMoedaRTA.doubleToMoeda(valor));
            lbValorTotal.setText(ReplaceMoedaRTA.doubleToMoeda(valor - ReplaceMoedaRTA.moedaToDouble(tfDesconto.getText())));
        }
    }

    private void bloqueiaEntrega(boolean controle) {
        if (controle) {
            for (Component cp : pnInfoEntrega.getComponents()) {
                cp.setEnabled(false);
                tfTroco.setText("0,00");
                tfObservacao.setEnabled(false);
            }
        } else {
            for (Component cp : pnInfoEntrega.getComponents()) {
                cp.setEnabled(true);
                tfObservacao.setEnabled(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPedido = new javax.swing.ButtonGroup();
        pnInfo = new javax.swing.JPanel();
        rbPedidoLocal = new javax.swing.JRadioButton();
        rbPedidoEntrega = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbValorTotal = new javax.swing.JLabel();
        dtDataHora = new br.com.fs.rta.JDateTimeField();
        jLabel1 = new javax.swing.JLabel();
        tfDesconto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbValorPedido = new javax.swing.JLabel();
        pnItens = new javax.swing.JPanel();
        spItens = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        btRemoverItem = new javax.swing.JButton();
        btAlterarItem = new javax.swing.JButton();
        btSelecionar = new javax.swing.JButton();
        pnDetalhes = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbUnidade = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbPrecoVenda = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbEstoque = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbComposto = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        lbPromocao = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfCodProduto = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        btConfirmarItem = new javax.swing.JButton();
        pnInfoEntrega = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfNomeCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfLogradouro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfComplemento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfReferencia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfTroco = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfContato = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfObservacao = new javax.swing.JTextPane();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setTitle("Novo pedido");
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

        pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        bgPedido.add(rbPedidoLocal);
        rbPedidoLocal.setText("PEDIDO LOCAL");
        rbPedidoLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPedidoLocalActionPerformed(evt);
            }
        });

        bgPedido.add(rbPedidoEntrega);
        rbPedidoEntrega.setText("DELIVERY");
        rbPedidoEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPedidoEntregaActionPerformed(evt);
            }
        });

        jLabel4.setText("Data/hora:");

        jLabel6.setText("Valor total:");

        lbValorTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbValorTotal.setForeground(new java.awt.Color(0, 102, 0));
        lbValorTotal.setText("R$ 0,00");

        dtDataHora.setEnabled(false);
        dtDataHora.setNextFocusableComponent(tfDesconto);

        jLabel1.setText("Desconto:");

        tfDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescontoFocusLost(evt);
            }
        });

        jLabel5.setText("Pedido:");

        lbValorPedido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbValorPedido.setText("R$ 0,00");

        javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
        pnInfo.setLayout(pnInfoLayout);
        pnInfoLayout.setHorizontalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInfoLayout.createSequentialGroup()
                        .addComponent(rbPedidoLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbPedidoEntrega))
                    .addGroup(pnInfoLayout.createSequentialGroup()
                        .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnInfoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDesconto))
                            .addComponent(dtDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValorPedido)
                            .addComponent(lbValorTotal)))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnInfoLayout.setVerticalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPedidoLocal)
                    .addComponent(rbPedidoEntrega))
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dtDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(lbValorPedido)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lbValorTotal))
                .addContainerGap())
        );

        pnItens.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Itens do pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tbItens.setModel(new ItensPedidoTableModel());
        tbItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbItensMouseClicked(evt);
            }
        });
        spItens.setViewportView(tbItens);

        btRemoverItem.setText("Remover");
        btRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverItemActionPerformed(evt);
            }
        });

        btAlterarItem.setText("Alterar");
        btAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarItemActionPerformed(evt);
            }
        });

        btSelecionar.setText("Selecionar");
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });

        pnDetalhes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes do item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel15.setText("Unidade:");

        lbUnidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbUnidade.setText("UN");

        jLabel17.setText("Venda:");

        lbPrecoVenda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPrecoVenda.setForeground(new java.awt.Color(51, 102, 0));
        lbPrecoVenda.setText("R$ 0,00");

        jLabel18.setText("Em estoque:");

        lbEstoque.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEstoque.setText("0");

        jLabel19.setText("Composto:");

        lbComposto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbComposto.setText("SIM");

        jLabel20.setText("Quantidade:");

        lbPromocao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPromocao.setForeground(new java.awt.Color(204, 51, 0));
        lbPromocao.setText("PROMOÇÃO");

        jLabel16.setText("Código:");

        tfCodProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodProdutoFocusLost(evt);
            }
        });

        tfNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfNome.setEnabled(false);

        javax.swing.GroupLayout pnDetalhesLayout = new javax.swing.GroupLayout(pnDetalhes);
        pnDetalhes.setLayout(pnDetalhesLayout);
        pnDetalhesLayout.setHorizontalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhesLayout.createSequentialGroup()
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetalhesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel20))
                        .addGap(4, 4, 4)
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCodProduto)
                            .addComponent(lbUnidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPrecoVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfQuantidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17))
                        .addGap(84, 84, 84)))
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(14, 14, 14)
                        .addComponent(lbComposto))
                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEstoque))
                    .addComponent(lbPromocao, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(tfNome))
                .addContainerGap())
        );
        pnDetalhesLayout.setVerticalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(lbUnidade))
                    .addComponent(jLabel19)
                    .addComponent(lbComposto))
                .addGap(9, 9, 9)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lbPrecoVenda)
                    .addComponent(jLabel17)
                    .addComponent(lbEstoque))
                .addGap(6, 6, 6)
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbPromocao))
                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel20)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btConfirmarItem.setText("Confirmar item");
        btConfirmarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnItensLayout = new javax.swing.GroupLayout(pnItens);
        pnItens.setLayout(pnItensLayout);
        pnItensLayout.setHorizontalGroup(
            pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spItens, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
            .addComponent(pnDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnItensLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSelecionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btConfirmarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAlterarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRemoverItem)
                .addContainerGap())
        );
        pnItensLayout.setVerticalGroup(
            pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItensLayout.createSequentialGroup()
                .addComponent(pnDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemoverItem)
                    .addComponent(btAlterarItem)
                    .addComponent(btSelecionar)
                    .addComponent(btConfirmarItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spItens, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnInfoEntrega.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações para entrega", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel3.setText("Entregar à:");

        jLabel7.setText("Logradouro:");

        jLabel8.setText("Número:");

        tfNumero.setPreferredSize(new java.awt.Dimension(59, 20));

        jLabel9.setText("Bairro:");

        jLabel10.setText("Complemento:");

        jLabel11.setText("Próximo a:");

        jLabel12.setText("Troco a levar:");

        jLabel13.setText("Contato:");

        jLabel21.setText("Observação:");

        jScrollPane1.setViewportView(tfObservacao);

        javax.swing.GroupLayout pnInfoEntregaLayout = new javax.swing.GroupLayout(pnInfoEntrega);
        pnInfoEntrega.setLayout(pnInfoEntregaLayout);
        pnInfoEntregaLayout.setHorizontalGroup(
            pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoEntregaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnInfoEntregaLayout.createSequentialGroup()
                        .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(pnInfoEntregaLayout.createSequentialGroup()
                        .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnInfoEntregaLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInfoEntregaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInfoEntregaLayout.createSequentialGroup()
                        .addComponent(tfReferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnInfoEntregaLayout.createSequentialGroup()
                        .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(tfContato)))
                    .addComponent(jLabel21)
                    .addComponent(jScrollPane1))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnInfoEntregaLayout.setVerticalGroup(
            pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoEntregaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnInfoEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnInfoEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbPedidoEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPedidoEntregaActionPerformed
        this.bloqueiaEntrega(false);
        tfTroco.setText("0,00");
    }//GEN-LAST:event_rbPedidoEntregaActionPerformed

    private void rbPedidoLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPedidoLocalActionPerformed
        this.bloqueiaEntrega(true);
    }//GEN-LAST:event_rbPedidoLocalActionPerformed

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        ConsultaItensPedidoGUI bip = new ConsultaItensPedidoGUI(this);
        bip.setVisible(true);
    }//GEN-LAST:event_btSelecionarActionPerformed

    private void btAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarItemActionPerformed
        if (tbItens.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Nenhum item selecionado!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            int row = tbItens.getSelectedRow();
            int codigo = Integer.parseInt(tbItens.getValueAt(row, 0).toString());
            double qtd = Double.parseDouble(tbItens.getValueAt(row, 2).toString().replace(",", "."));
            ItensPedidoDAO itensDAO = new ItensPedidoDAO();
            itensDAO.removerItem(codigo, PEDIDO.getIdPedido(), qtd);
            this.carregaTabelaItens();

            ProdutoDAO dao = new ProdutoDAO();
            ProdutoTO to = (ProdutoTO) dao.buscarId(codigo);

            tfCodProduto.setText(String.valueOf(to.getIdProdFormatado(to.getIdProduto())));
            tfNome.setText(to.getNome());
            switch (to.getUnidade()) {
                case "UN":
                    lbUnidade.setText("UNIT.");
                    break;
                case "L":
                    lbUnidade.setText("LITRO");
                    break;
                case "KG":
                    lbUnidade.setText("KG");
                    break;
            }
            lbPrecoVenda.setText(ReplaceMoedaRTA.doubleToMoeda(ProdutoDAO.precoProduto(to.getIdProduto())));
            if (to.getComposto().equals("S")) {
                lbComposto.setText("SIM");
                lbEstoque.setText(String.valueOf(dao.estoqueComposto(to.getIdProduto())));
                if (!to.getUnidade().equals("UN")) {
                    tfQuantidade.setDocument(mascara.permiteVirgula());
                    tfQuantidade.setText(to.getQtdKGL(qtd));
                } else {
                    tfQuantidade.setDocument(mascara.somenteNumero());
                    tfQuantidade.setText(String.valueOf(to.getQtdUnidade(qtd)));
                }
            } else {
                lbComposto.setText("NÃO");
                if (!to.getUnidade().equals("UN")) {
                    lbEstoque.setText(to.getQtdKGL(to.getQtd()));
                    tfQuantidade.setDocument(mascara.permiteVirgula());
                    tfQuantidade.setText(to.getQtdKGL(qtd));
                } else {
                    lbEstoque.setText(String.valueOf(to.getQtdUnidade(to.getQtd())));
                    tfQuantidade.setDocument(mascara.somenteNumero());
                    tfQuantidade.setText(String.valueOf(to.getQtdUnidade(qtd)));
                }
            }
            if (PromocaoDAO.verificaExiste(codigo)) {
                lbPromocao.setText("PRODUTO NA PROMOÇÃO! Preço normal: " + ReplaceMoedaRTA.doubleToMoeda(to.getPrecovenda()));
            } else {
                lbPromocao.setText("");
            }
            tbItens.setEnabled(false);
            btConfirmarItem.setEnabled(true);
            btAlterarItem.setEnabled(false);
            btSelecionar.setEnabled(false);
            btRemoverItem.setEnabled(false);
            tfQuantidade.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar informações do produto!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btAlterarItemActionPerformed

    private void btConfirmarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarItemActionPerformed
        if (tfCodProduto.getText().equals("000")) {
            JOptionPane.showMessageDialog(null, "Selecione um produto!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfQuantidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfQuantidade.requestFocus();
            return;
        }
        if ((tfQuantidade.getText().equals("0")) || (tfQuantidade.getText().equals("00")) || (tfQuantidade.getText().equals("000")) || (tfQuantidade.getText().equals("0000"))) {
            JOptionPane.showMessageDialog(null, "A quantidade não pode ser 0!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfQuantidade.requestFocus();
            return;
        }
        if (Double.parseDouble(tfQuantidade.getText().replace(",", ".")) > Double.parseDouble(lbEstoque.getText().replace(",", "."))) {
            JOptionPane.showMessageDialog(null, "Quantidade indisponível! \nEstoque: " + lbEstoque.getText(), "Atenção", JOptionPane.WARNING_MESSAGE);
            tfQuantidade.requestFocus();
            return;
        }
        ItensPedidoTO itensTO = new ItensPedidoTO();
        ProdutoTO produtoTO = new ProdutoTO();
        ItensPedidoDAO itensDAO = new ItensPedidoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        try {
            PEDIDO.setFuncionario(LoginDAO.operador);
            PEDIDO.setDataHoraPedido(dtDataHora.getDate());
            PEDIDO.setValorPedido(ReplaceMoedaRTA.moedaToDouble(lbValorPedido.getText()));
            PEDIDO.setDesconto(ReplaceMoedaRTA.moedaToDouble(tfDesconto.getText()));
            PEDIDO.setValortotal(ReplaceMoedaRTA.moedaToDouble(lbValorTotal.getText()));
            if (rbPedidoLocal.isSelected()) {
                PEDIDO.setTipoPedido("L");
            } else {
                PEDIDO.setTipoPedido("E");
            }
            PEDIDO.setSituacao("A");
            if (PEDIDO.getIdPedido() == 0) {
                int senha = pedidoDAO.defineSenha() + 1;
                PEDIDO.setSenha(senha);
                PEDIDO.setIdPedido(pedidoDAO.inserir(PEDIDO));
                itensTO.setPedido(PEDIDO);
                produtoTO.setIdProduto(tfCodProduto.getText());
                itensTO.setProduto(produtoTO);
                itensTO.setQtd(Double.parseDouble(tfQuantidade.getText().replace(",", ".")));
                itensTO.setValorVenda(ReplaceMoedaRTA.moedaToDouble(lbPrecoVenda.getText()));
                itensDAO.inserir(itensTO);
            } else {
                itensTO.setPedido(PEDIDO);
                produtoTO.setIdProduto(tfCodProduto.getText());
                if (itensDAO.verificaSeExiste(produtoTO.getIdProduto(), PEDIDO.getIdPedido()) == true) {
                    JOptionPane.showMessageDialog(this, "Este item já foi adicionado!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                itensTO.setProduto(produtoTO);
                itensTO.setQtd(Double.parseDouble(tfQuantidade.getText().replace(",", ".")));
                itensTO.setValorVenda(ReplaceMoedaRTA.moedaToDouble(lbPrecoVenda.getText()));
                itensDAO.inserir(itensTO);
            }
            this.carregaTabelaItens();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar item!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        tbItens.setEnabled(true);
        btSelecionar.setEnabled(true);
        btConfirmarItem.setEnabled(false);
        btAlterarItem.setEnabled(false);
        btRemoverItem.setEnabled(false);
    }//GEN-LAST:event_btConfirmarItemActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        int o = JOptionPane.showConfirmDialog(null, "Ao cancelar, os itens retornarão ao estoque e o pedido será deletado. Prosseguir?", "Confirmar cancelamento", JOptionPane.YES_NO_OPTION);
        if (o == JOptionPane.YES_OPTION) {
            try {
                if (PEDIDO.getIdPedido() == 0) {
                    this.dispose();
                } else {
                    ItensPedidoDAO itensDAO = new ItensPedidoDAO();
                    PedidoDAO pedidoDAO = new PedidoDAO();
                    if (tbItens.getRowCount() != 0) {
                        for (int i = 0; i < tbItens.getRowCount(); i++) {
                            int codigo = Integer.parseInt(tbItens.getValueAt(i, 0).toString());
                            double qtd = Double.parseDouble(tbItens.getValueAt(i, 2).toString().replace(",", "."));
                            itensDAO.removerItem(codigo, PEDIDO.getIdPedido(), qtd);
                        }
                        pedidoDAO.excluir(PEDIDO);
                    } else {
                        pedidoDAO.excluir(PEDIDO);
                    }
                    this.dispose();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cancelar pedido!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
        } else {
            repaint();
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tbItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbItensMouseClicked
        btRemoverItem.setEnabled(true);
        btAlterarItem.setEnabled(true);
        if (evt.getClickCount() == 2) {
            try {
                JTable target = (JTable) evt.getSource();
                int row = target.getSelectedRow();
                int codigo = Integer.parseInt(target.getValueAt(row, 0).toString());
                double qtd = Double.parseDouble(target.getValueAt(row, 2).toString().replace(",", "."));
                ItensPedidoDAO itensDAO = new ItensPedidoDAO();
                itensDAO.removerItem(codigo, PEDIDO.getIdPedido(), qtd);
                this.carregaTabelaItens();

                ProdutoDAO dao = new ProdutoDAO();
                ProdutoTO to = (ProdutoTO) dao.buscarId(codigo);

                tfCodProduto.setText(String.valueOf(to.getIdProdFormatado(to.getIdProduto())));
                tfNome.setText(to.getNome());
                switch (to.getUnidade()) {
                    case "UN":
                        lbUnidade.setText("UNIT.");
                        break;
                    case "L":
                        lbUnidade.setText("LITRO");
                        break;
                    case "KG":
                        lbUnidade.setText("KG");
                        break;
                }
                lbPrecoVenda.setText(ReplaceMoedaRTA.doubleToMoeda(ProdutoDAO.precoProduto(to.getIdProduto())));
                if (to.getComposto().equals("S")) {
                    lbComposto.setText("SIM");
                    lbEstoque.setText(String.valueOf(dao.estoqueComposto(to.getIdProduto())));
                    if (!to.getUnidade().equals("UN")) {
                        tfQuantidade.setDocument(mascara.permiteVirgula());
                        tfQuantidade.setText(to.getQtdKGL(qtd));
                    } else {
                        tfQuantidade.setDocument(mascara.somenteNumero());
                        tfQuantidade.setText(String.valueOf(to.getQtdUnidade(qtd)));
                    }
                } else {
                    lbComposto.setText("NÃO");
                    if (!to.getUnidade().equals("UN")) {
                        lbEstoque.setText(to.getQtdKGL(to.getQtd()));
                        tfQuantidade.setDocument(mascara.permiteVirgula());
                        tfQuantidade.setText(to.getQtdKGL(qtd));
                    } else {
                        lbEstoque.setText(String.valueOf(to.getQtdUnidade(to.getQtd())));
                        tfQuantidade.setDocument(mascara.somenteNumero());
                        tfQuantidade.setText(String.valueOf(to.getQtdUnidade(qtd)));
                    }
                }
                if (PromocaoDAO.verificaExiste(codigo)) {
                    lbPromocao.setText("PRODUTO NA PROMOÇÃO! Preço normal: " + ReplaceMoedaRTA.doubleToMoeda(to.getPrecovenda()));
                } else {
                    lbPromocao.setText("");
                }
                tbItens.setEnabled(false);
                btConfirmarItem.setEnabled(true);
                btAlterarItem.setEnabled(false);
                btSelecionar.setEnabled(false);
                btRemoverItem.setEnabled(false);
                tfQuantidade.requestFocus();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar informações do item!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tbItensMouseClicked

    private void btRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverItemActionPerformed
        if (tbItens.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Nenhum item selecionado!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            int o = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover?", "Confirmar remoção", JOptionPane.YES_NO_OPTION);
            if (o == JOptionPane.YES_OPTION) {
                try {
                    int row = tbItens.getSelectedRow();
                    int codigo = Integer.parseInt(tbItens.getValueAt(row, 0).toString());
                    double qtd = Double.parseDouble(tbItens.getValueAt(row, 2).toString().replace(",", "."));
                    ItensPedidoDAO itensDAO = new ItensPedidoDAO();

                    itensDAO.removerItem(codigo, PEDIDO.getIdPedido(), qtd);

                    JOptionPane.showMessageDialog(this, "Item removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    this.carregaTabelaItens();
                    btRemoverItem.setEnabled(false);
                    btAlterarItem.setEnabled(false);
                    btConfirmarItem.setEnabled(false);
                    btSelecionar.setEnabled(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro ao remover item!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                repaint();
            }
        }
    }//GEN-LAST:event_btRemoverItemActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        if (tbItens.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(this, "Nenhum item selecionado!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if ((ReplaceMoedaRTA.moedaToDouble(tfDesconto.getText())
                > ReplaceMoedaRTA.moedaToDouble(lbValorPedido.getText()))) {
            JOptionPane.showMessageDialog(this, "Desconto maior ou igual o "
                    + "valor do pedido!", "Atenção", JOptionPane.WARNING_MESSAGE);
            tfDesconto.requestFocus();
            return;
        }
        try {
            PedidoDAO pedidodao = new PedidoDAO();

            PEDIDO.setFuncionario(LoginDAO.operador);
            PEDIDO.setDataHoraPedido(dtDataHora.getDate());
            PEDIDO.setValorPedido(ReplaceMoedaRTA.moedaToDouble(lbValorPedido.getText()));
            PEDIDO.setDesconto(ReplaceMoedaRTA.moedaToDouble(tfDesconto.getText()));
            PEDIDO.setValortotal(ReplaceMoedaRTA.moedaToDouble(lbValorTotal.getText()));
            if (rbPedidoLocal.isSelected()) {
                PEDIDO.setTipoPedido("L");
            } else {
                PEDIDO.setTipoPedido("E");
            }

            if (rbPedidoLocal.isSelected()) {
                PEDIDO.setSituacao("P");
                RecebePedidoGUI receber = new RecebePedidoGUI(this, PEDIDO);
                receber.setVisible(true);
            }
            if (rbPedidoEntrega.isSelected()) {
                if (tfNomeCliente.getText().length() <= 1) {
                    JOptionPane.showMessageDialog(this, "Informe o nome do cliente!",
                            "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    tfNomeCliente.requestFocus();
                    return;
                }
                if (tfContato.getText().length() <= 1) {
                    JOptionPane.showMessageDialog(this, "Informe um telefone para contato!",
                            "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    tfContato.requestFocus();
                    return;
                }
                if (tfLogradouro.getText().length() <= 1) {
                    JOptionPane.showMessageDialog(this, "Informe o logradouro de entrega!",
                            "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    tfLogradouro.requestFocus();
                    return;
                }
                if (tfNumero.getText().length() < 1) {
                    JOptionPane.showMessageDialog(this, "Informe o número de entrega!",
                            "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    tfNumero.requestFocus();
                    return;
                }
                if (tfBairro.getText().length() <= 1) {
                    JOptionPane.showMessageDialog(this, "Informe o bairro de entrega!",
                            "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    tfBairro.requestFocus();
                    return;
                }
                if (tfObservacao.getText().length() > 150) {
                    JOptionPane.showMessageDialog(this, "Observação não pode conter "
                            + "mais de 150 caracteres!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    tfObservacao.requestFocus();
                    return;
                }

                PedidoEntregaTO entregaTO = new PedidoEntregaTO();
                PedidoEntregaDAO entregadao = new PedidoEntregaDAO();
                FluxoFinanTO fluxoto = new FluxoFinanTO();
                FluxoFinanDAO fluxodao = new FluxoFinanDAO();

                if (ReplaceMoedaRTA.moedaToDouble(tfTroco.getText()) > fluxodao.caixaTotal()) {
                    JOptionPane.showMessageDialog(this, "Você não tem em caixa a quantia do "
                            + "troco solicitado!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    tfTroco.requestFocus();
                    return;
                }

                PEDIDO.setSituacao("A");
                pedidodao.atualizarPedido(PEDIDO);
                entregaTO.setNomecliente(tfNomeCliente.getText());
                entregaTO.setBairro(tfBairro.getText());
                entregaTO.setContato(tfContato.getText());
                entregaTO.setComplemento(tfComplemento.getText());
                entregaTO.setLogradouro(tfLogradouro.getText());
                entregaTO.setNumero(tfNumero.getText());
                entregaTO.setValortroco(ReplaceMoedaRTA.moedaToDouble(tfTroco.getText()));
                entregaTO.setReferencia(tfReferencia.getText());
                entregaTO.setObservacao(tfObservacao.getText());
                entregaTO.setPedido(PEDIDO);
                entregadao.inserir(entregaTO);
                fluxoto.setSituacao("A");
                fluxoto.setPedido(PEDIDO);
                fluxoto.setTipomovimentacao("E");
                fluxoto.setDatahora(new Date());
                ContaTO contato = new ContaTO();
                contato.setIdConta(1);
                fluxoto.setConta(contato);
                TiposPgtoTO formapgto = new TiposPgtoTO();
                formapgto.setIdTipoPgto(1);
                fluxoto.setTipoPgto(formapgto);
                fluxoto.setDesconto(ReplaceMoedaRTA.moedaToDouble(tfDesconto.getText()));
                fluxoto.setValorTotal(ReplaceMoedaRTA.moedaToDouble(lbValorTotal.getText()));
                fluxodao.inserirEntrega(fluxoto);

                this.bloqueiaCampos();
                JOptionPane.showMessageDialog(this, "Pedido salvo com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                PrincipalGUI.carregaTabela();
                this.dispose();

                String arquivo = "CupomDelivery";
                String arquivo2 = "CupomInterno";
                HashMap parametros = new HashMap();
                parametros.put("idpedido", PEDIDO.getIdPedido());
                new ImprimeTicketRTA(arquivo, parametros);
                new ImprimeTicketRTA(arquivo2, parametros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar pedido\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void tfDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoFocusLost
        this.valorTotal();
    }//GEN-LAST:event_tfDescontoFocusLost

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        instancia = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void tfCodProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodProdutoFocusLost
        if (tfCodProduto.getText().length() != 0) {
            try {
                if (Integer.parseInt(tfCodProduto.getText()) > 0) {
                    ProdutoDAO dao = new ProdutoDAO();
                    ProdutoTO to = (ProdutoTO) dao.buscarId(Integer.parseInt(tfCodProduto.getText()));
                    if (to.getIdProduto() != 0) {
                        if ((to.getSituacao().equals("A")) && (to.getTipo().equals("F"))) {
                            if (to.getComposto().equals("N")) {
                                if (to.getQtd() > 0) {
                                    this.preencheProduto(to);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Produto faltando em estoque!");
                                    this.limparCamposItem();
                                }
                            } else {
                                if (dao.checaDisponibilidade(to.getIdProduto()) == true) {
                                    JOptionPane.showMessageDialog(null, "Produto faltando em estoque!");
                                    this.limparCamposItem();
                                } else {
                                    this.preencheProduto(to);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Produto não disponível para venda!");
                            this.limparCamposItem();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                        this.limparCamposItem();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar por código!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tfCodProdutoFocusLost

    private void limparCamposItem() {
        tfCodProduto.setText("000");
        tfNome.setText("");
        lbPrecoVenda.setText("");
        lbUnidade.setText("");
        lbEstoque.setText("");
        lbComposto.setText("");
        lbPromocao.setText("");
        tfQuantidade.setText("");
    }

    protected void preencheProduto(ProdutoTO toRetorno) {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            tfCodProduto.setText(String.valueOf(toRetorno.getIdProdFormatado(toRetorno.getIdProduto())));
            tfNome.setText(toRetorno.getNome());
            switch (toRetorno.getUnidade()) {
                case "UN":
                    lbUnidade.setText("UNIT.");
                    break;
                case "L":
                    lbUnidade.setText("LITRO");
                    break;
                case "KG":
                    lbUnidade.setText("KG");
                    break;
            }
            lbPrecoVenda.setText(ReplaceMoedaRTA.doubleToMoeda(ProdutoDAO.precoProduto(toRetorno.getIdProduto())));
            if (toRetorno.getComposto().equals("S")) {
                lbComposto.setText("SIM");
                lbEstoque.setText(String.valueOf(dao.estoqueComposto(toRetorno.getIdProduto())));
                tfQuantidade.setDocument(mascara.somenteNumero());
            } else {
                lbComposto.setText("NÃO");
                if (!toRetorno.getUnidade().equals("UN")) {
                    lbEstoque.setText(toRetorno.getQtdKGL(toRetorno.getQtd()));
                    tfQuantidade.setDocument(mascara.permiteVirgula());
                } else {
                    lbEstoque.setText(String.valueOf(toRetorno.getQtdUnidade(toRetorno.getQtd())));
                    tfQuantidade.setDocument(mascara.somenteNumero());
                }
            }
            if (PromocaoDAO.verificaExiste(toRetorno.getIdProduto())) {
                lbPromocao.setText("PRODUTO NA PROMOÇÃO! Preço normal: " + ReplaceMoedaRTA.doubleToMoeda(toRetorno.getPrecovenda()));
            } else {
                lbPromocao.setText("");
            }
            btConfirmarItem.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher dados do produto!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgPedido;
    private javax.swing.JButton btAlterarItem;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btConfirmarItem;
    private javax.swing.JButton btRemoverItem;
    private javax.swing.JButton btSelecionar;
    private br.com.fs.rta.JDateTimeField dtDataHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbComposto;
    private javax.swing.JLabel lbEstoque;
    private javax.swing.JLabel lbPrecoVenda;
    private javax.swing.JLabel lbPromocao;
    private javax.swing.JLabel lbUnidade;
    private javax.swing.JLabel lbValorPedido;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JPanel pnDetalhes;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnInfoEntrega;
    private javax.swing.JPanel pnItens;
    private javax.swing.JRadioButton rbPedidoEntrega;
    private javax.swing.JRadioButton rbPedidoLocal;
    private javax.swing.JScrollPane spItens;
    private javax.swing.JTable tbItens;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCodProduto;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JTextField tfContato;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfLogradouro;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNomeCliente;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextPane tfObservacao;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfReferencia;
    private javax.swing.JTextField tfTroco;
    // End of variables declaration//GEN-END:variables
}
