package br.com.fiap.dsaouda.javaweb.servlet.professor;

import java.io.IOException;
import java.math.BigDecimal;
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
		String disciplinaUUID = request.getParameter("disciplina");
		
		Disciplina disciplina = new DisciplinaDao(em).buscarPorUUID(disciplinaUUID);
		List<NotaAlunosDisciplinaDTO> notaAlunosDiciplina = new NotaDao(em).getNotaAlunosDiciplina(disciplina.getId());
		
		HttpSession session = request.getSession();
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
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		notaDao.remover(disciplina.getId());
		
		for (String usuarioId : usuarios) {
			Usuario usuario = em.getReference(Usuario.class, Long.parseLong(usuarioId));
			
			String projeto1 = request.getParameter("projeto1["+usuarioId+"]");
			String atividadePratica = request.getParameter("atividadePratica["+usuarioId+"]");
			String projeto2 = request.getParameter("projeto2["+usuarioId+"]");
			
			try {
				Nota nota = new Nota(usuario, disciplina);
				nota.setProjeto1(new BigDecimal(projeto1));
				nota.setAtividadePratica(new BigDecimal(atividadePratica));
				nota.setProjeto2(new BigDecimal(projeto2));
				
				notaDao.salvar(nota);
			} catch (NumberFormatException e) {}
		}
		
		transaction.commit();
		request.getSession().setAttribute("mensagem", "Notas atualizadas com sucesso!");
		
		response.sendRedirect(request.getHeader("referer"));
	}	
}
