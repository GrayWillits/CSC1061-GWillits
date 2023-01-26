
public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double basePay;
	
	public BasePlusCommissionEmployee(String first, String last, int SSN, double grossSales, double commission, double basePay) {
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
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
