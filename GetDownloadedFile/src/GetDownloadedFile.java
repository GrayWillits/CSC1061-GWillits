
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class GetDownloadedFile {
	
	public String getFile(String file) {
		Scanner scnr = new Scanner(System.in);
		String filePath = getFile(file, scnr);
		scnr.close();
		return filePath;
	}

	public String getFile(String file, Scanner scnr) {
		
		Path currentDirectoryPath = FileSystems.getDefault().getPath("");
		
    	String currentDirectoryName = currentDirectoryPath.toAbsolutePath().toString();
    	String filePath = "";
    	String[] directorySegments = currentDirectoryName.split("\\\\");
    	
    	for (int i = 0; i < 3; i++) {
    		filePath += directorySegments[i] + "\\";
    	}
    	filePath += "Downloads\\" + file;
    	
    	System.out.println("Enter file path or leave blank to use the default path of\n\t\"" + filePath + "\"   or   \"" + filePath.concat("\\" + file));
    	String input = scnr.nextLine();
    	if (!input.equals("")) {
    		filePath = input;
    	}
    	
		File fileTest = new File(filePath);
		if (!fileTest.exists()) {
			System.out.println("The file " + filePath + " does not exist.\nExiting ...");
			System.exit(-1);
		} 
		
		if (input.equals("")) {
			File altFile = new File(filePath.concat("\\" + file));
			if (altFile.exists()) {
				filePath += "\\" + file;
			}
		}
		
		return filePath;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
