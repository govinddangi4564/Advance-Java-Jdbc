package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateBetween {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";
	
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		PreparedStatement ps = con.prepareStatement(
	            "select * from employees where joining_date between ? and ?");

	        ps.setDate(1, java.sql.Date.valueOf("2022-01-01"));
	        ps.setDate(2, java.sql.Date.valueOf("2022-12-31"));

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            System.out.println(rs.getInt(1) + " " + rs.getString(2));
	        }
	        con.close();
	}
}
