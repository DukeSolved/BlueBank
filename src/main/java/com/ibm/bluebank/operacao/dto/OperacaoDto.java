package com.ibm.bluebank.operacao.dto;

import com.ibm.bluebank.shared.enums.EnumTipoOperacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OperacaoDto {

    private EnumTipoOperacao tipo;
    private Double valor;
    private String numeroOperacao;
    private String agenciaOperacao;
    private String numeroDestino;
    private String agenciaDestino;

}
