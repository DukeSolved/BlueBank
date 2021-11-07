package com.ibm.bluebank.shared.utils;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.logging.Logger;

public class TelefoneUtil {

    private static final String DEZ_DIGITOS = "(##) ####-####";
    private static final String ONZE_DIGITOS = "(##) #####-####";

    public static String aplicarMascara(String telefone) {
        MaskFormatter mk;
        try {
            String mascara = DEZ_DIGITOS;
            if (telefone.length() > 10) {
                mascara = ONZE_DIGITOS;
            }
            mk = new MaskFormatter(mascara);
            mk.setValueContainsLiteralCharacters(false);
            telefone = mk.valueToString(telefone);
        } catch (ParseException e) {
            e.printStackTrace();
            Logger.getLogger("Erro ap aplicar máscara");
        }
        return telefone;
    }

    public static String removerMascara(String telefone) {
        return telefone.replaceAll("/|\\.|-","");
    }
}
