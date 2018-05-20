package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Loaihang;

public interface CategoryService {
	public List<Loaihang> getAllCategories();

	public Loaihang getCategory(int idCate);

	public boolean insertCategory(Loaihang loaihang);

	public boolean updateCategory(Loaihang loaihang);

	public boolean deleteCategory(int idCate);
}
