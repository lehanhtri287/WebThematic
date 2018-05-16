package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Sanpham;

public interface ProductService {
	public boolean addProduct(Sanpham sanpham);

	public boolean editProduct(Sanpham sanpham);

	public boolean deleteProduct(int idSanpham);

	public List<Sanpham> getAllProduct();

}
