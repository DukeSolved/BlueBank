package com.ibm.bluebank.cliente.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

@Service
public class ClienteValidator {

    @Autowired
    private Validator validator;

}
