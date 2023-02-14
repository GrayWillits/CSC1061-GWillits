import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
	
	private final String FILE_NAME = "PersonDatabase.txt";

	public Database() throws IOException {
		// TODO Auto-generated constructor stub
		File myFile = new File(FILE_NAME);
		
		if (!myFile.exists()) {
			if (myFile.createNewFile()) {
				System.out.println("Created new file");
			}
		}
	}
	
	public void writePerson (Person person) throws IOException {
		
		PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_NAME, true));
		
		writer.println(person.toCSV());
		
		writer.close();
	}
	
	public ArrayList<Person> readDatabase () throws FileNotFoundException {
		
		ArrayList<Person> data = new ArrayList<Person>();
		ArrayList<String[]> tempData = new ArrayList<String[]>();
		
		File myFile = new File(FILE_NAME);
		Scanner reader = new Scanner(myFile);
		
		while (reader.hasNextLine()) {
			tempData.add(reader.nextLine().split(","));
		}
		
		for (String[] temp: tempData) {
			if (temp[0].equals("Person")) {
				data.add(new Person(temp[1], temp[2], temp[3], temp[4]));
			}
			else if (temp[0].equals("Employee")) {
				data.add(new Employee(temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]));
			}
			else if (temp[0].equals("Faculty")) {
				data.add(new Faculty(temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]));
			}
			else if (temp[0].equals("Staff")) {
				data.add(new Staff(temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]));
			}
			else if (temp[0].equals("Student")) {
				data.add(new Student(temp[1], temp[2], temp[3], temp[4], temp[5]));
			}
		}
		
		reader.close();
		return data;

	}
	
	public void clearDatabase () throws IOException {
		PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, false),false);
		
		writer.flush();
		writer.close();
		
		System.out.println("The file \"" + FILE_NAME + "\" has been cleared");
	}
	
}
