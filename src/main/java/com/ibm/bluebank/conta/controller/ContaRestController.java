package com.ibm.bluebank.conta.controller;

import com.ibm.bluebank.conta.dto.ContaDto;
import com.ibm.bluebank.conta.service.ContaService;
import com.ibm.bluebank.conta.validator.ContaValidator;
import com.ibm.bluebank.shared.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conta")
public class ContaRestController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ContaValidator contaValidator;

    @PostMapping()
    public ResponseEntity<Response> salvar(@RequestBody ContaDto contaRequest, BindingResult result) {
        Response<ContaDto> response = new Response<>();
        return ResponseEntity.ok(response);
    }

}
