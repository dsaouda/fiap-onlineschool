package br.com.fiap.dsaouda.javaweb.servlet.professor;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dsaouda.javaweb.dao.DisciplinaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Disciplina;
import br.com.fiap.dsaouda.javaweb.model.Usuario;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/professor/minhas-disciplinas")
public class MinhasDisciplinasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		DisciplinaDao disciplinaDao = new DisciplinaDao(em);
		
		HttpSession session = request.getSession();
		Usuario professor = (Usuario) session.getAttribute("usuarioSession");
		
		String cursoUUID = request.getParameter("curso");
		List<Disciplina> disciplinas;
		
		if (cursoUUID != null && !cursoUUID.trim().isEmpty()) {
			 disciplinas = disciplinaDao.byProfessor(professor.getId(), cursoUUID);
		} else {
			disciplinas = disciplinaDao.byProfessor(professor.getId());
		}
		
		request.setAttribute("disciplinas", disciplinas);
		Dispatcher.forward(request, response, "/professor/minhasDisciplinas.jsp");
	}
}
