package br.com.fiap.dsaouda.javaweb.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
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
import br.com.fiap.dsaouda.javaweb.model.Usuario;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/admin/matricula/cadastro")
public class MatriculaCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		MatriculaDao dao = new MatriculaDao(JpaUtil.getEntityManager());
		Matricula matricula = dao.buscarPorUUID(uuid);
		
		dao.delete(matricula);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cursoUUID = request.getParameter("curso");
		
		CursoDao cursoDao = new CursoDao(JpaUtil.getEntityManager());
		MatriculaDao matriculaDao = new MatriculaDao(JpaUtil.getEntityManager());
		
		try {
			Curso curso = cursoDao.buscarPorUUID(cursoUUID);
			List<Usuario> usuarios = matriculaDao.getUsuariosNaoMatriculado(curso.getUuid());
			
			request.setAttribute("curso", curso);
			request.setAttribute("usuarios", usuarios);
			
		} catch (NoResultException e) {
			Dispatcher.forward(request, response, "/notfound.jsp");
			return ;
		}
		
		
		Dispatcher.forward(request, response, "/admin/matriculaCadastro.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cursoUUID = request.getParameter("curso");
		EntityManager em = JpaUtil.getEntityManager();
		
		CursoDao cursoDao = new CursoDao(em);
		MatriculaDao matriculaDao = new MatriculaDao(em);
		
		Curso curso = cursoDao.buscarPorUUID(cursoUUID);
		
		String[] usuariosId = request.getParameterValues("usuarios");
		
		Set<Usuario> usuarios = new HashSet<>();
		for (String usuarioId : usuariosId) {
			Usuario usuario = em.getReference(Usuario.class, Long.parseLong(usuarioId));
			usuarios.add(usuario);
		}
		
		matriculaDao.matricular(curso, usuarios);
		response.sendRedirect("../matricula?curso=" + curso.getUuid());
	}
}
