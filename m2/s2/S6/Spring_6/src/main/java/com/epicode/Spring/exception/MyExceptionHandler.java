package com.epicode.Spring.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> manageEntityNotFoundException(EntityNotFoundException e) {
		// NOT_FOUND -> EntityNotFoundException
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<String> manageEntityExistsException(EntityExistsException e) {
		// FOUND -> EntityExistsException
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
	}
	

}
