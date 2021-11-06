package com.ibm.bluebank.operacao.dto;

import com.ibm.bluebank.shared.enums.EnumTipoMovimento;

import java.util.Date;

public class MovimentoDto {

    private EnumTipoMovimento tipo;
    private Date data;
    private Double valor;

    public MovimentoDto() {
    }

    public MovimentoDto(EnumTipoMovimento tipo, Date data, Double valor) {
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
    }

    public EnumTipoMovimento getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoMovimento tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
