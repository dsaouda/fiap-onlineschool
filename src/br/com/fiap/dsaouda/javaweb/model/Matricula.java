package br.com.fiap.dsaouda.javaweb.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="matricula", uniqueConstraints={
	@UniqueConstraint(columnNames = {"id_curso", "id_aluno"})
})
public class Matricula implements Serializable {

	private static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyMMddHHmm");
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true, nullable=false)
	private String uuid;
	
	@Column(nullable=false, unique=true)
	private String codigo;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "id_aluno")
	private Usuario aluno;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date matriculadoEm = new Date();
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date cancelamentoEm;
	
	@Deprecated //JPA Only
	protected Matricula() {}
	
	public Matricula(Curso curso, Usuario aluno) {
		this.curso = curso;
		this.aluno = aluno;
		
		LocalDateTime now = LocalDateTime.now();
		
		codigo = format.format(now) + gerarMatricula(100, 999);
		uuid = UUID.randomUUID().toString();
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public Date getCancelamentoEm() {
		return cancelamentoEm;
	}

	public void setCancelamentoEm(Date cancelamentoEm) {
		this.cancelamentoEm = cancelamentoEm;
	}

	public long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public Date getMatriculadoEm() {
		return matriculadoEm;
	}

	private int gerarMatricula(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
