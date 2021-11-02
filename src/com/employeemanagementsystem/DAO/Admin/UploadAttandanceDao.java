package com.employeemanagementsystem.DAO.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.Admin.AttandanceAdminModel;
import com.employeemanagementsystem.model.Admin.SignUpModel;

public class UploadAttandanceDao {
	private Connection connect = Dbconnection.getconnect();
	private static final String ListUserForAttandance = "select id,fullname,username from users where id=?";
	private static final String insertAttandance = "insert into attendance values(?,?,?,?,?,?,?)";
	private static final String showAttendance="select * from attendance";

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
	public void insertAttandance(AttandanceAdminModel attandanceAdminModel) throws SQLException {
		PreparedStatement ps = connect.prepareStatement(insertAttandance);
		ps.setInt(1, attandanceAdminModel.getID());
		ps.setString(2, attandanceAdminModel.getName());
		ps.setString(3, attandanceAdminModel.getUsername());
		ps.setString(4, attandanceAdminModel.getDate());
		ps.setString(5, attandanceAdminModel.getInTime());
		ps.setString(6, attandanceAdminModel.getOutTime());
		ps.setString(7, attandanceAdminModel.getStatus());
		
		
		ps.executeUpdate();
		ps.close();
		System.out.println("In DAO");
	}




public  List<AttandanceAdminModel> showAttendance() throws SQLException {
	
	Connection con=Dbconnection.getconnect();
	PreparedStatement ps=con.prepareStatement(showAttendance);
	List<AttandanceAdminModel> attendance=new ArrayList<AttandanceAdminModel>();
	
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		AttandanceAdminModel attendanceShow=new AttandanceAdminModel();
		attendanceShow.setID(rs.getInt("id"));
		attendanceShow.setName(rs.getString("name"));
		attendanceShow.setUsername(rs.getString("username"));
		attendanceShow.setDate(rs.getString("date"));
		attendanceShow.setInTime(rs.getString("intime"));
		attendanceShow.setOutTime(rs.getString("outtime"));
		attendanceShow.setStatus(rs.getString("_status"));
		attendance.add(attendanceShow);
	}
	
	return attendance;
}






}