package br.com.fiap.dsaouda.javaweb.exception;

import br.com.fiap.dsaouda.javaweb.model.Disciplina;
import br.com.fiap.dsaouda.javaweb.model.Usuario;

public class DisciplinaNaoEhDoProfessorException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DisciplinaNaoEhDoProfessorException() {
		super("Disciplina não pertence ao professor");
	}
	
	public static void throwsSeDisciplinaNaoForDoProfessor(Disciplina disciplina, Usuario professor) {
		if (disciplina.getProfessor().getId() != professor.getId()) {
			throw new DisciplinaNaoEhDoProfessorException();
		}
	}
	
}
