package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool.ObjectPool;

import connection.MyPool;
import model.Comment;

public class CommentDAO {
	public static List<Comment> getComment(int idProduct) {
		List<Comment> comments = new ArrayList<>();
		String sql = "SELECT * FROM CMT WHERE ID_SANPHAM=?";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();

		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idProduct);
			rs = ps.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setIdComment(rs.getInt(1));
				comment.setIdProduct(rs.getInt(2));
				comment.setNameCustomer(rs.getNString(3));
				comment.setTimeCmt(rs.getTimestamp(4));
				comment.setContext(rs.getNString(5));

				comments.add(comment);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}

	public static boolean createComment(Comment comment) {
		String sql = "insert into CMT(ID_SANPHAM, TEN_KH, NOI_DUNG) values (?, ?, ?);";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();

		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, comment.getIdProduct());
			ps.setNString(2, comment.getNameCustomer());
			ps.setNString(3, comment.getContext());

			return 1 == ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean editComment(Comment comment) {
		return false;
	}

	public static boolean deleteComment(int idCmt) {
		String sql = "delete from CMT where ID_CMT=?;";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();

		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idCmt);

			return 1 == ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static int countCmt(int idProd) {
		String sql = "select count(*) from CMT where ID_SANPHAM=?;";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();
		int result = 0;

		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idProd);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		// Comment comment = new Comment();
		// comment.setIdProduct(1);
		// comment.setNameCustomer("Trí Dubai");
		// comment.setContext("Tốt đấy");
		// List<Comment> comments = getComment(1);
		// Collections.reverse(comments);
		//
		//
		//
		// System.out.println(comments.get(1).toString());
		// System.out.println(createComment(comment));
	}
}
