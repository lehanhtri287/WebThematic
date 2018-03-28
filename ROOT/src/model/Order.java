package model;

import java.sql.Timestamp;
import java.util.List;

public class Order {
	private int idOrder;
	private Timestamp dateTime;
	private int totalPrice;
	private String customerName;
	private String phoneNumber;
	private String address;
	private String email;
	private List<OrderDetail> orderDetails;

	public Order() {
	}

	public Order(int idOrder, Timestamp dateTime, int totalPrice, String customerName, String phoneNumber,
			String address, String email) {
		this.idOrder = idOrder;
		this.dateTime = dateTime;
		this.totalPrice = totalPrice;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", dateTime=" + dateTime + ", totalPrice=" + totalPrice + ", customerName="
				+ customerName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", email=" + email
				+ ", orderDetails=" + orderDetails + "]";
	}

	
}