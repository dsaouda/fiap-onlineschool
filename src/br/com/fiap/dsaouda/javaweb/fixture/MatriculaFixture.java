package br.com.fiap.dsaouda.javaweb.fixture;
import javax.persistence.EntityManager;

import br.com.fiap.dsaouda.javaweb.dao.MatriculaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Curso;
import br.com.fiap.dsaouda.javaweb.model.Matricula;
import br.com.fiap.dsaouda.javaweb.model.Usuario;

public class MatriculaFixture {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		MatriculaDao dao = new MatriculaDao(em);
		
		Matricula matricula = em.getReference(Matricula.class, 1L);
		Curso curso = em.getReference(Curso.class, 1L);
		Usuario aluno = em.getReference(Usuario.class, 2L);
		
		try {
			String nome = matricula.getAluno().getNome();
			System.out.println("Matricula já cadastrada para aluno: " + nome);
			
		} catch (Exception e) {
			dao.salvar(new Matricula(curso, aluno));
		}
	}
}
