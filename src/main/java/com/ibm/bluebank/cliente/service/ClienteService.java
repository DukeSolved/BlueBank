package com.ibm.bluebank.cliente.service;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    ClienteDto criarCliente(ClienteDto clienteDto);

    Optional<Cliente> getClienteByToken(String token);

    List<Cliente> getClientes();

    Boolean clienteJaCadastrado(String cpf);
}
