package com.ibm.bluebank.extrato.service;

import com.ibm.bluebank.extrato.dto.ExtratoDto;

import java.util.Date;

public interface ExtratoService {

    ExtratoDto getExtrato(Date dataInicio, Date dataFim);
}
