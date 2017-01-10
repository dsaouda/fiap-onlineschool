package br.com.fiap.dsaouda.javaweb.dto;

import br.com.fiap.dsaouda.javaweb.model.Nota;
import br.com.fiap.dsaouda.javaweb.model.Usuario;

public class NotaAlunosDisciplinaDTO {

	private Usuario usuario;
	private Nota nota;

	public NotaAlunosDisciplinaDTO(Usuario usuario, Nota nota) {
		this.usuario = usuario;
		this.nota = nota;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Nota getNota() {
		
		if (nota == null) {
			nota = new Nota();
		}
		
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
}
