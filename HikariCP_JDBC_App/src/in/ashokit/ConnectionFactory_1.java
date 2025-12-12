package in.ashokit;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory_1 {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";
	
	public static void main(String[] args) throws SQLException {
		HikariConfig config = new HikariConfig();
		
		config.setJdbcUrl(DB_URL);
		config.setUsername(DB_UNAME);
		config.setPassword(DB_PWD);
		
		config.setMaximumPoolSize(20);
		config.setMinimumIdle(5);
		
		HikariDataSource datasource = new HikariDataSource(config);
		
		Connection con = datasource.getConnection();
		
		String sql = "INSERT INTO BOOKS VALUES (110, 'Django', 4500.0)";
		
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate(sql);
		
		System.out.println("Record Inserted...");
		
		con.close();
		
	}
}
