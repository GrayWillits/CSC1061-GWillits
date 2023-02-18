
/**
 * Extends Person but also contains additional information pertaining to an employee
 */
public class Employee extends Person {
	
	/**
	 * Stores a person's office
	 */
	private String office;
	/**
	 * Stores a person's salary
	 */
	private String salary;
	/**
	 * Stores the date a person was hired
	 */
	private String dateHired;

	/**
	 * Default constructor
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with parameters
	 * @param name Sets the person's name
	 * @param address Sets the person's address
	 * @param phone Sets the person's phone number
	 * @param email Sets the person's email
	 * @param office Sets the person's office
	 * @param salary Sets the person's salary
	 * @param dateHired Sets the person's date hired
	 */
	public Employee(String name, String address, String phone, String email, String office, String salary,
			String dateHired) {
		super(name, address, phone, email);
		this.office = office.replace(",", "");
		this.salary = salary.replace(",", "");
		this.dateHired = dateHired.replace(",", "");
	}
	
	/**
	 * Returns the person's office
	 * @return the office of the person
	 */
	public String getOffice() {
		return office;
	}

	/**
	 * Sets the person's office
	 * @param office the office to set
	 */
	public void setOffice(String office) {
		this.office = office;
	}

	/**
	 * Returns the person's salary
	 * @return the salary of the person
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * Sets the person's salary
	 * @param salary the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}

	/**
	 * Returns the person's date hired
	 * @return the dateHired of the person
	 */
	public String getDateHired() {
		return dateHired;
	}

	/**
	 * Sets the person's date hired
	 * @param dateHired the dateHired to set
	 */
	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}

	/**
	 * Returns information about the person in a CSV format
	 * @return Returns information about the person in a CSV format
	 */
	@Override
	public String toCSV() {
		return super.toCSV() + "," + office + "," + salary + "," + dateHired;
	}

	/**
	 * Returns information about the person as a String
	 * @return Returns information about the person as a String
	 */
	@Override
	public String toString() {
		return super.toString() + ", office=" + office + ", salary=" + salary + ", dateHired=" + dateHired;
	}

}
