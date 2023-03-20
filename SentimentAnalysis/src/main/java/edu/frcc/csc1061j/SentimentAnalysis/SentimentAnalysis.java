package edu.frcc.csc1061j.SentimentAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class SentimentAnalysis {

	public static void main(String[] args) throws FileNotFoundException {
		
		HashMap<String, Integer> sentiments = new HashMap<String, Integer>();
		String[] data;
		String[] words;
		boolean first = true;
		int sentiment = 0;
		double overall = 0;
		String input = "";
		Scanner scnr = new Scanner(System.in);
		File file = new File("sentiments.txt");
		Scanner reader = new Scanner(file);
		
		while (reader.hasNextLine()) { //Apparently "naive" is in there twice
			data = reader.nextLine().split(",");
			sentiments.put(data[0], Integer.parseInt(data[1]));
		}
		
		System.out.println("Enter text:");
		while (true) {
			String temp = scnr.nextLine();
			if (temp.equals("END")) {
				break;
			}
			input += ((first) ? "" : " ") + temp;
			first = false;
		}
		words = input.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		System.out.println("\nWords: " + words.length);
		for (int i = 0; i < words.length; i++) {
			if (i < words.length - 1) {
				if (sentiments.containsKey(words[i] + " " + words[i + 1])) {
					sentiment += sentiments.get(words[i] + " " + words[i + 1]);
					continue;
				}
			}
			if (sentiments.containsKey(words[i])) {
				sentiment += sentiments.get(words[i]);
				continue;
			}
		}
		System.out.println("Sentiment: " + sentiment);
		overall = (double)sentiment / words.length;
		System.out.printf("Overall: %.2f", overall);
		
		reader.close();
		scnr.close();
	}

}
