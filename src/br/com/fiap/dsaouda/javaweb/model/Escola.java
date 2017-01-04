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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="escola")
public class Escola implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length=255,nullable=false)
	private String nome;
	
	@Column(nullable=true, columnDefinition="TEXT")
	private String observacao;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="escola")
	private Set<Curso> cursos = new HashSet<>();
}
