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

    public void validarClienteDto(ClienteDto clienteDto, BindingResult result) {
        validarCampoString(clienteDto.getNome(), "nome", "Nome não informado", result);
        validarCampoString(clienteDto.getSenha(), "senha", "Senha não informada", result);
        validarCampoDoubleObrigatorio(clienteDto.getRenda(), "renda", "Renda não informada", result);
        validarEmail(clienteDto, result);
        validarTelefone(clienteDto, result);
        validarCPF(clienteDto.getCpf(), result);
        if (!result.hasErrors()) {
            boolean clienteJaCadastrado = clienteService.clienteJaCadastrado(clienteDto.getCpf());
            if (clienteJaCadastrado) {
                result.addError(new ObjectError("cpf", "Cliente já está cadastrado"));
            }
        }
    }

    private void validarEmail(ClienteDto clienteDto, BindingResult result) {
        if (validarCampoString(clienteDto.getTelefone(), "email", "Email não informado", result)) {
            Boolean valido = EmailUtil.validarEmail(clienteDto.getEmail());
            if (!valido) {
                result.addError(new ObjectError("email", "Email inválido"));
            }
        }
    }

    private void validarTelefone(ClienteDto clienteDto, BindingResult result) {
        if (validarCampoString(clienteDto.getTelefone(), "telefone", "Telefone não informado", result)) {
            String telefone = TelefoneUtil.removerMascara(clienteDto.getTelefone());
            if (!(telefone.length() == 10 || telefone.length() == 11)) {
                result.addError(new ObjectError("telefone", "Telefone invalido, um número de telefone deve possuir 2 dígitos de DDD seguido de 8 ou 9 dígitos do número"));
            }
        }
    }

    public void validarCPF(String cpf, BindingResult result) {
        if (validarCampoString(cpf, "cpf", "CPF não informado", result)) {
            cpf = CpfUtil.removerMascara(cpf);
            boolean isValid = CpfUtil.isValid(cpf);
            if (!isValid) {
                result.addError(new ObjectError("cpf", "CPF inválido"));
            }
        }
    }


}
