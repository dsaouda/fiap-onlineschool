package br.com.fiap.dsaouda.javaweb.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.fiap.dsaouda.javaweb.model.Curso;
import br.com.fiap.dsaouda.javaweb.model.Matricula;
import br.com.fiap.dsaouda.javaweb.model.Usuario;

public class MatriculaDao extends AbstractDao<Matricula, Long> {

	public MatriculaDao(EntityManager em) {
		super(em, Matricula.class);
	}
	
	public void matricular(Curso curso, Set<Usuario> usuario) {
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			usuario.forEach(aluno -> em.merge(new Matricula(curso, aluno)));
			t.commit();
		} catch (RuntimeException e) {
			t.rollback();
			throw e;
		}
	}
	
	public List<Matricula> byAluno(long id) {
		TypedQuery<Matricula> query = em.createQuery("from Matricula where aluno.id = :id", Matricula.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public List<Matricula> byCurso(String cursoUUID) {
		TypedQuery<Matricula> query = em.createQuery("from Matricula where curso.uuid = :uuid", Matricula.class);
		query.setParameter("uuid", cursoUUID);
		return query.getResultList();
	}

	public List<Usuario> getUsuariosNaoMatriculado(String uuid) {
		TypedQuery<Usuario> query = em.createQuery("from Usuario u where NOT EXISTS (select m FROM Matricula m where m.aluno.id = u.id AND m.curso.uuid = :uuid)", Usuario.class);
		query.setParameter("uuid", uuid);
		return query.getResultList();
	}
}
