package br.com.model;

import java.time.LocalDate;

public class Conta {
	private LocalDate dataCadastro;
	private LocalDate dataPagamento;
	private Double valorConta;
	private Double valorCadastro;
	private String observacao;

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

	@Override
	public String toString() {
		return "Conta [dataCadastro=" + dataCadastro + ", dataPagamento=" + dataPagamento + ", valorConta=" + valorConta
				+ ", valorCadastro=" + valorCadastro + ", observacao=" + observacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((valorCadastro == null) ? 0 : valorCadastro.hashCode());
		result = prime * result + ((valorConta == null) ? 0 : valorConta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataPagamento == null) {
			if (other.dataPagamento != null)
				return false;
		} else if (!dataPagamento.equals(other.dataPagamento))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (valorCadastro == null) {
			if (other.valorCadastro != null)
				return false;
		} else if (!valorCadastro.equals(other.valorCadastro))
			return false;
		if (valorConta == null) {
			if (other.valorConta != null)
				return false;
		} else if (!valorConta.equals(other.valorConta))
			return false;
		return true;
	}

}
