package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class UpdateData {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Govind";
	private static final String SELECT_SQL = "SELECT * FROM BOOKS";

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet rs = stmt.executeQuery(SELECT_SQL);

//		rs.absolute(2);
//		rs.updateDouble(3, 5500.00);
//		rs.updateRow();
		
//		rs.deleteRow();
//		rs.last();
//		rs.previous();
//		rs.first();

//		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
//
//		rs.previous();
//		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));

		
		ResultSetMetaData metaData = rs.getMetaData();
		
		System.out.println("Column Count : " + metaData.getColumnCount());
		
		System.out.println("-----------------------------------------------");
		
		for(int i = 1; i<= metaData.getColumnCount(); i++) {
			System.out.println(metaData.getColumnName(i));
		}
		
		System.out.println("-----------------------------------------------");
		
		for(int i = 1; i<= metaData.getColumnCount(); i++) {
			String columnName = metaData.getColumnTypeName(i);
			System.out.println(columnName);
		}
		
		con.close();
	}

}
