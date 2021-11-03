package com.ibm.bluebank.cliente.service.impl;

import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.cliente.repository.ClienteRepository;
import com.ibm.bluebank.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente getClienteByToken(String token) {
        return new Cliente();
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
