package com.ibm.bluebank.extrato.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

@Service
public class ExtratoValidator {

    @Autowired
    private Validator validator;

}
