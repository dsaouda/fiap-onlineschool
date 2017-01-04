package br.com.fiap.dsaouda.javaweb.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
