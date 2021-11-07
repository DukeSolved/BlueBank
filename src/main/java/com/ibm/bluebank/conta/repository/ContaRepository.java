package com.ibm.bluebank.conta.repository;

import com.ibm.bluebank.conta.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findContaByNumeroAndAgencia(String numero, String agencia);

}
