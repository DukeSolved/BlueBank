package com.ibm.bluebank.cliente.service.impl;

import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.cliente.repository.ClienteRepository;
import com.ibm.bluebank.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Optional<Cliente> getClienteByToken(String token) {
        return Optional.ofNullable(clienteRepository.findByToken(token));
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Boolean clienteJaCadastrado(String cpf) {
        return clienteRepository.countByCpf(cpf) > 0;
    }
}
