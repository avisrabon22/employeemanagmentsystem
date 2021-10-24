	package com.employeemanagementsystem.DAO.Admin;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	//import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	//import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import com.employeemanagementsystem.dbconnection.Dbconnection;
	import com.employeemanagementsystem.model.Admin.SignUpModel;

	public class UserListDao {
//		Connection with DB******************************
		Connection con = Dbconnection.getconnect();
//		SQL Query*******************************************************
		private static final String list_users = "select * from users";
		private static final String delete_user = "delete from users where id=?";
	//User List*************************************************************************
		public List<SignUpModel> UserList() throws SQLException {
			List<SignUpModel> usersList = new ArrayList<SignUpModel>();
	//********************************************************************************
			PreparedStatement ps = con.prepareStatement(list_users);
			ResultSet rs = ps.executeQuery();
			try {
//				System.out.println("Connected with DB");
//		**********************************************************************		      
				rs.next();
				while (rs.next()) {
					SignUpModel user = new SignUpModel();
					user.setID(rs.getInt("ID"));
					user.setFullName(rs.getString("FullName"));
					user.setUsername(rs.getString("Username"));
					user.setPassword(rs.getString("Pass"));
					user.setGender(rs.getString("Gender"));
					user.setRole(rs.getString("_ROLE"));
					user.setContactNumber(rs.getString("ContactNumber"));
//					System.out.println("In Data");
					usersList.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ps.close();
				rs.close();
			}
			return usersList;
	//End function*******************************************************
		}

//		Delete user **********************************************************
		public void deleteUser(int delete) throws SQLException {
			PreparedStatement ps = con.prepareStatement(delete_user);
			ps.setInt(1, delete);
			ps.executeUpdate();
//		System.out.println("In Dao function");
			ps.close();
	//End function******************************************************
		}

		
		
		
	//End Class**************************************************************************************************
	}

