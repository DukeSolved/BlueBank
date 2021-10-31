package com.ibm.bluebank.cliente.service.impl;

import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.cliente.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Override
    public Cliente getClienteByToken(String token) {
        return new Cliente();
    }
}
