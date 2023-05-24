package br.com.fs.rta;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class JComboBox extends javax.swing.JComboBox {

    private static final long serialVersionUID = 1L;

    private List id = new ArrayList();

    public JComboBox() {
        this.id = id;
    }

    public void adicionaValor(List<ArrayList<ArrayList<String>>> list) {
        id.clear();
        this.removeAllItems();
        @SuppressWarnings("unchecked")
        List<Object> desc = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            List linha = new ArrayList();
            linha.add(list.get(i).get(1));
            this.id.add(list.get(i).get(0));
            desc.add(new JComboBoxTO(linha.get(0).toString()));
        }
        setModel(new DefaultComboBoxModel(desc.toArray()));
    }

    public int getSelectedId() {
        try {
            return Integer.parseInt(this.id.get(this.getSelectedIndex()).toString());
        } catch (NumberFormatException e) {
        }
        return 0;
    }

 public void setValorSelecionado(int codigo)
  {
    for (int i = 0; i < this.id.size(); i++)
    {
      Object valorPosicaoObj = this.id.get(i);
      String valorPosicaoStr = String.valueOf(valorPosicaoObj);
      int valorPosicaoInt = Integer.parseInt(valorPosicaoStr);
      if (codigo == valorPosicaoInt) {
        setSelectedIndex(i);
      }
    }
  }
}
