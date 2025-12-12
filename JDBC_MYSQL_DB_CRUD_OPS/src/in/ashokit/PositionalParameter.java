package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PositionalParameter {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";

	private static final String INSERT_SQL = "INSERT INTO BOOKS VALUES (?,?,?) ";

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);
		
		pstmt.setInt(1, 105);
		pstmt.setString(2, "AWS");
		pstmt.setDouble(3, 3500.00);
		
		int count = pstmt.executeUpdate();
		System.out.println("Rows Effected : " + count);
		
		con.close();
	}
}