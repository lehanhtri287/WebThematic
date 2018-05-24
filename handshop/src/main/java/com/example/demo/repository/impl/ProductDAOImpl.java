package com.example.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Loaihang;
import com.example.demo.entities.Sanpham;
import com.example.demo.hibernate.HibernateUtil;
import com.example.demo.repository.ProductDAO;

@SuppressWarnings("deprecation")
@Repository
public class ProductDAOImpl implements ProductDAO{
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private int pageSize;

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
			sanphams = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return sanphams;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Sanpham> getProductPagination(int page) {
		List<Sanpham> sanphams = new ArrayList<>();

		Session session = sessionFactory.openSession();

		int offset = 0;

		if (page > getNumpPages()) {
			page = getNumpPages();
		}
		if (page <= 0) {
			page = 1;
		}
		offset = (page - 1) * pageSize;
		try {
			session.getTransaction().begin();
			String hql = "from " + Sanpham.class.getName() + " where tinh_trang = 0";
			Query query = session.createQuery(hql);
			query.setFirstResult(offset);
			query.setMaxResults(pageSize);
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
			session.getTransaction().rollback();
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public boolean updateProduct(Sanpham sanpham) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			Sanpham sp = (Sanpham) session.get(Sanpham.class, sanpham.getIdSanpham());

			sp.setTenSanpham(sanpham.getTenSanpham());
			sp.setGia(sanpham.getGia());
			sp.setGiamGia(sanpham.getGiamGia());
			sp.setTinhTrang(sanpham.getTinhTrang());
			sp.setImages(sanpham.getImages());
			sp.setMoTa(sanpham.getMoTa());
			sp.setSoLuong(sanpham.getSoLuong());

			Query query = session.createQuery("from " + Loaihang.class.getName() + " where ID_LOAIHANG = :ID_LOAIHANG");
			query.setInteger("ID_LOAIHANG", sanpham.getLoaihang().getIdLoaihang());
			Loaihang cate = (Loaihang) query.uniqueResult();
			sp.setLoaihang(cate);

			session.update(sp);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public boolean deleteProduct(int idSanpham) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();

			Query query = session.createSQLQuery("call delete_sanpham(:idSanpham)");
			query.setParameter("idSanpham", idSanpham);
			int res = query.executeUpdate();

			session.getTransaction().commit();
			return 1 == res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public int getNumpPages() {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();

			Query query = session.createSQLQuery("select count(*) as numPages from sanpham where tinh_trang = 0")
					.addScalar("numPages", new IntegerType());

			int res = (int) query.uniqueResult();
			int numPages = res / pageSize;
			if (res % pageSize > 0) {
				numPages += 1;
			}

			session.getTransaction().commit();
			return numPages;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Sanpham> getProductByCate(int id) {
		List<Sanpham> sanphams = new ArrayList<>();
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			String hql = "from " + Sanpham.class.getName() + " where id_loaihang = :idCate";
			Query query = session.createQuery(hql);
			query.setInteger("idCate", id);
			
			sanphams = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return sanphams;
	}

	public static void main(String[] args) {
		ProductDAOImpl sanphamDAO = new ProductDAOImpl();
		// Loaihang cate = new Loaihang();
		// cate.setIdLoaihang(12);
		// Sanpham sanpham = new Sanpham(cate, "Lục lạc", 230000, "Lục lạc vàng đáng yêu
		// quá đi", 0, 0, "images/1.jpg", 5);
		// sanpham.setIdSanpham(1003);
		// System.out.println(sanphamDAO.updateProduct(sanpham));
		sanphamDAO.setPageSize(5);
		System.out.println(sanphamDAO.getProductByCate(12).size());
	}
}
