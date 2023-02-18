
/**
 * Extends Employee but also contains additional information pertaining to a Faculty member
 */
public class Faculty extends Employee {
	
	/**
	 * Stores a person's office hours
	 */
	private String officeHours;
	/**
	 * Stores a person's rank
	 */
	private String rank;

	/**
	 * Default constructor
	 */
	public Faculty() {
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
	 * @param officeHours Sets the person's office hours
	 * @param rank Sets the person's rank
	 */
	public Faculty(String name, String address, String phone, String email, String office, String salary,
			String dateHired, String officeHours, String rank) {
		super(name, address, phone, email, office, salary, dateHired);
		this.officeHours = officeHours.replace(",", "");
		this.rank = rank.replace(",", "");
	}

	/**
	 * Returns the person's office hours
	 * @return the officeHours of the person
	 */
	public String getOfficeHours() {
		return officeHours;
	}

	/**
	 * Sets the person's office hours
	 * @param officeHours the officeHours to set
	 */
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	/**
	 * Returns the person's rank
	 * @return the rank of the person
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Sets the person's rank
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * Returns information about the person in a CSV format
	 * @return Returns information about the person in a CSV format
	 */
	@Override
	public String toCSV() {
		return super.toCSV() + "," + officeHours + "," + rank;
	}

	/**
	 * Returns information about the person as a String
	 * @return Returns information about the person as a String
	 */
	@Override
	public String toString() {
		return super.toString() + ", officeHours=" + officeHours + ", rank=" + rank;
	}

}
