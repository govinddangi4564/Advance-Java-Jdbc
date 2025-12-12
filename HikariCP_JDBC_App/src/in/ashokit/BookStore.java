package in.ashokit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookStore {
	public static void main(String[] args) throws Exception{
		Connection con = ConnectionFactory.getDBConnection();
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from books");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "---" + rs.getString(2) + "---" + rs.getDouble(3));
		}
		
		rs.close();
		stmt.close();
		con.close();
	}
}
