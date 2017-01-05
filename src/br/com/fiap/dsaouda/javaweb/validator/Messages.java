package br.com.fiap.dsaouda.javaweb.validator;

import javax.validation.ConstraintViolation;

public class Messages<T> {

	private String field;
	private String message;
	private Object invalidValue;
	
	public Messages(ConstraintViolation<T> v) {
		field = v.getPropertyPath().toString();
		message = v.getMessage();
		invalidValue = v.getInvalidValue();
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

	public Object getInvalidValue() {
		return invalidValue;
	}
	
	/**
	 * Propriedade usada para o getmdl (material design lite)
	 * @return Nome da propriedade esperada pelo material design lite
	 */
	public String isInvalid() {
		return "is-invalid";
	}
}
