package MainATM;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;



public class MainAtm {
	static Connection conn=null;
	static int account_no=0;
	

	public static void main(String[] args) throws SQLException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
account_no=ValidateUser.validateuser();
		
		if(account_no==0) {
			System.out.println("Wrong password reapeat the process");
			
		}else {
		
	for(;;) {
		
		System.out.println("Account NO:"+account_no);
		
		
		
		System.out.println("*****************operation************");
		 System.out.println(" 1 : Withdraw");  
         System.out.println(" 2 : Deposit");  
         System.out.println(" 3 : Check Balance"); 
         System.out.println(" 4 : Transaction Detail");
         System.out.println(" 5 : EXIT");  
         System.out.print("Choose the operation you want to perform:");  
         int choice = sc.nextInt();  
         
         switch (choice) {
		case 1: 
			DatabaseOPerations.withdraw(account_no);

			
		
			break;
	    
		case 2:
			DatabaseOPerations.diposit(account_no);
			
			
		
			break;
			
		case 3:
			DatabaseOPerations.checkBalance(account_no);
			Thread.sleep(10000);
			
		
			break;
			
		case 4:
			DatabaseOPerations.getTransaction(account_no);
			break;
			
		case 5:
			System.out.println("*********visit again*******");
			System.exit(0);
	   
		default:
			System.out.println("Enter Valid Choice ");
			
		
			
		}
         String s;
         System.out.println("Do you want to continue banking with us Enter Yes OR No");
			s=sc.next();
			s=s.toLowerCase();
			  if (s.equals("yes")) {
				  System.out.println("continue The process______________");
				  
			  }
			  else if (s.equals("no")) {
				  System.exit(0);
			  }
			  else {
				  System.out.println("Enter Valid Choice");
			  }
		
		
		
	
	
	}
	}}}


