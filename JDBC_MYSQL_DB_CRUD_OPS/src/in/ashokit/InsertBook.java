package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertBook {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME = "root";
    private static final String DB_PWD = "Govind";
//    private static final String INSERT_SQL = "INSERT INTO BOOKS VALUES(101, 'Java', 1000)"; 
    private static final String INSERT_SQL = "INSERT INTO BOOKS VALUES(104, 'Css', 9000)";
    
    public static void main(String[] args) throws Exception {
        
        // Step-1 : Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Step-2 : Get DB Connection
        Connection con =  DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
        
        // Step-3 : Create Statement
        Statement stmt = con.createStatement();
        
/**
        
        // INSERT query
//         String SQL = "INSERT INTO BOOKS VALUES(104, 'Spring', 3000)";
        
        // UPDATE query
//         String SQL = "UPDATE BOOKS SET BOOK_PRICE = 3500 WHERE book_id = 104";

        // DELETE query
//        String SQL = "DELETE FROM BOOKS WHERE BOOK_ID = 104";
        
//      int rowsEffected = stmt.executeUpdate(SQL);

 */
        
        // Step-4 : Execute Query
        int rowsEffected = stmt.executeUpdate(INSERT_SQL);
        
        // Step-5 : Process the result
        System.out.println("Record Inserted Count : " + rowsEffected);
        
        // Step-6 : Close Connection
        con.close();
    }
}
