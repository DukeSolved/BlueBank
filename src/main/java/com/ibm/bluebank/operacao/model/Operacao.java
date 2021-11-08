package com.ibm.bluebank.operacao.model;

import com.ibm.bluebank.conta.model.Conta;
import com.ibm.bluebank.shared.enums.EnumTipoOperacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_OPERACAO")
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Conta.class)
    @JoinColumn(name="CONTA_ID")
    private Conta contaOperacao;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Conta.class)
    @JoinColumn(name="CONTA_DESTINO_ID")
    private Conta contaDestino;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_OPERACAO", nullable = false)
    private EnumTipoOperacao tipoOperacao;

    @Column(name="VALOR")
    private Double valor;

    @Column(name="DATA_OPERACAO")
    private Date dataOperacao;

}
