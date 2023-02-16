
public class SavingsAccount extends Account {

	public SavingsAccount() {
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(int id, double balance, double annualInterestRate) {
		super(id, balance, annualInterestRate);
		// TODO Auto-generated constructor stub
	}
	
	public SavingsAccount(int id, double balance, double annualInterestRate, String name) {
		super(id, balance, annualInterestRate, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void withdraw(double withdraw) {
		if (withdraw <= this.getBalance()) {
			super.withdraw(withdraw);
		}
		else {
			System.out.println("Current Balance of " + this.getBalance() + ", Withdraw Failed");
		}
	}

}
