package com.ibm.bluebank.shared.controller;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.shared.dto.Response;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public abstract class Controller {

    public void fillResponseErrors(Response<ClienteDto> response, BindingResult result) {
        response.setSucesso(false);
        Map<String, String> erros = new HashMap<>();
        result.getAllErrors().forEach(erro -> erros.put(erro.getObjectName(), erro.getDefaultMessage()));
        response.setErros(erros);
    }
}
