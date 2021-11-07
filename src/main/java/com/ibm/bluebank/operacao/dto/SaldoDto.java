package com.ibm.bluebank.operacao.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class SaldoDto {

    private Double limite;
    private Double saldo;
    private Double limiteUtilizaco;

}
