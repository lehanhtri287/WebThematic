package model;

public class User {
	private int userID;
	private String userName;
	private String password;
	private String role;
	private String nameCustomer;
	private String address;
	private String phoneNumbers;

	public User() {
	}

	public User(int userID, String userName, String password, String role, String nameCustomer, String address,
			String phoneNumbers) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.nameCustomer = nameCustomer;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
