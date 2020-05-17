package com.assignment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.exception.DuplicateRecordException;
import com.assignment.exception.EmployeeNotFoundException;
import com.assignment.model.Employee;
import com.assignment.model.Employees;
import com.assignment.service.EmployeeService;

/**
 * The Class EmployeeController.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	/** The employee service. */
	private EmployeeService employeeService;

	/**
	 * Instantiates a new employee controller.
	 *
	 * @param employeeService the employee service
	 */
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * Gets the all employees.
	 *
	 * @param httpRequest the http request
	 * @return the all employees
	 */
	@GetMapping(value = "/v1/employees", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Employees> getAllEmployees(HttpServletRequest httpRequest) {
		Employees employees = new Employees();
		try {
			List<Employee> employeeList = employeeService.getAllEmployees();
			employees.setEmployee(employeeList);
		} catch (EmployeeNotFoundException e) {
			logger.error("Exception Occured in getAllEmployees : {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	/**
	 * Gets the employee.
	 *
	 * @param empId       the emp id
	 * @param httpRequest the http request
	 * @return the employee
	 */
	@GetMapping(value = "/v1/employees/{empId}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") long empId, HttpServletRequest httpRequest) {
		Employee employee;
		try {
			employee = employeeService.getEmployeeById(empId);
		} catch (EmployeeNotFoundException e) {
			logger.error("Exception Occured in getEmployee : {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	/**
	 * Delete employee.
	 *
	 * @param empId       the emp id
	 * @param httpRequest the http request
	 * @return the response entity
	 */
	@DeleteMapping(value = "/v1/employees/{empId}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empId") long empId, HttpServletRequest httpRequest) {
		try {
			employeeService.deleteEmployee(empId);
		} catch (EmployeeNotFoundException e) {
			logger.error("Exception Occured in deleteEmployee : {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/v1/employees/{empId}/add", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Void> addEmployee(@PathVariable("empId") long empId, @RequestBody Employee employee,
			HttpServletRequest httpRequest) {
		try {
			if (employee.getId() != empId) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			employeeService.addEmployee(empId, employee);
		} catch (DuplicateRecordException e) {
			logger.error("Exception Occured in addEmployee : {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
