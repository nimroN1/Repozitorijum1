package com.nimro.N1ERP.dto;

public class LoginDTO {
	
	private String username;
	private String role;
	private String token;
	
	public LoginDTO() {
		
	}
	
	public LoginDTO(String username, String role, String token) {
		this.username = username;
		this.role = role;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String password) {
		this.role = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
