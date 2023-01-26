
public class HourlyEmployee extends Employee {
	private double wage;
	private double hours;
	
	public HourlyEmployee(String first, String last, int SSN, double wage, double hours) {
		super(first, last, SSN);
		this.wage = wage;
		this.hours = hours;
	}
	
	public double getWage() {
		return wage;
	}
	
	public void setWage(double wage) {
		this.wage = wage;
	}
	
	public double getHours() {
		return hours;
	}
	
	public void setHours(double hours) {
		this.hours = hours;
	}

	@Override
	public double getPaymentAmount() {
		return hours * wage;
	}

	@Override
	public String toString() {
		return super.toString() + "\npayment amount = " + this.getPaymentAmount();
	}
	
	
	
}
