package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedPositionalStmt {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";

	private static final String INSERT_SQL = "INSERT INTO BOOKS VALUES (?,?,?) ";

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Book Id");
		int id = sc.nextInt();
		
		System.out.println("Enter Book Name");
		String name = sc.next();
		
		System.out.println("Enter Book Price");
		double price = sc.nextDouble();
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setDouble(3, price);
		
		int count = pstmt.executeUpdate();
		System.out.println("Rows Effected : " + count);
		
		con.close();
	}
}
