import java.time.LocalDate;

public class Transaction {
	
	private LocalDate dateOfTransaction;
	private String transactionType;
	private double transactionAmount;
	private double newBalance;

	public Transaction(String type, double amount, double newBalance) {
		// TODO Auto-generated constructor stub
		this.dateOfTransaction = java.time.LocalDate.now();
		this.transactionType = type;
		this.transactionAmount = amount;
		this.newBalance = newBalance;
	}
	
	@Override
	public String toString() {
		return "Date = " + this.getDateOfTransaction() + ", Type = " + this.getTransactionType() + ", Amount = " + this.getTransactionAmount() + ", New Balance = " + this.getNewBalance();
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public double getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}

	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}

}
