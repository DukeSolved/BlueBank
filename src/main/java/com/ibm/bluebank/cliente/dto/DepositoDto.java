package com.ibm.bluebank.cliente.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DepositoDto {

    private Double valor;
    private String numero;
    private String agencia;

}
