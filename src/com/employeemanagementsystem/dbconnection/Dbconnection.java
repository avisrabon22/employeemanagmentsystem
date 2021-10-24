package com.employeemanagementsystem.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {

	public static Connection getconnect() {
		Connection con = null;
		try {
			if (con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(
						"jdbc:mysql://ls-dba2334cde9acd836a7f3ed5c2e27834bcd09eb1.crgfoczgg7zq.ap-south-1.rds.amazonaws.com:3306/employeemanagementsystem",
						"dbmasteruser", "Avijit3834");

//				System.out.println("Connected with Database");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
