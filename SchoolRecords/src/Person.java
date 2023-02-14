
public class Person {
	
	private String name;
	private String address;
	private String phone;
	private String email;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String address, String phone, String email) {
				
		this.name = name.replace(",", "");
		this.address = address.replace(",", "");
		this.phone = phone.replace(",", "");
		this.email = email.replace(",", "");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toCSV() {
		return getClass().toString().split(" ", 2)[1] + "," + name + "," + address + "," + phone + "," + email;
	}

	@Override
	public String toString() {
		return getClass().toString().split(" ", 2)[1] + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email;
	}

}
