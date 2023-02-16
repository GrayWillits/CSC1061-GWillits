
public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Start of Part 1
		
		Account test1 = new Account(1122, 20000, 4.5);
		
		SavingsAccount test2 = new SavingsAccount(2000, 5000, 7);
		CheckingAccount test3 = new CheckingAccount(3000, 15000, 3.5);
		
		test1.withdraw(2500);
		test1.deposit(3000);
		
		System.out.println(test1.toString());
		
		System.out.println(test2.toString());
		System.out.println(test3.toString());
		
		//End of Part 1
		
		
		
		//Start of Part 2
		
		CheckingAccount test4 = new CheckingAccount(1122, 1000, 1.5, "George");
		
		test4.deposit(30);
		test4.deposit(40);
		test4.deposit(50);
		
		test4.withdraw(5);
		test4.withdraw(4);
		test4.withdraw(2);
		
		test4.accountSummary();
		
		//End of Part 2

	}

}
