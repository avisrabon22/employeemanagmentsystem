package com.employeemanagementsystem.DAO.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.AttendanceModel;
import com.employeemanagementsystem.model.Admin.AttandanceModel;
import com.employeemanagementsystem.model.Admin.SignUpModel;

public class UploadAttandanceDao {
	private Connection connect = Dbconnection.getconnect();
	private static final String ListUserForAttandance = "select id,fullname,username from users where id=?";
	private static final String insertAttandance = "insert into attendance values(?,?,?,?,?,?,?)";
	private static final String showAttendance="select * from attendance where username=?";

	SignUpModel users = new SignUpModel();
//************************************************************************************************
	public List<SignUpModel> userListForAttandance(int ID) throws SQLException {
		List<SignUpModel> listofUsers = new ArrayList<SignUpModel>();

		PreparedStatement ps = connect.prepareStatement(ListUserForAttandance);

		
		ps.setInt(1,ID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			SignUpModel attandance = new SignUpModel();
			attandance.setID(rs.getInt("ID"));
			attandance.setFullName(rs.getString("FullName"));
			attandance.setUsername(rs.getString("username"));
			listofUsers.add(attandance);
		}
		ps.close();
		rs.close();
		System.out.println("In attendance DAO");
		return listofUsers;
		
		
	}

//	*************************************************************************************************
	public void insertAttandance(AttandanceModel attandanceModel) throws SQLException {
		PreparedStatement ps = connect.prepareStatement(insertAttandance);
		ps.setInt(1, attandanceModel.getID());
		ps.setString(2, attandanceModel.getName());
		ps.setString(3, attandanceModel.getUsername());
		ps.setString(4, attandanceModel.getDate());
		ps.setString(5, attandanceModel.getInTime());
		ps.setString(6, attandanceModel.getOutTime());
		ps.setString(7, attandanceModel.getStatus());
		
		
		ps.executeUpdate();
		ps.close();
		System.out.println("In DAO");
	}




public  List<AttandanceModel> showAttendance(String username) throws SQLException {
	
	Connection con=Dbconnection.getconnect();
	PreparedStatement ps=con.prepareStatement(showAttendance);
	List<AttendanceModel> attendance=new ArrayList<AttendanceModel>();
	
	ps.setString(0,username);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		AttendanceModel attendanceShow=new AttendanceModel();
//		
//		attendanceShow.;
//		attendanceShow.
//		attendanceShow.set
		
	}
	
	
	
	
	
	
	return null;
}






}