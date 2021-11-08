package com.ibm.bluebank.operacao.service;

import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.operacao.model.Operacao;

import java.util.Date;
import java.util.List;

public interface OperacaoService {

    void deposito(Operacao operacao);

    void saque(Operacao operacao);

    void transferir(Operacao operacao);

    List<Operacao> getOperacoes(Cliente cliente, Date dataInicio, Date dataFim);

}
