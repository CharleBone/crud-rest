package com.crud.rest.exceptions;

import java.util.Date;
import java.util.List;

public class ErrorResponse {

	private int status;

	private String message;

	private Date timestamp;

	List<String> errors;

	ErrorResponse(String message) {
		this.message = message;
	}
	
	ErrorResponse() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
