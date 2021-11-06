package com.ibm.bluebank.operacao.service;

import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.operacao.dto.ExtratoDto;

import java.util.Date;

public interface ExtratoService {

    ExtratoDto getExtrato(Cliente cliente, Date dataInicio, Date dataFim);
}
