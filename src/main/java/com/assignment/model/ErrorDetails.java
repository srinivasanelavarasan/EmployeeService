package com.assignment.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The Class ErrorDetails. Helps to build error response for an API
 */
@Data
@AllArgsConstructor
public class ErrorDetails {

	/** The timestamp. */
	private Date timestamp;

	/** The message. */
	private String message;

	/** The details. */
	private String details;

}
