package br.com.fiap.dsaouda.javaweb.servlet.professor;

import static br.com.fiap.dsaouda.javaweb.exception.DisciplinaNaoEhDoProfessorException.throwsSeDisciplinaNaoForDoProfessor;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dsaouda.javaweb.dao.DisciplinaDao;
import br.com.fiap.dsaouda.javaweb.dao.NotaDao;
import br.com.fiap.dsaouda.javaweb.dto.NotaAlunosDisciplinaDTO;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Disciplina;
import br.com.fiap.dsaouda.javaweb.model.Nota;
import br.com.fiap.dsaouda.javaweb.model.Usuario;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/professor/avaliar")
public class AvaliarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		HttpSession session = request.getSession();
		
		String disciplinaUUID = request.getParameter("disciplina");		
		Disciplina disciplina = new DisciplinaDao(em).buscarPorUUID(disciplinaUUID);		
		Usuario professor = getProfessor(request);
		
		throwsSeDisciplinaNaoForDoProfessor(disciplina, professor);
		
		List<NotaAlunosDisciplinaDTO> notaAlunosDiciplina = new NotaDao(em).getNotaAlunosDiciplina(disciplina.getId());
		
		request.setAttribute("mensagem", session.getAttribute("mensagem"));
		session.removeAttribute("mensagem");
		
		request.setAttribute("avaliacoes", notaAlunosDiciplina);
		request.setAttribute("disciplina", disciplina);
		Dispatcher.forward(request, response, "/professor/avaliar.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		
		NotaDao notaDao = new NotaDao(em);
		
		String[] usuarios = request.getParameterValues("usuario");
		String disciplinaUUID = request.getParameter("disciplina");
		
		Disciplina disciplina = new DisciplinaDao(em).buscarPorUUID(disciplinaUUID);
		
		Usuario professor = getProfessor(request);
		
		throwsSeDisciplinaNaoForDoProfessor(disciplina, professor);
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		notaDao.remover(disciplina.getId());
		
		for (String usuarioId : usuarios) {
			Usuario usuario = em.getReference(Usuario.class, Long.parseLong(usuarioId));
			
			String projeto1 = request.getParameter("projeto1["+usuarioId+"]");
			String atividadePratica = request.getParameter("atividadePratica["+usuarioId+"]");
			String projeto2 = request.getParameter("projeto2["+usuarioId+"]");
			
			Nota nota = new Nota(usuario, disciplina);
			
			nota.setProjeto1(projeto1);
			nota.setAtividadePratica(atividadePratica);
			nota.setProjeto2(projeto2);
			
			notaDao.salvarSemTransacao(nota);
		}
		
		transaction.commit();
		request.getSession().setAttribute("mensagem", "Notas atualizadas com sucesso!");
		
		response.sendRedirect(request.getHeader("referer"));
	}

	private Usuario getProfessor(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario professor = (Usuario) session.getAttribute("usuarioSession");
		return professor;
	}	
}
