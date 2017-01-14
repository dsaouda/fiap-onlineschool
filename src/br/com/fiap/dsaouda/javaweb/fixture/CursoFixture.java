package br.com.fiap.dsaouda.javaweb.fixture;
import javax.persistence.EntityManager;

import br.com.fiap.dsaouda.javaweb.dao.CursoDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Curso;
import br.com.fiap.dsaouda.javaweb.model.Escola;

public class CursoFixture {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		CursoDao dao = new CursoDao(em);
		
		Escola escola = em.getReference(Escola.class, 1L);
		Curso curso = em.getReference(Curso.class, 1L);
		
		try {
			String nome = curso.getNome();
			System.out.println("Curso Já cadastrado: " + nome);
			
		} catch (Exception e) {
			dao.salvar(new Curso(escola, "MBA em Desenvolvimento de Aplicações Java SOA e Internet das Coisas", "Curso criado automaticamente para ser usado como demostração.", 300));
		}
	}
}
