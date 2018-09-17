package com.example.movieservice.models;

import java.sql.Date;

public class Showtime {
	private long showtimeId;

	private long movieId;

	private long theaterId;

	private String slot;

	private Date date;

	private Status status;

	public Showtime() {

	}

	public Showtime(long showtimeId, long movieId, long theaterId, String slot, Date date, Status status) {
		super();
		this.showtimeId = showtimeId;
		this.movieId = movieId;
		this.theaterId = theaterId;
		this.slot = slot;
		this.date = date;
		this.status = status;
	}

	public long getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(long showtimeId) {
		this.showtimeId = showtimeId;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Showtime [showtimeId=" + showtimeId + ", movieId=" + movieId + ", theaterId=" + theaterId + ", slot="
				+ slot + ", date=" + date + ", status=" + status + "]";
	}

}
