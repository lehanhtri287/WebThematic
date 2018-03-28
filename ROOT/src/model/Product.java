package model;

public class Product {
	private int idProduct;
	private String nameProduct;
	private int price;
	private String description;
	private int status;
	private int idCategory;
	private int salePercent;
	private String image;
	private int quantity;

	public Product() {
	}

	public Product(int idProduct, String nameProduct, int price, String description, int status, int idCategory,
			int salePercent, String image, int quantity) {
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.price = price;
		this.description = description;
		this.status = status;
		this.idCategory = idCategory;
		this.salePercent = salePercent;
		this.image = image;
		this.quantity = quantity;
	}

	public Product(String nameProduct, int price, String description, int status, int idCategory, int salePercent,
			String image, int quantity) {
		this.nameProduct = nameProduct;
		this.price = price;
		this.description = description;
		this.status = status;
		this.idCategory = idCategory;
		this.salePercent = salePercent;
		this.image = image;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getSalePercent() {
		return salePercent;
	}

	public void setSalePercent(int salePercent) {
		this.salePercent = salePercent;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", price=" + price
				+ ", description=" + description + ", status=" + status + ", idCategory=" + idCategory
				+ ", salePercent=" + salePercent + ", image=" + image + ", quantity=" + quantity + "]";
	}

}