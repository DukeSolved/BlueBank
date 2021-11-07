package com.ibm.bluebank.conta.converter;

import com.ibm.bluebank.conta.dto.ContaDto;
import com.ibm.bluebank.conta.model.Conta;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ContaConverter {

    public Function<Conta, ContaDto> toDto = new Function<Conta, ContaDto>() {
        @Override
        public ContaDto apply(Conta conta) {
            ContaDto contaDto = new ContaDto();
            contaDto.setNumero(conta.getNumero());
            contaDto.setAgencia(conta.getAgencia());
            contaDto.setSaldo(conta.getSaldo());
            contaDto.setLimite(conta.getLimite());
            if (conta.getSaldo() < 0) {
                contaDto.setLimiteDisponivel(conta.getSaldo() + conta.getLimite());
            }
            return contaDto;
        }
    };


}
