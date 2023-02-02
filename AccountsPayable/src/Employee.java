
public class Employee {
	private String first;
	private String last;
	private String SSN;
		
	public Employee(String first, String last, String SSN) {
		this.first = first;
		this.last = last;
		this.SSN = SSN;
	}

	public Employee() {
		this.first = "N/A";
		this.last = "N/A";
		this.SSN = "N/A";
	}
	
	public double getPaymentAmount() {
		return -1;
	}

	public String getFirst() {
		return this.first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return this.last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getSSN() {
		return this.SSN;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}

	@Override
	public String toString() {
		return "first = " + this.first + "\nlast = " + this.last + "\nSSN = " + this.SSN;
	}
	
	
}
