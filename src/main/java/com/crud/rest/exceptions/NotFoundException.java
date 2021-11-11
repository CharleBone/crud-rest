package com.crud.rest.exceptions;

public class NotFoundException extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String mensaje) {
		super(mensaje);
	}
}
