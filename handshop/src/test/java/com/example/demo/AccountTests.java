package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.AccountController;
import com.example.demo.entities.Account;
import com.example.demo.model.AccountLogin;
import com.example.demo.model.AccountSignup;
import com.example.demo.repository.AccountDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTests {
	
	@Autowired
	AccountDAO accountDAO;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testFindByEmail(){
		assertEquals("nhoccodaihp96@gmail.com", accountDAO.findByEmail("nhoccodaihp96@gmail.com "));
	}
	
	@Test
	public void testGetAccountFromAccountSignup(){
		AccountSignup accountSignup = new AccountSignup("trinhpham0415@gmail7", "a", "a", "a", "a", "a");
		Account account = new AccountController().getAccountFromAccountSignup(accountSignup);
		assertFalse("fail", accountDAO.signUp(account));
	}
	
	@Test
	public void testFindByEmailAndPassword(){
		AccountLogin accountLogin = new AccountLogin("nhoccodaihp96@gmail.com", "a");
		Account account = accountDAO.findByEmailAndPassword(accountLogin);
		assertTrue(account != null);
	}

}