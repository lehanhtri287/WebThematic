package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.ProductDAO;
import com.example.demo.entities.Sanpham;
import com.example.demo.service.ProductService;


public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public boolean addProduct(Sanpham sanpham) {
		return productDAO.insertProduct(sanpham);
	}

	@Override
	public boolean editProduct(Sanpham sanpham) {
		return productDAO.updateProduct(sanpham);
	}

	@Override
	public boolean deleteProduct(int idSanpham) {
		return productDAO.deleteProduct(idSanpham);
	}

	@Override
	public List<Sanpham> getAllProduct() {
		return productDAO.getAllProduct();
	}

}
