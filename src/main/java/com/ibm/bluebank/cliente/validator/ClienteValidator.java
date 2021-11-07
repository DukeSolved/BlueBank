package com.ibm.bluebank.cliente.validator;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.shared.utils.CpfUtil;
import com.ibm.bluebank.shared.utils.EmailUtil;
import com.ibm.bluebank.shared.utils.TelefoneUtil;
import com.ibm.bluebank.shared.validator.Validator;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Service
public class ClienteValidator extends Validator {

    public void validate(ClienteDto clienteDto, BindingResult result) {
        validarCampoStringObrigatorio(clienteDto.getNome(), "nome", "Nome não informado", result);
        validarCampoStringObrigatorio(clienteDto.getSenha(), "senha", "Senha não informada", result);
        validarCampoDoubleObrigatorio(clienteDto.getRenda(), "renda", "Renda não informada", result);
        validarEmail(clienteDto, result);
        validarCPF(clienteDto, result);
        validarTelefone(clienteDto, result);
    }

    private void validarEmail(ClienteDto clienteDto, BindingResult result) {
        if (validarCampoStringObrigatorio(clienteDto.getTelefone(), "email", "Email não informado", result)) {
            Boolean valido = EmailUtil.validarEmail(clienteDto.getEmail());
            if (!valido) {
                result.addError(new ObjectError("email", "Email inválido"));
            }
        }
    }

    private void validarTelefone(ClienteDto clienteDto, BindingResult result) {
        if (validarCampoStringObrigatorio(clienteDto.getTelefone(), "telefone", "Telefone não informado", result)) {
            String telefone = TelefoneUtil.removerMascara(clienteDto.getTelefone());
            if (!(telefone.length() == 10 || telefone.length() == 11)) {
                result.addError(new ObjectError("telefone", "Telefone invalido, um número de telefone deve possuir 2 dígitos de DDD seguido de 8 ou 9 dígitos do número"));
            }
        }
    }

    private void validarCPF(ClienteDto clienteDto, BindingResult result) {
        if (validarCampoStringObrigatorio(clienteDto.getCpf(), "cpf", "CPF não informado", result)) {
            String cpf = CpfUtil.removerMascara(clienteDto.getCpf());
            boolean isValid = CpfUtil.isValid(cpf);
            if (isValid) {
                boolean clienteJaCadastrado = clienteService.clienteJaCadastrado(cpf);
                if (clienteJaCadastrado) {
                    result.addError(new ObjectError("cpf", "Cliente já está cadastrado"));
                }
            } else {
                result.addError(new ObjectError("cpf", "CPF inválido"));
            }
        }
    }


}
