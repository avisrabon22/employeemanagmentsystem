package com.employeemanagementsystem.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.AttendanceModel;

public class AttendanceDao {

	public  List<AttendanceModel> getAttendance(String username) throws SQLException {
		List<AttendanceModel> attendance=new ArrayList<AttendanceModel>();
		Connection con=Dbconnection.getconnect();
		String attendace="select * from attendance where username=?";
		AttendanceModel getAttendance=new AttendanceModel();
		PreparedStatement ps=con.prepareStatement(attendace);
		ResultSet rs=ps.executeQuery();
		rs.getString(username);
		 getAttendance.setId(rs.getInt("id"));
         getAttendance.setName(rs.getString("name"));
		while(rs.next()) {
			
			getAttendance=new AttendanceModel();
                getAttendance.setDate(rs.getString("date"));
                getAttendance.setIntime(rs.getString("intime"));
                getAttendance.setOuttime(rs.getString("outtime"));
                getAttendance.setStatus(rs.getString("_status"));
                attendance.add(getAttendance);
			
		}
		return attendance;
	}
	
	
	
	
	
}
