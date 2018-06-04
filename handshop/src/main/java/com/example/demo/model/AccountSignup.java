package com.example.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AccountSignup {
	
	@Email(message = "{accSignup.email.invalid}")
	@NotEmpty(message = "{accSignup.empty}")
	private String email;
	@NotEmpty(message = "{accSignup.empty}")
	private String password;
	@NotEmpty(message = "{accSignup.empty}")
	private String confirmPassword;
	private String fullName;
	private String address;
	private String phoneNumber;
	
	public AccountSignup() {}

	public AccountSignup(
			@Email(message = "{accSignup.email.invalid}") @NotEmpty(message = "{accSignup.empty}") String email,
			@NotEmpty(message = "{accSignup.empty}") String password,
			@NotEmpty(message = "{accSignup.empty}") String confirmPassword, String fullName, String address,
			String phoneNumber) {
		super();
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "AccountSignup [email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", fullName=" + fullName + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
