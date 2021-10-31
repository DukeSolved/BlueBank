package com.ibm.bluebank.extrato.service.impl;

import com.ibm.bluebank.extrato.dto.ExtratoDto;
import com.ibm.bluebank.extrato.service.ExtratoService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ExtratoServiceImpl implements ExtratoService {

    @Override
    public ExtratoDto getExtrato(Date dataInicio, Date dataFim) {
        return null;
    }
}
