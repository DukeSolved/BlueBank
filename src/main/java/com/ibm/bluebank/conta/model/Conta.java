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

    @Column(name = "LIMITE", nullable = false)
    private Double limite;

    @Column(name = "CRIADO_EM", nullable = false)
    private Date criadoEm;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private EnumStatusConta status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getAgencia() {
		return agencia;
	}

	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public Date getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public EnumStatusConta getStatus() {
		return status;
	}

	public void setStatus(EnumStatusConta status) {
		this.status = status;
	}
    
    

}
