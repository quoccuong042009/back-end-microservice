package com.example.showtimeservice.models;

public class Theater {
	private long theaterId;

	private String name;

	public Theater() {

	}

	public Theater(long theaterId, String name) {
		super();
		this.theaterId = theaterId;
		this.name = name;
	}

	public long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Theater [theaterId=" + theaterId + ", name=" + name + "]";
	}

}
