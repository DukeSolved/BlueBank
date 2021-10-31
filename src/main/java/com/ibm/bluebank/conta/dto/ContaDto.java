package com.ibm.bluebank.conta.dto;

import java.math.BigDecimal;

public class ContaDto {

    private String numero;
    private BigDecimal saldo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
