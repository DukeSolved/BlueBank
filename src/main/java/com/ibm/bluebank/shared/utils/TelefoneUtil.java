package com.ibm.bluebank.shared.utils;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.logging.Logger;

public class TelefoneUtil {
    public static String TelefoneUtil1(String telefone){
        MaskFormatter mk;
        try {
            mk = new MaskFormatter("(##)#### - ####");
            mk.setValueContainsLiteralCharacters(false);
            telefone = mk.valueToString(telefone);
        }catch (ParseException e){
            e.printStackTrace();
            Logger.getLogger("Erro ap aplicar mascara de 8 digitos");
        }
        return telefone;
    }

}
