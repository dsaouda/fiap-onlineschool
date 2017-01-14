package br.com.fiap.dsaouda.javaweb.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.LoggerDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Logger;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/admin/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		LoggerDao loggerDao = new LoggerDao(em);	
		
		List<Logger> ultimosEventos = loggerDao.buscarUltimos(100);
		request.setAttribute("ultimosEventos", ultimosEventos);
		
		Dispatcher.forward(request, response, "/admin/home.jsp");
	}
}
