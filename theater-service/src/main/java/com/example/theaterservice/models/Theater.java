package com.example.theaterservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Theater")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Theater {
	@Id
	@GeneratedValue
	@Column(name = "theater_id", nullable = false)
	private long theaterId;

	@Column(name = "name")
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
