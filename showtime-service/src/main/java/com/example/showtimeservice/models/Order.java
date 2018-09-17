package com.example.showtimeservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Orders")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Order {
	@Id
	@GeneratedValue
	@Column(name = "order_id", nullable = false)
	private long orderId;

	@Column(name = "user_id")
	private long userId;

	@Column(name = "showtime_id")
	private long showtimeId;

	@Column(name = "seats")
	private String seats;

	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status statusId;

	public Order() {

	}

	public Order(long orderId, long userId, long showtimeId, String seats, Status statusId) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.showtimeId = showtimeId;
		this.seats = seats;
		this.statusId = statusId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(long showtimeId) {
		this.showtimeId = showtimeId;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public Status getStatusId() {
		return statusId;
	}

	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", showtimeId=" + showtimeId + ", seats=" + seats
				+ ", statusId=" + statusId + "]";
	}

}
