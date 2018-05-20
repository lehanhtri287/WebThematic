package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.entities.Loaihang;
import com.example.demo.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO categoryDAO;

	public CategoryServiceImpl() {
		categoryDAO = new CategoryDAO();
	}

	@Override
	public List<Loaihang> getAllCategories() {
		return categoryDAO.getAllCategory();
	}

	@Override
	public Loaihang getCategory(int idCate) {
		return categoryDAO.getCategory(idCate);
	}

	@Override
	public boolean insertCategory(Loaihang loaihang) {
		return categoryDAO.addCategory(loaihang);
	}

	@Override
	public boolean updateCategory(Loaihang loaihang) {
		return categoryDAO.updateCategory(loaihang);
	}

	@Override
	public boolean deleteCategory(int idCate) {
		return categoryDAO.deleteCategory(idCate);
	}

}
