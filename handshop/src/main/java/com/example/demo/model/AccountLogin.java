package com.example.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AccountLogin {
	@Pattern(regexp = "^(.+)@(.+\\.+.+)$", message = "{field.email.invalid}")
	private String email;
	@NotEmpty(message = "{field.empty}")
	private String password;
	
	public AccountLogin() {}

	public AccountLogin(
			@Pattern(regexp = "^(.+)@(.+\\.+.+)$", message = "{field.email.invalid}") String email,
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
