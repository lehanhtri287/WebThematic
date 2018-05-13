package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Taikhoan;
import com.example.demo.hibernate.HibernateUtil;

@SuppressWarnings({"deprecation", "rawtypes"})
@Repository
public class TaikhoanDAO {
	
	public String signUp(Taikhoan taikhoan){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		taikhoan.setMatKhau(encoder.encode(taikhoan.getMatKhau()));
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String matKhau = null;
		try {
			session.save(taikhoan);
			session.getTransaction().commit();
			Query query = session.createQuery("select tk.matKhau from " + Taikhoan.class.getName() +
					" tk where tk.tenDangnhap = :tenDangnhap");
			query.setString("tenDangnhap", taikhoan.getTenDangnhap());
			matKhau = (String) query.uniqueResult();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return matKhau;
	}
	
//	public String login(){
//		
//	}
	
}
