package edu.frcc.csc1061j.MyBookTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookCreator {

	public static void main(String[] args) {
		
		BookTree book = new BookTree("Trees for Dummies");
		
		book.addBookNode("Chapter 1", 1, 0, 0);
		book.addBookNode("Chapter 2", 2, 0, 0);
		book.addBookNode("Chapter 3", 3, 0, 0);
		
		book.addBookNode("Section 1.1", 1, 1, 0);
		book.addBookNode("Section 2.2", 2, 2, 0);
		book.addBookNode("Section 3.3", 3, 3, 0);
		book.addBookNode("Section 1.2", 1, 2, 0);
		book.addBookNode("Section 2.3", 2, 3, 0);
		book.addBookNode("Section 3.1", 3, 1, 0);

		book.addBookNode("SubSection 1.1.1", 1, 1, 1);
		book.addBookNode("SubSection 2.2.2", 2, 2, 2);
		book.addBookNode("SubSection 3.3.3", 3, 3, 3);
		

		for (BookNode node: book) {
			System.out.println(node.toString());
		}
		
		
		
		
		List<String> outputs = new ArrayList<String>();
		List<BookNode> nodes = new ArrayList<BookNode>();
		System.out.println(book.getBook());
		book.getBook().getChildNodes().forEach(t -> outputs.add(t.toString().replace("\t", "")));
		System.out.println(outputs);
		outputs.clear();
		book.getBook().getChildNodes().forEach(t -> nodes.addAll(t.getChildNodes()));
		nodes.forEach(s -> outputs.add(s.toString().replace("\t", "")));
		System.out.println(outputs);
		
	}

}





