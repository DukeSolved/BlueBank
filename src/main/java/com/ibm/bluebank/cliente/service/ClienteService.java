package com.ibm.bluebank.cliente.service;

import com.ibm.bluebank.cliente.model.Cliente;

public interface ClienteService {

    Cliente getClienteByToken(String token);
}
