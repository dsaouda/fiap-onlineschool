package br.com.fiap.dsaouda.javaweb.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dsaouda.javaweb.dao.UsuarioDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Usuario;

abstract public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected String redirect;
	protected String header;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/login.jsp");
		
		request.setAttribute("headerLogin", header);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		UsuarioDao usuarioDao = new UsuarioDao(em);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/login.jsp");
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		try {
			Usuario usuario = usuarioDao.byEmail(email);			
			if (usuario.isSenhaValida(senha) == false) {
				throw new RuntimeException("Usuário e/ou senha inválidos!");
			}
			
			HttpSession session = request.getSession();
			
			regraExtraDeValidacao(request, response, usuario);
			
			session.setAttribute("usuario", usuario);
			response.sendRedirect(request.getContextPath() + redirect);
			
		} catch (RuntimeException e) {
			request.setAttribute("headerLogin", header);
			request.setAttribute("error", e.getMessage());
			rd.forward(request, response);
		}
	}
	
	
	abstract protected void regraExtraDeValidacao(HttpServletRequest request, HttpServletResponse response, Usuario usuario);
}
