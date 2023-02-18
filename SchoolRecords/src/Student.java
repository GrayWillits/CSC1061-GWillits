
/**
 * Extends Person but also contains additional information pertaining to a student
 */
public class Student extends Person {
	
	/**
	 * Store's a person's status
	 */
	private String status;

	/**
	 * Default constructor
	 */
	public Student() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with parameters
	 * @param name Sets the person's name
	 * @param address Sets the person's address
	 * @param phone Sets the person's phone number
	 * @param email Sets the person's email address
	 * @param status Sets the person's status
	 */
	public Student(String name, String address, String phone, String email, String status) {
		super(name, address, phone, email);
		this.status = status.replace(",", "");
	}


	/**
	 * Returns the person's status
	 * @return the status of the person
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the person's status
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Returns information about the person in a CSV format
	 * @return Returns information about the person in a CSV format
	 */
	@Override
	public String toCSV() {
		return super.toCSV() + "," + status;
	}

	/**
	 * Returns information about the person as a String
	 * @return Returns information about the person as a String
	 */
	@Override
	public String toString() {
		return super.toString() + ", status=" + status;
	}

}
