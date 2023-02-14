
public class Student extends Person {
	
	private String status;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String address, String phone, String email, String status) {
		super(name, address, phone, email);
		this.status = status.replace(",", "");
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toCSV() {
		return super.toCSV() + "," + status;
	}

	@Override
	public String toString() {
		return super.toString() + ", status=" + status;
	}

}
