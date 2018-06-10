package com.example.demo.service;

import com.example.demo.entities.Account;
import com.example.demo.model.AccountLogin;

public interface AccountService {
	public boolean signUp(Account account);
	
	public String findByEmail(String email);
	
	public Account findByEmailAndPassword(AccountLogin account);
	
	public boolean updateAccountInfo(Account account);

	public int size();
}
