import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSchoolRecords {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Database test = new Database();
		Person person = new Person();
		Person person2 = new Person();
		
		test.writePerson(person);
		test.writePerson(person2);
	}

}
