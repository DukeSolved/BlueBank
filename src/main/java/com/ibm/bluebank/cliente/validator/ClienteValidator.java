package com.ibm.bluebank.cliente.validator;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

@Service
public class ClienteValidator {

    @Autowired
    private Validator validator;

    public void validate(ClienteDto clienteDto, BindingResult result){
        validator.validate(clienteDto, result);
    }
}
