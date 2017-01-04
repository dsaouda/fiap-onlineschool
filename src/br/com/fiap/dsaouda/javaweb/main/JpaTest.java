package br.com.fiap.dsaouda.javaweb.main;

import javax.persistence.EntityManager;

import br.com.fiap.dsaouda.javaweb.dao.UsuarioDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Usuario;

public class JpaTest {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		UsuarioDao dao = new UsuarioDao(em);
		
		//Usuario usuario = new Usuario("Admin", "dsaouda", "dsaouda", true);
		
		Usuario usuario = dao.buscar(1L);
		//usuario.setNome("Admin Sistema2");
		//dao.salvar(usuario);
		
		System.out.println(usuario.isSenhaValida("dsaouda"));
	}
}
