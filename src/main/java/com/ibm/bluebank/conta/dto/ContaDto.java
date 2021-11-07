package com.ibm.bluebank.conta.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ContaDto {

    private String numero;
    private String agencia;
    private Double saldo;
    private Double limite;
    private Double limiteDisponivel = 0.0;

}
