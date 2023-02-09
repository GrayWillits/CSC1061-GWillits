import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSchoolRecords {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Database test = new Database();
		Person person = new Person();
		Employee person2 = new Employee();
		
		System.out.println(person2.toCSV());
		
		test.writePerson(person2);
		test.writePerson(person);
		
		test.readDatabase();
	}

}
