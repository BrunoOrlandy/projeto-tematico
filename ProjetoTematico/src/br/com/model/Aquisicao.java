package br.com.model;

import java.time.LocalDate;

public class Aquisicao {
	private String aquisicao;
	private double valor;
	private Integer quantParcelas;
	private String formaPagamento;
	private LocalDate dataAquisicao;

	public String getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(String aquisicao) {
		this.aquisicao = aquisicao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Integer getQuantParcelas() {
		return quantParcelas;
	}

	public void setQuantParcelas(Integer quantParcelas) {
		this.quantParcelas = quantParcelas;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public LocalDate getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(LocalDate dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

}
