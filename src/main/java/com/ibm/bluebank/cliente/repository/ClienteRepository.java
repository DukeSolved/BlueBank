package com.ibm.bluebank.cliente.repository;

import com.ibm.bluebank.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByToken(String token);
}
