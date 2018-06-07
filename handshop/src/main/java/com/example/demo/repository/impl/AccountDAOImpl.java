package com.example.demo.repository.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;
import com.example.demo.hibernate.HibernateUtil;
import com.example.demo.model.AccountLogin;
import com.example.demo.repository.AccountDAO;

@Repository
public class AccountDAOImpl implements AccountDAO{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountDAOImpl.class);

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	public boolean signUp(Account account){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		account.setPassword(encoder.encode(account.getPassword()));
		account.setPosition("KH");
		account.setConfirmation(0);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(account);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			LOGGER.error("- error when call method signUp with paramater " + account, e);
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}

	@Override
	public String findByEmail(String email) {
		String emailResult = null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<String> query = session.createQuery("select email from Account where email = :email", String.class);
		query.setParameter("email", email);
		try {
			Optional<String> result = query.uniqueResultOptional();
			if(result.isPresent()) emailResult = result.get();
		} catch (NoSuchElementException e) {
			LOGGER.error("- error when call method findByEmail with paramater " + email, e);
		}finally {
			session.close();
		}
		return emailResult;
	}

	@Override
	public Account findByEmailAndPassword(AccountLogin accountLogin) {
		Account account = null;;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Account> query = session.createQuery("select new com.example.demo.entities.Account(password, confirmation) from Account where email = :email", Account.class);
		query.setParameter("email", accountLogin.getEmail());
		try{
			Optional<Account> result = query.uniqueResultOptional();
			account = result.get();
			if (result.isPresent()){
				if (encoder.matches(accountLogin.getPassword(), account.getPassword())){
					account = new Account(account.getPassword(), account.getConfirmation());
				}
			}
		} catch (NoSuchElementException e) {
			LOGGER.error("- error when call method findByEmailAndPassword with paramater " + account, e);
		}finally {
			session.close();
		}
		return account;
	}
	
}
