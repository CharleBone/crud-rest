package com.crud.rest.exceptions;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundException(Exception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestException(Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleException(InvalidDataException exc) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        List<String> errores = exc.getResult().getFieldErrors()
                .stream()
                .map(err -> "El campo '" + err.getField() + " ' " + err.getDefaultMessage())
                .collect(Collectors.toList());
		return buildResponseEntity(httpStatus, new RuntimeException("Informacion invalida"), errores);
	}

	private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exc,
			List<String> errors) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exc.getMessage());
		error.setStatus(httpStatus.value());
		error.setErrors(errors);
		return new ResponseEntity<>(error, httpStatus);

	}
}
