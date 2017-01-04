package br.com.fiap.dsaouda.javaweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.EscolaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;

@WebServlet("/admin/escola")
public class EscolaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EscolaDao dao = new EscolaDao(JpaUtil.getEntityManager());
		request.setAttribute("escolas", dao.getList());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/admin/escola.jsp");
		rd.forward(request, response);
	}
}
