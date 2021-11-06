package com.ibm.bluebank.cliente.converter;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.conta.converter.ContaConverter;
import com.ibm.bluebank.conta.model.Conta;
import com.ibm.bluebank.conta.service.ContaService;
import com.ibm.bluebank.shared.utils.SenhaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class ClienteConverter {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ContaConverter contaConverter;

    public Function<Cliente, ClienteDto> toDto = new Function<Cliente, ClienteDto>() {
        @Override
        public ClienteDto apply(Cliente cliente) {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setId(cliente.getId());
            clienteDto.setNome(cliente.getNome());
            clienteDto.setEmail(cliente.getEmail());
            clienteDto.setSenha(cliente.getSenha());
            clienteDto.setRenda(cliente.getRenda());
            clienteDto.setCpf(cliente.getCpf());
            clienteDto.setToken(cliente.getToken());
            Optional<Conta> contaOpt = Optional.ofNullable(cliente.getConta());
            contaOpt.ifPresent(conta -> {
                clienteDto.setConta(conta.getNumero());
                clienteDto.setAgencia(conta.getAgencia());
                clienteDto.setSaldo(conta.getSaldo());
                clienteDto.setLimite(conta.getLimite());
            });
            return clienteDto;
        }
    };

    public Function<ClienteDto, Cliente> toModel = new Function<ClienteDto, Cliente>() {
        @Override
        public Cliente apply(ClienteDto clienteDto) {
            Cliente cliente = new Cliente();
            cliente.setId(clienteDto.getId());
            cliente.setNome(clienteDto.getNome());
            cliente.setCpf(clienteDto.getCpf());
            cliente.setFone(clienteDto.getFone());
            cliente.setEmail(clienteDto.getEmail());
            cliente.setSenha(SenhaUtil.getHash(clienteDto.getSenha()));
            cliente.setRenda(clienteDto.getRenda());
            Optional<Conta> contaOpt = contaService.getContaByNumeroAndAgencia(clienteDto.getConta(), clienteDto.getAgencia());
            contaOpt.ifPresent(conta -> cliente.setConta(conta));
            return cliente;
        }
    };
}
