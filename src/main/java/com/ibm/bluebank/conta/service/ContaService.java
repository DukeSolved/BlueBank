package com.ibm.bluebank.conta.service;

import com.ibm.bluebank.conta.model.Conta;

import java.util.Optional;

public interface ContaService {

    Optional<Conta> getContaById(Long contaId);

    Optional<Conta> getContaByNumeroAndAgencia(Long numero, Long agencia);

    Conta criarConta(Double renda);
}
