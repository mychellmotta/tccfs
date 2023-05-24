package br.com.fs.rta;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

    private static final long serialVersionUID = 1L;

    private final JButton renderButton = new JButton();
    private final JButton editButton = new JButton();

    public ButtonColumn(JTable table, int column, ImageIcon icon, ActionListener action) {
        super();

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer(this);
        columnModel.getColumn(column).setCellEditor(this);

        editButton.addActionListener(action);

        editButton.setFocusPainted(false);
        renderButton.setFocusPainted(false);

        editButton.setContentAreaFilled(false);
        renderButton.setContentAreaFilled(false);

        editButton.setBorderPainted(false);
        renderButton.setBorderPainted(false);

        editButton.setIcon(icon);
        renderButton.setIcon(icon);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Color b = table.getCellRenderer(0, 0).getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column).getBackground();
        renderButton.setBackground(b);
        return renderButton;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        Color b = table.getCellRenderer(0, 0).getTableCellRendererComponent(table, value, isSelected, true, row, column).getBackground();
        editButton.setBackground(b);
        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
}
