import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class AccountsPayable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		
		ArrayList<Employee> payableEmployees = new ArrayList<Employee>();
		ArrayList<String> check = new ArrayList<String>(Arrays.asList("commission", "base plus commission", "hourly", "salary", "base"));
		
		String type, first, last, SSN;
		int sales, commission, base, wage, hours, salary;
		
		
		for (int i = 0; i < 6; i++) {
			
			type = null;
			while (true) {
				System.out.println("Enter employee type, use \"Commission\" \"Base Plus Commission\" \"Hourly\" \"Salary\" or \"Base\"");
				type = scnr.nextLine();
				if (check.contains(type.toLowerCase())) {
					break;
				} 
				else {
					System.out.println("Invalid input");
				}
			}
			
			//first, last, SSN
			System.out.println("Enter first name");
			first = scnr.nextLine();
			System.out.println("Enter last name");
			last = scnr.nextLine();
			System.out.println("Enter SSN");
			SSN = scnr.nextLine();

			if (type.toLowerCase().equals("commission")) {
				//gross sales, commission
				System.out.println("Enter gross sales");
				sales = scnr.nextInt();
				System.out.println("Enter commission");
				commission = scnr.nextInt();
				
				payableEmployees.add(new CommissionEmployee(first, last, SSN, sales, commission));
			}
			else if (type.toLowerCase().equals("base plus commission")) {
				//base pay, all from commission
				System.out.println("Enter gross sales, must be type Int");
				sales = scnr.nextInt();
				System.out.println("Enter commission, must be type Int");
				commission = scnr.nextInt();				
				System.out.println("Enter base pay, must be type Int");
				base = scnr.nextInt();
				
				payableEmployees.add(new BasePlusCommissionEmployee(first, last, SSN, sales, commission, base));
			}
			else if (type.toLowerCase().equals("hourly")) {
				//wage, hours
				System.out.println("Enter wage, must be type Int");
				wage = scnr.nextInt();
				System.out.println("Enter hours, must be type Int");
				hours = scnr.nextInt();
				
				payableEmployees.add(new HourlyEmployee(first, last, SSN, wage, hours));
			}
			else if (type.toLowerCase().equals("salary")) {
				//weekly salary
				System.out.println("Enter salary, must be type Int");
				salary = scnr.nextInt();
				
				payableEmployees.add(new SalariedEmployee(first, last, SSN, salary));
			}
			else if (type.toLowerCase().equals("base")) {
				payableEmployees.add(new Employee(first, last, SSN));
			}
			
		}
		
		
		for (Employee employee: payableEmployees) {
			System.out.println(employee.getFirst() + " " + employee.getLast() + " : " + employee.getPaymentAmount());
		}
		
		for (Employee employee: payableEmployees) {
			if (employee.getClass() == BasePlusCommissionEmployee.class) {
				((BasePlusCommissionEmployee) employee).setBasePay(1.1 * ((BasePlusCommissionEmployee) employee).getBasePay());
			}
		}
		
		for (Employee employee: payableEmployees) {
			System.out.println(employee.getFirst() + " " + employee.getLast() + " : " + employee.getPaymentAmount());
		}
		
	}
	
	public void print (Employee employee) {
		System.out.println(employee.toString());
	}
	
	public void otherPrint (Employee employee) {
		System.out.println("first = " + employee.getFirst()+ "\nlast = " + employee.getLast() + "\nSSN = " + employee.getSSN());
	}

}
