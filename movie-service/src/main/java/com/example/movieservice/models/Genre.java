package com.example.movieservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Genre")
public class Genre {
	@Id
	@GeneratedValue
	@Column(name = "genre_id", nullable = false)
	private long genre_id;

	@Column(name = "genre")
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
