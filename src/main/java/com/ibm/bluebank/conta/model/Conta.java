package com.ibm.bluebank.conta.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ibm.bluebank.shared.enums.EnumStatusConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @Column(name = "AGENCIA", nullable = false)
    private String agencia;

    @Column(name = "SALDO", nullable = false)
    private Double saldo;

    @Column(name = "LIMITE", nullable = false)
    private Double limite;

    @Column(name = "CRIADO_EM", nullable = false)
    private Date criadoEm;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private EnumStatusConta status;

    
    

}
