package com.ibm.bluebank.cliente.validator;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Optional;

@Service
public class ClienteValidator {

    @Autowired
    private ClienteService clienteService;

    public void validate(ClienteDto clienteDto, BindingResult result) {
        Optional<String> optCpf = Optional.ofNullable(clienteDto.getCpf());
        if (optCpf.isPresent()) {
            boolean clienteJaCadastrado = clienteService.clienteJaCadastrado(clienteDto.getCpf());
            if (clienteJaCadastrado) {
                result.addError(new ObjectError("cpf", "O CPF já está cadastrado"));
            }
        } else {
            result.addError(new ObjectError("cpf", "O CPF não informado"));
        }
    }
}
