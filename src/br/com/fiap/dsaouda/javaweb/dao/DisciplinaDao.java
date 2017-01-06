package br.com.fiap.dsaouda.javaweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dsaouda.javaweb.model.Disciplina;

public class DisciplinaDao extends AbstractDao<Disciplina, Long> {

	public DisciplinaDao(EntityManager em) {
		super(em, Disciplina.class);
	}

	public List<Disciplina> byCurso(String cursoUUID) {
		TypedQuery<Disciplina> query = em.createQuery("from Disciplina where curso.uuid = :uuid", Disciplina.class);
		query.setParameter("uuid", cursoUUID);
		return query.getResultList();
	}
}
