package com.ibm.bluebank.cliente.service;

import com.ibm.bluebank.cliente.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Optional<Cliente> getClienteByToken(String token);

    Cliente salvar(Cliente cliente);

    List<Cliente> getClientes();

    Optional<Cliente> getClienteById(Long id);

    Boolean clienteJaCadastrado(String cpf);
}
