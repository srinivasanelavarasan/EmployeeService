package com.assignment.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * The Class LoggingAspect. This class helps us to append logs in every method
 * entry and exit.
 */
@Aspect
@Component
@Configuration
public class LoggingAspect {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	@Before("execution(* com.assignment.controller.EmployeeController.getAllEmployees(..))")
	public void getAllEmployees() {
		logger.info("Execute advice on getAllEmployees()");
	}

	/**
	 * Gets the all employees after.
	 *
	 * @return the all employees after
	 */
	@After("execution(* com.assignment.controller.EmployeeController.getAllEmployees(..))")
	public void getAllEmployeesAfter() {
		logger.info("Execute advice on getAllEmployees() After");
	}

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	@Before("execution(* com.assignment.controller.EmployeeController.getEmployee(..))")
	public void getEmployee() {
		logger.info("Execute advice on getEmployee()");
	}

	/**
	 * Gets the employee after.
	 *
	 * @return the employee after
	 */
	@After("execution(* com.assignment.controller.EmployeeController.getEmployee(..))")
	public void getEmployeeAfter() {
		logger.info("Execute advice on getEmployee() After");
	}

}
