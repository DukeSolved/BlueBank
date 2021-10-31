package com.ibm.bluebank.cliente.controller;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.service.ClienteService;
import com.ibm.bluebank.cliente.validator.ClienteValidator;
import com.ibm.bluebank.shared.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteValidator clienteValidator;

    @PostMapping()
    public ResponseEntity<Response> salvar(@RequestBody ClienteDto clienteRequest, BindingResult result) {
        Response<ClienteDto> response = new Response<>();
        return ResponseEntity.ok(response);
    }

}
