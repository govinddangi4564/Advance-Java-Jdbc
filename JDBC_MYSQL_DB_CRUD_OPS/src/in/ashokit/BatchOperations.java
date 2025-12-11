package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchOperations {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";
	
	public static void main(String[] args) throws SQLException {
	 Connection con = DriverManager.getConnection(DB_URL, DB_UNAME,DB_PWD);
	 Statement stmt = con.createStatement();
	 
	 stmt.addBatch("INSERT INTO BOOKS VALUES(107, 'AI', 2800.00)");
	 stmt.addBatch("INSERT INTO BOOKS VALUES(108, 'ML', 3800.00)");
	 stmt.addBatch("INSERT INTO BOOKS VALUES(109, 'DS', 4800.00)");
	 
	 int[] count = stmt.executeBatch();
	 
	 for(int i : count) {
		 System.out.println(i);
	 }
	 
	 con.close();
	 
	 System.out.println("Execution completed...");
	}
}
