package edu.frcc.csc1061j.PlaylistManager;

public class Song {
	
	private String title;
	private String artist;

	public Song() {
		// TODO Auto-generated constructor stub
	}
	
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	@Override
    public boolean equals(Object o) {
 
        if (o == this) {
            return true;
        }

        if (!(o instanceof Song)) {
            return false;
        }
         
        Song c = (Song) o;
         
        return this.title.equals(c.title) && this.artist.equals(c.artist);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	@Override
	public String toString() {
		return artist + " - " + title;
		
	}

}
