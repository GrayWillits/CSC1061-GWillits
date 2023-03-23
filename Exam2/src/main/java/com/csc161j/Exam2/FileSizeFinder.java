package com.csc161j.Exam2;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;

public class FileSizeFinder {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		Path currentDirectoryPath = FileSystems.getDefault().getPath("");
    	String currentDirectoryName = currentDirectoryPath.toAbsolutePath().toString(), filePath = "", input = "";
    	String[] directorySegments = currentDirectoryName.split("\\\\");
    	for (int i = -1, j = 0; i <= 1; j++) {
    		if (i != -1) {filePath += "\\" + directorySegments[j];}
    		else {i++; filePath += directorySegments[j];}
    		if (directorySegments[j].equals("Users") || i == 1) {i++;}
    	}
    	filePath += "\\Downloads\\FileSizeTest\\FileSizeTest";
    	System.out.println("Enter file path or leave blank for default");
    	input = scnr.nextLine();
    	if (!input.equals("")) {filePath = input;}
    	System.out.println("Using file \"" + filePath + "\"");

		File file = new File(filePath);

		if (!file.exists()) {
			System.out.println("The file " + filePath + " does not exist.\nExiting ...");
			System.exit(-1);
		}

		FileTree tree = new FileTree(filePath);

		System.out.println("File size listing");
		for (FileNode fileNode: tree) {
			if (fileNode.getFile().isDirectory()) {
				long size = 0;
				for (FileNode child : fileNode.getChildNodes()) {
					size += child.getFileSize();
				}
				fileNode.setFileSize(size);
				System.out.println(fileNode);
			}
		}

		System.out.println("===============================================================================================");
		System.out.println("Breadth first listing of files");
		Iterator<FileNode> iterator = tree.breadthFirstIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		scnr.close();
	}

}
