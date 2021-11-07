package com.ibm.bluebank.conta.service;

import com.ibm.bluebank.conta.model.Conta;

import java.util.Optional;

public interface ContaService {

    Optional<Conta> getContaById(Long contaId);

    Optional<Conta> getContaByNumeroAndAgencia(String numero, String agencia);

    Conta criarConta(Double renda);

    Conta salvar(Conta conta);

    void adicionarAoSaldo(Conta contaOperacao, Double valor);

    void descontarDoSaldo(Conta contaOperacao, Double valor);
}
