package com.ibm.bluebank.conta.service.impl;

import com.ibm.bluebank.conta.model.Conta;
import com.ibm.bluebank.conta.repository.ContaRepository;
import com.ibm.bluebank.conta.service.ContaService;
import com.ibm.bluebank.shared.utils.ContaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public Optional<Conta> getContaById(Long contaId) {
        return contaRepository.findById(contaId);
    }

    @Override
    public Optional<Conta> getContaByNumeroAndAgencia(Long numero, Long agencia) {
        return contaRepository.findContaByNumeroAndAgencia(numero, agencia);
    }

    @Override
    public Conta criarConta(Double renda) {
        Conta conta = ContaUtil.getConta(renda);
        contaRepository.save(conta);
        return conta;
    }
}
