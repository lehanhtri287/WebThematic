package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.pool.ObjectPool;

import connection.MyPool;
import model.Category;

public class CategoryDAO {
	public CategoryDAO() {
	}

	public static ArrayList<Category> getAllCategory() {
		ArrayList<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM LOAIHANG;";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setIdCategory(rs.getInt(1));
				category.setNameCategory(rs.getString(2));
				categories.add(category);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException ee) {
				ee.printStackTrace();
			}
			try {
				if (connection != null)
					pool.returnObject(connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					pool.returnObject(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return categories;
	}

	public static boolean createCategory(String nameCategory) {
		String sql = "INSERT INTO LOAIHANG(TEN_LOAIHANG) VALUES (?);";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setNString(1, nameCategory);

			return 1 == ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					pool.returnObject(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean editCategory(Category category) {
		String sql = "UPDATE LOAIHANG SET TEN_LOAIHANG=? WHERE ID_LOAIHANG=?;";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setNString(1, category.getNameCategory());
			ps.setInt(2, category.getIdCategory());

			return 1 == ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					pool.returnObject(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean deleteCatgory(int idCategory) {
		String sql = "DELETE FROM LOAIHANG WHERE ID_LOAIHANG=?;";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idCategory);

			return 1 == ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					pool.returnObject(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Category> categories = getAllCategory();
//		Category category = new Category(9, "");

		System.out.println(categories.size());
		System.out.println(deleteCatgory(9));
	}
}
