package com.ibm.bluebank.extrato.dto;

import java.math.BigDecimal;
import java.util.Date;

public class MovimentoDto {

    private Date data;
    private String descricao;
    private Double valor;

    public MovimentoDto() {
    }

    public MovimentoDto(Date data, String descricao, Double valor) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
