package br.com.fiap.dsaouda.javaweb.main;
import javax.persistence.EntityManager;

import br.com.fiap.dsaouda.javaweb.dao.NotaDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;

public class Test {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		NotaDao notaDao = new NotaDao(em);
		
		notaDao.getNotaAlunosDiciplina(2L).forEach(n -> {
			System.out.println("==================");
			System.out.println(n.getUsuario().getNome());
			System.out.println(n.getNota().getProjeto1());
			System.out.println(n.getNota().getProjeto2());
			System.out.println(n.getNota().getAtividadePratica());
		});
		
	}
}
