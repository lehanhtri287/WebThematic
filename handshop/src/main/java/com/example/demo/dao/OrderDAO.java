package com.example.demo.dao;

import org.hibernate.SessionFactory;

import com.example.demo.entities.Donhang;
import com.example.demo.hibernate.HibernateUtil;

@SuppressWarnings("deprecation")
public class OrderDAO {
	private SessionFactory sessionFactory;

	public OrderDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public Donhang getOrder() {
		return null;
	}
	
}