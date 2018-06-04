package com.example.demo.repository;

import com.example.demo.entities.Account;

public interface AccountDAO {
	
	public boolean signUp(Account account);
	
	public String findByEmail(String email);
}
