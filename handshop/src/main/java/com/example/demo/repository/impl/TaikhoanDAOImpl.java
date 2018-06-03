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

import com.example.demo.entities.Taikhoan;
import com.example.demo.hibernate.HibernateUtil;
import com.example.demo.repository.TaikhoanDAO;

@Repository
public class TaikhoanDAOImpl implements TaikhoanDAO{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaikhoanDAOImpl.class);

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	public boolean signUp(Taikhoan taikhoan){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		taikhoan.setMatKhau(encoder.encode(taikhoan.getMatKhau()));
		taikhoan.setChucvu("KH");
		taikhoan.setIsConfirm(0);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(taikhoan);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			LOGGER.error("- error when call method signUp with paramater " + taikhoan, e);
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}

	@Override
	public String findByEmail(String email) {
		String tenDangnhap = null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<String> query = session.createQuery("select tenDangnhap from Taikhoan where tenDangnhap = :email", String.class);
		query.setParameter("email", email);
		try {
			Optional<String> result = query.uniqueResultOptional();
			if(result.isPresent()) tenDangnhap = result.get();
		} catch (NoSuchElementException e) {
			LOGGER.error("- error when call method findByEmail with paramater " + email, e);
		}finally {
			session.close();
		}
		return tenDangnhap;
	}
	
}
