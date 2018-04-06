package com.hcl.assessment.controller.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
/**
 * Custom exception handler for response entity.
 * @author kanika.sharma
 *
 */

@ControllerAdvice
public class CustomResponseEntityExceptionHandler {
	
	@ExceptionHandler(InvalidInputException.class)
	  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(InvalidInputException ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	  }
}
