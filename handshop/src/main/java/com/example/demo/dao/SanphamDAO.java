package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.demo.entities.Sanpham;
import com.example.demo.hibernate.HibernateUtil;

@SuppressWarnings("deprecation")
public class SanphamDAO {
	private SessionFactory sessionFactory;

	public SanphamDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public List<Sanpham> getAllSanpham() {
		List<Sanpham> sanphams = new ArrayList<>();

		// Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			String hql = "from " + Sanpham.class.getName();
			Query query = session.createQuery(hql);
			query.setMaxResults(12);
			sanphams = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return sanphams;
	}

	public Sanpham getSanpham(int id) {
		Session session = sessionFactory.openSession();
		Sanpham result = null;
		try {
			session.getTransaction().begin();
			String hql = "from " + Sanpham.class.getName() +" where ID_SANPHAM = :idSanpham";
			Query query = session.createQuery(hql);
			query.setInteger("idSanpham", id);
			result = (Sanpham) query.uniqueResult();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return result;
	}
	
	public static void main(String[] args) {
		SanphamDAO sanphamDAO = new SanphamDAO();
		System.out.println(sanphamDAO.getSanpham(12).toString());
	}
}
