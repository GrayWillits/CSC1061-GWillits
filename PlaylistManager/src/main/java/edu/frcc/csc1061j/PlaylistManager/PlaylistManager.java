package edu.frcc.csc1061j.PlaylistManager;

import java.util.Arrays;
import java.util.Scanner;


public class PlaylistManager {
	
	public static void main(String[] args) {
		
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
				
				continue;
			}
			
			else if (option == 5) { //reverse
				playlist.reverse();
				continue;
			}
			
			else if (option == 6) { //load
				
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
				"quit";
	}
	
	public static int input(Scanner scnr) {
		String[] commands = {"add", "remove", "count", "play", "shuffle", "reverse", "load", "quit"};
		String input;		
		while (true) {
			System.out.print("\n: ");
			input = scnr.nextLine();
			if (Arrays.asList(commands).contains(input)) {
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
	
	public void shuffle(DoubleLinkedList<Song> playlist) {
		
	}

}
