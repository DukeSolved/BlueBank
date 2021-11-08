package com.ibm.bluebank.operacao.converter;

import com.ibm.bluebank.conta.model.Conta;
import com.ibm.bluebank.conta.service.ContaService;
import com.ibm.bluebank.operacao.dto.MovimentoDto;
import com.ibm.bluebank.operacao.dto.OperacaoDto;
import com.ibm.bluebank.operacao.model.Operacao;
import com.ibm.bluebank.shared.dates.converter.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

@Service
public class OperacaoConverter {

    @Autowired
    private ContaService contaService;

    @Autowired
    private DataConverter dataConverter;

    public Function<OperacaoDto, Operacao> toModel = new Function<OperacaoDto, Operacao>() {
        @Override
        public Operacao apply(OperacaoDto operacaoDto) {
            Operacao operacao = new Operacao();
            operacao.setTipoOperacao(operacaoDto.getTipo());
            operacao.setDataOperacao(new Date());
            operacao.setValor(operacaoDto.getValor());
            Optional<Conta> contaOpt = contaService.getContaByNumeroAndAgencia(operacaoDto.getNumeroOperacao(), operacaoDto.getAgenciaOperacao());
            contaOpt.ifPresent(operacao::setContaOperacao);
            Optional<Conta> contaDestinoOpt = contaService.getContaByNumeroAndAgencia(operacaoDto.getNumeroDestino(), operacaoDto.getAgenciaDestino());
            contaDestinoOpt.ifPresent(operacao::setContaDestino);
            return operacao;
        }
    };


    public Function<Operacao, MovimentoDto> toMovimentoDto = new Function<Operacao, MovimentoDto>() {
        @Override
        public MovimentoDto apply(Operacao operacao) {
            MovimentoDto movimentoDto = new MovimentoDto();
            movimentoDto.setData(dataConverter.toString(operacao.getDataOperacao()));
            movimentoDto.setValor(operacao.getValor());
            movimentoDto.setTipo(operacao.getTipoOperacao());
            return movimentoDto;
        }
    };
}
