package br.com.fs.rta;

import com.toedter.calendar.JDateChooser;
import java.util.Date;

public class JDateTimeField extends JDateChooser {

    private static final long serialVersionUID = 1L;

    private Date date;

    public JDateTimeField() {
        super("dd/MM/yyyy HH:mm", "##/##/####", ' ');
    }

    public JDateTimeField(String dataFormat, String mask, char separator) {
        super(dataFormat, mask, separator);
    }

    public void setValue(Date date) {
        setDate(date);
    }

    public Date getValue() {
        return getDate();
    }
}
