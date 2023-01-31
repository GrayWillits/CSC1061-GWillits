
public class AccountsPayable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] payableEmployees = new Employee[6];
		
		for (Employee employee: payableEmployees) {
			System.out.println("FIX ME");
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
