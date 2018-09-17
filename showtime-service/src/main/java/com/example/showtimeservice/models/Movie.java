package com.example.showtimeservice.models;

import java.sql.Date;

public class Movie {
	private long movieId;

	private String movieTitle;

	private String description;

	private Genre genre;

	private Date startDate;

	private Date endDate;

	private String picUrl;

	public Movie() {

	}

	public Movie(long movieId, String movieTitle, String description, Genre genre, Date startDate, Date endDate,
			String picUrl) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.description = description;
		this.genre = genre;
		this.startDate = startDate;
		this.endDate = endDate;
		this.picUrl = picUrl;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", description=" + description + ", genre="
				+ genre + ", startDate=" + startDate + ", endDate=" + endDate + ", picUrl=" + picUrl + "]";
	}

}
