package com.example.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Comment;
import com.example.demo.hibernate.HibernateUtil;
import com.example.demo.repository.CommentDAO;

@Repository
@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
public class CommentDAOImpl implements CommentDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public List<Comment> getComments(int idProduct) {
		List<Comment> comments = new ArrayList<>();
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			String hql = "from " + Comment.class.getName() + " where ID_SANPHAM = :ID_SANPHAM";
			Query query = session.createQuery(hql);
			query.setParameter("ID_SANPHAM", idProduct);
			// query.setMaxResults(12);
			comments = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return comments;
	}

	@Override
	public boolean insertComment(Comment comment) {
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			session.save(comment);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public boolean deleteComment(int idComment) {
		// TODO Auto-generated method stub
		return false;
	}
//	public static void main(String[] args) {
//		CommentDAOImpl commentDAOImpl = new CommentDAOImpl();
//		Product product = new Product();
//		product.setIdProduct(2);
//		Account account = new Account();
//		account.setId(12);
//		
//		Comment cmt = new Comment(product, account, "Hello xin chao");
////		System.out.println(commentDAOImpl.getComments(2));
//		System.out.println(commentDAOImpl.insertComment(cmt));
//	}
}
