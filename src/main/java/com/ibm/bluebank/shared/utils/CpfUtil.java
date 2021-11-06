package com.ibm.bluebank.shared.utils;

public class CpfUtil {
    public static boolean isValid(String cpf){
        int d1, d2;
        int digit1, digit2, rest;
        int digitCPF;
        String nDigitResult;

        if (cpf.trim().length() != 11){
            return false;
        }else if(Long.valueOf(cpf.trim()).equals(Long.valueOf("0")) || cpf.trim().equals("11111111111") ||
            cpf.trim().equals("22222222222") || cpf.equals("33333333333") ||
            cpf.trim().equals("44444444444") || cpf.equals("55555555555") ||
            cpf.trim().equals("66666666666") || cpf.equals("77777777777") ||
            cpf.trim().equals("88888888888") || cpf.equals("99999999999")){
            return false;
        }else{
            d1 = d2 = 0;
            digit1 = digit2 = rest = 0;

            for (int nCount = 1; nCount < cpf.length() -1; nCount++){
                digitCPF = Integer.valueOf(cpf.substring(nCount -1, nCount)).intValue();
                // multiplica a ultima casa por 2 a seguinte por 3 e assim por diante
                d1 = d1 + (11 - nCount) * digitCPF;
                // para o segundo digito repita o procedimento incluindo  o primeiro digito calculado no passo anterior
                d2 = d2 + (12 - nCount) * digitCPF;
            }
            //primeiro resto da divisao por 11
            rest = (d1 % 11);
            digit1 = (rest < 2?0:(11 - rest));
            d2 += 2 * digit1;

            // segundo resto da divisao por 11
            rest = (d2 % 11);
            digit2 = (rest < 2?0:(11 - rest));

            // digito verificador do cpf que esta sendo validado
            String nDigitVerif = cpf.substring(cpf.length() - 2, cpf.length());
            // concatenando o primeiro resto com o segundo
             nDigitResult = String.valueOf(digit1) + String.valueOf(digit2);
            //comparar o digito verificador do cpf com o primeiro resto + o segundo resto

            return nDigitVerif.equals(nDigitResult);

        }
    }
}
