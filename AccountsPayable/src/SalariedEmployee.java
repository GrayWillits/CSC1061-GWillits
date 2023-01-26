
public class SalariedEmployee extends Employee {
	private double weeklySalary;

	public SalariedEmployee(String first, String last, int SSN, double weeklySalary) {
		super(first, last, SSN);
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}
	
	@Override
	public double getPaymentAmount() {
		return weeklySalary;
	}

	@Override
	public String toString() {
		return super.toString() + "\npayment amount = " + this.getPaymentAmount();
	}
	
}
