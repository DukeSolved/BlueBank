package com.ibm.bluebank.extrato.service.impl;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.conta.dto.ContaDto;
import com.ibm.bluebank.extrato.dto.ExtratoDto;
import com.ibm.bluebank.extrato.dto.MovimentoDto;
import com.ibm.bluebank.extrato.service.ExtratoService;
import com.ibm.bluebank.shared.dates.converter.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ExtratoServiceImpl implements ExtratoService {

    @Autowired
    private DataConverter dataConverter;

    @Override
    public ExtratoDto getExtrato(Cliente cliente, Date dataInicio, Date dataFim) {
        ExtratoDto extrato = new ExtratoDto();
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNome("Ezequiel Lorenzatti");

        ContaDto contaDto = new ContaDto();
        contaDto.setNumero("0000000001");
        contaDto.setSaldo(new BigDecimal(500000.00));
        clienteDto.setContaDto(contaDto);

        extrato.setCliente(clienteDto);

        extrato.setInicio(dataConverter.toString(dataInicio));
        extrato.setFim(dataConverter.toString(dataFim));

        List<MovimentoDto> movimento = Arrays.asList(
                new MovimentoDto(new Date(), "Deposito", 50000.00),
                new MovimentoDto(new Date(), "Saque", 50000.00),
                new MovimentoDto(new Date(), "Tranferência", 500.01)
        );
        extrato.setMovimento(movimento);
        return extrato;
    }
}
