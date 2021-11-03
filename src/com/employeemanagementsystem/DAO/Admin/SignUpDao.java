package com.employeemanagementsystem.DAO.Admin;

//import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.Admin.SignUpModel;

public class SignUpDao {
//	SQL Commands @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	private static final String insert_user = "insert into users values(default,?,?,?,?,?,?)";
	private static final String find_user = "select * from users where id=?";
	private static final String update_user="update users set FullName=?,username=?,pass=?,gender=?,_Role=?,contactnumber=? where id=?";

// DB connection#####################################################################	
	static private Connection dbconnect = Dbconnection.getconnect();
//	Insert User****************************************************************
	public void SignUp(SignUpModel userSignup) {
		try {
			PreparedStatement ps = dbconnect.prepareStatement(insert_user);
			ps.setString(1, userSignup.getFullName());
			ps.setString(2, userSignup.getUsername());
			ps.setString(3, userSignup.getPassword());
			ps.setString(4, userSignup.getGender());
			ps.setString(5, userSignup.getRole());
			ps.setString(6, userSignup.getContactNumber());

			ps.executeUpdate();
//			System.out.println("Data Inserted");
			ps.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		
	}

	// Edit user*****************************************************************
	public List<SignUpModel> editUser(int find) throws SQLException {
		PreparedStatement ps = dbconnect.prepareStatement(find_user);
		List<SignUpModel> userFind = new ArrayList<SignUpModel>();

		ps.setInt(1, find);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			SignUpModel update = new SignUpModel();
			update.setID(rs.getInt("ID"));
			update.setFullName(rs.getString("FullName"));
			update.setUsername(rs.getString("Username"));
			update.setPassword(rs.getString("Pass"));
			update.setGender(rs.getString("Gender"));
			update.setRole(rs.getString("_ROLE"));
			update.setContactNumber(rs.getString("ContactNumber"));
			userFind.add(update);
		}
//		System.out.println("In Dao function");
		rs.close();
		ps.close();
		return userFind;
		// End function******************************************************
	}

//	Update data into DBs******************************************************
	public void updateUserDBs(SignUpModel updatedata) throws SQLException {
		PreparedStatement ps = dbconnect.prepareStatement(update_user);
		try {
//			System.out.println("In update Dao before");
			ps.setString(1, updatedata.getFullName());
			ps.setString(2, updatedata.getUsername());
			ps.setString(3, updatedata.getPassword());
			ps.setString(4, updatedata.getGender());
			ps.setString(5, updatedata.getRole());
			ps.setString(6, updatedata.getContactNumber());
			ps.setInt(7, updatedata.getID());

			ps.executeUpdate();
//			System.out.println("In update Dao after");
//			System.out.println("Data Inserted");
         
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			ps.close();
		}

	}
	
	
	
	
	
	
	
	
//	End Class**************************************************************************************************************
}
