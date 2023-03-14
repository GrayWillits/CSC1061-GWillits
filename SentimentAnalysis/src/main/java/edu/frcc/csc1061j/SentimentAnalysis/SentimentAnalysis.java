package edu.frcc.csc1061j.SentimentAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class SentimentAnalysis {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scnr = new Scanner(System.in);
		HashMap<String, Integer> sentiments = new HashMap<String, Integer>();
		String[] temp;
		
		File file = new File("sentiments.txt");
		Scanner reader = new Scanner(file);
		
		while (reader.hasNextLine()) { //Apparently "naive" is in there twice
			temp = reader.nextLine().split(",");
			sentiments.put(temp[0], Integer.parseInt(temp[1]));
		}
		
		
		reader.close();
		
	}

}
