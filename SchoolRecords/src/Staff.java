
public class Staff extends Employee {
	
	private String title;

	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(String name, String address, String phone, String email, String office, String salary,
			String dateHired, String title) {
		super(name, address, phone, email, office, salary, dateHired);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toCSV() {
		return super.toCSV() + "," + title;
	}

	@Override
	public String toString() {
		return super.toString() + ", title=" + title;
	}

}
