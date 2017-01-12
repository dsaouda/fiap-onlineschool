package br.com.fiap.dsaouda.javaweb.filter;

import javax.servlet.annotation.WebFilter;

@WebFilter("/aluno/*")
public class AlunoFilter extends PermissaoFilter {

	public AlunoFilter() {
		super("/aluno/login", "aluno");
	}
}
