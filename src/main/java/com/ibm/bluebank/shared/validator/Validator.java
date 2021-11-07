package com.ibm.bluebank.shared.validator;

import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.cliente.service.ClienteService;
import com.ibm.bluebank.conta.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Optional;

public abstract class Validator {

    @Autowired
    public ClienteService clienteService;

    @Autowired
    public ContaService contaService;

    public void validarToken(String token, BindingResult result) {
        if (validarCampoString(token, "token", "Token não informado", result)) {
            Optional<Cliente> cliente = clienteService.getClienteByToken(token);
            if (!cliente.isPresent()) {
                result.addError(new ObjectError("token", "Token inválido"));
            }
        }
    }

    public Boolean validarCampoString(String param, String name, String mensagemSeNaoPresente, BindingResult result) {
        return validarCampoString(param, name, mensagemSeNaoPresente, result, true);
    }

    public Boolean validarCampoString(String param, String name, String mensagemSeNaoPresente, BindingResult result, Boolean obrigatorio) {
        Optional<String> paramOpt = Optional.ofNullable(param);
        if (!paramOpt.isPresent()) {
            if (obrigatorio) {
                result.addError(new ObjectError(name, mensagemSeNaoPresente));
            }
        }
        return paramOpt.isPresent();
    }

    public Boolean validarCampoDoubleObrigatorio(Double param, String name, String mensagemSeNaoPresente, BindingResult result) {
        boolean isNull = param == null;
        if (isNull) {
            result.addError(new ObjectError(name, mensagemSeNaoPresente));
        }
        return isNull;
    }
}
