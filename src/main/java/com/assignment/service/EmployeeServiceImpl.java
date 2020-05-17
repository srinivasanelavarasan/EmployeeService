package com.assignment.service;

import static com.assignment.constant.Constants.XML_FILE_PATH;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.assignment.exception.EmployeeNotFoundException;
import com.assignment.model.Employee;
import com.assignment.util.XMLParser;

/**
 * The Class EmployeeServiceImpl.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assignment.service.EmployeeService#getAllEmployees()
	 */
	@Override
	public List<Employee> getAllEmployees() {
		logger.info("getAllEmployees method EmployeeServiceImpl invoked");
		List<Employee> empList = null;
		try {
			empList = XMLParser.parseEmployeesXML(XML_FILE_PATH);
			if (empList.isEmpty()) {
				logger.debug("Resultset empty for getAllEmployees Api in Service Impl");
				throw new EmployeeNotFoundException("Empty Resultset");
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new EmployeeNotFoundException("Exception while parsing" + e.getMessage());
		}
		return empList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assignment.service.EmployeeService#getEmployeeById(long)
	 */
	@Override
	public Employee getEmployeeById(long empId) {
		logger.info("getEmployeeById method EmployeeServiceImpl invoked");
		try {
			List<Employee> employeeList = XMLParser.parseEmployeesXML(XML_FILE_PATH);
			return employeeList.stream().filter(e -> e.getId() == empId).collect(Collectors.toList()).get(0);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new EmployeeNotFoundException(e.getMessage());
		} catch (IndexOutOfBoundsException e1) {
			throw new EmployeeNotFoundException(e1.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assignment.service.EmployeeService#deleteEmployee(long)
	 */
	@Override
	public boolean deleteEmployee(long empId) {
		logger.info("deleteEmployee method EmployeeServiceImpl invoked");
		try {
			return XMLParser.removeEmployee(XML_FILE_PATH, empId);
		} catch (Exception e) {
			throw new EmployeeNotFoundException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.assignment.service.EmployeeService#addEmployee(long, com.assignment.model.Employee)
	 */
	@Override
	public boolean addEmployee(long empId, Employee employee) {
		logger.info("addEmployee method EmployeeServiceImpl invoked");
		try {
			return XMLParser.addEmployee(XML_FILE_PATH, empId, employee);
		} catch (Exception e) {
			throw new EmployeeNotFoundException(e.getMessage());
		}
		
	}

}
