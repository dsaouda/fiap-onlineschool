package br.com.fiap.dsaouda.javaweb.exception;

public class SemPermissaoException extends MensagemException {
	private static final long serialVersionUID = 1L;

	public SemPermissaoException() {
		super("Voc� n�o tem permiss�o para acessar esse recurso");
	}
}
