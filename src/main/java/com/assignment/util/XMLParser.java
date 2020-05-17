package com.assignment.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.assignment.exception.EmployeeNotFoundException;
import com.assignment.model.Employee;

/**
 * The Class XMLParser.
 */
public final class XMLParser {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(XMLParser.class);

	/**
	 * Instantiates a new XML parser.
	 */
	private XMLParser() {
		throw new IllegalStateException("XMLParser class");
	}

	/**
	 * Parses the employees XML.
	 *
	 * @return the list
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException                 the SAX exception
	 * @throws IOException                  Signals that an I/O exception has
	 *                                      occurred.
	 */
	public static List<Employee> parseEmployeesXML(String xmlFilePath)
			throws ParserConfigurationException, SAXException, IOException {
		logger.info("parseEmployeesXML invoked with parameter: {}", xmlFilePath);
		List<Employee> employees = new ArrayList<>();
		Employee employee = null;
		Document document = createDocumentBuilderFactory(xmlFilePath);
		document.getDocumentElement().normalize();
		NodeList nList = document.getElementsByTagName("employee");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				employee = new Employee();
				employee.setId(Integer.parseInt(eElement.getAttribute("id")));
				employee.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
				employee.setAge(Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent()));
				employee.setDesignation(eElement.getElementsByTagName("designation").item(0).getTextContent());
				employees.add(employee);
			}
		}
		return employees;
	}

	/**
	 * Creates the document builder factory.
	 *
	 * @return the document
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException                 the SAX exception
	 * @throws IOException                  Signals that an I/O exception has
	 *                                      occurred.
	 */
	private static Document createDocumentBuilderFactory(String xmlFilePath)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(xmlFilePath));
		return document;
	}

	/**
	 * Removes the employee.
	 *
	 * @param empId the emp id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public static boolean removeEmployee(String xmlFilePath, long empId) throws Exception {
		logger.info("removeEmployee invoked with parameter: {}", xmlFilePath);
		Document document = createDocumentBuilderFactory(xmlFilePath);
		document.getDocumentElement().normalize();
		NodeList nList = document.getElementsByTagName("employee");
		boolean isEmpExists = false;
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				if (eElement.getAttribute("id").equals(String.valueOf(empId))) {
					eElement.getParentNode().removeChild(eElement);
					isEmpExists = true;
					break;
				}

			}
		}
		if (!isEmpExists)
			throw new EmployeeNotFoundException("No Record found for the given empId " + empId);
		document.normalize();
		prettyPrint(xmlFilePath, document);
		return true;
	}

	/**
	 * Pretty print.
	 *
	 * @param xml the xml
	 * @throws Exception the exception
	 */
	public static final void prettyPrint(String xmlFilePath, Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.transform(new DOMSource(xml), new StreamResult(xmlFilePath));
	}

}
