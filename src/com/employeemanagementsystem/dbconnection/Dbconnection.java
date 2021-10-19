package com.employeemanagementsystem.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;


public class Dbconnection {
	public static Connection getconnect() {
		
		
		String DB_URL=System.getenv("DB_URL");
		String DB_Port=System.getenv("DB_Port");
		String DB_Name=System.getenv("DB_Name");
		String DB_Username=System.getenv("DB_Username");
		String DB_pass=System.getenv("DB_pass");
		Connection con = null;
		try {
			
			if(con==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://"+DB_URL+":3306/"+DB_Name+","+DB_Username+","+DB_pass);
//				System.out.println("Connected with Database");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
}
