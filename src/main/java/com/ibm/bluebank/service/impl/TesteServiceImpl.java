package com.ibm.bluebank.service.impl;

import com.ibm.bluebank.service.TesteService;
import org.springframework.stereotype.Service;

@Service
public class TesteServiceImpl implements TesteService {

    @Override
    public String teste() {
        return "teste";
    }
}
