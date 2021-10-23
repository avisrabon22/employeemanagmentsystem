package com.employeemanagementsystem.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {

	public static Connection getconnect() {
		Connection con = null;
		try {
			if (con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
<<<<<<< HEAD
				con=DriverManager.getConnection("jdbc:mysql://localhost:8000/employeemanagementsystem","avijit","Avijit");
=======
				con = DriverManager.getConnection(
						"jdbc:mysql://ls-dba2334cde9acd836a7f3ed5c2e27834bcd09eb1.crgfoczgg7zq.ap-south-1.rds.amazonaws.com:3306/employeemanagementsystem",
						"dbmasteruser", "Avijit3834");
>>>>>>> f25f2477bb76b262ef24476bc6c11b90f3c840df
//				System.out.println("Connected with Database");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
