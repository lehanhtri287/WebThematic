package com.example.demo.model;

import javax.validation.constraints.Pattern;

public class AccountInfoUpdating {
	private String email;
	private String fullName;
	@Pattern(regexp = "(\\d{10,11})", message = "{accSignup.phone.invalid}")
	private String phoneNumber;
	private String address;
	private String password;
	
	public AccountInfoUpdating() {}

	public AccountInfoUpdating(String email, String fullName,
			@Pattern(regexp = "(\\d{10,11})", message = "{accSignup.phone.invalid}") String phoneNumber, String address,
			String password) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AccountInfoUpdating [email=" + email + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", password=" + password + "]";
	}

}
