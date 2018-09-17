package com.example.showtimeservice.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Showtime")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Showtime {
	@Id
	@GeneratedValue
	@Column(name = "showtime_id", nullable = false)
	private long showtimeId;

	@Column(name = "movie_id")
	private long movieId;

	@Column(name = "theater_id")
	private long theaterId;

	@Column(name = "slot")
	private String slot;

	@Column(name = "date")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;

	public Showtime() {

	}

	public Showtime(long showtimeId, long movieId, long theaterId, String slot, Date date,
			com.example.showtimeservice.models.Status status) {
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
