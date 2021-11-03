package com.ibm.bluebank.conta.model;


import com.ibm.bluebank.shared.enums.EnumStatusConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    private Long numero;

    @Column(name = "AGENCIA", nullable = false)
    private Long agencia;

    @Column(name = "SALDO", nullable = false)
    private Double saldo;

    @Column(name = "CRIADO_EM", nullable = false)
    private Date criadoEm;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private EnumStatusConta status;

}
