package com.ibm.bluebank.cliente.model;

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




}
