package MainATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static String un="root";
	private static String pass="root";
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/bankingsystem";
	
	private static Connection conn=null;
	
	public static Connection  getConnection() throws SQLException {
		
		if(conn==null)
		conn =DriverManager.getConnection(url,un,pass);
		
		return conn;
		
	}
	
	

}
