package com.employeemanagementsystem.DAO.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.Admin.AttandanceModel;
import com.employeemanagementsystem.model.Admin.SignUpModel;

public class UploadAttandanceDao {
	private Connection connect = Dbconnection.getconnect();
	String ListUserForAttandance = "select id,fullname from users where id=?";
	String insertAttandance = "insert into attendance values(default,?,?,?,?,?)";
	

	SignUpModel users = new SignUpModel();

	public List<SignUpModel> userListForAttandance(int ID) throws SQLException {
		List<SignUpModel> listofUsers = new ArrayList<SignUpModel>();

		PreparedStatement ps = connect.prepareStatement(ListUserForAttandance);

		
		ps.setInt(1,ID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			SignUpModel attandance = new SignUpModel();
			attandance.setID(rs.getInt("ID"));
			attandance.setFullName(rs.getString("FullName"));
			listofUsers.add(attandance);
		}
		ps.close();
		rs.close();
		System.out.println("In attendance DAO");
		return listofUsers;
		
		
	}

	public void insertAttandance(AttandanceModel attandanceModel) throws SQLException {
		PreparedStatement ps = connect.prepareStatement(insertAttandance);
		ps.setString(1, attandanceModel.getDate());
		ps.setString(2, attandanceModel.getInTime());
		ps.setString(3, attandanceModel.getOutTime());
		ps.setString(4, attandanceModel.getStatus());
		ps.setInt(5, attandanceModel.getID());
		
		ps.executeUpdate();
		ps.close();
		System.out.println("In DAo");
	}

}
