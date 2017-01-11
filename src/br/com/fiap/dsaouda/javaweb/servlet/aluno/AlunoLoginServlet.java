package br.com.fiap.dsaouda.javaweb.servlet.aluno;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dsaouda.javaweb.model.Usuario;
import br.com.fiap.dsaouda.javaweb.servlet.LoginServlet;

@WebServlet("/aluno/login")
public class AlunoLoginServlet extends LoginServlet {
	private static final long serialVersionUID = 1L;
    
	public AlunoLoginServlet() {
		super();
		
		header = "Aluno";
		redirect = "/aluno/meus-cursos";
	}

	@Override
	protected void regraExtraDeValidacao(HttpServletRequest request, HttpServletResponse response, Usuario usuario) {
		HttpSession session = request.getSession();
		session.setAttribute("perfil", "aluno");
	}
}
