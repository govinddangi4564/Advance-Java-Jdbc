package in.ashokit;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ImageInsert {
	public static void main(String[] args) throws Exception{
		
		File f = new File("C:\\Users\\govin\\OneDrive\\Pictures\\image.webp");
		FileInputStream fis = new FileInputStream(f);
		
		Connection con = ConnectionFactory.getDBConnection();
		
		String sql = "INSERT INTO imageInsert VALUES(?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, 101);
		pstmt.setBlob(2, fis);
		
		int count = pstmt.executeUpdate();
		
		System.out.println("Recorde inserted : " + count);
		
		pstmt.close();
		con.close();
	}

}
