package com.ibm.bluebank.extrato.controller;

import com.ibm.bluebank.extrato.dto.ExtratoDto;
import com.ibm.bluebank.extrato.service.ExtratoService;
import com.ibm.bluebank.shared.dates.converter.DataConverter;
import com.ibm.bluebank.shared.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("extratos")
public class ExtratoRestController {

    @Autowired
    private ExtratoService extratoService;

    @Autowired
    private DataConverter dateConverter;

    @GetMapping
    public ResponseEntity<Response> extrato(@RequestParam("inicio") String inicio, @RequestParam("fim") String fim) {
        Response<ExtratoDto> response = new Response<>();

        Map<String, String> erros = new HashMap<>();
        Date dataInicio = dateConverter.toDate("inicio", inicio, erros);
        Date dataFim = dateConverter.toDate("fim", fim, erros);
        if (erros.size() > 0) {
            response.setErros(erros);
            response.setSucesso(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        ExtratoDto extrato = extratoService.getExtrato(dataInicio, dataFim);
        response.setSucesso(true);
        response.setData(extrato);
        return ResponseEntity.ok(response);
    }

}
