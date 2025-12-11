package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpHike {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";
	private static final String SELECT_SQL = "SELECT * FROM EMPLOYEE";

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee Hike : ");
		double hike = sc.nextDouble();
/*
		
//		It is correct but now this time it is not use because it decrease the performance because it runs the number of records available so, it is not use
		 
		String UPDATE_SAL_SQL = "UPDATE EMPLOYEE SET EMP_SALARY = ? WHERE EMP_ID = ?";
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_SQL);
		PreparedStatement pstmt = con.prepareStatement(UPDATE_SAL_SQL);
		
		while(rs.next()) {
			int empId = rs.getInt("EMP_ID");
			double existingSal = rs.getDouble("EMP_SALARY");
			double newSal = existingSal + (existingSal * hike) / 100;
			pstmt.setDouble(1, newSal);
			pstmt.setInt(2, empId);
			
			pstmt.executeUpdate();
		}	
*/
		
//		New approach
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		String UPDATE_SAL_SQL = "UPDATE EMPLOYEE SET EMP_SALARY = EMP_SALARY + (EMP_SALARY * ?) / 100";

		PreparedStatement pstmt = con.prepareStatement(UPDATE_SAL_SQL);
		pstmt.setDouble(1, hike);
		
		pstmt.executeUpdate();
		
		System.out.println("Update completed..............");
		con.close();
	}
}
