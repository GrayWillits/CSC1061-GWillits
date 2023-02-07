import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Database {
	
	private final String FILE_NAME = "PersonDatabase.txt";
	//private FileWriter fWriter = 

	public Database() throws IOException {
		// TODO Auto-generated constructor stub
		File myFile = new File(FILE_NAME);
		
		if (!myFile.exists()) {
			if (myFile.createNewFile()) {
				System.out.println("Created new file");
			}
		}
		
		PrintWriter writer = new PrintWriter(myFile.getName());
		writer.close();
		
	}
	
	public void writePerson (Person person) throws IOException {
		
		PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_NAME, true));
		
		writer.println(person.getClass());
		writer.println(person.toString());
		
		writer.close();
	}
	
	public ArrayList<Person> readDatabase () {
		ArrayList<Person> data = new ArrayList<Person>();
		
		return data;

	}
	
}
