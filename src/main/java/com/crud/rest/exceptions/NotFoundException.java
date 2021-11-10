package com.crud.rest.exceptions;

public class NotFoundException extends RuntimeException{

	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String mensaje) {
		super(mensaje);
	}
}
