package br.com.fiap.dsaouda.javaweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dsaouda.javaweb.model.Usuario;

public class UsuarioDao extends AbstractDao<Usuario, Long> {

	public UsuarioDao(EntityManager em) {
		super(em, Usuario.class);
	}
	
	public Usuario byEmail(String email) {
		TypedQuery<Usuario> query = em.createQuery("from Usuario where email = :email", Usuario.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}
	
	public List<Usuario> getListComum() {
		TypedQuery<Usuario> query = em.createQuery("from Usuario where admin = false", Usuario.class);
		return query.getResultList();
	}
	
	
}
