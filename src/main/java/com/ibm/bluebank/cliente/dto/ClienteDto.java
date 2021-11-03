package com.ibm.bluebank.cliente.dto;

import com.ibm.bluebank.conta.dto.ContaDto;

public class ClienteDto {

    private String nome;
    private ContaDto conta = new ContaDto();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContaDto getConta() {
        return conta;
    }

    public void setConta(ContaDto conta) {
        this.conta = conta;
    }
}
