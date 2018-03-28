package connection;

import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.commons.pool.impl.GenericObjectPoolFactory;

public class MyPool {
	public static ObjectPool pool = initMySqlConnectionPool();

	public static ObjectPool initMySqlConnectionPool() {
		ReadFileProperties propertiesLibrary = new ReadFileProperties();
		Properties properties = propertiesLibrary.readFileProperties();
		String user = properties.getProperty("user");
		String pass = properties.getProperty("pass");
		String schema = properties.getProperty("schema");
		String host = properties.getProperty("host");
		int port = Integer.parseInt(properties.getProperty("port"));

		PoolableObjectFactory mySqlPoolableObjectFactory = new ConnectionPool(host, port, schema, user, pass);
		GenericObjectPool.Config config = new GenericObjectPool.Config();
		config.maxActive = 10;
		config.testOnBorrow = true;
		config.testWhileIdle = true;
		config.timeBetweenEvictionRunsMillis = 10000;
		config.minEvictableIdleTimeMillis = 60000;

		GenericObjectPoolFactory genericObjectPoolFactory = new GenericObjectPoolFactory(mySqlPoolableObjectFactory,
				config);
		ObjectPool pool = genericObjectPoolFactory.createPool();
		return pool;
	}

	public static ObjectPool getInstance() {
		if (pool == null) {
			pool = initMySqlConnectionPool();
		}
		return pool;
	}

	public static void main(String[] args) {
		ObjectPool pool = MyPool.getInstance();
		Connection connection = null;

		try {
			connection = (Connection) pool.borrowObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(connection);
	}
}
