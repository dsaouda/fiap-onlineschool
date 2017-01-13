package br.com.fiap.dsaouda.javaweb.dao;

import javax.persistence.EntityManager;

import br.com.fiap.dsaouda.javaweb.model.Logger;

public class LoggerDao extends AbstractDao<Logger, Long> {

	public LoggerDao(EntityManager em) {
		super(em, Logger.class);
	}
}
