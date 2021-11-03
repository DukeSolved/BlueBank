package com.ibm.bluebank.cliente.dto;

import com.ibm.bluebank.conta.dto.ContaDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClienteDto {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String fone;
    private String senha;
    private Double renda;
    private Long numero;
    private Long agencia;
    private Double saldo;
    private Double limite;

}
