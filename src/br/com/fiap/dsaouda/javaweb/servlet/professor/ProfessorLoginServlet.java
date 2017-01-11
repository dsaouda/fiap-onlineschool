package br.com.fiap.dsaouda.javaweb.servlet.professor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dsaouda.javaweb.model.Usuario;
import br.com.fiap.dsaouda.javaweb.servlet.LoginServlet;

@WebServlet("/professor/login")
public class ProfessorLoginServlet extends LoginServlet {
	private static final long serialVersionUID = 1L;
    
	public ProfessorLoginServlet() {
		super();
		
		header = "Professor";
		redirect = "/professor/minhas-disciplinas";
	}

	@Override
	protected void regraExtraDeValidacao(HttpServletRequest request, HttpServletResponse response, Usuario usuario) {
		HttpSession session = request.getSession();
		session.setAttribute("perfil", "professor");
	}
}
