package com.ibm.bluebank.operacao.dto;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ExtratoDto {

    private ClienteDto cliente;
    private String inicio;
    private String fim;
    private List<MovimentoDto> movimento;

}
