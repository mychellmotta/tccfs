package br.com.fs;

import br.com.fs.gui.LoginGUI;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("ComboBox.disabledForeground", Color.BLACK);
            UIManager.put("JRadioButton.disabledForeground", Color.BLACK);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        new LoginGUI().setVisible(true);
    }
}
