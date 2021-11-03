package com.ibm.bluebank.cliente.controller;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.dto.DepositoDto;
import com.ibm.bluebank.cliente.dto.SaqueDto;
import com.ibm.bluebank.cliente.dto.TransferenciaDto;
import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.cliente.service.ClienteService;
import com.ibm.bluebank.cliente.validator.ClienteValidator;
import com.ibm.bluebank.extrato.dto.ExtratoDto;
import com.ibm.bluebank.extrato.service.ExtratoService;
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
    private ClienteValidator clienteValidator;

    @Autowired
    private ExtratoService extratoService;

    @Autowired
    private DataConverter dateConverter;


    @PostMapping()
    public ResponseEntity<Response> salvar(@RequestBody ClienteDto clienteRequest, BindingResult result) {
        Response<ClienteDto> response = new Response<>();
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<Response> getClientes() {
        Response<List<ClienteDto>> response = new Response<>();
        List<ClienteDto> clientes = Arrays.asList(new ClienteDto(), new ClienteDto());
        response.setData(clientes);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Response> getCliente(@PathParam("id") Long id) {
        Response<ClienteDto> response = new Response<>();
        response.setData(new ClienteDto());
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/{id}/conta/depositar")
    public ResponseEntity<Response> depositar(@PathParam("id") Long id, @RequestBody DepositoDto depositoDto) {
        Response<String> response = new Response<>();
        response.setData("Depósito realizado");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/{id}/conta/sacar")
    public ResponseEntity<Response> sacar(@PathParam("id") Long id, @RequestBody SaqueDto saqueDto) {
        Response<String> response = new Response<>();
        response.setData("Saque realizado");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/{id}/conta/tranferir")
    public ResponseEntity<Response> transferir(@PathParam("id") Long id, @RequestBody TransferenciaDto transferenciaDto) {
        Response<String> response = new Response<>();
        response.setData("Transferência realizada");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{id}/conta/extrato")
    public ResponseEntity<Response> extrato(@PathParam("id") Long id, @RequestParam("inicio") String inicio, @RequestParam("fim") String fim) {
        Response<ExtratoDto> response = new Response<>();
        Map<String, String> erros = new HashMap<>();
        Date dataInicio = dateConverter.toDate("inicio", inicio, erros);
        Date dataFim = dateConverter.toDate("fim", fim, erros);
        if (erros.size() > 0) {
            response.setErros(erros);
            response.setSucesso(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        String token = ""; // o token do usuario será obetido pelo request;
        Cliente cliente = clienteService.getClienteByToken(token);
        ExtratoDto extrato = extratoService.getExtrato(cliente, dataInicio, dataFim);
        response.setSucesso(true);
        response.setData(extrato);
        return ResponseEntity.ok(response);
    }
}
