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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="curso")
public class Curso implements Serializable {

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
	private String sobre;
	
	@Min(value=1)
	@Column(nullable=false)
	private int cargaHoraria = 0;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "id_escola")
	private Escola escola;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
	private Set<Disciplina> disciplinas = new HashSet<>();
	
	@Deprecated //JPA Only
	protected Curso() {}
	
	public Curso(Escola escola, String nome, String sobre, int cargaHoraria) {
		this.escola = escola;
		this.nome = nome;
		this.sobre = sobre;
		this.cargaHoraria = cargaHoraria;
		
		uuid = UUID.randomUUID().toString();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getSobre() {
		return sobre;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public Escola getEscola() {
		return escola;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public Curso setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public Curso setSobre(String sobre) {
		this.sobre = sobre;
		return this;
	}

	public Curso setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
		return this;
	}

	public Curso setEscola(Escola escola) {
		this.escola = escola;
		return this;
	}
}
