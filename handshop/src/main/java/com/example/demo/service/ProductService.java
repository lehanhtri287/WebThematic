package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Product;

public interface ProductService {
	public boolean addProduct(Product sanpham);

	public boolean editProduct(Product sanpham);

	public boolean deleteProduct(int idSanpham);

	public List<Product> getAllProduct();
	
	public Product getProduct(int idProduct);
	
	public List<Product> getProductByCate(int idLoaihang);

}
