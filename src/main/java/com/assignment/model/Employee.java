package com.assignment.model;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Employee.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "employee")
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