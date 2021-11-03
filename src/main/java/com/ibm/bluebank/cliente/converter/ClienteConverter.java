package com.ibm.bluebank.cliente.converter;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClienteConverter {

    public Function<Cliente, ClienteDto> toDto = new Function<Cliente, ClienteDto>() {
        @Override
        public ClienteDto apply(Cliente cliente) {
            return null;
        }
    };

    public Function<ClienteDto, Cliente> toModel = new Function<ClienteDto, Cliente>() {
        @Override
        public Cliente apply(ClienteDto clienteDto) {
            return null;
        }
    };
}
