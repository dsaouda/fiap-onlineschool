package br.com.fiap.dsaouda.javaweb.dto;

import br.com.fiap.dsaouda.javaweb.model.Disciplina;
import br.com.fiap.dsaouda.javaweb.model.Nota;

public class DisciplinaNotaDTO {

	private Disciplina disciplina;
	private Nota nota = new Nota();
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public void setNota(Nota nota) {
		this.nota = nota;
	}	

	public Disciplina getDisciplina() {
		return disciplina;
	}
	public float getProjeto1() {
		return nota.getProjeto1();
	}
	public float getAtividadePratica() {
		return nota.getAtividadePratica();
	}
	public float getProjeto2() {
		return nota.getProjeto2();
	}
	public String getStatus() {
		return nota.getStatus();
	}
	
	public float getMedia() {
		return nota.getMedia();
	}
}
