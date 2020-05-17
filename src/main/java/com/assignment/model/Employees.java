package com.assignment.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Employees.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employees. */
	@JacksonXmlProperty
	private List<Employee> employee;
}