package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteBook {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME = "root";
    private static final String DB_PWD = "Govind";
    
public static void main(String[] args) throws Exception {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con =  DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
        
        Statement stmt = con.createStatement();

        String SQL = "DELETE FROM BOOKS WHERE BOOK_ID = 103";

        
        int rowsEffected = stmt.executeUpdate(SQL);
        
        System.out.println("Record Inserted Count : " + rowsEffected);
        
        con.close();
    }

}
