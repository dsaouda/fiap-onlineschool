package br.com.fiap.dsaouda.javaweb.servlet;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dsaouda.javaweb.dao.UsuarioDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Usuario;
import br.com.fiap.dsaouda.javaweb.util.Dispatcher;
import br.com.fiap.dsaouda.javaweb.validator.SimpleValidation;
import br.com.fiap.dsaouda.javaweb.validator.SimpleValidationException;

@WebServlet("/admin/usuario/cadastro")
public class UsuarioCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		
		if (uuid != null && !uuid.isEmpty()) {
			UsuarioDao dao = new UsuarioDao(JpaUtil.getEntityManager());
			Usuario usuario = dao.buscarPorUUID(uuid);
			request.setAttribute("usuario", usuario);
		}
		
		
		Dispatcher.forward(request, response, "/admin/usuarioCadastro.jsp");
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		UsuarioDao dao = new UsuarioDao(JpaUtil.getEntityManager());
		Usuario usuario = dao.buscarPorUUID(uuid);
		
		dao.delete(usuario);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDao dao = new UsuarioDao(JpaUtil.getEntityManager());
		Usuario usuario = getUsuario(request, dao);
		
		try {
			
			SimpleValidation<Usuario> validation = new SimpleValidation<>(usuario);
			
			if (!validation.isValid()) {
				request.setAttribute("usuario", usuario);
				request.setAttribute("errors", validation.getErrors());
				throw new SimpleValidationException();
			}
			
			dao.salvar(usuario);
			response.sendRedirect("../usuario");
		} catch (RuntimeException e) {
			Dispatcher.forward(request, response, "/admin/usuarioCadastro.jsp");
		}
	}

	private Usuario getUsuario(HttpServletRequest request, UsuarioDao dao) throws ServletException {
		String uuid = request.getParameter("uuid");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
		
		//criar nova usuario
		if (uuid == null || uuid.isEmpty()) {			
			return new Usuario(nome, email, senha, admin);	
		} 
		
		//atualizar
		try {
			Usuario usuario = dao.buscarPorUUID(uuid);
			usuario.setNome(nome)
				.setAdmin(admin);
			
			if (!senha.isEmpty()) {
				usuario.setSenha(senha);
			}
				
			
			return usuario;
		} catch (NoResultException e) {
			throw new ServletException("Não foi possível salvar a usuário");
		}
	}
}
