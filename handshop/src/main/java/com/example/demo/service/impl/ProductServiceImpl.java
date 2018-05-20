package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD:handshop/src/main/java/com/example/demo/serviceImpl/ProductServiceImpl.java
import com.example.demo.dao.ProductDAO;
import com.example.demo.entities.Loaihang;
=======
>>>>>>> master:handshop/src/main/java/com/example/demo/service/impl/ProductServiceImpl.java
import com.example.demo.entities.Sanpham;
import com.example.demo.repository.ProductDAO;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;
<<<<<<< HEAD:handshop/src/main/java/com/example/demo/serviceImpl/ProductServiceImpl.java

	public ProductServiceImpl() {
		productDAO = new ProductDAO();
	}

=======
	
>>>>>>> master:handshop/src/main/java/com/example/demo/service/impl/ProductServiceImpl.java
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

	@Override
	public Sanpham getProduct(int idProduct) {
		return productDAO.getProduct(idProduct);
	}

	@Override
	public List<Sanpham> getProductByCate(int idLoaihang) {
		// TODO Auto-generated method stub
		return productDAO.getProductByCate(idLoaihang);
	}

}
