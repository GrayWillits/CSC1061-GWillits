
public class AccountsPayable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] payableEmployees = new Employee[6];
		
		for (Employee Employees: payableEmployees) {
			System.out.println("FIX ME");
		}
	}
	
	public void print (Employee employee) {
		System.out.println(employee.toString());
	}
	
	public void otherPrint (Employee employee) {
		System.out.println("first = " + employee.getFirst()+ "\nlast = " + employee.getLast() + "\nSSN = " + employee.getSSN());
	}

}
