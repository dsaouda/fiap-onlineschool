package br.com.fiap.dsaouda.javaweb.dao;

import javax.persistence.EntityManager;

import br.com.fiap.dsaouda.javaweb.model.Escola;

public class EscolaDao extends AbstractDao<Escola, Long> {

	public EscolaDao(EntityManager em) {
		super(em, Escola.class);
	}
}
