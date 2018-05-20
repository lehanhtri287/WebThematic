package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Loaihang;
import com.example.demo.repository.CategoryDAO;
import com.example.demo.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO categoryDAO;

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
