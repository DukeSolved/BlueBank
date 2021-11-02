package com.ibm.bluebank.cliente.dto;

import com.ibm.bluebank.conta.dto.ContaDto;

public class DepositoDto {

    private Double valor;
    private ContaDto conta;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public ContaDto getConta() {
        return conta;
    }

    public void setConta(ContaDto conta) {
        this.conta = conta;
    }
}
