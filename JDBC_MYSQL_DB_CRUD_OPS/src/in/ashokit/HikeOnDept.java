package in.ashokit;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class HikeOnDept {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";
	private static final String SELECT_SQL = "SELECT * FROM EMPLOYEE";

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Emp Hike for HR Dept : ");
		double hrDeptHike = sc.nextDouble();
		
		System.out.println("Enter Emp Hike for Sales Dept : ");
		double salesDeptHike = sc.nextDouble();
		
		System.out.println("Enter Emp Hike for Admin Dept : ");
		double adminDeptHike = sc.nextDouble();
		
		System.out.println("Enter Emp Hike for Security Dept : ");
		double securityDeptHike = sc.nextDouble();
		
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME, DB_PWD);
		
		String UPDATE_SAL_SQL = "UPDATE EMPLOYEE SET EMP_SALARY = EMP_SALARY + (EMP_SALARY * ?) / 100 WHERE EMP_DEPT = ?";
		
		PreparedStatement pstmt = con.prepareStatement(UPDATE_SAL_SQL);
		
		pstmt.setDouble(1, hrDeptHike);
		pstmt.setString(2, "HR");
		pstmt.executeUpdate();
		
		
		pstmt.setDouble(1, salesDeptHike);
		pstmt.setString(2, "Sales");
		pstmt.executeUpdate();
		
		
		pstmt.setDouble(1, adminDeptHike);
		pstmt.setString(2, "Admin");
		pstmt.executeUpdate();
		
		
		pstmt.setDouble(1, securityDeptHike);
		pstmt.setString(2, "Security");
		pstmt.executeUpdate();

		System.out.println("Update completed..............");
		con.close();

	}
}
