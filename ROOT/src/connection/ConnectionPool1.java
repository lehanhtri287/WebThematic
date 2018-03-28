package connection;

import java.sql.DriverManager;

import org.apache.commons.pool.BasePoolableObjectFactory;

public class ConnectionPool1 extends BasePoolableObjectFactory {
	private String host;
	private String schema;
	private String user;
	private String password;

	public ConnectionPool1(String host, String schema, String user, String password) {
		this.host = host;
		this.schema = schema;
		this.user = user;
		this.password = password;
	}

	@Override
	public Object makeObject() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://" + host + "/" + schema;
		return DriverManager.getConnection(url, user, password);
	}
}