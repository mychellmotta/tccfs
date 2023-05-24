package br.com.fs.dao;

import br.com.fs.to.ProducaoTO;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class ThreadProducao extends Thread {

    ProducaoDAO dao = new ProducaoDAO();
    ProducaoTO to = new ProducaoTO();
    ProdutoDAO produtodao = new ProdutoDAO();

    @Override
    public void run() {
        try {
            while (this.isAlive()) {
                Date dia = new Date();
                Calendar calendario = new GregorianCalendar();
                calendario.setTime(dia);
                String dayOfWeek = dao.weekDay(calendario);
                ArrayList<ProducaoTO> producoes = new ArrayList();
                producoes = dao.checagemDiaSemana(dayOfWeek);
                if (!producoes.isEmpty()) {
                    for (int i = 0; i < producoes.size(); i++) {
                        if (dao.checagemDia(producoes.get(i).getIdproducao()) == false) {
                            to = dao.buscarId(producoes.get(i).getIdproducao());
                            if (to.getQtd() <= produtodao.estoqueComposto(to.getProduto().getIdProduto())) {
                                produtodao.ajustarEstoqueItens(to.getProduto().getIdProduto(), to.getQtd());
                                produtodao.ajustarEstoqueProd(to.getProduto().getIdProduto(), to.getQtd());
                                dao.registrarLog(to.getIdproducao());
                                String impressao = "Sua produção diária (cód: " + to.getIdProdFormatado(to.getIdproducao()) + ") para o produto " + to.getProduto().getNome() + " na quantidade ";
                                if (to.getProduto().getUnidade().equals("UN")) {
                                    impressao += to.getQtdUnidade(to.getQtd());
                                } else {
                                    impressao += to.getQtdKGL(to.getQtd());
                                }
                                impressao += " foi contabilizada!";
                                JOptionPane.showMessageDialog(null, impressao, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }
                ThreadProducao.sleep(21600000);
            }
        } catch (HeadlessException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Erro no processamento de rotinas de produção!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro no processamento de rotinas de produção!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
