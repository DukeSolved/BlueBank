package com.ibm.bluebank.cliente.converter;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.conta.converter.ContaConverter;
import com.ibm.bluebank.conta.dto.ContaDto;
import com.ibm.bluebank.conta.model.Conta;
import com.ibm.bluebank.conta.service.ContaService;
import com.ibm.bluebank.shared.utils.CpfUtil;
import com.ibm.bluebank.shared.utils.SecurityUtil;
import com.ibm.bluebank.shared.utils.TelefoneUtil;
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
            clienteDto.setNome(cliente.getNome());
            clienteDto.setEmail(cliente.getEmail());
            clienteDto.setRenda(cliente.getRenda());
            clienteDto.setCpf(CpfUtil.applicarMascara(cliente.getCpf()));
            clienteDto.setToken(cliente.getToken());
            clienteDto.setTelefone(TelefoneUtil.aplicarMascara(cliente.getTelefone()));
            Optional<Conta> contaOpt = Optional.ofNullable(cliente.getConta());
            contaOpt.ifPresent(conta -> {
                ContaDto contaDto = contaConverter.toDto.apply(conta);
                clienteDto.setConta(Optional.of(contaDto));
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
            cliente.setCpf(CpfUtil.removerMascara(clienteDto.getCpf()));
            cliente.setEmail(clienteDto.getEmail());
            cliente.setTelefone(TelefoneUtil.removerMascara(clienteDto.getTelefone()));
            cliente.setSenha(SecurityUtil.getHash(clienteDto.getSenha()));
            cliente.setRenda(clienteDto.getRenda());

            return cliente;
        }
    };
}
