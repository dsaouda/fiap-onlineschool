package br.com.fiap.dsaouda.javaweb.dao;

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
}
