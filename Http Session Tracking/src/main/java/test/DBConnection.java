package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static Connection conn=null;
	private DBConnection() {
		
	}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","c##batch111","shivam");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return conn;
	}
}
