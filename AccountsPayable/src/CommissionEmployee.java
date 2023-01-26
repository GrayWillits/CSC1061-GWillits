
public class CommissionEmployee extends Employee {
	private double grossSales;
	private double commission;
	
	public double getGrossSales() {
		return grossSales;
	}
	
	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}
	
	public double getCommission() {
		return commission;
	}
	
	public void setCommission(double commission) {
		this.commission = commission;
	}

	@Override
	public double getPaymentAmount() {
		return grossSales * commission;
	}

	@Override
	public String toString() {
		return super.toString() + "\npayment amount = " + this.getPaymentAmount();
	}

	public CommissionEmployee(String first, String last, int SSN, double grossSales, double commission) {
		super(first, last, SSN);
		this.grossSales = grossSales;
		this.commission = commission;
	}
	
	
}
