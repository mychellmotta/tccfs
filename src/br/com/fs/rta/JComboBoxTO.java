package br.com.fs.rta;

public class JComboBoxTO {

    private final String SelectedItem;

    public JComboBoxTO(String SelectedItem) {
        this.SelectedItem = SelectedItem;
    }

    @Override
    public String toString() {
        return SelectedItem;
    }
}
