package com.employeemanagementsystem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.AttendanceModel;

public class AttendanceDao {

	public  List<AttendanceModel> getAttendance() throws SQLException {
		
		Connection con=Dbconnection.getconnect();
		String attendace="";
		
		PreparedStatement ps=con.prepareStatement(attendace);
		
		return null;
	}
	
	
	
	
	
}
