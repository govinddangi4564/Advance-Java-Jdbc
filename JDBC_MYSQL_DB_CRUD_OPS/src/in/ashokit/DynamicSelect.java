package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicSelect {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";

	public static void main(String[] args) throws SQLException{

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Price");
		double price = sc.nextDouble();

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		StringBuilder sql = new StringBuilder("SELECT * FROM BOOKS");
		if (price > 0) {
			sql.append(" WHERE BOOK_PRICE <= ?");
		}

		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		if (price > 0) {
			pstmt.setDouble(1, price);
		}
		
		ResultSet rs =  pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "--" + rs.getString(2) + "--" + rs.getDouble(3));			
		}
		
		con.close();
		sc.close();

	}

}
