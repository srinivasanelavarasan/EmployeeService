package com.assignment.util;

import static com.assignment.constant.Constants.XML_FILE_PATH;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.assignment.model.Employee;

/**
 * The Class XMLParser.
 */
public final class XMLParser {

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
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static List<Employee> parseEmployeesXML() throws ParserConfigurationException, SAXException, IOException {
		List<Employee> employees = new ArrayList<>();
		Employee employee = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(XML_FILE_PATH));
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
	 * Removes the employee.
	 *
	 * @param empId the emp id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public static boolean removeEmployee(long empId) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new FileInputStream(new File(XML_FILE_PATH)));
        Element element = (Element) doc.getElementsByTagName("employee").item(111);
        element.getParentNode().removeChild(element);
        doc.normalize();
        prettyPrint(doc);  	
		return true;
	}
	
    /**
     * Pretty print.
     *
     * @param xml the xml
     * @throws Exception the exception
     */
    public static final void prettyPrint(Document xml) throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xml), new StreamResult(out));
        System.out.println(out.toString());
    }

}
