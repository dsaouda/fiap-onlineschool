package br.com.fiap.dsaouda.javaweb.model;

import static br.com.fiap.dsaouda.javaweb.model.AtividadePorcentagem.ATIVIDADEPRATICA;
import static br.com.fiap.dsaouda.javaweb.model.AtividadePorcentagem.PROJETO1;
import static br.com.fiap.dsaouda.javaweb.model.AtividadePorcentagem.PROJETO2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="nota", uniqueConstraints={
	@UniqueConstraint(columnNames = {"id_usuario", "id_disciplina"})
})
public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Range(min=0, max=10)
	@Column(precision=4, scale=2, nullable=true)
	private BigDecimal projeto1;
	
	@Range(min=0, max=10)
	@Column(precision=4, scale=2, nullable=true)
	private BigDecimal projeto2;
	
	@Range(min=0, max=10)
	@Column(precision=4, scale=2, nullable=true)
	private BigDecimal atividadePratica;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_disciplina", nullable=false)
	private Disciplina disciplina;

	public Nota() {}
	
	public Nota(Usuario usuario, Disciplina disciplina) {
		this.usuario = usuario;
		this.disciplina = disciplina;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getProjeto1() {
		return projeto1;
	}

	public void setProjeto1(BigDecimal projeto1) {
		this.projeto1 = projeto1;
	}

	public BigDecimal getProjeto2() {
		return projeto2;
	}

	public void setProjeto2(BigDecimal projeto2) {
		this.projeto2 = projeto2;
	}

	public BigDecimal getAtividadePratica() {
		return atividadePratica;
	}

	public void setAtividadePratica(BigDecimal atividadePratica) {
		this.atividadePratica = atividadePratica;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public BigDecimal getMedia() {
		if (!isAvaliado()) {
			return null;
		}
		
		BigDecimal nota1 = projeto1.multiply(PROJETO1.getPorcentagem());
		BigDecimal nota2 = atividadePratica.multiply(ATIVIDADEPRATICA.getPorcentagem());
		BigDecimal nota3 = projeto2.multiply(PROJETO2.getPorcentagem());		
		return nota1.add(nota2).add(nota3).round(MathContext.DECIMAL32);
	}

	public String getStatus() {
		if (!isAvaliado()) {
			return "-";			
		}
		
		return getMedia().floatValue() >= 7 ? "APROVADO" : "REPROVADO";
	}

	private boolean isAvaliado() {
		return projeto1 != null && atividadePratica != null && projeto2 != null;
	}
}
