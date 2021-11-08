package com.ibm.bluebank.operacao.validator;

import com.ibm.bluebank.cliente.model.Cliente;
import com.ibm.bluebank.conta.model.Conta;
import com.ibm.bluebank.operacao.dto.OperacaoDto;
import com.ibm.bluebank.shared.dates.converter.DataConverter;
import com.ibm.bluebank.shared.dates.exceptions.DateParseException;
import com.ibm.bluebank.shared.utils.DateUtil;
import com.ibm.bluebank.shared.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Optional;

@Service
public class OperacaoValidator extends Validator {

    @Autowired
    private DataConverter dataConverter;

    public void validarOperacao(String token, OperacaoDto operacaoDto, BindingResult result) {
        validarToken(token, result);
        validarValor(operacaoDto.getValor(), result);
        validarContaOperacao(operacaoDto, result);
        validarContaDestino(operacaoDto, result);
        if (!result.hasErrors()) {
            validarSaldo(token, operacaoDto, result);
        }
    }

    public void validarExtrato(String token, String inicio, String fim, BindingResult result) {
        validarToken(token, result);
        validarData(inicio, "inicio", result);
        validarData(fim, "fim", result);
    }

    private void validarData(String toDate, String param, BindingResult result) {
        try {
            DateUtil.toDate(toDate);
        } catch (DateParseException e) {
            result.addError(new ObjectError(param, e.getMessage()));
        }
    }

    public void validarSaldo(String token, OperacaoDto operacaoDto, BindingResult result) {
        boolean validarSaldo = operacaoDto.getTipo().getValidarSaldo();
        if (validarSaldo) {
            Optional<Cliente> cliente = clienteService.getClienteByToken(token);
            if (cliente.isPresent()) {
                Optional<Conta> contaOperacao = contaService.getContaByNumeroAndAgencia(operacaoDto.getNumeroOperacao(), operacaoDto.getAgenciaOperacao());
                if (contaOperacao.isPresent()) {
                    Conta conta = cliente.get().getConta();
                    if (conta.getId().equals(contaOperacao.get().getId())) {
                        if (operacaoDto.getValor() > (conta.getSaldo() + conta.getLimite())) {
                            result.addError(new ObjectError("saldo", "Saldo insuficiente"));
                        }
                    } else {
                        result.addError(new ObjectError("contaOperacao", "O token informado não pertence a conta e agência informadas"));
                    }
                }
            }
        }
    }


    private void validarValor(Double valor, BindingResult result) {
        boolean hasValor = validarCampoDoubleObrigatorio(valor, "valor", "Valor não informado", result);
        if (hasValor) {
            if (valor <= 0) {
                result.addError(new ObjectError("valor", "O valor deve ser maior que zero"));
            }
        }
    }

    private void validarContaOperacao(OperacaoDto operacaoDto, BindingResult result) {
        boolean obrigatorio = operacaoDto.getTipo().getContaOperacaoObrigatoria();
        boolean hasNumero = validarCampoString(operacaoDto.getNumeroOperacao(), "numeroOperacao", "Número da conta não informado", result, obrigatorio);
        boolean hasAgencia = validarCampoString(operacaoDto.getAgenciaOperacao(), "agenciaOperacao", "Número da agência não informado", result, obrigatorio);
        if (hasNumero && hasAgencia) {
            Optional<Conta> contaOpt = contaService.getContaByNumeroAndAgencia(operacaoDto.getNumeroOperacao(), operacaoDto.getAgenciaOperacao());
            if (!contaOpt.isPresent()) {
                result.addError(new ObjectError("contaOperacao", "Conta não localizada para número e agência informados"));
            }
        }
    }

    private void validarContaDestino(OperacaoDto operacaoDto, BindingResult result) {
        boolean obrigatorio = operacaoDto.getTipo().getContaDestinoObrigatoria();
        boolean hasNumero = validarCampoString(operacaoDto.getNumeroDestino(), "numeroDestino", "Número da conta não informado", result, obrigatorio);
        boolean hasAgencia = validarCampoString(operacaoDto.getAgenciaDestino(), "agenciaDestino", "Número da agência não informado", result, obrigatorio);
        if (hasNumero && hasAgencia) {
            Optional<Conta> contaOpt = contaService.getContaByNumeroAndAgencia(operacaoDto.getNumeroDestino(), operacaoDto.getAgenciaDestino());
            if (!contaOpt.isPresent()) {
                result.addError(new ObjectError("contaDestino", "Conta não localizada para número e agência informados"));
            }
        }
    }
}
