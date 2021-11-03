package com.ibm.bluebank.extrato.dto;

import com.ibm.bluebank.cliente.dto.ClienteDto;

import java.util.List;

public class ExtratoDto {

    private ClienteDto cliente;
    private String inicio;
    private String fim;
    private List<MovimentoDto> movimento;

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public List<MovimentoDto> getMovimento() {
        return movimento;
    }

    public void setMovimento(List<MovimentoDto> movimento) {
        this.movimento = movimento;
    }
}
