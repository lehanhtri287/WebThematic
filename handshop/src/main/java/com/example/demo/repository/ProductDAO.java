package com.example.demo.repository;

import java.util.List;

import com.example.demo.entities.Sanpham;

public interface ProductDAO {

	public void setPageSize(int pageSize);
	
	public List<Sanpham> getAllProduct();

	public List<Sanpham> getProductPagination(int page);

	public Sanpham getProduct(int id);

	public boolean insertProduct(Sanpham sanpham);
	
	public boolean updateProduct(Sanpham sanpham);

	public boolean deleteProduct(int idSanpham);
	
	public int getNumpPages();
	
	public List<Sanpham> getProductByCate(int idLoaihang);

}
