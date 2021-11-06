package com.ibm.bluebank.conta.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ContaDto {

    private Long numero;
    private Long agencia;
    private Double saldo;
    private Double limite;

}
