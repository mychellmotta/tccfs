package br.com.fs.rta;

import java.text.ParseException;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

public class Mascaras {

    public MaskFormatter SetaMascara(String Mascara) {
        MaskFormatter mf = new MaskFormatter();
        try {
            mf.setMask(Mascara);
            mf.setPlaceholderCharacter(' ');
            mf.setValidCharacters("0123456789");
            mf.setValueContainsLiteralCharacters(false);
        } catch (ParseException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return mf;
    }

    public PlainDocument permitePontoTraco() {
        DocumentFilter filter = new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(offset, text.replaceAll("[^0-9\\.-]", ""), attr);
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^0-9\\.-]", ""), attrs);
            }
        };

        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(filter);

        return doc;
    }

    public PlainDocument permitePonto() {
        DocumentFilter filter = new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(offset, text.replaceAll("[^0-9\\.]", ""), attr);
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^0-9\\.]", ""), attrs);
            }
        };

        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(filter);

        return doc;
    }
    
    public PlainDocument permiteVirgula() {
        DocumentFilter filter = new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(offset, text.replaceAll("[^0-9\\,]", ""), attr);
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^0-9\\,]", ""), attrs);
            }
        };

        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(filter);

        return doc;
    }
    
        public PlainDocument somenteNumero() {
        DocumentFilter filter = new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(offset, text.replaceAll("[^0-9]", ""), attr);
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^0-9]", ""), attrs);
            }
        };

        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(filter);

        return doc;
    }
}
