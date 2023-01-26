
public class Employee {
	private String first;
	private String last;
	private int SSN;
		
	public Employee(String first, String last, int SSN) {
		this.first = first;
		this.last = last;
		this.SSN = SSN;
	}

	public Employee() {
		this.first = "N/A";
		this.last = "N/A";
		this.SSN = -1;
	}
	
	public double getPaymentAmount() {
		return -1;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public int getSSN() {
		return SSN;
	}

	public void setSSN(int sSN) {
		SSN = sSN;
	}
	
	
}
