package com.ibm.bluebank.operacao.repository;

import com.ibm.bluebank.operacao.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM TB_OPERACAO WHERE " +
                    "((TIPO_OPERACAO = 'TRANSFERENCIA' AND (CONTA_ID = :idConta OR CONTA_DESTINO_ID = :idConta)) " +
                    " OR " +
                    "(TIPO_OPERACAO = 'DEPOSITO' AND CONTA_DESTINO_ID = :idConta) " +
                    " OR " +
                    "(TIPO_OPERACAO = 'SAQUE' AND CONTA_ID = :idConta)) " +
                    " AND " +
                    " DATA_OPERACAO BETWEEN DATE(:dataInicio) AND DATE(:dataFim)")
    List<Operacao> getExtrato(Long idConta, Date dataInicio, Date dataFim);
}
