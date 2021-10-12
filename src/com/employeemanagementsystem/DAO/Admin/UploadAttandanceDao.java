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
	String ListUserForAttandance = "select ID,FullName from users where ID=?";
	String insertAttandance = "insert into attandance values(default,?,?,?,?)";
	String UpdatedAttandance = "select ID,FullName from users union select InTime,OutTime,Status from attandance";

	SignUpModel users = new SignUpModel();

	public List<SignUpModel> userListForAttandance(int ID) throws SQLException {
		List<SignUpModel> listofUsers = new ArrayList<SignUpModel>();

		PreparedStatement ps = connect.prepareStatement(ListUserForAttandance);

		
		ps.setInt(1,ID);
		ResultSet rs = ps.executeQuery();
		rs.next();
		while (rs.next()) {
			SignUpModel attandance = new SignUpModel();
			attandance.setID(rs.getInt("ID"));
			attandance.setFullName(rs.getString("FullName"));
			attandance.setInTime(rs.getTime("InTime"));
			attandance.setOutTime(rs.getTime("OutTime"));
			attandance.setStatus(rs.getString("_Status"));
			listofUsers.add(attandance);
		}
		ps.close();
		rs.close();
		System.out.println("In attendance DAO");
		
		return listofUsers;
	}

//	public List<AttandanceModel> UpdatedUserListForAttandance() throws SQLException {
//		List<AttandanceModel> listofupdatedUsers = new ArrayList<AttandanceModel>();
//		PreparedStatement psu = connect.prepareStatement(UpdatedAttandance);
//		ResultSet rsu = psu.executeQuery();
//
//		rsu.next();
//		while (rsu.next()) {
//			AttandanceModel updateAttandance = new AttandanceModel();
//			updateAttandance.setInTime(rsu.getTime("InTime"));
//			updateAttandance.setOutTime(rsu.getTime("OutTime"));
//			updateAttandance.setStatus(rsu.getString("_Status"));
//			listofupdatedUsers.add(updateAttandance);
//		}
//		psu.close();
//		rsu.close();
//		return listofupdatedUsers;
//	}

	public void insertAttandance(AttandanceModel attandanceModel) throws SQLException {
		PreparedStatement ps = connect.prepareStatement(insertAttandance);
		ps.setTime(1, attandanceModel.getInTime());
		ps.setTime(2, attandanceModel.getOutTime());
		ps.setString(3, attandanceModel.getStatus());
		ps.setInt(4, attandanceModel.getID());
		ps.executeUpdate();

		ps.close();
	}

}
