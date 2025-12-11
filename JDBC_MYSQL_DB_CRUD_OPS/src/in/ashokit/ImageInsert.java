package in.ashokit;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageInsert {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		PreparedStatement ps = con.prepareStatement(
	            "insert into user values(?,?,?)");

	        ps.setInt(1, 101);
	        ps.setString(2, "Bot");

	        FileInputStream fis = new FileInputStream("C:\\Users\\govin\\OneDrive\\Pictures\\Screenshots\\Screenshot 2025-11-08 121333.png");
	        ps.setBinaryStream(3, fis, fis.available());

	        int count = ps.executeUpdate();
	        System.out.println(count + " record inserted");
	        con.close();
	}
}
