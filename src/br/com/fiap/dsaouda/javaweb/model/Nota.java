package br.com.fiap.dsaouda.javaweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import static br.com.fiap.dsaouda.javaweb.model.AtividadePorcentagem.*;

@Entity
@Table(name="nota")
public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(precision=2,nullable=true)
	private float projeto1;
	
	@Column(precision=2,nullable=true)
	private float projeto2;
	
	@Column(precision=2,nullable=true)
	private float atividadePratica;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_disciplina")
	private Disciplina disciplina;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getProjeto1() {
		return projeto1;
	}

	public void setProjeto1(float projeto1) {
		this.projeto1 = projeto1;
	}

	public float getProjeto2() {
		return projeto2;
	}

	public void setProjeto2(float projeto2) {
		this.projeto2 = projeto2;
	}

	public float getAtividadePratica() {
		return atividadePratica;
	}

	public void setAtividadePratica(float atividadePratica) {
		this.atividadePratica = atividadePratica;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public float getMedia() {
		float nota1 = PROJETO1.getPorcentagem() * projeto1;
		float nota2 = ATIVIDADEPRATICA.getPorcentagem() * atividadePratica;
		float nota3 = PROJETO2.getPorcentagem() * projeto2;
		
		return nota1 + nota2 + nota3;
	}

	public String getStatus() {
		if (projeto1 > 0 && atividadePratica > 0 && projeto2 > 0) {
			return getMedia() >= 7 ? "APROVADO" : "REPROVADO";
		}
		
		return "-";
	}
}
