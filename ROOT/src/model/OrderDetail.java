package model;

public class OrderDetail {
	private int idOrder;
	private int idProduct;
	private int quantity;
	private String nameProduct;

	public OrderDetail() {
	}

	public OrderDetail(int idOrder, int idProduct, int quantity, String nameProduct) {
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.nameProduct = nameProduct;
	}

	public OrderDetail(int idOrder, int idProduct, int quantity) {
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.quantity = quantity;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	@Override
	public String toString() {
		return "OrderDetail [idOrder=" + idOrder + ", idProduct=" + idProduct + ", quantity=" + quantity
				+ ", nameProduct=" + nameProduct + "]";
	}

}