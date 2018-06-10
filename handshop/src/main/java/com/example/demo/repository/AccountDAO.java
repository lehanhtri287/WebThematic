package com.example.demo.repository;

import com.example.demo.entities.Account;
import com.example.demo.model.AccountLogin;

public interface AccountDAO {
	
	public boolean signUp(Account account);
	
	public String findByEmail(String email);
	
	public Account findByEmailAndPassword(AccountLogin account);
	
	public boolean updateAccountInfo(Account account);

	public int size();

}
