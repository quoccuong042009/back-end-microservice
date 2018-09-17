package com.example.zuulapigateway.models;

import java.sql.Date;

public class User {
	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Role role;
	private Status status;
	private Date dateOfBirth;

	public User() {

	}

	public User(Long userId, String firstName, String lastName, String email, String password, Role role, Status status,
			Date dateOfBirth) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
		this.dateOfBirth = dateOfBirth;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole_id(Role role) {
		this.role = role;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus_id(Status status) {
		this.status = status;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", status=" + status + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}
}
