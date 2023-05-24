package br.com.fs.rta;

import br.com.fs.dao.Conexao;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

public class ImprimeRTA {

    private final String caminhoRelatorio = System.getProperty("user.dir")
            + "/src/br/com/fs/report/";
    private final String caminhoRelatorioJAR = System.getProperty("user.dir")
            + "\\report\\";

    public ImprimeRTA(String nomeRelatorio, Map parametros) throws SQLException, JRException, Exception {
        Conexao conn = new Conexao();
        try {
            String arquivo = this.caminhoRelatorio
                    + nomeRelatorio + ".jasper";
            if (new File(arquivo).exists() == false) {
                arquivo = this.caminhoRelatorioJAR
                        + nomeRelatorio + ".jasper";
                if (new File(arquivo).exists() == false) {
                    JOptionPane.showMessageDialog(null,
                            "Não existe o relatório no caminho "
                            + "especificado.");
                    return;
                }
            }
            @SuppressWarnings("unchecked")
            JasperPrint jp = JasperFillManager.fillReport(arquivo, parametros, conn.getCon());

            int paginas = jp.getPages().size();
            JasperPrintManager.printPages(jp, 0, paginas - 1, true);

            if (!conn.getCon().isClosed()) {
                conn.getCon().close();
            }

        } catch (JRException | HeadlessException | SQLException e) {
            System.out.println("Relatório: " + nomeRelatorio + " - " + e.toString());
        } finally {
            if (!conn.getCon().isClosed()) {
                conn.getCon().close();
            }
        }
    }
}
