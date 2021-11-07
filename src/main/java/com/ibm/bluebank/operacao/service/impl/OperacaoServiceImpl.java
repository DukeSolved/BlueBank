package com.ibm.bluebank.operacao.service.impl;

import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.conta.service.ContaService;
import com.ibm.bluebank.operacao.dto.ExtratoDto;
import com.ibm.bluebank.operacao.model.Operacao;
import com.ibm.bluebank.operacao.repository.OperacaoRepository;
import com.ibm.bluebank.operacao.service.OperacaoService;
import com.ibm.bluebank.shared.dates.converter.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OperacaoServiceImpl implements OperacaoService {

    @Autowired
    private DataConverter dataConverter;

    @Autowired
    private OperacaoRepository operacaoRepository;

    @Autowired
    private ContaService contaService;

    @Override
    public void deposito(Operacao operacao) {
        operacao = operacaoRepository.save(operacao);
        contaService.adicionarAoSaldo(operacao.getContaDestino(), operacao.getValor());
    }

    @Override
    public void saque(Operacao operacao) {
        operacao = operacaoRepository.save(operacao);
        contaService.descontarDoSaldo(operacao.getContaOperacao(), operacao.getValor());
    }

    @Override
    public void transferir(Operacao operacao) {
        operacao = operacaoRepository.save(operacao);
        contaService.adicionarAoSaldo(operacao.getContaDestino(), operacao.getValor());
        contaService.descontarDoSaldo(operacao.getContaOperacao(), operacao.getValor());
    }

    @Override
    public ExtratoDto getExtrato(Cliente cliente, Date dataInicio, Date dataFim) {
        return new ExtratoDto();
    }


}
