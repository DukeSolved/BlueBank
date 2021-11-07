package com.ibm.bluebank.shared.utils;

import com.ibm.bluebank.conta.model.Conta;
import com.ibm.bluebank.shared.enums.EnumStatusConta;

import java.util.Date;

public class ContaUtil {

    public static Conta getConta(Double renda) {
        Conta conta = new Conta();
        conta.setCriadoEm(new Date());
        conta.setSaldo(0.0);
        conta.setLimite(renda * 10);
        conta.setNumero(String.valueOf(System.currentTimeMillis()));
        conta.setAgencia("0001");
        conta.setStatus(EnumStatusConta.ATIVA);
        return conta;
    }
}
