package com.example.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Chitietdonhang;
import com.example.demo.entities.ChitietdonhangId;
import com.example.demo.entities.Donhang;
import com.example.demo.entities.Product;
import com.example.demo.hibernate.HibernateUtil;
import com.example.demo.repository.OrderDAO;

@Repository
@SuppressWarnings({ "rawtypes", "deprecation", "unchecked"})
public class OrderDAOImpl implements OrderDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public List<Donhang> getListOrders() {
		return null;
	}

	@Override
	public boolean insertOrder(Donhang donhang) {
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			session.save(donhang);
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
	public boolean updateOrder(Donhang donhang) {
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();

			Query query = session.createQuery("from " + Donhang.class.getName() + " where ID_DONHANG := idDonhang");
			query.setInteger("idDonhang", donhang.getIdDonhang());
			Donhang dh = (Donhang) query.uniqueResult();
			dh.setNgayDh(donhang.getNgayDh());
			dh.setDiachi(donhang.getDiachi());
			dh.setEmail(donhang.getEmail());
			dh.setSdt(donhang.getSdt());
			dh.setStatus(donhang.getStatus());
			dh.setTenKhachhang(donhang.getTenKhachhang());
			dh.setTongTien(donhang.getTongTien());

			session.save(dh);
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
	public boolean deleteOrder(int idOrder) {
		return false;
	}

	public Donhang getOrder(int idDonhang) {
		Session session = sessionFactory.openSession();
		Donhang dh = null;

		try {
			session.getTransaction().begin();

			Query query = session.createQuery("from " + Donhang.class.getName() + " where ID_DONHANG = :idDonhang");
			query.setInteger("idDonhang", idDonhang);
			dh = (Donhang) query.uniqueResult();

			session.getTransaction().commit();
			return dh;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return dh;
	}

	@Override
	public int getInsertedID() {
		Session session = sessionFactory.openSession();
		int res = 0;
		try {
			session.getTransaction().begin();

			Query query = session.createSQLQuery("select id_donhang from donhang order by id_donhang desc limit 1");

			res = (int) query.uniqueResult();

			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public boolean insertOrderDetail(int idDonhang, int idSanpham, int soLuong) {
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();

			Donhang donhang = (Donhang) session.get(Donhang.class, idDonhang);
			Product sanpham = (Product) session.get(Product.class, idSanpham);
			ChitietdonhangId chitietdonhangId = new ChitietdonhangId(idDonhang, idSanpham, soLuong);

			session.save(new Chitietdonhang(chitietdonhangId, donhang, sanpham));

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

	public List<Chitietdonhang> getOrderDetail() {
		List<Chitietdonhang> orderDetails = new ArrayList<>();

		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			String hql = "from " + Chitietdonhang.class.getName();
			Query query = session.createQuery(hql);
			orderDetails = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return orderDetails;
	}

	@Override
	public int size() {
		Session session = sessionFactory.openSession();
		int res = 0;
		try {
			session.getTransaction().begin();

			Query query = session.createSQLQuery("select count(*) as size from donhang")
					.addScalar("size", new IntegerType());

			res = (int) query.uniqueResult();

			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return res;
	}

	@Override
	public List<Donhang> getNewOrders() {
		List<Donhang> orders = new ArrayList<>();

		// Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			String hql = "from " + Donhang.class.getName() + " order by ngay_dh desc";
			Query query = session.createQuery(hql);
			query.setMaxResults(5);
			orders = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return orders;
	}
}
