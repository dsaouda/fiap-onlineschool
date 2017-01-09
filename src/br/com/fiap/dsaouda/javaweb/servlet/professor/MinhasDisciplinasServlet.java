package br.com.fiap.dsaouda.javaweb.servlet.professor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.DisciplinaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Disciplina;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/professor/minhas-disciplinas")
public class MinhasDisciplinasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final long professor = 2L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Disciplina> disciplinas = new DisciplinaDao(JpaUtil.getEntityManager()).byProfessor(professor);
		
		request.setAttribute("disciplinas", disciplinas);
		Dispatcher.forward(request, response, "/professor/minhasDisciplinas.jsp");
	}
}
