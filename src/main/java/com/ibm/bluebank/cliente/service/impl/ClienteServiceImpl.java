package com.ibm.bluebank.cliente.service.impl;

import com.ibm.bluebank.cliente.converter.ClienteConverter;
import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.cliente.repository.ClienteRepository;
import com.ibm.bluebank.cliente.service.ClienteService;
import com.ibm.bluebank.conta.model.Conta;
import com.ibm.bluebank.conta.service.ContaService;
import com.ibm.bluebank.shared.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteConverter clienteConverter;

    @Autowired
    private ContaService contaService;

    @Override
    public Optional<Cliente> getClienteByToken(String token) {
        return Optional.ofNullable(clienteRepository.findByToken(token));
    }

    @Override
    public ClienteDto criarCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteConverter.toModel.apply(clienteDto);
        Conta conta = contaService.criarConta(cliente.getRenda());
        cliente.setConta(conta);
        cliente.setToken(SecurityUtil.gerarToken(cliente));
        cliente = clienteRepository.save(cliente);
        return clienteConverter.toDto.apply(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Boolean clienteJaCadastrado(String cpf) {
        return clienteRepository.countByCpf(cpf) > 0;
    }
}
