package com.ibm.bluebank.cliente.validator;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Service
public class ClienteValidator {

    public void validate(ClienteDto clienteDto, BindingResult result) {
        // exemplo de validacao
        if (clienteDto.getCpf() == null) {
            result.addError(new ObjectError("cpf", "Não pode ser null"));
        }
    }
}
