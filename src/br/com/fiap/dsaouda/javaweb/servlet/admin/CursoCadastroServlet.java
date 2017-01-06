package br.com.fiap.dsaouda.javaweb.servlet.admin;

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
import br.com.fiap.dsaouda.javaweb.model.Curso;
import br.com.fiap.dsaouda.javaweb.model.Escola;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;
import br.com.fiap.dsaouda.javaweb.validator.SimpleValidation;
import br.com.fiap.dsaouda.javaweb.validator.SimpleValidationException;

@WebServlet("/admin/curso/cadastro")
public class CursoCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EscolaDao escolaDao = new EscolaDao(JpaUtil.getEntityManager());
		CursoDao cursoDao = new CursoDao(JpaUtil.getEntityManager());
		
		String escolaUUID = request.getParameter("escola");
		String uuid = request.getParameter("uuid");
		
		try {
			Escola escola = escolaDao.buscarPorUUID(escolaUUID);
			request.setAttribute("escola", escola);
		} catch (NoResultException e) {
			Dispatcher.forward(request, response, "/notfound.jsp");
			return ;
		}
		
		if (uuid != null && !uuid.isEmpty()) {
			Curso curso = cursoDao.buscarPorUUID(uuid);
			request.setAttribute("curso", curso);
		}
		
		
		Dispatcher.forward(request, response, "/admin/cursoCadastro.jsp");
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		CursoDao dao = new CursoDao(JpaUtil.getEntityManager());
		Curso curso = dao.buscarPorUUID(uuid);
		
		dao.delete(curso);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursoDao cursoDao = new CursoDao(JpaUtil.getEntityManager());
		EscolaDao escolaDao = new EscolaDao(JpaUtil.getEntityManager());
		
		Curso curso = getCurso(request, response, escolaDao, cursoDao);
		
		try {
			
			SimpleValidation<Curso> validation = new SimpleValidation<>(curso);
			
			if (!validation.isValid()) {
				request.setAttribute("curso", curso);
				request.setAttribute("errors", validation.getErrors());
				throw new SimpleValidationException();
			}
			
			cursoDao.salvar(curso);
			response.sendRedirect("../curso?escola=" + request.getParameter("escola"));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			Dispatcher.forward(request, response, "/admin/cursoCadastro.jsp");
		}
	}

	private Curso getCurso(HttpServletRequest request, HttpServletResponse response, EscolaDao escolaDao, CursoDao cursoDao) throws ServletException {
		String escolaUUID = request.getParameter("escola");
		String uuid = request.getParameter("uuid");
		String nome = request.getParameter("nome");
		String sobre = request.getParameter("sobre");
		int cargaHoraria = 0;
		
		try {
			cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
		} catch (Exception e) {
			
		}
		
		Escola escola = escolaDao.buscarPorUUID(escolaUUID);
		request.setAttribute("escola", escola);
		
		//criar nova curso
		if (uuid == null || uuid.isEmpty()) {			
			return new Curso(escola, nome, sobre, cargaHoraria);	
		} 
		
		//atualizar
		try {
			Curso curso = cursoDao.buscarPorUUID(uuid);
			curso.setNome(nome)
				.setCargaHoraria(cargaHoraria)
				.setSobre(sobre);
			
			return curso;
		} catch (NoResultException e) {
			throw new ServletException("Não foi possível salvar a curso");
		}
	}
}
