package br.com.fiap.dsaouda.javaweb.validator;

import java.util.HashMap;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class SimpleValidation<T> {
	private static Validator validator;
	private Set<ConstraintViolation<T>> validate;
	
	static {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	public SimpleValidation(T obj) {
		validate = validator.validate(obj);
	}
	
	public boolean isValid() {
		return validate.isEmpty();
	}
	
	public HashMap<String, Messages<T>> getErrors() {
		HashMap<String, Messages<T>> errors = new HashMap<>();
		
		validate.forEach(v -> {
			Messages<T> messages = new Messages<T>(v);
			errors.put(messages.getField(), messages);
		});
		
		return errors;
	}
}
