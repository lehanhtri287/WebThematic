package com.example.demo.service;

import com.example.demo.entities.Account;

public interface AccountService {
	public boolean signUp(Account account);
	
	public String findByEmail(String email);
}
