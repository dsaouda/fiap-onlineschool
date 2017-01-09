package br.com.fiap.dsaouda.javaweb.servlet.professor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.DisciplinaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Disciplina;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/professor/avaliar")
public class AvaliarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String disciplinaUUID = request.getParameter("disciplina");
		
		Disciplina disciplina = new DisciplinaDao(JpaUtil.getEntityManager()).buscarPorUUID(disciplinaUUID);
		
		request.setAttribute("disciplina", disciplina);
		Dispatcher.forward(request, response, "/professor/avaliar.jsp");
	}
}
