package in.ashokit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadProperties {
	public static void main(String[] args) throws IOException {
		
		File fl = new File("db.properties");
		FileInputStream fis = new FileInputStream(fl);
		
		Properties p = new Properties();
		p.load(fis);
		
		String uname = p.getProperty("db.username");
		String pwd = p.getProperty("db.password");
		
		System.out.println(uname);
		System.out.println(pwd);
		
		fis.close();
	}

}
