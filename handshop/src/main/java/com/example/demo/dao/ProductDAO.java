package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.demo.entities.Loaihang;
import com.example.demo.entities.Sanpham;
import com.example.demo.hibernate.HibernateUtil;

@SuppressWarnings("deprecation")
public class ProductDAO {
	private SessionFactory sessionFactory;

	public ProductDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Sanpham> getAllProduct() {
		List<Sanpham> sanphams = new ArrayList<>();

		// Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			String hql = "from " + Sanpham.class.getName();
			Query query = session.createQuery(hql);
			// query.setMaxResults(12);
			sanphams = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return sanphams;
	}

	@SuppressWarnings("rawtypes")
	public Sanpham getProduct(int id) {
		Session session = sessionFactory.openSession();
		Sanpham result = null;
		try {
			session.getTransaction().begin();
			String hql = "from " + Sanpham.class.getName() + " where ID_SANPHAM = :idSanpham";
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

	@SuppressWarnings("rawtypes")
	public boolean insertProduct(Sanpham sanpham) {
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();

			Query query = session.createQuery("from " + Loaihang.class.getName() + " where ID_LOAIHANG = :ID_LOAIHANG");
			query.setInteger("ID_LOAIHANG", sanpham.getLoaihang().getIdLoaihang());
			Loaihang cate = (Loaihang) query.uniqueResult();
			sanpham.setLoaihang(cate);

			session.save(sanpham);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().commit();
		}
		return false;
	}

	public boolean updateProduct(Sanpham sanpham) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			Sanpham sp = (Sanpham) session.get(Sanpham.class, sanpham.getIdSanpham());
			
			session.update(sp);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().commit();
		}
		return false;
	}

	public static void main(String[] args) {
		ProductDAO sanphamDAO = new ProductDAO();
		Loaihang cate = new Loaihang();
		cate.setIdLoaihang(3);
		Sanpham sanpham = new Sanpham(cate, "Lục lạc", 80000, "Lục lạc vàng đáng yêu", 0, 0, "images/1.jpg", 5);
		System.out.println(sanphamDAO.insertProduct(sanpham));
	}
}
