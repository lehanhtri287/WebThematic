package com.example.demo.repository;

import com.example.demo.entities.Taikhoan;

public interface TaikhoanDAO {
	
	public boolean signUp(Taikhoan taikhoan);
	
	public String findByEmail(String email);
}
