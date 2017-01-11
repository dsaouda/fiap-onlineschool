package br.com.fiap.dsaouda.javaweb.servlet.admin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dsaouda.javaweb.model.Usuario;
import br.com.fiap.dsaouda.javaweb.servlet.LoginServlet;

@WebServlet("/admin/login")
public class AdminLoginServlet extends LoginServlet {
	private static final long serialVersionUID = 1L;
    
	public AdminLoginServlet() {
		super();
		
		header = "Admin";
		redirect = "/admin/home";
	}

	@Override
	protected void regraExtraDeValidacao(HttpServletRequest request, HttpServletResponse response, Usuario usuario) {
		if (!usuario.isAdmin()) {
			throw new RuntimeException("Usu�rio n�o tem permiss�o de acessar esse recurso");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("perfil", "admin");
	}
}
