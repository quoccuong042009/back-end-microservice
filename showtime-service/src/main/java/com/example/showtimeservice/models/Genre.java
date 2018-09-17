package com.example.showtimeservice.models;

public class Genre {
	private long genre_id;

	private String genre;

	public Genre() {

	}

	public Genre(long genre_id, String genre) {
		super();
		this.genre_id = genre_id;
		this.genre = genre;
	}

	public long getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(long genre_id) {
		this.genre_id = genre_id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Genre [genre_id=" + genre_id + ", genre=" + genre + "]";
	}

}
