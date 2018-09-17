package com.example.orderservice.models;

import java.sql.Date;

public class OrderDetail {
	private long orderId;
	private String email;
	private String movieTitle;
	private String Genre;
	private Date date;
	private String theater;
	private String time;
	private String seats;
	private Status status;

	public OrderDetail(long orderId, String email, String movieTitle, String genre, Date date, String theater,
			String time, String seats, Status status) {
		super();
		this.orderId = orderId;
		this.email = email;
		this.movieTitle = movieTitle;
		Genre = genre;
		this.date = date;
		this.theater = theater;
		this.time = time;
		this.seats = seats;
		this.status = status;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", email=" + email + ", movieTitle=" + movieTitle + ", Genre="
				+ Genre + ", date=" + date + ", theater=" + theater + ", time=" + time + ", seats=" + seats
				+ ", status=" + status + "]";
	}

}
