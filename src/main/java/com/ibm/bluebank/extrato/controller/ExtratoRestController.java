package com.ibm.bluebank.extrato.controller;

import com.ibm.bluebank.extrato.dto.ExtratoDto;
import com.ibm.bluebank.extrato.service.ExtratoService;
import com.ibm.bluebank.extrato.validator.ExtratoValidator;
import com.ibm.bluebank.shared.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("extrato")
public class ExtratoRestController {

    @Autowired
    private ExtratoService extratoService;

    @Autowired
    private ExtratoValidator extratoValidator;

    @PostMapping()
    public ResponseEntity<Response> extrato(@RequestBody ExtratoDto extratoRequest, BindingResult result) {
        Response<ExtratoDto> response = new Response<>();
        return ResponseEntity.ok(response);
    }

}
