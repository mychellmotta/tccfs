package br.com.fs.rta;

import java.text.NumberFormat;
import java.util.Locale;

public class ReplaceMoedaRTA {
        
    private static double valor = 0;
    private static String str = "";
    
    public static double moedaToDouble(String str){
        if (str.isEmpty()){
            str = "0";
        }
       
        str = str.replace(".", "");
        str = str.replace(",", ".");
        str = str.replace("R$", "");
        
        valor = Double.parseDouble(str);
        return valor;
    }
    
    public static String doubleToMoeda(double dbl){
        //format
        Locale meuLocal = new Locale("pt", "BR");
        //parse
        NumberFormat format = NumberFormat.getCurrencyInstance(meuLocal);
        str = format.format(dbl);
        return str;
    }
    
    private ReplaceMoedaRTA() {
    }
 
}
