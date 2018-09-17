package com.example.orderservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Status")
public class Status {
	@Id
	@GeneratedValue
	@Column(name = "status_id", nullable = false)
	private int statusID;

	@Column(name = "status")
	private String status;

	public Status() {

	}

	public Status(int statusID, String status) {
		super();
		this.statusID = statusID;
		this.status = status;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Status [statusID=" + statusID + ", title=" + status + "]";
	}
}
