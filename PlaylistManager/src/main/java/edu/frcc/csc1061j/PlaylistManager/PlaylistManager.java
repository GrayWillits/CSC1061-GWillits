package edu.frcc.csc1061j.PlaylistManager;

import java.util.Arrays;


public class PlaylistManager {
	
	public static void main(String[] args) {
		
		DoubleLinkedList<Song> ml = new DoubleLinkedList<Song>();
		ml.add(new Song("A", "B"));
		ml.add(new Song("C", "B"));
		ml.add(new Song("D", "B"));
		
		for (Song song: ml) {
			System.out.println(song);
		}
		
		System.out.println(Arrays.toString(ml.toArray()) + "size = " + ml.size());
				
	}
	
	public void Shuffle(DoubleLinkedList<Song> playlist) {
		
	}

}
