package br.com.fiap.dsaouda.javaweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.dsaouda.javaweb.dto.DisciplinaNotaDTO;
import br.com.fiap.dsaouda.javaweb.model.Disciplina;
import br.com.fiap.dsaouda.javaweb.model.Nota;

public class NotaDao extends AbstractDao<Nota, Long> {

	public NotaDao(EntityManager em) {
		super(em, Nota.class);
	}

	public List<DisciplinaNotaDTO> getNotasAluno(String cursoUUID, long usuarioId) {
		TypedQuery<Disciplina> query = em.createQuery("from Disciplina where curso.uuid = :uuid", Disciplina.class);
		query.setParameter("uuid", cursoUUID);
		
		List<DisciplinaNotaDTO> notas = new ArrayList<>();
		
		List<Disciplina> disciplinas = query.getResultList();
		disciplinas.forEach(d -> {
			
			DisciplinaNotaDTO dto = new DisciplinaNotaDTO();
			dto.setDisciplina(d);
			
			TypedQuery<Nota> q = em.createQuery("from Nota where disciplina.id = :disciplina AND usuario.id = :usuario", Nota.class);
			q.setParameter("disciplina", d.getId());
			q.setParameter("usuario", usuarioId);
			
			try {
				dto.setNota(q.getSingleResult());
			} catch (NoResultException e) {}
			
			notas.add(dto);
		});
		
		return notas;
	}
}
