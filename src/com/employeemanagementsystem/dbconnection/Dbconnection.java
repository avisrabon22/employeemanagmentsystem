package com.employeemanagementsystem.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {

	public static Connection getconnect() {
		Connection con = null;
		try {
			if (con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection();
						

//				System.out.println("Connected with Database");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
