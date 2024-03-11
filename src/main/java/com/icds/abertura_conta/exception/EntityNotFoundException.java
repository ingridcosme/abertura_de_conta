package com.icds.abertura_conta.exception;

public class EntityNotFoundException extends ApiException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
