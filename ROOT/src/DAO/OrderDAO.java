package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool.ObjectPool;

import connection.MyPool;
import model.Order;
import model.OrderDetail;

public class OrderDAO {
	public static List<Order> getAllOrder() {
		List<Order> orders = new ArrayList<>();
		String sql = "select * from DONHANG order by ID_DONHANG desc;";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();

		try {
			ResultSet rs = null;
			Order order = new Order();
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				order.setIdOrder(rs.getInt(1));
				order.setDateTime(rs.getTimestamp(2));
				order.setTotalPrice(rs.getInt(3));
				order.setCustomerName(rs.getNString(4));
				order.setPhoneNumber(rs.getString(5));
				order.setAddress(rs.getNString(6));

				orders.add(order);
			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		return orders;
	}

	public static Order getOrderDetail(int idOrder) {
		Order order = new Order();
		String sql = "SELECT * FROM V_DONHANG WHERE ID_DONHANG = ?;";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();
		List<OrderDetail> orderDetails = new ArrayList<>();

		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idOrder);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDetail orderDetail = new OrderDetail();
				order.setIdOrder(rs.getInt(1));
				order.setDateTime(rs.getTimestamp(2));
				order.setTotalPrice(rs.getInt(3));
				order.setCustomerName(rs.getNString(4));
				order.setPhoneNumber(rs.getString(5));
				order.setAddress(rs.getNString(6));
				order.setEmail(rs.getString(7));

				orderDetail.setIdOrder(rs.getInt(1));
				orderDetail.setIdProduct(rs.getInt(8));
				orderDetail.setNameProduct(rs.getNString(9));
				orderDetail.setQuantity(rs.getInt(10));

				orderDetails.add(orderDetail);
			}
			order.setOrderDetails(orderDetails);
			return order;
		} catch (Exception e) {
			e.printStackTrace();
			return order;
		}
	}

	public static int getIdOrder() {
		int result = 0;
		String sql = "select ID_DONHANG from DONHANG order by ID_DONHANG desc limit 1;";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();

		try {
			ResultSet rs = null;
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
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
		return result;
	}

	public static boolean createOrder(Order order) {
		String sql = "insert into DONHANG(TONG_TIEN, TEN_KHACHHANG, SDT, DIACHI, EMAIL) values (?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();

		try {
			connection = (Connection) pool.borrowObject();

			ps = connection.prepareStatement(sql);
			ps.setInt(1, order.getTotalPrice());
			ps.setNString(2, order.getCustomerName());
			ps.setString(3, order.getPhoneNumber());
			ps.setNString(4, order.getAddress());
			ps.setString(5, order.getEmail());

			return 1 == ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

	public boolean editOrder(Order order) {
		return false;
	}

	public static boolean deleteOrder(int idOrder) {
		String sql = "CALL XOA_DONHANG(?);";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();

		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idOrder);
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

	public static boolean createOrderDetail(OrderDetail orderDetail) {
		String sql = "insert into CHITIETDONHANG values (?,?,?);";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();

		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, orderDetail.getIdOrder());
			ps.setInt(2, orderDetail.getIdProduct());
			ps.setInt(3, orderDetail.getQuantity());

			return 1 == ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// public static OrderDetail getOrderDetail(int idOrder) {
	// String sql = "SELECT * FROM";
	// return null;
	// }

	public static int size() {
		String sql = "SELECT COUNT(*) FROM DONHANG;";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		ObjectPool pool = MyPool.getInstance();

		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
	}

	public static void main(String[] args) {
		// Order order = new Order();
		// order.setAddress("Mộ Đức, Quảng Ngãi");
		// order.setCustomerName("Kim Jong-un");
		// order.setPhoneNumber("01638575780");
		// order.setTotalPrice(450000);
		// order.setEmail("asdasdasd");
		//
		// OrderDAO.createOrder(order);
		// Product product1 = new Product(1, "", 0, "", 0, 1, 0, "", 5);
		// Product product2 = new Product(2, "", 0, "", 0, 1, 0, "", 5);
		// Product product3 = new Product(3, "", 0, "", 0, 1, 0, "", 5);
		//
		// List<Product> products = new ArrayList<>();
		// products.add(product1);
		// products.add(product2);
		// products.add(product3);
		//
		// order.setIdOrder(OrderDAO.getIdOrder());
		// for (Product product : products) {
		// OrderDAO.createOrderDetail(
		// new OrderDetail(order.getIdOrder(), product.getIdProduct(),
		// product.getQuantity()));
		// }
		//
		// System.out.println(order.toString());
		System.out.println(getOrderDetail(11));
	}
}
