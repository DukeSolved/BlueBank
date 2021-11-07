package com.ibm.bluebank.cliente.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ibm.bluebank.conta.dto.ContaDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDto {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;
    private Double renda;
    private String token;
    private Optional<ContaDto> conta = Optional.empty();
}
