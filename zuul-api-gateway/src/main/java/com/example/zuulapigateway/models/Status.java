package com.example.zuulapigateway.models;

public class Status {
	private int statusID;
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
