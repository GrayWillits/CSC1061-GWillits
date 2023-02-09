
public class Faculty extends Employee {
	
	private String officeHours;
	private String rank;

	public Faculty() {
		// TODO Auto-generated constructor stub
	}

	public Faculty(String name, String address, String phone, String email, String office, String salary,
			String dateHired, String officeHours, String rank) {
		super(name, address, phone, email, office, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}

	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toCSV() {
		return super.toCSV() + "," + officeHours + "," + rank;
	}

	@Override
	public String toString() {
		return super.toString() + ", officeHours=" + officeHours + ", rank=" + rank;
	}

}
