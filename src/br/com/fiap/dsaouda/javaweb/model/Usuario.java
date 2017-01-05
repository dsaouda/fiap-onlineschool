package br.com.fiap.dsaouda.javaweb.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true, nullable=false)
	private String uuid;
	
	@Size(min=4, max=80, message="Nome precisa ter mais de {min} caracteres e menos que {max}")
	@Column(length=80,nullable=false)
	private String nome;
	
	@NotNull(message="Preencha o campo e-mail")
	@NotBlank(message="E-mail não é válido")
	@Email(message="E-mail não é válido")
	@Column(length=120, nullable=false, unique=true)
	private String email;
	
	@Column(length=120, nullable=false)
	private String senha;
	
	@Transient
	@Size(min=4, message="Senha precisa ter no mínimo {min} caracteres")
	private String plainSenha;

	@Column(nullable=false)
	private boolean admin = false;
	
	@Deprecated //JPA ONLY
	protected Usuario() {}
	
	public Usuario(String nome, String email, String senha, boolean admin) {
		this.nome = nome;
		this.email = email;
		setSenha(senha);
		this.admin = admin;
		
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

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public Usuario setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public Usuario setSenha(String senha) {
		this.plainSenha = senha;
		
		if (senha != null && !senha.isEmpty()) {
			String hashed = BCrypt.hashpw(senha, BCrypt.gensalt(12));
		
			this.senha = hashed;
		}
		
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
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", admin=" + admin
				+ "]";
	}
}
