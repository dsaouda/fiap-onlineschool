package br.com.fiap.dsaouda.javaweb.model;

import java.io.Serializable;
import java.util.Date;
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

@Entity
@Table(name="logger")
public class Logger implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true, nullable=false)
	private String uuid;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Column(unique=false, nullable=true)
	private String perfil;
	
	@Column(unique=false, nullable=false)
	private String ip;
	
	@Column(unique=false, nullable=false)
	private String url;
	
	@Column(unique=false, nullable=false)
	private String metodo;
	
	@Column(unique=false, nullable=true)
	private String info;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(unique=false, nullable=false)
	private Date dataEvento = new Date();
	
	@Deprecated //JPA ONLY
	protected Logger() {}
	
	public Logger(Usuario usuario, String perfil, String ip, String url, String metodo, String info) {
		this.usuario = usuario;
		this.perfil = perfil;
		this.ip = ip;
		this.url = url;
		this.metodo = metodo;
		this.info = info;
		
		uuid = UUID.randomUUID().toString();
	}

	public Logger(String ip, String url, String metodo, String info) {
		this.ip = ip;
		this.url = url;
		this.metodo = metodo;
		this.info = info;
		
		uuid = UUID.randomUUID().toString();
	}

	public long getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getPerfil() {
		return perfil;
	}

	public String getIp() {
		return ip;
	}

	public String getUrl() {
		return url;
	}

	public String getMetodo() {
		return metodo;
	}

	public String getInfo() {
		return info;
	}
	
	public Date getDataEvento() {
		return dataEvento;
	}

	@Override
	public String toString() {
		String email = "Desconhecido (Não logado)";
		if (usuario != null) {
			email = usuario.getEmail();
		}
		
		return "Logger [usuario=" + email + ", perfil=" + perfil + ", ip=" + ip
				+ ", url=" + url + ", metodo=" + metodo + ", info=" + info + "]";
	}
}