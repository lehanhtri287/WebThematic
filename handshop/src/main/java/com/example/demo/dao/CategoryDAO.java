package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Loaihang;
import com.example.demo.hibernate.HibernateUtil;

@SuppressWarnings("deprecation")
@Repository
public class CategoryDAO {
	private SessionFactory sessionFactory;

	public CategoryDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

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

	public static void main(String[] args) {
		// BCryptPasswordEncoder crypto = new BCryptPasswordEncoder();

		// String encode = crypto.encode("trile123");
		//
		// System.out.println(encode);
		// System.out.println(crypto.matches("trile12223",
		// "$2a$10$NuCgUHiTbe/4pEDxCz78H.6HBiGGJr6HL23HPINZyvNokTmtmNTaW"));
		CategoryDAO categoryDAO = new CategoryDAO();
		// System.out.println(categoryDAO.getAllCategory().size());
		// System.out.println(categoryDAO.addCategory(new Loaihang("Áo thun trẻ em")));
		// Loaihang cate = new Loaihang();
		// cate.setIdLoaihang(13);
		// cate.setTenLoaihang("Ao thun tre em");
		 System.out.println(categoryDAO.deleteCategory(13));
	}
}
