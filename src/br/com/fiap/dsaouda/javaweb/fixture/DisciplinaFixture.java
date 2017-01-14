package br.com.fiap.dsaouda.javaweb.fixture;
import javax.persistence.EntityManager;

import br.com.fiap.dsaouda.javaweb.dao.DisciplinaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Curso;
import br.com.fiap.dsaouda.javaweb.model.Disciplina;
import br.com.fiap.dsaouda.javaweb.model.Usuario;

public class DisciplinaFixture {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		DisciplinaDao dao = new DisciplinaDao(em);
		
		Disciplina disciplina = em.getReference(Disciplina.class, 1L);
		Curso curso = em.getReference(Curso.class, 1L);
		Usuario professor = em.getReference(Usuario.class, 3L);
		
		try {
			String nome = disciplina.getNome();
			System.out.println("Disciplina já cadastrado: " + nome);
			
		} catch (Exception e) {
			dao.salvar(new Disciplina(curso, professor, "Java na WEB", "- JSP / Servlets\n- Spring MVC\n- JSF\n- Primefaces JSTL"));
			dao.salvar(new Disciplina(curso, professor, "Persistência em Java (JDBC e JPA)", "- Hibernate\n- TopLink\n- JPA\n- JDBC"));
		}
	}
}
