package com.ibm.bluebank.extrato.controller;

import com.ibm.bluebank.extrato.dto.ExtratoDto;
import com.ibm.bluebank.extrato.service.ExtratoService;
import com.ibm.bluebank.shared.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("extratos")
public class ExtratoRestController {

    @Autowired
    private ExtratoService extratoService;

    @GetMapping
    public ResponseEntity<Response> extrato(@RequestParam("inicio") Date inicio, @RequestParam("fim") Date fim) {
        Response<ExtratoDto> response = new Response<>();
        return ResponseEntity.ok(response);
    }

}
