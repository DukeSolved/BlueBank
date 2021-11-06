package com.ibm.bluebank.operacao.service.impl;

import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.operacao.dto.ExtratoDto;
import com.ibm.bluebank.operacao.service.ExtratoService;
import com.ibm.bluebank.shared.dates.converter.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ExtratoServiceImpl implements ExtratoService {

    @Autowired
    private DataConverter dataConverter;

    @Override
    public ExtratoDto getExtrato(Cliente cliente, Date dataInicio, Date dataFim) {
        return new ExtratoDto();
    }
}
