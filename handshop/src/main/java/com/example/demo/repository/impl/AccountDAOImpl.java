package com.example.demo.repository.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.IntegerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;
import com.example.demo.hibernate.HibernateUtil;
import com.example.demo.model.AccountLogin;
import com.example.demo.repository.AccountDAO;

@Repository
public class AccountDAOImpl implements AccountDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountDAOImpl.class);

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public boolean signUp(Account account) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String fullName = account.getFullName();
		fullName = fullName.replaceAll("\\s+", " "); // replace spaces to space between
		fullName = fullName.replaceAll("(^\\s+|\\s+$)", ""); // remove spaces at left and right
		account.setFullName(fullName);
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
		} finally {
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
			if (result.isPresent())
				emailResult = result.get();
		} catch (NoSuchElementException e) {
			LOGGER.error("- error when call method findByEmail with paramater " + email, e);
		} finally {
			session.close();
		}
		return emailResult;
	}

	@Override
	public Account findByEmailAndPassword(AccountLogin accountLogin) {
		Account account = null;

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query<Account> query = session.createQuery("from " + Account.class.getName() + " where email = :email",
				Account.class);

		query.setParameter("email", accountLogin.getEmail());
		try {
			Optional<Account> result = query.uniqueResultOptional();
			account = (Account) result.get();

			if (result.isPresent()) {
				if (!encoder.matches(accountLogin.getPassword(), account.getPassword())) {
					account = null;
				}
			}
		} catch (NoSuchElementException e) {
			LOGGER.error("- error when call method findByEmailAndPassword with paramater " + account, e);
		} finally {
			session.close();
		}
		return account;
	}

	@Override
	public boolean updateAccountInfo(Account account) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Account accountResult = null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query<Account> query = session.createQuery("from Account where email = :email", Account.class);
		query.setParameter("email", account.getEmail());
		try {
			Optional<Account> result = query.uniqueResultOptional();
			if (result.isPresent()) {
				accountResult = result.get();
				if (encoder.matches(account.getPassword(), accountResult.getPassword())) {
					accountResult.setFullName(account.getFullName());
					accountResult.setPhoneNumber(account.getPhoneNumber());
					accountResult.setAddress(account.getAddress());
					session.save(accountResult);
					session.getTransaction().commit();
					return true;
				}
			}
		} catch (NoSuchElementException e) {
			LOGGER.error("- error when call method updateAccountInfo with paramater " + account, e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
}
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public int size() {
		Session session = sessionFactory.openSession();
		int res = 0;
		try {
			session.getTransaction().begin();

			Query query = session.createSQLQuery("select count(*) as size from taikhoan where chucvu = 'KH'")
								 .addScalar("size", new IntegerType());

			res = (int) query.uniqueResult();

			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return res;

	}

}
