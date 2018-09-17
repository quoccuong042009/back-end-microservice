package com.example.showtimeservice.models;

import java.sql.Date;

public class ShowtimeDetail {
	private long showtimeId;
	private String movieTitle;
	private String theaterName;
	private Genre genre;
	private Date date;
	private String time;
	private Status status;

	public ShowtimeDetail(long showtimeId, String movieTitle, String theaterName, Genre genre, Date date, String time,
			Status status) {
		super();
		this.showtimeId = showtimeId;
		this.movieTitle = movieTitle;
		this.theaterName = theaterName;
		this.genre = genre;
		this.date = date;
		this.time = time;
		this.status = status;
	}

	public long getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(long showtimeId) {
		this.showtimeId = showtimeId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ShowtimeDetail [showtimeId=" + showtimeId + ", movieTitle=" + movieTitle + ", theaterName="
				+ theaterName + ", genre=" + genre + ", date=" + date + ", time=" + time + ", status=" + status + "]";
	}

}
