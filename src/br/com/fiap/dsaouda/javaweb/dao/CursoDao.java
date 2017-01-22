package br.com.fiap.dsaouda.javaweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dsaouda.javaweb.model.Curso;

public class CursoDao extends AbstractDao<Curso, Long> {

	public CursoDao(EntityManager em) {
		super(em, Curso.class);
	}

	public List<Curso> byEscola(String escolaUUID) {
		TypedQuery<Curso> query = em.createQuery("from Curso where escola.uuid = :uuid", Curso.class);
		query.setParameter("uuid", escolaUUID);
		return query.getResultList();
	}

	public List<Curso> byProfessor(long professorId) {
		TypedQuery<Curso> query = em.createQuery("select c from Curso c join c.disciplinas d where d.professor.id = :professor", Curso.class);
		query.setParameter("professor", professorId);
		return query.getResultList();
	}
}
