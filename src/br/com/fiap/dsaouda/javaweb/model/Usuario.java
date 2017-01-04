package br.com.fiap.dsaouda.javaweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length=120,nullable=false)
	private String nome;
	
	@Column(length=120, nullable=false, unique=true)
	private String email;
	
	@Column(length=120, nullable=false)
	private String senha;

	@Column(nullable=false)
	private boolean admin = false;
	
	@Deprecated //JPA ONLY
	protected Usuario() {}
	
	public Usuario(String nome, String email, String senha, boolean admin) {
		this.nome = nome;
		this.email = email;
		setSenha(senha);
		this.admin = admin;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", admin=" + admin
				+ "]";
	}

	public Usuario setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public Usuario setSenha(String senha) {
		String hashed = BCrypt.hashpw(senha, BCrypt.gensalt(12));
		
		this.senha = hashed;
		return this;
	}
	
	public Usuario setAdmin(boolean admin) {
		this.admin = admin;
		return this;
	}

	public boolean isSenhaValida(String senhaVisivel) {
		String hash = this.getSenha();
		return BCrypt.checkpw(senhaVisivel, hash);
	}
}
