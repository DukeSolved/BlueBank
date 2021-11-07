package com.ibm.bluebank.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ibm.bluebank.conta.model.Conta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {
    private  Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;
    private String conta;
    private float renda;
//
//    public Cliente(Long id, String nome, String cpf, String email, String telefone, String senha, String conta, float renda ){
//       this.id = id;
//       this.nome = nome;
//       this.cpf = cpf;
//       this.email = email;
//       this.telefone = telefone;
//       this.senha = senha;
//       this.conta = conta;
//       this.renda = renda;
//    }

    public Long getId(){return id;}

    public void setId(Long id){this.id = id;}

    public String getNome(){return nome;}

    public void setNome(String nome){this.nome = nome;}

    public String getCpf(){return cpf;}

    public void setCpf(String cpf){this.cpf = cpf;}

    public String getEmail(){return email;}

    public void setEmail(String email){this.email = email;}

    public String getTelefone(){return telefone;}

    public void setTelefone(String telefone){this.telefone = telefone;}

    public String getSenha(){return senha;}

    public void setSenha(String senha){this.senha = senha;}

    public String getConta(){return conta;}

    public void setConta(String conta){this.conta = conta;}

    public float getRenda(){return renda;}

    public void setRenda(float renda){this.renda = renda;}




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

    @Column(name = "FONE", nullable = false)
    private String fone;

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
