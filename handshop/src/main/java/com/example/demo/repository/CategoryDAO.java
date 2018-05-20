package com.example.demo.repository;

import java.util.List;

import com.example.demo.entities.Loaihang;

public interface CategoryDAO {

	public List<Loaihang> getAllCategory();

	public Loaihang getCategory(int idCate);

	public boolean addCategory(Loaihang loaihang);

	public boolean updateCategory(Loaihang loaihang);

	public boolean deleteCategory(int idLoaihang);
}
