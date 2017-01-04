package br.com.fiap.dsaouda.javaweb.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length=255,nullable=false)
	private String nome;
	
	@Column(nullable=false, columnDefinition="TEXT")
	private String descricao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_escola")
	private Escola escola;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
	private Set<Disciplina> disciplinas = new HashSet<>();
}
