package br.com.fiap.dsaouda.javaweb.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dsaouda.javaweb.dao.UsuarioDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsuarioDao usuarioDao = new UsuarioDao(JpaUtil.getEntityManager());
	
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/login.jsp");
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		try {
			Usuario usuario = usuarioDao.byEmail(email);			
			if (usuario.isSenhaValida(senha) == false) {
				throw new RuntimeException("Senha não é válida");
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			response.sendRedirect(request.getContextPath() + "/admin/home");
			
		} catch (RuntimeException e) {			
			request.setAttribute("error", "Usuário e/ou senha inválidos!");
			rd.forward(request, response);
		}
	}

}
