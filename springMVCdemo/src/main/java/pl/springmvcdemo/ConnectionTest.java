package pl.springmvcdemo;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void testConnection() {
		String url = "jdbc:mysql://db4free.net/sql5vlp5dhq78?useSSL=false";
		String user = "sqlfbatpp0u82";
		String password = "hiberjava";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver installed");
		}
		
		try {
			DriverManager.getConnection(url, user, password);
			System.out.println("Connection confirmed");
		} catch (SQLException e) {
			System.out.println("Cannot connect with database");
		}
	}
}
