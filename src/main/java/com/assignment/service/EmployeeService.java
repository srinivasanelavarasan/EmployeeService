package com.assignment.service;

import java.util.List;

import com.assignment.model.Employee;

/**
 * The Interface EmployeeService.
 */
public interface EmployeeService {

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	List<Employee> getAllEmployees();
	
	/**
	 * Gets the employee by id.
	 *
	 * @param empId the emp id
	 * @return the employee by id
	 */
	Employee getEmployeeById(long empId);
	
	/**
	 * Delete employee.
	 *
	 * @param empId the emp id
	 * @return true, if successful
	 */
	boolean deleteEmployee(long empId);
}
