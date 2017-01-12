package br.com.fiap.dsaouda.javaweb.exception;

public class SemPermissaoException extends MensagemException {
	private static final long serialVersionUID = 1L;

	public SemPermissaoException() {
		super("Você não tem permissão para acessar esse recurso");
	}
}
