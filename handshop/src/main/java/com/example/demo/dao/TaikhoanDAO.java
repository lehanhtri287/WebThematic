package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Taikhoan;
import com.example.demo.hibernate.HibernateUtil;
@SuppressWarnings("deprecation")
@Repository
public class TaikhoanDAO {
	
	@SuppressWarnings("rawtypes")
	public String signUp(Taikhoan taikhoan){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String tenDangnhap = null;
		Query query = null;
		try {
			session.save(taikhoan);
			session.getTransaction().commit();
			query = session.createQuery("select tk.tenDangnhap from " + Taikhoan.class.getName() +
					" tk where tk.tenDangnhap = :tenDangnhap");
			query.setString("tenDangnhap", taikhoan.getTenDangnhap());
			tenDangnhap = (String) query.uniqueResult();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return tenDangnhap;
	}
	
}
