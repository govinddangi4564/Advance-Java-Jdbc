package in.ashokit;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ImageDownload {
	public static void main(String[] args) throws Exception {
		
		Connection con = ConnectionFactory.getDBConnection();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT*FROM imageInsert");
		
		if(rs.next()) {
			System.out.println(rs.getInt(1));
			byte[] stream = rs.getBytes(2);
			
			FileOutputStream fos = new FileOutputStream("C:\\Users\\govin\\OneDrive\\Documents\\Copied item\\CopiedImage.png");
			fos.write(stream);
			fos.close();
		}
		con.close();
	}
}
