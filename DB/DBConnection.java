package DB;

import java.sql.*;

public class  DBConnection {
	
	public static Connection CreateConnection() throws Exception { 
		
     // Load JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
     // Connect Database 
		String url = "jdbc:mysql://localhost:3306/btl_ltnc";
		String username = "root";
		String password = "1234";
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
	return conn;
		
	}
} 
