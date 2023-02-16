import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
	
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private LocalDate dateCreated;
	private String name;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	public Account() {
		// TODO Auto-generated constructor stub
		this.dateCreated = java.time.LocalDate.now();
	}
	
	public Account(int id, double balance, double annualInterestRate) {
		
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = java.time.LocalDate.now();
	}
	
	public Account(String name, int id, double balance) {
		
		this.name = name;
		this.id = id;
		this.balance = balance;
		this.dateCreated = java.time.LocalDate.now();
	}

	public Account(int id, double balance, double annualInterestRate, String name) {

		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.name = name;
		this.dateCreated = java.time.LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMonthlyInterestRate() {
		return this.getAnnualInterestRate() / 12;
	}
	
	public double getMonthlyInterest() {
		return this.getBalance() * this.getMonthlyInterestRate() / 100;
	}
	
	public void withdraw(double withdraw) {
		this.setBalance(this.getBalance() - withdraw);
		transactions.add(new Transaction("W", withdraw, this.getBalance()));
	}
	
	public void deposit(double deposit) {
		this.setBalance(this.getBalance() + deposit);
		transactions.add(new Transaction("D", deposit, this.getBalance()));
	}
	
	@Override
	public String toString() {
		return "ID = " + this.getId() + ", Name = " + this.getName() + ", Date Created = " + this.getDateCreated() + ", Balance = " + this.getBalance() + ", Monthly Interest = " + this.getMonthlyInterest();
	}
	
	public void accountSummary() {
		
		System.out.println(this.toString());
		
		for (Transaction action: transactions) {
			System.out.println("  " + action.toString());
		}
		
	}

}
