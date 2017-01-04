package br.com.fiap.dsaouda.javaweb.servlet;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.EscolaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Escola;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;

@WebServlet("/admin/escola/cadastro")
public class EscolaCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		
		String uuid = request.getParameter("uuid");
		
		if (uuid != null && !uuid.isEmpty()) {
			EscolaDao dao = new EscolaDao(JpaUtil.getEntityManager());
			Escola escola = dao.buscarPorUUID(uuid);
			request.setAttribute("escola", escola);
		}
		
		
		Dispatcher.forward(request, response, "/admin/escolaCadastro.jsp");
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		EscolaDao dao = new EscolaDao(JpaUtil.getEntityManager());
		Escola escola = dao.buscarPorUUID(uuid);
		
		dao.delete(escola);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		
		EscolaDao dao = new EscolaDao(JpaUtil.getEntityManager());
		Escola escola = getEscola(request, dao);
		
		try {
			dao.salvar(escola);
			response.sendRedirect("../escola");
		} catch (RuntimeException e) {
			Dispatcher.forward(request, response, "/admin/escolaCadastro.jsp");
		}
	}

	private Escola getEscola(HttpServletRequest request, EscolaDao dao) throws ServletException {
		String uuid = request.getParameter("uuid");
		String nome = request.getParameter("nome");
		String observacao = request.getParameter("observacao");
		
		//criar nova escola
		if (uuid == null || uuid.isEmpty()) {
			return new Escola(nome, observacao);	
		} 
		
		//atualizar
		try {
			Escola escola = dao.buscarPorUUID(uuid);
			escola.setNome(nome)
			.setObservacao(observacao);
			return escola;
		} catch (NoResultException e) {
			throw new ServletException("Não foi possível salvar a escola");
		}
	}
}
