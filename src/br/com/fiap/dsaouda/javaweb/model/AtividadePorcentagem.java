package br.com.fiap.dsaouda.javaweb.model;

import java.math.BigDecimal;

public enum AtividadePorcentagem {

	PROJETO1(0.3f), ATIVIDADEPRATICA(0.3f), PROJETO2(0.4f);
	
	private BigDecimal porcentagem;

	AtividadePorcentagem(float porcentagem) {
		this.porcentagem = new BigDecimal(porcentagem);
	}
	
	public BigDecimal getPorcentagem() {
		return porcentagem;
	}
}
