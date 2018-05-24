package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Taikhoan;
import com.example.demo.repository.TaikhoanDAO;
import com.example.demo.service.TaikhoanService;

@Service
public class TaikhoanServiceImpl implements TaikhoanService{
	@Autowired
	TaikhoanDAO taikhoanDAO;
	
	@Override
	public boolean signUp(Taikhoan taikhoan) {
		return taikhoanDAO.signUp(taikhoan);
	}

}
