package com.ibm.bluebank.cliente.repository;

import com.ibm.bluebank.conta.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
