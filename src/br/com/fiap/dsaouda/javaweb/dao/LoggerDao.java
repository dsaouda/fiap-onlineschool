package br.com.fiap.dsaouda.javaweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dsaouda.javaweb.model.Logger;

public class LoggerDao extends AbstractDao<Logger, Long> {

	public LoggerDao(EntityManager em) {
		super(em, Logger.class);
	}

	public List<Logger> buscarUltimos(int limite) {
		TypedQuery<Logger> query = em.createQuery("from Logger l order by l.dataEvento DESC", Logger.class);
		query.setMaxResults(limite);
		return query.getResultList();
	}
}
