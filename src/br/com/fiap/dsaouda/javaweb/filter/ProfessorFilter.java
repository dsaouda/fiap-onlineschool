package br.com.fiap.dsaouda.javaweb.filter;

import javax.servlet.annotation.WebFilter;

@WebFilter("/professor/*")
public class ProfessorFilter extends PermissaoFilter {

	public ProfessorFilter() {
		super("/professor/login", "professor");
	}
}
