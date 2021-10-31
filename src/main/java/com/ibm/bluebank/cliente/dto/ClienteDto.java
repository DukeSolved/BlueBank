package com.ibm.bluebank.cliente.dto;

import com.ibm.bluebank.conta.dto.ContaDto;

public class ClienteDto {

    private String nome;
    private ContaDto contaDto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContaDto getContaDto() {
        return contaDto;
    }

    public void setContaDto(ContaDto contaDto) {
        this.contaDto = contaDto;
    }
}
