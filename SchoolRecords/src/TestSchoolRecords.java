import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**	
 * 
 * @author Gray Willits
 * 
 * 
 */

/**
 * 
 * Describe what a class does
 *
 */

/**
 * Describe what a method does
 * 
 * @param if applicable
 * 
 * @return if applicable
 *
 */




public class TestSchoolRecords {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Database database = new Database();
		ArrayList<Person> data;
		
		Person person1 = new Student("Kevin", "8642 Real Drive", "(555) 555-5555", "KevinX@email.edu", "Senior");
		Person person2 = new Student("Ivy", "1234 Boardwalk Avenue", "+1 (970) 585-1234", "IvyM@email.edu", "Freshman");
		
		Person person3 = new Faculty("Ryan", "2513 Place Lane", "723-8123", "Ryannnn@company.org", "Headquarters", "67890", "02/24/3725", "9-5", "Junior");
		Person person4 = new Faculty("Sam", "4215 Something Circle", "+1 123-4567", "Sammy@company.org", "Branch Office 1", "103657", "45/65/2502","10-8", "Senior");
		
		Person person5 = new Staff("Ava", "9876 House Street", "(888) 888-8888", "Ava@something.com", "Colorado Main", "679867", "45/68/4521", "Manager");
		Person person6 = new Staff("May", "6356 Park Plaza", "789-1234", "May@something.com", "New York City", "65458", "45/48/3215", "Janitor");
		
		database.writePerson(person1);
		database.writePerson(person2);
		database.writePerson(person3);
		database.writePerson(person4);
		database.writePerson(person5);
		database.writePerson(person6);
		
		data = database.readDatabase();
		
		for (Person person: data) {
			System.out.println(person.toString());
		}
	}

}
