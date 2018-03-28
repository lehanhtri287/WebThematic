package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
	public static Connection getConnection() {
		Connection connection = null;
		String url = "jdbc:mysql://mariadb13317-mariadb.jelastic.com/shophandmade";
		String user = "root";
		String pass = "VZLmob94797";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connect success!!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void closed(Statement st, ResultSet rs, Connection cnn) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (cnn != null) {
			try {
				cnn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Connection connection = Connector.getConnection();
		System.out.println(connection);
	}
}
