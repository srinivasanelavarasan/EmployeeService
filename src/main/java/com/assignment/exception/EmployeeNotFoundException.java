package com.assignment.exception;

/**
 * The Class EmployeeNotFoundException.
 */
public class EmployeeNotFoundException extends RuntimeException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new employee not found exception.
	 *
	 * @param message the message
	 */
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
