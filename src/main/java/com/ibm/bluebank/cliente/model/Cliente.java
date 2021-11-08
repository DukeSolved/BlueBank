package com.ibm.bluebank.cliente.model;

import com.ibm.bluebank.conta.model.Conta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "RENDA", nullable = false)
    private Double renda;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Conta.class)
    @JoinColumn(name = "CONTA_ID")
    private Conta conta;

    @Column(name = "TOKEN", nullable = false)
    private String token;

}
