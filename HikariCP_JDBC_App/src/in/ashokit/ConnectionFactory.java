package in.ashokit;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static DataSource datasource = null;
	
	static {
		try {
			File fl = new File("db.properties");
			FileInputStream fis = new FileInputStream(fl);

			Properties p = new Properties();
			p.load(fis);

			String url = p.getProperty("db.url");
			String uname = p.getProperty("db.uname");
			String pwd = p.getProperty("db.pwd");
			String poolSize = p.getProperty("db.poolSize");

			HikariConfig config = new HikariConfig();

			config.setJdbcUrl(url);
			config.setUsername(uname);
			config.setPassword(pwd);
			config.setMaximumPoolSize(Integer.parseInt(poolSize));

			datasource = new HikariDataSource(config);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Connection getDBConnection() throws Exception{
		return datasource.getConnection();
	}
}
