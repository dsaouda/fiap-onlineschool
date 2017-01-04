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

@Entity
@Table(name="disciplina")
public class Disciplina implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length=255,nullable=false)
	private String nome;
	
	@Column(nullable=false, columnDefinition="TEXT")
	private String conteudoProgramatico;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_curso")
	private Curso curso;
}
