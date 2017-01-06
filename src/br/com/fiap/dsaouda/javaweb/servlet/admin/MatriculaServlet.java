package br.com.fiap.dsaouda.javaweb.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.CursoDao;
import br.com.fiap.dsaouda.javaweb.dao.MatriculaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Curso;
import br.com.fiap.dsaouda.javaweb.model.Matricula;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/admin/matricula")
public class MatriculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cursoUUID = request.getParameter("curso");
		
		CursoDao cursoDao = new CursoDao(JpaUtil.getEntityManager());
		MatriculaDao matriculaDao = new MatriculaDao(JpaUtil.getEntityManager());
		
		try {
			Curso curso = cursoDao.buscarPorUUID(cursoUUID);
			List<Matricula> matriculas = matriculaDao.byCurso(curso.getUuid());
			
			request.setAttribute("curso", curso);
			request.setAttribute("matriculas", matriculas);
			
		} catch (NoResultException e) {
			Dispatcher.forward(request, response, "/notfound.jsp");
			return ;
		}
		
		
		Dispatcher.forward(request, response, "/admin/matriculaCurso.jsp");
	}
}
