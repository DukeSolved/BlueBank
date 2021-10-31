package com.ibm.bluebank.extrato.service;

import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.extrato.dto.ExtratoDto;

import java.util.Date;

public interface ExtratoService {

    ExtratoDto getExtrato(Cliente cliente, Date dataInicio, Date dataFim);
}
