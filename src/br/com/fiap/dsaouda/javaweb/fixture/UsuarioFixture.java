package br.com.fiap.dsaouda.javaweb.fixture;
import javax.persistence.EntityManager;

import br.com.fiap.dsaouda.javaweb.dao.UsuarioDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Usuario;

public class UsuarioFixture {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		UsuarioDao dao = new UsuarioDao(em);

		Usuario admin = new Usuario("admin", "admin@fiap.com.br", "1234", true);
		Usuario aluno = new Usuario("Diego Saouda", "aluno@fiap.com.br", "1234", false);
		Usuario professor = new Usuario("Celso", "professor@fiap.com.br", "1234", false);

		try {
			dao.salvar(admin);
		} catch (Exception e) {}
		
		try {
			dao.salvar(aluno);
		} catch (Exception e) {}
		
		try {
			dao.salvar(professor);
		} catch (Exception e) {}
	}
}
