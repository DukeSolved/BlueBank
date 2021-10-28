package com.ibm.bluebank.rest.controller;

import com.ibm.bluebank.rest.dto.Response;
import com.ibm.bluebank.service.TesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteRestController {

    @Autowired
    private TesteService testeService;

    @GetMapping("/teste")
    public ResponseEntity<Response> teste() {
        Response<String> response = new Response<>();
        response.setSucesso(true);
        response.setData(testeService.teste());
        return ResponseEntity.ok(response);
    }


}
