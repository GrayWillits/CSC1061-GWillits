import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Database {
	
	private final String FILE_NAME = "PersonDatabase";

	public Database() throws IOException {
		// TODO Auto-generated constructor stub
		File myFile = new File("PersonDatabase.txt");
		
		if (!myFile.exists()) {
			if (myFile.createNewFile()) {
				System.out.println("Created new file");
			}
		}
		PrintWriter printWriter = new PrintWriter(myFile.getName());
		
	}
	
	public void writePerson (Person person) {
		
	}
	
//	File myFile = new File("filewritetest.txt");
//	if (!myFile.exists()) {
//		if (myFile.createNewFile()) {
//			
//		}
//	}
//	
//	PrintWriter printWriter = new PrintWriter(myFile.getName());
//	printWriter.close();

}
