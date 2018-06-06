package com.example.demo.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.demo.entities.ChitietdonhangId;
import com.example.demo.hibernate.HibernateUtil;
import com.example.demo.repository.OrderDetailDAO;

public class OrderDetailDAOImpl implements OrderDetailDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public boolean insertOrderDetail(ChitietdonhangId chitietdonhangId) {
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			session.save(chitietdonhangId);
			session.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateOrderDetail(ChitietdonhangId chitietdonhangId) {
		return false;
	}

	@Override
	public boolean deleteOrderDetail(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
