package br.com.fiap.dsaouda.javaweb.servlet.aluno;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.MatriculaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Matricula;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/aluno/meus-cursos")
public class MeusCursosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final long aluno = 2L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Matricula> matriculas = new MatriculaDao(JpaUtil.getEntityManager()).byAluno(aluno);
		
		request.setAttribute("matriculas", matriculas);
		Dispatcher.forward(request, response, "/aluno/meusCursos.jsp");
	}
}
