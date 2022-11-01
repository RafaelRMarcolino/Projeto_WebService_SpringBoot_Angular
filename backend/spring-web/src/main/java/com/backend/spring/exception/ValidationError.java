package com.backend.spring.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ErrorDetails {
private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();


	public ValidationError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
	}
	
	public List<FieldMessage> getErrors(){
		
		return errors;
	}

	public void addError(String fieldName, String messegem) {
		errors.add(new FieldMessage(fieldName, messegem));
	}
}
