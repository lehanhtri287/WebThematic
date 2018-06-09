package com.example.demo.repository;

import java.util.List;

import com.example.demo.entities.Product;

public interface ProductDAO {

	public void setPageSize(int pageSize);
	
	public List<Product> getAllProduct();

	public List<Product> getProductPagination(int page);

	public Product getProduct(int id);

	public boolean insertProduct(Product sanpham);
	
	public boolean updateProduct(Product sanpham);

	public boolean deleteProduct(int idSanpham);
	
	public int getNumpPages();
	
	public List<Product> getProductByCate(int idLoaihang);

}
