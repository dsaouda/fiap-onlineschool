package br.com.fiap.dsaouda.javaweb.exception;

public class MensagemException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MensagemException() {
	}
	
	public MensagemException(String mensagem) {
		super(mensagem);
	}
}
