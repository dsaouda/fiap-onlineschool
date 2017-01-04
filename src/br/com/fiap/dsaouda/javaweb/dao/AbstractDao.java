package br.com.fiap.dsaouda.javaweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class AbstractDao<T, ID> {

	protected EntityManager em;
	private Class<T> persistedClass;
	
	protected AbstractDao(EntityManager em, Class<T> persistedClass) {
		this.em = em;
		this.persistedClass = persistedClass;
	}
	
	public void salvar(T entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<T> getList() {
	       CriteriaBuilder builder = em.getCriteriaBuilder();
	       CriteriaQuery<T> query = builder.createQuery(persistedClass);
	       query.from(persistedClass);
	       return em.createQuery(query).getResultList();
	   }

   public T buscar(ID id) {
       return em.find(persistedClass, id);
   }
}
