package com.example.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Loaihang;
import com.example.demo.hibernate.HibernateUtil;
import com.example.demo.repository.CategoryDAO;

@SuppressWarnings("deprecation")
@Repository
public class CategoryDAOImpl implements CategoryDAO{
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Loaihang> getAllCategory() {
		List<Loaihang> categories = new ArrayList<>();
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			String hql = "from " + Loaihang.class.getName() + " where is_delete = 0";
			Query query = session.createQuery(hql);
			// query.setMaxResults(12);
			categories = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return categories;
	}

	public Loaihang getCategory(int idCate) {
		Loaihang loaihang = null;
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();

			loaihang = (Loaihang) session.get(Loaihang.class, idCate);
			// Query query = session.createQuery(hql);
			// query.setMaxResults(12);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return loaihang;
	}

	public boolean addCategory(Loaihang loaihang) {
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			session.save(loaihang);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return false;
	}

	public boolean updateCategory(Loaihang loaihang) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			Loaihang cate = (Loaihang) session.get(Loaihang.class, loaihang.getIdLoaihang());
			cate.setTenLoaihang(loaihang.getTenLoaihang());

			session.update(cate);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public boolean deleteCategory(int idLoaihang) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();

			Query query = session.createSQLQuery("call delete_loaihang(:idLoaihang)");
			query.setParameter("idSanpham", idLoaihang);
			int res = query.executeUpdate();

			session.getTransaction().commit();
			return 1 == res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return false;
	}

}
