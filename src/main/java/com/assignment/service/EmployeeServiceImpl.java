package com.assignment.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;

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

	/* (non-Javadoc)
	 * @see com.assignment.service.EmployeeService#getAllEmployees()
	 */
	@Override
	public List<Employee> getAllEmployees() {
		try {
			return XMLParser.parseEmployeesXML();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new EmployeeNotFoundException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.assignment.service.EmployeeService#getEmployeeById(long)
	 */
	@Override
	public Employee getEmployeeById(long empId) {
		try {
			List<Employee> employeeList = XMLParser.parseEmployeesXML();
			return employeeList.stream().filter(e -> e.getId() == empId).collect(Collectors.toList()).get(0);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new EmployeeNotFoundException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.assignment.service.EmployeeService#deleteEmployee(long)
	 */
	@Override
	public boolean deleteEmployee(long empId) {
		try {
			return XMLParser.removeEmployee(empId);
		} catch (Exception e) {
            throw new EmployeeNotFoundException(e.getMessage());
		}
	}

}
