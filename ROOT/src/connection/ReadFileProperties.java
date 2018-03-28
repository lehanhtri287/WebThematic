package connection;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadFileProperties {
	public Properties readFileProperties() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		try {
			properties.load(classLoader.getResourceAsStream("config.properties"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return properties;
	}

}
