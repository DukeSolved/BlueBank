package com.ibm.bluebank.conta.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

@Service
public class ContaValidator {

    @Autowired
    private Validator validator;

}
