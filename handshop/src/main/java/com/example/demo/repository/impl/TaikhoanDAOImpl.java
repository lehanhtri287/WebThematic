package com.example.demo.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Taikhoan;
import com.example.demo.hibernate.HibernateUtil;
import com.example.demo.repository.TaikhoanDAO;

@Repository
public class TaikhoanDAOImpl implements TaikhoanDAO{
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	public boolean signUp(Taikhoan taikhoan){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		taikhoan.setMatKhau(encoder.encode(taikhoan.getMatKhau()));
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(taikhoan);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
}
