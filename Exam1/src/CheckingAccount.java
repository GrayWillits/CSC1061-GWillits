
public class CheckingAccount extends Account {
	
	private double overdraftLimit = 200;

	public CheckingAccount() {
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(int id, double balance, double annualInterestRate) {
		super(id, balance, annualInterestRate);
		// TODO Auto-generated constructor stub
	}
	
	public CheckingAccount(int id, double balance, double annualInterestRate, String name) {
		super(id, balance, annualInterestRate, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void withdraw(double withdraw) {
		if (withdraw <= (this.getBalance() + overdraftLimit)) {
			super.withdraw(withdraw);
		}
		else {
			System.out.println("Overdraft Limit of " + this.getOverdraftLimit() + ", Current Balance of " + this.getBalance() + ", Withdraw Failed");
		}
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Overdraft Limit = " + this.getOverdraftLimit();
	}

}
