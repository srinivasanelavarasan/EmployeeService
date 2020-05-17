package com.assignment.model;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Employee.
 */

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new employee.
 */

/**
 * Instantiates a new employee.
 */
@NoArgsConstructor

/**
 * Instantiates a new employee.
 *
 * @param id the id
 * @param name the name
 * @param age the age
 * @param designation the designation
 */

/**
 * Instantiates a new employee.
 *
 * @param id the id
 * @param name the name
 * @param age the age
 * @param designation the designation
 */
@AllArgsConstructor
public class Employee implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	@JacksonXmlProperty(isAttribute = true)
	private long id;
	
	/** The name. */
	@JacksonXmlProperty
	private String name;
	
	/** The age. */
	@JacksonXmlProperty
	private int age;
	
	/** The designation. */
	@JacksonXmlProperty
	private String designation;
}