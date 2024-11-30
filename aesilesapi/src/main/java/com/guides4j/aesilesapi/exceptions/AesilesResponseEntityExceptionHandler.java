package com.guides4j.aesilesapi.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.guides4j.aesilesapi.models.AesilesApiErrorDetails;

@ControllerAdvice
public class AesilesResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<AesilesApiErrorDetails> handleAllExceptions(Exception ex, WebRequest request)
			throws Exception {
		AesilesApiErrorDetails apiErrors = new AesilesApiErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<AesilesApiErrorDetails>(apiErrors, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<AesilesApiErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request)
			throws Exception {
		AesilesApiErrorDetails apiErrors = new AesilesApiErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<AesilesApiErrorDetails>(apiErrors, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		AesilesApiErrorDetails errorDetails = new AesilesApiErrorDetails(LocalDateTime.now(),
				"Total Errors:" + ex.getErrorCount() + "Error:" + ex.getFieldError().getDefaultMessage(),
				request.getDescription(false));

		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
