package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.model.AccountLogin;
import com.example.demo.repository.AccountDAO;
import com.example.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDAO accountDAO;
	
	@Override
	public boolean signUp(Account account) {
		return accountDAO.signUp(account);
	}

	@Override
	public String findByEmail(String email) {
		return accountDAO.findByEmail(email);
	}

	@Override
	public Account findByEmailAndPassword(AccountLogin account) {
		return accountDAO.findByEmailAndPassword(account);
	}

	@Override
	public boolean updateAccountInfo(Account account) {
		return accountDAO.updateAccountInfo(account);
	}

}
