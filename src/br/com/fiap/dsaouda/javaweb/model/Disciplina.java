package br.com.fiap.dsaouda.javaweb.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="disciplina")
public class Disciplina implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true, nullable=false)
	private String uuid;
	
	@Size(min=4, max=80, message="Nome precisa ter mais de {min} caracteres e menos que {max}")
	@Column(length=255,nullable=false)
	private String nome;
	
	@NotEmpty
	@NotBlank
	@NotNull
	@Column(nullable=false, columnDefinition="TEXT")
	private String conteudoProgramatico;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "id_professor")
	private Usuario professor;
	
	@Deprecated //JPA Only
	protected Disciplina() {}
	
	public Disciplina(Curso curso, Usuario professor, String nome, String conteudoProgramatico) {
		this.curso = curso;
		this.professor = professor;
		this.nome = nome;
		this.conteudoProgramatico = conteudoProgramatico;
		
		uuid = UUID.randomUUID().toString();
	}

	public String getNome() {
		return nome;
	}

	public Disciplina setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getConteudoProgramatico() {
		return conteudoProgramatico;
	}

	public Disciplina setConteudoProgramatico(String conteudoProgramatico) {
		this.conteudoProgramatico = conteudoProgramatico;
		return this;
	}

	public Curso getCurso() {
		return curso;
	}

	public Disciplina setCurso(Curso curso) {
		this.curso = curso;
		return this;
	}

	public Usuario getProfessor() {
		return professor;
	}

	public Disciplina setProfessor(Usuario professor) {
		this.professor = professor;
		return this;
	}

	public long getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}
}
