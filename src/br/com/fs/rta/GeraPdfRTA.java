package br.com.fs.rta;

import br.com.fs.dao.Conexao;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class GeraPdfRTA {

    private final String caminhoRelatorio = System.getProperty("user.dir")
            + "/src/br/com/fs/report/";
    private final String caminhoRelatorioJAR = System.getProperty("user.dir")
            + "\\report\\";

    public GeraPdfRTA(String nomeRelatorio, Map parametros) throws SQLException, JRException, Exception {
        Conexao conn = new Conexao();
        try {
            String arquivo = this.caminhoRelatorio
                    + nomeRelatorio + ".jasper";
            String pdftemporario = this.caminhoRelatorio + nomeRelatorio + ".pdf";
            if (new File(arquivo).exists() == false) {
                arquivo = this.caminhoRelatorioJAR
                        + nomeRelatorio + ".jasper";
                pdftemporario = this.caminhoRelatorioJAR + nomeRelatorio + ".pdf";
                if (new File(arquivo).exists() == false) {
                    JOptionPane.showMessageDialog(null,
                            "Não existe o relatório no caminho "
                            + "especificado.");
                    return;
                }
            }

            @SuppressWarnings("unchecked")
            JasperPrint jp = JasperFillManager.fillReport(arquivo, parametros, conn.getCon());
            JasperExportManager.exportReportToPdfFile(jp, pdftemporario);

            File file = new File(pdftemporario);
            java.awt.Desktop.getDesktop().open(file);
            file.deleteOnExit();

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
