package br.com.fiap.dsaouda.javaweb.model;

public enum AtividadePorcentagem {

	PROJETO1(0.3f), ATIVIDADEPRATICA(0.3f), PROJETO2(0.4f);
	
	private float porcentagem;

	AtividadePorcentagem(float porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	public float getPorcentagem() {
		return porcentagem;
	}
}
