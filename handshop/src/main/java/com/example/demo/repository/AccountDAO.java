package com.example.demo.repository;

import com.example.demo.entities.Account;
import com.example.demo.model.AccountLogin;
import com.example.demo.model.AccountPassUpdating;

public interface AccountDAO {
	
	public boolean signUp(Account account);
	
	public String findByEmail(String email);
	
	public Account findByEmailAndPassword(AccountLogin accountLogin);
	
	public boolean updateAccountInfo(Account account);
	
	public Account updateAccountPassWord(AccountPassUpdating accountPassUpdating);

	public int size();

}
