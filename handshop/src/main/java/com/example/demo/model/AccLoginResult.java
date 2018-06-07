package com.example.demo.model;

public class AccLoginResult {
	private String password;
	private Integer confirmation;
	
	public AccLoginResult() {}
	
	public AccLoginResult(String password, Integer confirmation) {
		super();
		this.password = password;
		this.confirmation = confirmation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(Integer confirmation) {
		this.confirmation = confirmation;
	}

	@Override
	public String toString() {
		return "AccLoginResult [password=" + password + ", confirmation=" + confirmation + "]";
	}
	
}
