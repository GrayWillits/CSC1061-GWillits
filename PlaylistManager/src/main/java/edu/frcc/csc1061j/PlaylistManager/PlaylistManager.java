package edu.frcc.csc1061j.PlaylistManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class PlaylistManager {
	
	public static void main(String[] args) throws IOException {
		
		DoubleLinkedList<Song> playlist = new DoubleLinkedList<Song>();
		Scanner scnr = new Scanner(System.in);
		String artist, title;
		int option;
				
		System.out.println(menu());
		
		while (true) {
			option = input(scnr);
			
			if (option == 0) { //add
				System.out.print("Enter artist : ");
				artist = scnr.nextLine();
				System.out.print("Enter title : ");
				title = scnr.nextLine();
				
				playlist.add(new Song(title, artist));
				continue;
			}
			
			else if (option == 1) { //remove
				System.out.print("Enter artist : ");
				artist = scnr.nextLine();
				System.out.print("Enter title : ");
				title = scnr.nextLine();
				
				playlist.remove(new Song(title, artist));
				continue;
			}
			
			else if (option == 2) { //count
				System.out.println(playlist.count());
				continue;
			}
			
			else if (option == 3) { //play
				for (Song song: playlist) {
					System.out.println(song.toString());
				}
				continue;
			}
			
			else if (option == 4) { //shuffle
				shuffle(playlist);
				continue;
			}
			
			else if (option == 5) { //reverse
				playlist.reverse();
				continue;
			}
			
			else if (option == 6) { //load
				load(playlist, scnr);
				continue;
			}
			
			else if (option == 7) { //save
				save(playlist, scnr);
				continue;
			}

			else { //quit
				break;
			}
		}
	}
	
	public static String menu() {
		return 	"*** Playlist Manager! ***\n" +
				"Commands:\n" +
				"add\n" +
				"remove\n" +
				"count\n" +
				"play\n" +
				"shuffle\n" +
				"reverse\n" +
				"load\n" +
				"save\n" +
				"quit";
	}
	
	public static int input(Scanner scnr) {
		String[] commands = {"add", "remove", "count", "play", "shuffle", "reverse", "load", "save", "quit"};
		String input;		
		while (true) {
			System.out.print("\n: ");
			input = scnr.nextLine();
			if (Arrays.asList(commands).contains(input.toLowerCase())) {
				int i = 0;
				for (String command: commands) {
					if (input.equals(command)) {
						return i;
					}
					i++;
				}
			}
			else {
				System.out.println("Enter a valid command");
				input = null;
			}
		}
	}
	
	public static boolean shuffle(DoubleLinkedList<Song> playlist) {
		Random rand = new Random();
		int length = playlist.count();
		Song song = new Song();
		ArrayList<Integer> options = new ArrayList<Integer>();
		Integer i, j;
		
		if (length == 1 || length == 0) {
			return true;
		}
		for (i = 0; i < length; i++) {
			options.add(i);
		}
		while (options.size() > 1) {
			i = rand.nextInt(options.size());
			options.remove(i);
			j = rand.nextInt(options.size());
			options.remove(j);
			song = playlist.get(i);
			playlist.set(i, playlist.get(j));
			playlist.set(j, song);
		}
		return true;
	}
	
	public static void save(DoubleLinkedList<Song> playlist, Scanner scnr) throws IOException {
		System.out.print("Enter file : ");
		String file = scnr.nextLine();
		File myFile = new File(file);
		if (!myFile.exists()) {
			myFile.createNewFile();
		}
		PrintWriter writer = new PrintWriter(new FileOutputStream(file, false));

		for (Song song: playlist) {
			writer.println(song.getTitle().replace(",", "") + "," + song.getArtist().replace(",", ""));
		}
		
		writer.close();
	}
	
	public static void load(DoubleLinkedList<Song> playlist, Scanner scnr) throws IOException {
		ArrayList<String[]> tempData = new ArrayList<String[]>();
		System.out.print("Enter file : ");
		String file = scnr.nextLine();
		File myFile = new File(file);
		if (!myFile.exists()) {
			myFile.createNewFile();
		}
		Scanner reader = new Scanner(myFile);

		while (reader.hasNextLine()) {
			tempData.add(reader.nextLine().split(","));
		}
		for (String[] data: tempData) {
			playlist.add(new Song(data[0], data[1]));
		}
		
		reader.close();
	}

}
