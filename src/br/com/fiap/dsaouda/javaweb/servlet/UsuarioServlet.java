package br.com.fiap.dsaouda.javaweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.UsuarioDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;

@WebServlet("/admin/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDao dao = new UsuarioDao(JpaUtil.getEntityManager());
		request.setAttribute("usuarios", dao.getList());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/admin/usuario.jsp");
		rd.forward(request, response);
	}
}
