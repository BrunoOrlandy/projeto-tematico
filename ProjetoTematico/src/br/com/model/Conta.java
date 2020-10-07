package br.com.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_conta")
	private Long id;

	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;

	@Column(name = "data_pagamento")
	private LocalDate dataPagamento;

	@Column(name = "valor_conta")
	private Double valorConta;

	@Column(name = "valor_cadastro")
	private Double valorCadastro;

	@Column(name = "observacao")
	private String observacao;

//	@ManyToOne(targetEntity = "CategoriaConta" ,cascade = CascadeType.ALL)
//	private CategoriaConta CategoriaCconta;

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorConta() {
		return valorConta;
	}

	public void setValorConta(Double valorConta) {
		this.valorConta = valorConta;
	}

	public Double getValorCadastro() {
		return valorCadastro;
	}

	public void setValorCadastro(Double valorCadastro) {
		this.valorCadastro = valorCadastro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public CategoriaConta getCategoriaCconta() {
//		return CategoriaCconta;
//	}
//
//	public void setCategoriaCconta(CategoriaConta categoriaCconta) {
//		CategoriaCconta = categoriaCconta;
//	}

	

}
