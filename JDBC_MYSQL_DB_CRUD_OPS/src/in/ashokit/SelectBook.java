package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectBook {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";
    private static final String SELECT_SQL = "SELECT * FROM BOOKS"; 
//	private static final String SELECT_SQL = "SELECT * FROM BOOKS WHERE BOOK_ID = 101"; 

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(SELECT_SQL);

    // ---------------------------------------------------------------------------------------------------------------
		
//		it is for full table
		
		while(rs.next()) {
			int bookId = rs.getInt("BOOK_ID");
			String bookName = rs.getString("BOOK_NAME");
			double price = rs.getDouble("BOOK_PRICE");
			
//			System.out.println(bookId);
//			System.out.println(bookName);
//			System.out.println(price);
			
//			System.out.println(bookId + "\t" + bookName + "\t" + price);
			
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
		}
		
	// ----------------------------------------------------------------------------------------------------------------------
			
//   it is only for one query
		
//		if(rs.next()) {
//			int bookId = rs.getInt("BOOK_ID");
//			String bookName = rs.getString("BOOK_NAME");
//			double price = rs.getDouble("BOOK_PRICE");
//			
//			System.out.println(bookId);
//			System.out.println(bookName);
//			System.out.println(price);
//		}else {
//			System.out.println("No Records Found");
//		}
			
	// -----------------------------------------------------------------------------------------------------------------------

		con.close();
	}

}
