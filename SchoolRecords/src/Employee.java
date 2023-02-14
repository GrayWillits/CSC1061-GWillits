
public class Employee extends Person {
	
	private String office;
	private String salary;
	private String dateHired;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String address, String phone, String email, String office, String salary,
			String dateHired) {
		super(name, address, phone, email);
		this.office = office.replace(",", "");
		this.salary = salary.replace(",", "");
		this.dateHired = dateHired.replace(",", "");
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDateHired() {
		return dateHired;
	}

	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}

	@Override
	public String toCSV() {
		return super.toCSV() + "," + office + "," + salary + "," + dateHired;
	}

	@Override
	public String toString() {
		return super.toString() + ", office=" + office + ", salary=" + salary + ", dateHired=" + dateHired;
	}

}
