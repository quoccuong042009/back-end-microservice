package com.example.zuulapigateway.models;

public class Role {
	private int roleId;
	private String role;

	Role() {

	}

	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
