package br.com.fiap.dsaouda.javaweb.servlet.aluno;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.CursoDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Curso;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/aluno/disciplinas")
public class DisciplinasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cursoUUID = request.getParameter("curso");
		Curso curso = new CursoDao(JpaUtil.getEntityManager()).buscarPorUUID(cursoUUID);
		
		request.setAttribute("curso", curso);
		request.setAttribute("disciplinas", curso.getDisciplinas());
		Dispatcher.forward(request, response, "/aluno/disciplinas.jsp");
	}
}
