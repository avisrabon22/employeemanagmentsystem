package com.employeemanagementsystem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.UsersDetails;

public class UserDao {

	public String userLogin(UsersDetails users) {
//************************************************************************************		
		String username = users.getUsername();
		String password = users.getPassword();

//************************************************************************************	
		String usernameDB = "";
		String passwordDB = "";
		String roleDB = "";
//************************************************************************************		
		try {
			Connection con=Dbconnection.getconnect();
//			System.out.println("Connected with DB");
			String sql = "select Username,Pass,_ROLE from users";

			Statement St = con.createStatement();
			ResultSet Rs = St.executeQuery(sql);
//		***************************************************************	
			while (Rs.next()) {
				usernameDB = Rs.getString("Username");
				passwordDB = Rs.getString("Pass");
				roleDB = Rs.getString("_ROLE");

				if (username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("ADMIN")) {
					return "ADMIN_ROLE";
				} else if (username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("USER")) {
					return "USER_ROLE";
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Invalid";

	}

}
