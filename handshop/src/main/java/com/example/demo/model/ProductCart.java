package com.example.demo.model;

import com.example.demo.entities.Sanpham;

public class ProductCart {
	private Sanpham product;
	private int quantityCart;

	public ProductCart(Sanpham product, int quantityCart) {
		super();
		this.product = product;
		this.quantityCart = quantityCart;
	}

	public ProductCart() {
		// TODO Auto-generated constructor stub
	}

	public int getQuantityCart() {
		return quantityCart;
	}

	public void setQuantityCart(int quantityCart) {
		this.quantityCart = quantityCart;
	}

	public Sanpham getProduct() {
		return product;
	}

	public void setProduct(Sanpham product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductCart [product=" + product + ", quantityCart=" + quantityCart + "]";
	}

}
