package br.com.fiap.dsaouda.javaweb.servlet;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.CursoDao;
import br.com.fiap.dsaouda.javaweb.dao.EscolaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Escola;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/admin/curso")
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String escolaUUID = request.getParameter("escola");
		
		EscolaDao escolaDao = new EscolaDao(JpaUtil.getEntityManager());
		
		if (escolaUUID == null || escolaUUID.isEmpty()) {
			request.setAttribute("escolas", escolaDao.getList());
			
			Dispatcher.forward(request, response, "/admin/curso.jsp");
			return;
		}
		
		try {
			Escola escola = escolaDao.buscarPorUUID(escolaUUID);
			request.setAttribute("escola", escola);
		} catch (NoResultException e) {
			Dispatcher.forward(request, response, "/notfound.jsp");
			return ;
		}
		
		CursoDao cursoDao = new CursoDao(JpaUtil.getEntityManager());
		request.setAttribute("cursos", cursoDao.byEscola(escolaUUID));		
		Dispatcher.forward(request, response, "/admin/cursoEscola.jsp");
	}
}
