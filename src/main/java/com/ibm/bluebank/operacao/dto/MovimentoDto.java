package com.ibm.bluebank.operacao.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ibm.bluebank.shared.enums.EnumTipoOperacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimentoDto {

    private EnumTipoOperacao tipo;
    private String data;
    private Double valor;
    private String descricao;

}
