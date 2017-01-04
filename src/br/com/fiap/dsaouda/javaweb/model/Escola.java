package br.com.fiap.dsaouda.javaweb.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
	
	@Column(unique=true, nullable=false)
	private String uuid;
	
	@Column(length=255,nullable=false)
	private String nome;
	
	@Column(nullable=true, columnDefinition="TEXT")
	private String observacao;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="escola")
	private Set<Curso> cursos = new HashSet<>();

	@Deprecated //JPA only
	protected Escola() {}
	
	public Escola(String nome, String observacao) {
		this.nome = nome;
		this.observacao = observacao;
		
		uuid = UUID.randomUUID().toString();
	}
	
	public long getId() {
		return id;
	}
	
	public String getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

	public Escola setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getObservacao() {
		return observacao;
	}

	public Escola setObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}
}
