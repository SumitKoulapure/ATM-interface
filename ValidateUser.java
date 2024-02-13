package MainATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ValidateUser {


		
		public static int validateuser() throws SQLException{
			Connection conn=DatabaseConnection.getConnection();
			
			Statement stmt=null;
		
		
		//update password;
		int uname;
		String pass;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Account No: ");
		uname=sc.nextInt();
		
		System.out.println("Enter PIN Number:");
		pass=sc.next();
		
		
		stmt = conn.createStatement();
		String s="Select * from user where account_no='"+uname+"'and passwold='"+pass+"'";
		ResultSet rs=stmt.executeQuery(s);
		
		if(rs.next()) {
			System.out.println(" you login Sucefull");
		}
		else {
			System.out.println("wrong password");
			return 0;
		}
		return  uname;
		
	

	
	}
}
