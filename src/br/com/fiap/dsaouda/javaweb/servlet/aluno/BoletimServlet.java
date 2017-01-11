package br.com.fiap.dsaouda.javaweb.servlet.aluno;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dsaouda.javaweb.dao.CursoDao;
import br.com.fiap.dsaouda.javaweb.dao.NotaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Curso;
import br.com.fiap.dsaouda.javaweb.model.Usuario;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/aluno/boletim")
public class BoletimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cursoUUID = request.getParameter("curso");
		EntityManager em = JpaUtil.getEntityManager();
		Curso curso = new CursoDao(em).buscarPorUUID(cursoUUID);
		
		HttpSession session = request.getSession();
		Usuario aluno = (Usuario) session.getAttribute("usuario");
		
		request.setAttribute("curso", curso);		
		request.setAttribute("notas", new NotaDao(em).getNotasAluno(cursoUUID, aluno.getId()));
		Dispatcher.forward(request, response, "/aluno/boletim.jsp");
	}
}
