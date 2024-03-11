package com.icds.abertura_conta.exception;

public class EntityAlreadyExistsException extends ApiException {
	
	private static final long serialVersionUID = 1L;

	public EntityAlreadyExistsException(String message) {
		super(message);
	}

}
