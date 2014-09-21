import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable.PrintMode;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

public class JavaToXMLDemo {

	public static void main(String[] args) throws Exception {
		JavaToXMLDemo demo = new JavaToXMLDemo();
		JAXBContext context = JAXBContext.newInstance(Organisation.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(demo.getObject(), System.out);
	}

	Organisation getObject() {
		Organisation organisation = new Organisation("Nokia");

		Employee object = new Employee();
		object.setCode("CA");
		object.setName("Cath");
		object.setSalary(300);
		ArrayList<String> nameField = new ArrayList<String>();
		nameField.add("CA");
		nameField.add("Cath");
		object.setNamField(nameField);

		Employee object1 = new Employee();
		object1.setCode("DEV");
		object1.setName("Dharmendra");
		object1.setSalary(2000000);
		ArrayList<Employee> array = new ArrayList<Employee>();
		array.add(object);
		array.add(object1);
		
		ArrayList<String> nameField1 = new ArrayList<String>();
		nameField1.add("CA");
		nameField1.add("Cath");
		object.setNamField(nameField1);

		organisation.setEmployees(array);
		return organisation;
	}
}

// @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "name", "code", "namField", "salary" })
@XmlRootElement(name = "employee")
class Employee {
	private String code;
	private String name;
	ArrayList<String> namField = new ArrayList<String>();

	private int salary;

	public Employee() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int population) {
		this.salary = population;
	}

	/**
	 * @return the namField
	 */
	public ArrayList<String> getNamField() {
		return namField;
	}

	/**
	 * @param namField
	 *            the namField to set
	 */
	public void setNamField(ArrayList<String> namField) {
		this.namField = namField;
	}
}

// @XmlType(propOrder = { "name", "employees" })
@XmlRootElement(name = "org")
class Organisation {
	ArrayList<Employee> employees = new ArrayList<Employee>();

	String name;

	public Organisation() {
	}

	public Organisation(String name) {
		this.name = name;
	}

	/**
	 * @return the employees
	 */
	@XmlElement
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees
	 *            the employees to set
	 */
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * @return the name
	 */
	@XmlTransient
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}