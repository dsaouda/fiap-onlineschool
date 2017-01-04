package br.com.fiap.dsaouda.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="escola")
public class Escola {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length=255,nullable=false)
	private String nome;
	
	@Column(nullable=false, columnDefinition="TEXT")
	private String observacao;
	
}
