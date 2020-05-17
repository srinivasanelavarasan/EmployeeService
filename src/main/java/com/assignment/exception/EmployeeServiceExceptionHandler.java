package com.assignment.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.assignment.model.ErrorDetails;

/**
 * The Class EmployeeServiceExceptionHandler. Global Exception handler
 */
@ControllerAdvice
@RestController
public class EmployeeServiceExceptionHandler {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceExceptionHandler.class);

	/**
	 * Handle runtime exception.
	 *
	 * @param ex      the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(value = { RuntimeException.class })
	public final ResponseEntity<ErrorDetails> handleRuntimeException(RuntimeException ex, WebRequest request) {
		logger.error("Runtime Exception : {}", ex.getMessage());
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Handle invalid account number exception.
	 *
	 * @param ex      the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleEmployeeNotFoundException(EmployeeNotFoundException ex,
			WebRequest request) {
		logger.error("EmployeeNotFoundException : {}", ex.getMessage());
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
