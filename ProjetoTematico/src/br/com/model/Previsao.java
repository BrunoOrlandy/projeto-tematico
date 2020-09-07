package br.com.model;

import java.time.LocalDate;

public class Previsao {
	private LocalDate dataPrevisao;
	private double valorPrevisao;

	public LocalDate getDataPrevisao() {
		return dataPrevisao;
	}

	public void setDataPrevisao(LocalDate dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}

	public double getValorPrevisao() {
		return valorPrevisao;
	}

	public void setValorPrevisao(double valorPrevisao) {
		this.valorPrevisao = valorPrevisao;
	}

}
