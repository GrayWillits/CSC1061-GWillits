
/**
 * Extends Employee but also contains additional information pertaining to a Staff member
 */
public class Staff extends Employee {
	
	/**
	 * Stores a person's title
	 */
	private String title;

	/**
	 * Default constructor
	 */
	public Staff() {
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
	 * @param title Sets the person's title
	 */
	public Staff(String name, String address, String phone, String email, String office, String salary,
			String dateHired, String title) {
		super(name, address, phone, email, office, salary, dateHired);
		this.title = title.replace(",", "");
	}

	/**
	 * Returns the person's title
	 * @return the title of the person
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the person's title
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns information about the person in a CSV format
	 * @return Returns information about the person in a CSV format
	 */
	@Override
	public String toCSV() {
		return super.toCSV() + "," + title;
	}

	/**
	 * Returns information about the person as a String
	 * @return Returns information about the person as a String
	 */
	@Override
	public String toString() {
		return super.toString() + ", title=" + title;
	}

}
