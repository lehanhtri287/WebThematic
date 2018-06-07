package com.example.demo.model;

import javax.validation.constraints.NotEmpty;

public class AccountLogin {
	@NotEmpty(message = "{accLogin.empty}")
	private String email;
	@NotEmpty(message = "{accLogin.empty}")
	private String password;
	
	public AccountLogin() {}

	public AccountLogin(
			@NotEmpty(message = "{accLogin.empty}") String email,
			@NotEmpty(message = "{accLogin.empty}") String password) {
		super();
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "AccountLogin [email=" + email + ", password=" + password + "]";
	}
	
}
