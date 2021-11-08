package com.ibm.bluebank.cliente.controller;

import com.ibm.bluebank.cliente.converter.ClienteConverter;
import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.cliente.service.ClienteService;
import com.ibm.bluebank.cliente.validator.ClienteValidator;
import com.ibm.bluebank.operacao.converter.OperacaoConverter;
import com.ibm.bluebank.operacao.dto.ExtratoDto;
import com.ibm.bluebank.operacao.dto.MovimentoDto;
import com.ibm.bluebank.operacao.dto.OperacaoDto;
import com.ibm.bluebank.operacao.model.Operacao;
import com.ibm.bluebank.operacao.service.OperacaoService;
import com.ibm.bluebank.operacao.validator.OperacaoValidator;
import com.ibm.bluebank.shared.controller.Controller;
import com.ibm.bluebank.shared.dates.converter.DataConverter;
import com.ibm.bluebank.shared.dto.Response;
import com.ibm.bluebank.shared.enums.EnumTipoOperacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestController extends Controller {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteConverter clienteConverter;

    @Autowired
    private OperacaoConverter operacaoConverter;

    @Autowired
    private ClienteValidator clienteValidator;

    @Autowired
    private OperacaoValidator operacaoValidator;

    @Autowired
    private OperacaoService operacaoService;

    @Autowired
    private DataConverter dateConverter;

    @PostMapping()
    public ResponseEntity<Response> salvar(@RequestBody ClienteDto clienteRequest, BindingResult result) {
        Response<ClienteDto> response = new Response<>();
        clienteValidator.validarClienteDto(clienteRequest, result);

        if (result.hasErrors()) {
            fillResponseErrors(response, result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        ClienteDto clienteDto = clienteService.criarCliente(clienteRequest);
        response.setSucesso(true);
        response.setData(clienteDto);
        return ResponseEntity.ok(response);
    }


    @GetMapping()
    public ResponseEntity<Response> getClientes() {
        Response<List<ClienteDto>> response = new Response<>();
        List<Cliente> clientes = clienteService.getClientes();
        List<ClienteDto> clientesDto = new ArrayList<>();
        clientes.forEach(cliente -> {
            ClienteDto clienteDto = clienteConverter.toDto.apply(cliente);
            clientesDto.add(clienteDto);
        });
        response.setSucesso(true);
        response.setData(clientesDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Response> getCliente(@PathVariable(value = "cpf") String cpf) {
        Response<ClienteDto> response = new Response<>();
        Map<String, String> erros = new HashMap<>();
        MapBindingResult result = new MapBindingResult(erros, "cpf");
        clienteValidator.validarCPF(cpf, result);
        if (result.hasErrors()) {
            fillResponseErrors(response, result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Optional<Cliente> clienteOpt = clienteService.getClienteByCpf(cpf);
        clienteOpt.ifPresent(cliente -> {
            ClienteDto clienteDto = clienteConverter.toDto.apply(cliente);
            response.setSucesso(true);
            response.setData(clienteDto);
        });
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/{token}/depositar")
    public ResponseEntity<Response> depositar(@PathVariable("token") String token, @RequestBody OperacaoDto operacaoDto, BindingResult result) {
        Response<String> response = new Response<>();
        operacaoDto.setTipo(EnumTipoOperacao.DEPOSITO);
        operacaoValidator.validarOperacao(token, operacaoDto, result);
        if (result.hasErrors()) {
            fillResponseErrors(response, result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Operacao operacao = operacaoConverter.toModel.apply(operacaoDto);
        operacaoService.deposito(operacao);
        response.setSucesso(true);
        response.setData("Depósito realizado !");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/{token}/sacar")
    public ResponseEntity<Response> sacar(@PathVariable("token") String token, @RequestBody OperacaoDto operacaoDto, BindingResult result) {
        Response<String> response = new Response<>();
        operacaoDto.setTipo(EnumTipoOperacao.SAQUE);
        operacaoValidator.validarOperacao(token, operacaoDto, result);
        if (result.hasErrors()) {
            fillResponseErrors(response, result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Operacao operacao = operacaoConverter.toModel.apply(operacaoDto);
        operacaoService.saque(operacao);
        response.setSucesso(true);
        response.setData("Saque realizado !");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/{token}/transferir")
    public ResponseEntity<Response> transferir(@PathVariable("token") String token, @RequestBody OperacaoDto operacaoDto, BindingResult result) {
        Response<String> response = new Response<>();
        operacaoDto.setTipo(EnumTipoOperacao.TRANSFERENCIA);
        operacaoValidator.validarOperacao(token, operacaoDto, result);
        if (result.hasErrors()) {
            fillResponseErrors(response, result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Operacao operacao = operacaoConverter.toModel.apply(operacaoDto);
        operacaoService.transferir(operacao);
        response.setSucesso(true);
        response.setData("Transferência realizada");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{token}/extrato")
    public ResponseEntity<Response> extrato(@PathVariable("token") String token, @RequestParam("inicio") String inicio, @RequestParam("fim") String fim) {
        Response<ExtratoDto> response = new Response<>();
        Map<String, String> erros = new HashMap<>();
        MapBindingResult result = new MapBindingResult(erros, "extrato");
        operacaoValidator.validarExtrato(token, inicio, fim, result);
        if (erros.size() > 0) {
            fillResponseErrors(response, result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Optional<Cliente> clienteOpt = clienteService.getClienteByToken(token);
        Date dataInicio = dateConverter.toDate(inicio);
        Date dataFim = dateConverter.toDate(fim);
        if (clienteOpt.isPresent()) {
            ExtratoDto extrato = new ExtratoDto();
            extrato.setCliente(clienteConverter.toDto.apply(clienteOpt.get()));
            extrato.setInicio(dateConverter.toString(dataInicio));
            extrato.setFim(dateConverter.toString(dataFim));
            List<MovimentoDto> movimentos = new ArrayList<>();
            List<Operacao> operacoes = operacaoService.getOperacoes(clienteOpt.get(), dataInicio, dataFim);
            operacoes.forEach(operacao -> {
                movimentos.add(operacaoConverter.toMovimentoDto.apply(operacao));
            });
            extrato.setMovimento(movimentos);
            response.setSucesso(true);
            response.setData(extrato);
        }
        return ResponseEntity.ok(response);
    }

}
