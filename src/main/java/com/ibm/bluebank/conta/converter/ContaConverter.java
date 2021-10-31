package com.ibm.bluebank.conta.converter;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.conta.dto.ContaDto;
import com.ibm.bluebank.conta.model.Conta;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ContaConverter {

    public Function<Conta, ContaDto> toDto = new Function<Conta, ContaDto>() {
        @Override
        public ContaDto apply(Conta conta) {
            return null;
        }
    };

    public Function<ContaDto, Conta> toModel = new Function<ContaDto, Conta>() {
        @Override
        public Conta apply(ContaDto contaDto) {
            return null;
        }
    };
}
