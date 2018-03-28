package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool.ObjectPool;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import connection.MyPool;
import model.User;

public class UserDAO {
	private static BCryptPasswordEncoder encode = new BCryptPasswordEncoder();

	public static List<User> getUsers(String role) {
		List<User> users = new ArrayList<>();
		String sql = "select * from TAIKHOAN where CHUCVU = ?;";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();

		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setNameCustomer(rs.getNString(5));
				user.setAddress(rs.getNString(6));
				user.setPhoneNumbers(rs.getString(7));

				users.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

	public static boolean createUser(User user) {
		String sql = "insert into TAIKHOAN(TEN_DANGNHAP, MAT_KHAU, TEN_KH, DIACHI, SDT) values (?, ?, ?, ?, ?);";
		Connection connection = null;
		PreparedStatement ps = null;
		ObjectPool pool = MyPool.getInstance();

		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, encode.encode(user.getPassword()));
			ps.setNString(3, user.getNameCustomer());
			ps.setNString(4, user.getAddress());
			ps.setString(5, user.getPhoneNumbers());

			return 1 == ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static User getUser(String userName) {
		String sql = "select * from TAIKHOAN where TEN_DANGNHAP = ?;";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();
		User user = new User();
		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setNameCustomer(rs.getNString(5));
				user.setAddress(rs.getNString(6));
				user.setPhoneNumbers(rs.getString(7));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public static boolean checkUserLogin(String userName, String pass) {
		String sql = "select MAT_KHAU from TAIKHOAN where TEN_DANGNHAP = ?;";
		String password = "";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ObjectPool pool = MyPool.getInstance();

		try {
			connection = (Connection) pool.borrowObject();
			ps = connection.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while (rs.next()) {
				password = rs.getString(1);
			}
			rs.close();
			return encode.matches(pass, password);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static int size() {
		String sql = "SELECT COUNT(*) FROM TAIKHOAN WHERE CHUCVU='KH';";
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
		// String test = "trile";
		// BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
		// String test1 = bEncoder.encode(test);
		// String test2 = bEncoder.encode(test);
		// System.out.println(test1);
		// System.out.println(test2);

		User user = new User();
		user.setUserName("trile");
		user.setPassword("trile123");
		user.setPhoneNumbers("0123456789");
		user.setAddress("Quảng Ngãi");
		user.setNameCustomer("Trí Lê");

		// System.out.println(checkUserLogin("trile", "trile123"));
		// System.out.println(getUser("anhtri28"));

		System.out.println(getUser("abcd").getUserName());
	}
}
