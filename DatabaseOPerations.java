package MainATM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;



public class DatabaseOPerations {

	static Connection conn=null;
	   static Statement stmt = null;
	   static PreparedStatement pstmt=null;
	   static float balance=0;
	   static String sql;
	   static ResultSet rs;
	   static Scanner sc=new Scanner(System.in);
	   static String trs;
	   
	   
	   
	public static void withdraw(int account_no) throws SQLException {
		// TODO Auto-generated method stub
		
		conn=DatabaseConnection.getConnection();
		System.out.println("Enter The Amount To withdraw:-");
		
		float withdrawbalance=sc.nextFloat();
		if(withdrawbalance<0) {
			System.out.println("The Amount is in negeative");
		}else {
		
		 stmt=conn.createStatement();
		   sql="select balance from user where account_no="+account_no;
		   rs=stmt.executeQuery(sql);
			while(rs.next()) {
				balance=rs.getFloat("balance");
				}
			if(withdrawbalance>=balance) {
				System.out.println("Insuficient Balances");
				
			}else {
				String update="update user set balance=? where account_no=?";
				pstmt=conn.prepareStatement(update);
				float newbalance=balance-withdrawbalance;
				pstmt.setFloat(1, newbalance);
				pstmt.setInt(2, account_no);
				
				int i=pstmt.executeUpdate();
				
				if(i>0) {
					trs= "INSERT INTO transactions (account_no,old_balance,balance,transaction_type) VALUES(?,?,?,'withdraw')";
					pstmt=conn.prepareStatement(trs);
					pstmt.setInt(1, account_no);
					pstmt.setFloat(2, balance);
					pstmt.setFloat(3, newbalance);
					
					pstmt.executeUpdate();
					
						
					System.out.println("withdraw is Sucesfull");
					System.out.println("Your Balance is :"+newbalance+"Rs.");
				}
			}}

		
		
		
		
	}
	public static void diposit(int account_no) throws SQLException {
		// TODO Auto-generated method stub
		conn=DatabaseConnection.getConnection();
		System.out.println("Enter The Amount To Diposit-");
		
		float dipositbalance=sc.nextFloat();
		if(dipositbalance<0) {
			System.out.println("The Amount is in negeative");
		}else {
		
		
		 stmt=conn.createStatement();
		   sql="select balance from user where account_no="+account_no;
		   rs=stmt.executeQuery(sql);
			while(rs.next()) {
				balance=rs.getFloat("balance");
				}
			String update="update user set balance=? where account_no=?";
			pstmt=conn.prepareStatement(update);
			float newbalance=balance+dipositbalance;
			pstmt.setFloat(1, newbalance);
			pstmt.setInt(2, account_no);
			
			int i=pstmt.executeUpdate();
			if(i>0) {
				trs= "INSERT INTO transactions(account_no,old_balance,balance,transaction_type) VALUES(?,?,?,'deposit');";
				pstmt=conn.prepareStatement(trs);
				pstmt.setInt(1, account_no);
				pstmt.setFloat(2, balance);
				pstmt.setFloat(3, newbalance);
				
				pstmt.executeUpdate();
				
				
				 
				System.out.println("diposit is Sucesfull");

				System.out.println("Your Balance is :"+newbalance+"Rs.");
			}
		}
			
	
			
			
		
		
		
	}
	public static void checkBalance(int account_no) throws SQLException {
		conn=DatabaseConnection.getConnection();
		
		 stmt=conn.createStatement();
		   sql="select balance from user where account_no="+account_no;
		   System.out.println("ID \t Balance");
			System.out.println("______________________");
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
			long balance=(long)rs.getFloat("balance");
				System.out.println(account_no+"\t"+balance);
				
			}



		
		
		
	}
	public static void getTransaction(int account_no) throws SQLException {
		// TODO Auto-generated method stub

		conn=DatabaseConnection.getConnection();
		 stmt=conn.createStatement();
		sql = "SELECT * FROM transactions";
		 System.out.format("| %-12s | %-12s | %-9s | %-19s | %-21s |\n", "Account No", "Old Balance", "Balance", "Transaction Type", "Transaction Date");
		 System.out.println("+--------------+--------------+-----------+---------------------+-----------------------+");

		 rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int accountNo = rs.getInt("account_no");
                float oldBalance = rs.getFloat("old_balance");
                float balance = rs.getFloat("balance");
                String transactionType = rs.getString("transaction_type");
                Timestamp transactionDate = rs.getTimestamp("transaction_date");

                System.out.format("| %-12d | %-12.2f | %-9.2f | %-19s | %-21s |\n",accountNo, oldBalance, balance, transactionType, transactionDate);
                System.out.println();
			}
			
		

		
		
	}
	   
	   
	   

}
