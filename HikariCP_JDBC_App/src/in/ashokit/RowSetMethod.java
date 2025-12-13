package in.ashokit;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetMethod {
	public static void main(String[] args) throws Exception {
		
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		
		rowSet.setUrl("jdbc:mysql://localhost:3306/advjdb");
		rowSet.setUsername("root");
		rowSet.setPassword("Govind");
		
		rowSet.setCommand("select * from books");
		
		rowSet.execute();
		
		while(rowSet.next()) {
			System.out.print(rowSet.getInt(1) + "\t");
			System.out.print(rowSet.getString(2) + "\t");
			System.out.println(rowSet.getInt(3));
		}
		
		rowSet.close();
		
	}
}
