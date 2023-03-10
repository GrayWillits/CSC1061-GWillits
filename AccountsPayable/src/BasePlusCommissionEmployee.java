
public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double basePay;
	
	public BasePlusCommissionEmployee(String first, String last, String SSN, double grossSales, double commission, double basePay) {
		super(first, last, SSN, grossSales, commission);
		this.setBasePay(basePay);
	}

	public double getBasePay() {
		return basePay;
	}

	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return super.getPaymentAmount() + this.basePay;
	}

	@Override
	public String toString() {
		return "first = " + this.getFirst() + "\nlast = " + this.getLast() + "\nSSN = " + this.getSSN() + "\npayment amount = " + this.getPaymentAmount();
	}
	
}
