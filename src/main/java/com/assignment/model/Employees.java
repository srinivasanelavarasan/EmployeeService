package com.assignment.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The Class Employees.
 */
@JacksonXmlRootElement(localName = "employees")
public class Employees implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employees. */
	@JacksonXmlProperty
	private List<Employee> employees;

	/**
	 * Instantiates a new employees.
	 *
	 * @param employees the employees
	 */
	public Employees(List<Employee> employees) {
		super();
		this.employees = employees;
	}

	/**
	 * Instantiates a new employees.
	 */
	public Employees() {
		super();
	}

	/**
	 * Gets the employees.
	 *
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * Sets the employees.
	 *
	 * @param employees the new employees
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
