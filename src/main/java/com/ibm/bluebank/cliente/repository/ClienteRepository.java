package com.ibm.bluebank.cliente.repository;

import com.ibm.bluebank.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByToken(String token);

    Cliente findByCpf(String cpf);

    Integer countByCpf(String cpf);
}
