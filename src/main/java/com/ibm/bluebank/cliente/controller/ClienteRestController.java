package com.ibm.bluebank.cliente.controller;

import com.ibm.bluebank.cliente.converter.ClienteConverter;
import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.dto.DepositoDto;
import com.ibm.bluebank.cliente.dto.SaqueDto;
import com.ibm.bluebank.cliente.dto.TransferenciaDto;
import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.cliente.service.ClienteService;
import com.ibm.bluebank.cliente.validator.ClienteValidator;
import com.ibm.bluebank.operacao.dto.ExtratoDto;
import com.ibm.bluebank.operacao.service.ExtratoService;
import com.ibm.bluebank.shared.dates.converter.DataConverter;
import com.ibm.bluebank.shared.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteConverter clienteConverter;

    @Autowired
    private ClienteValidator clienteValidator;

    @Autowired
    private ExtratoService extratoService;

    @Autowired
    private DataConverter dateConverter;

    @PostMapping()
    public ResponseEntity<Response> salvar(@RequestBody ClienteDto clienteRequest, BindingResult result) {
        Response<ClienteDto> response = new Response<>();
        clienteValidator.validate(clienteRequest, result);
        if (result.hasErrors()) {
            response.setSucesso(false);
            Map<String, String> erros = new HashMap<>();
            result.getAllErrors().forEach(erro -> erros.put(erro.getObjectName(), erro.getDefaultMessage()));
            response.setErros(erros);
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

    @GetMapping(value = "/{token}")
    public ResponseEntity<Response> getCliente(@PathParam("token") String token) {
        Response<ClienteDto> response = new Response<>();
        Optional<Cliente> clienteOpt = clienteService.getClienteByToken(token);
        clienteOpt.ifPresent(cliente -> {
            ClienteDto clienteDto = clienteConverter.toDto.apply(cliente);
            response.setSucesso(true);
            response.setData(clienteDto);
        });
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/{token}/conta/depositar")
    public ResponseEntity<Response> depositar(@PathParam("token") String token, @RequestBody DepositoDto depositoDto) {
        Response<String> response = new Response<>();

        response.setData("Depósito realizado");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/{token}/conta/sacar")
    public ResponseEntity<Response> sacar(@PathParam("token") String token, @RequestBody SaqueDto saqueDto) {
        Response<String> response = new Response<>();
        response.setData("Saque realizado");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/{token}/conta/tranferir")
    public ResponseEntity<Response> transferir(@PathParam("token") String token, @RequestBody TransferenciaDto transferenciaDto) {
        Response<String> response = new Response<>();
        response.setData("Transferência realizada");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{token}/conta/extrato")
    public ResponseEntity<Response> extrato(@PathParam("token") String token, @RequestParam("inicio") String inicio, @RequestParam("fim") String fim) {
        Response<ExtratoDto> response = new Response<>();
        Map<String, String> erros = new HashMap<>();
        Optional<Cliente> clienteOpt = clienteService.getClienteByToken(token);
        Date dataInicio = dateConverter.toDate("inicio", inicio, erros);
        Date dataFim = dateConverter.toDate("fim", fim, erros);
        if (erros.size() > 0) {
            response.setErros(erros);
            response.setSucesso(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if (clienteOpt.isPresent()) {
            ExtratoDto extrato = extratoService.getExtrato(clienteOpt.get(), dataInicio, dataFim);
            response.setSucesso(true);
            response.setData(extrato);
        }
        return ResponseEntity.ok(response);
    }
}
