package in.ashokit;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProcedureINParameter {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";
	private static final String PROCEDURE = "call getBookById(?)";

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Book id : ");
		int bookId = sc.nextInt();

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		CallableStatement cstmt = con.prepareCall(PROCEDURE);
		cstmt.setInt(1, bookId);

		ResultSet rs = cstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1) + "-" + rs.getString(2) + "-" + rs.getDouble(3));
		}

		con.close();
	}
}
