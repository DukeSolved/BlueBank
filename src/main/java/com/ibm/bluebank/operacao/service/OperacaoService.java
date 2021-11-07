package com.ibm.bluebank.operacao.service;

import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.operacao.dto.ExtratoDto;
import com.ibm.bluebank.operacao.model.Operacao;

import java.util.Date;

public interface OperacaoService {

    void deposito(Operacao operacao);

    void saque(Operacao operacao);

    void transferir(Operacao operacao);

    ExtratoDto getExtrato(Cliente cliente, Date dataInicio, Date dataFim);

}
