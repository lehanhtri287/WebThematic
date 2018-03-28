package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool.ObjectPool;

import connection.MyPool;
import model.Product;

public class ProductDAO {
	public ProductDAO() {
	}

	public static ArrayList<Product> getAllProduct() {
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM SANPHAM order by ID_SANPHAM desc;";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setIdProduct(rs.getInt(1));
				product.setNameProduct(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDescription(rs.getNString(4));
				product.setStatus(rs.getByte(5));
				product.setIdCategory(rs.getInt(6));
				product.setSalePercent(rs.getInt(7));
				product.setImage(rs.getString(8));
				product.setQuantity(rs.getInt(9));
				products.add(product);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
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
		return products;
	}

	public static ArrayList<Product> getProductByCate(int idCategory) {
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM SANPHAM WHERE ID_LOAIHANG=?;";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idCategory);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setIdProduct(rs.getInt(1));
				product.setNameProduct(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDescription(rs.getNString(4));
				product.setStatus(rs.getByte(5));
				product.setIdCategory(rs.getInt(6));
				product.setSalePercent(rs.getInt(7));
				product.setImage(rs.getString(8));
				products.add(product);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
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
		return products;
	}

	public static List<Product> getProductLikeMost() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM V_LIKEMOST;";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setIdProduct(rs.getInt(1));
				product.setNameProduct(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDescription(rs.getNString(4));
				product.setStatus(rs.getByte(5));
				product.setIdCategory(rs.getInt(6));
				product.setSalePercent(rs.getInt(7));
				product.setImage(rs.getString(8));
				product.setQuantity(rs.getInt(9));
				products.add(product);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
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
		return products;
	}

	public static List<Product> getProductCheap() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM SANPHAM order by GIA;";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setIdProduct(rs.getInt(1));
				product.setNameProduct(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDescription(rs.getNString(4));
				product.setStatus(rs.getByte(5));
				product.setIdCategory(rs.getInt(6));
				product.setSalePercent(rs.getInt(7));
				product.setImage(rs.getString(8));
				product.setQuantity(rs.getInt(9));
				products.add(product);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
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
		return products;
	}

	public static List<Product> getProductAZ() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM SANPHAM order by TEN_SANPHAM;";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setIdProduct(rs.getInt(1));
				product.setNameProduct(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDescription(rs.getNString(4));
				product.setStatus(rs.getByte(5));
				product.setIdCategory(rs.getInt(6));
				product.setSalePercent(rs.getInt(7));
				product.setImage(rs.getString(8));
				product.setQuantity(rs.getInt(9));
				products.add(product);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
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
		return products;
	}

	public static List<Product> getProductSearch(String productName) {
		List<Product> products = new ArrayList<>();
		String sql = "Select * from SANPHAM where TEN_SANPHAM like '%" + productName + "%'";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setIdProduct(rs.getInt(1));
				product.setNameProduct(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDescription(rs.getNString(4));
				product.setStatus(rs.getByte(5));
				product.setIdCategory(rs.getInt(6));
				product.setSalePercent(rs.getInt(7));
				product.setImage(rs.getString(8));
				products.add(product);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
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
		return products;
	}

	public static List<Product> getProductPerPages(int page) {
		List<Product> products = new ArrayList<>();
		String sql = "SELECT * FROM SANPHAM ORDER BY ID_SANPHAM DESC LIMIT ?,5";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();
		int tmp = 0;
		if (page >= getNumPages()) {
			tmp = getNumPages();
		} else if (page <= 0) {
			tmp = 1;
		} else {
			tmp = (page - 1) * 5;
		}
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, tmp);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setIdProduct(rs.getInt(1));
				product.setNameProduct(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDescription(rs.getNString(4));
				product.setStatus(rs.getByte(5));
				product.setIdCategory(rs.getInt(6));
				product.setSalePercent(rs.getInt(7));
				product.setImage(rs.getString(8));
				product.setQuantity(rs.getInt(9));
				products.add(product);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
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
		return products;
	}

	public static Product getProduct(int id) {
		String sql = "SELECT * FROM SANPHAM WHERE ID_SANPHAM=?";
		Connection connection = null;
		Product product = new Product();
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product.setIdProduct(rs.getInt(1));
				product.setNameProduct(rs.getNString(2));
				product.setPrice(rs.getInt(3));
				product.setDescription(rs.getNString(4));
				product.setStatus(rs.getInt(5));
				product.setIdCategory(rs.getInt(6));
				product.setSalePercent(rs.getInt(7));
				product.setImage(rs.getString(8));
				product.setQuantity(rs.getInt(9));
			}

			return product;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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

	public static boolean createProduct(Product product) {
		String sql = "INSERT INTO SANPHAM(TEN_SANPHAM, GIA, MO_TA, TINH_TRANG, ID_LOAIHANG, GIAM_GIA, IMAGES) VALUES (?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setNString(1, product.getNameProduct());
			ps.setInt(2, product.getPrice());
			ps.setNString(3, product.getDescription());
			ps.setInt(4, product.getStatus());
			ps.setInt(5, product.getIdCategory());
			ps.setInt(6, product.getSalePercent());
			ps.setString(7, product.getImage());

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

	public static boolean editProduct(Product product) {
		String sql = "UPDATE SANPHAM SET TEN_SANPHAM = ?, GIA=?, MO_TA=?, TINH_TRANG=?, ID_LOAIHANG=?, GIAM_GIA=?, IMAGES=? WHERE ID_SANPHAM = ?";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setNString(1, product.getNameProduct());
			ps.setInt(2, product.getPrice());
			ps.setNString(3, product.getDescription());
			ps.setInt(4, product.getStatus());
			ps.setInt(5, product.getIdCategory());
			ps.setInt(6, product.getSalePercent());
			ps.setString(7, product.getImage());
			ps.setInt(8, product.getIdProduct());

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

	public static boolean deleteProduct(int idProduct) {
		String sql = "CALL XOA_SANPHAM(?);";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idProduct);

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

	public static int getNumPages() {
		String sql = "SELECT COUNT(*) FROM SANPHAM;";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0, tmp = 0;
		ObjectPool pool = MyPool.getInstance();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				tmp = rs.getInt(1);
			}
			result = tmp / 4;
			if (tmp % 4 != 0) {
				result += 1;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
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
		// ArrayList<Product> products = new ArrayList<>();
		// System.out.println(products.size());
		// System.out.println(getProductAZ().get(0).toString());
		// System.out.println(getProductSearch("goi").size());
		// System.out.println(getProduct(2).toString());
		// System.out.println(ProductDAO.checkEmail("14130355@st.hcmuaf.edu.vn"));
		// System.out.println(getNumPages());
		// System.out.println(getProductSearch("sp").get(3).getNameProduct());
//		System.out.println(getProductPerPages(1));
	}
}
