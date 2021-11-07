package com.ibm.bluebank.operacao.validator;

import com.ibm.bluebank.cliente.dto.DepositoDto;
import com.ibm.bluebank.conta.model.Conta;
import com.ibm.bluebank.shared.validator.Validator;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Optional;

@Service
public class OperacaoValidator extends Validator {

    public void validate(String token, DepositoDto depositoDto, BindingResult result) {
        validarToken(token, result);
        validarConta(depositoDto, result);
        validarValor(depositoDto, result);
    }

    private void validarValor(DepositoDto depositoDto, BindingResult result) {
        boolean valor = validarCampoDoubleObrigatorio(depositoDto.getValor(), "valor", "Valor não informado", result);
        if (valor) {
            if (depositoDto.getValor() <= 0) {
                result.addError(new ObjectError("valor", "O valor do depósito deve ser maior que zero"));
            }
        }
    }

    private void validarConta(DepositoDto depositoDto, BindingResult result) {
        boolean numero = validarCampoStringObrigatorio(depositoDto.getNumero(), "numero", "Número da conta não informado", result);
        boolean agencia = validarCampoStringObrigatorio(depositoDto.getAgencia(), "agencia", "Número da agência não informado", result);
        if (numero && agencia) {
            Optional<Conta> contaOpt = contaService.getContaByNumeroAndAgencia(depositoDto.getNumero(), depositoDto.getAgencia());
            if (!contaOpt.isPresent()) {
                result.addError(new ObjectError("conta", "Conta não localizada para número e agência informados"));
            }
        }
    }
}
