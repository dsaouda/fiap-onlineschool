package br.com.fiap.dsaouda.javaweb.servlet;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.CursoDao;
import br.com.fiap.dsaouda.javaweb.dao.DisciplinaDao;
import br.com.fiap.dsaouda.javaweb.dao.UsuarioDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Curso;
import br.com.fiap.dsaouda.javaweb.model.Disciplina;
import br.com.fiap.dsaouda.javaweb.model.Usuario;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;
import br.com.fiap.dsaouda.javaweb.validator.SimpleValidation;
import br.com.fiap.dsaouda.javaweb.validator.SimpleValidationException;

@WebServlet("/admin/disciplina/cadastro")
public class DisciplinaCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursoDao cursoDao = new CursoDao(JpaUtil.getEntityManager());
		DisciplinaDao disciplinaDao = new DisciplinaDao(JpaUtil.getEntityManager());
		UsuarioDao usuarioDao = new UsuarioDao(JpaUtil.getEntityManager());
		
		String cursoUUID = request.getParameter("curso");
		String uuid = request.getParameter("uuid");
		
		try {
			Curso curso = cursoDao.buscarPorUUID(cursoUUID);
			request.setAttribute("curso", curso);
		} catch (NoResultException e) {
			Dispatcher.forward(request, response, "/notfound.jsp");
			return ;
		}
		
		if (uuid != null && !uuid.isEmpty()) {
			Disciplina disciplina = disciplinaDao.buscarPorUUID(uuid);
			request.setAttribute("disciplina", disciplina);
		}
		
		request.setAttribute("professores", usuarioDao.getListComum());
		Dispatcher.forward(request, response, "/admin/disciplinaCadastro.jsp");
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		DisciplinaDao dao = new DisciplinaDao(JpaUtil.getEntityManager());
		Disciplina disciplina = dao.buscarPorUUID(uuid);
		
		dao.delete(disciplina);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DisciplinaDao disciplinaDao = new DisciplinaDao(JpaUtil.getEntityManager());
		CursoDao cursoDao = new CursoDao(JpaUtil.getEntityManager());
		UsuarioDao usuarioDao = new UsuarioDao(JpaUtil.getEntityManager());
		
		Disciplina disciplina = getDisciplina(request, response, cursoDao, disciplinaDao, usuarioDao);
		
		try {
			
			SimpleValidation<Disciplina> validation = new SimpleValidation<>(disciplina);
			
			if (!validation.isValid()) {
				request.setAttribute("disciplina", disciplina);
				request.setAttribute("errors", validation.getErrors());
				throw new SimpleValidationException();
			}
			
			disciplinaDao.salvar(disciplina);
			response.sendRedirect("../disciplina?curso=" + request.getParameter("curso"));
		} catch (RuntimeException e) {
			request.setAttribute("professores", usuarioDao.getListComum());
			Dispatcher.forward(request, response, "/admin/disciplinaCadastro.jsp");
		}
	}

	private Disciplina getDisciplina(HttpServletRequest request, HttpServletResponse response, CursoDao cursoDao, DisciplinaDao disciplinaDao, UsuarioDao usuarioDao) throws ServletException {
		String cursoUUID = request.getParameter("curso");
		String uuid = request.getParameter("uuid");
		String nome = request.getParameter("nome");
		String conteudoProgramatico = request.getParameter("conteudoProgramatico");
		String professorUUID = request.getParameter("professor");
			
		Curso curso = cursoDao.buscarPorUUID(cursoUUID);
		
		Usuario professor = null;
		if (professorUUID != null && !professorUUID.isEmpty()) {
			professor = usuarioDao.buscarPorUUID(professorUUID);
		}
		
		request.setAttribute("curso", curso);
		
		//criar nova disciplina
		if (uuid == null || uuid.isEmpty()) {			
			return new Disciplina(curso, professor, nome, conteudoProgramatico);
		} 
		
		//atualizar
		try {
			Disciplina disciplina = disciplinaDao.buscarPorUUID(uuid);
			disciplina.setNome(nome)
				.setConteudoProgramatico(conteudoProgramatico)
				.setProfessor(professor);
			
			return disciplina;
		} catch (NoResultException e) {
			throw new ServletException("Não foi possível salvar a disciplina");
		}
	}
}
