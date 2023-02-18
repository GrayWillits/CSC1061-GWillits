
/**
 * Class containing basic information about a person
 */
public class Person {
	
	/**
	 * Stores a person's name
	 */
	private String name;
	/**
	 * Stores a person's address
	 */
	private String address;
	/**
	 * Stores a person's phone number
	 */
	private String phone;
	/**
	 * Stores a person's email address
	 */
	private String email;

	/**
	 * Default constructor
	 */
	public Person() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with parameters
	 * @param name Sets the person's name
	 * @param address Sets the person's address
	 * @param phone Sets the person's phone number
	 * @param email Sets the person's email address
	 */
	public Person(String name, String address, String phone, String email) {
				
		this.name = name.replace(",", "");
		this.address = address.replace(",", "");
		this.phone = phone.replace(",", "");
		this.email = email.replace(",", "");
	}

	/**
	 * Returns the person's name
	 * @return the name of the person
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the person's name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the person's address
	 * @return the address of the person
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the person's address
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the person's phone
	 * @return the phone of the person
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the person's phone
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Returns the person's email
	 * @return the email of the person
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the person's email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns information about the person in a CSV format
	 * @return Returns information about the person in a CSV format
	 */
	public String toCSV() {
		return getClass().toString().split(" ", 2)[1] + "," + name + "," + address + "," + phone + "," + email;
	}

	/**
	 * Returns information about the person as a String
	 * @return Returns information about the person as a String
	 */
	@Override
	public String toString() {
		return getClass().toString().split(" ", 2)[1] + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email;
	}

}
