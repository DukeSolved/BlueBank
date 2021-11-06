package com.ibm.bluebank.cliente.repository;

import com.ibm.bluebank.operacao.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
}
