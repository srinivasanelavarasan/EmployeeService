package com.assignment.exception;

/**
 * The Class DuplicateRecordException.
 */
public class DuplicateRecordException extends RuntimeException {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new employee not found exception.
	 *
	 * @param message the message
	 */
	public DuplicateRecordException(String message) {
		super(message);
	}
}
