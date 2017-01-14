package br.com.fiap.dsaouda.javaweb.fixture;
import javax.persistence.EntityManager;

import br.com.fiap.dsaouda.javaweb.dao.EscolaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Escola;

public class EscolaFixture {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		EscolaDao dao = new EscolaDao(em);
		
		Escola escola = em.getReference(Escola.class, 1L);
		
		try {
			String nome = escola.getNome();
			System.out.println("Escola J� cadastrada: " + nome);
			
		} catch (Exception e) {
			dao.salvar(new Escola("Escola Demonstra��o", "Escola criada automaticamente para ser usada como demostra��o."));
		}
	}
}
