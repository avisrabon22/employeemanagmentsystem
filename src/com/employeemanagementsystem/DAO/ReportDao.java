package com.employeemanagementsystem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.ReportModel;


public class ReportDao {
	

	public List<ReportModel> getReport() throws SQLException {
		Connection con = Dbconnection.getconnect();
		String Report = "select * from employeereport";

		PreparedStatement ps = con.prepareStatement(Report);
		ResultSet rs = ps.executeQuery();
		List<ReportModel> reportList=new ArrayList<ReportModel>();
		while (rs.next()) {
			ReportModel report = new ReportModel();
			report.setId(rs.getInt("id"));
			report.setName(rs.getString("name"));
			report.setDate(rs.getString("date"));
			report.setInTime(rs.getString("logintime"));
			report.setOutTime(rs.getString("logouttime"));
			report.setStatus(rs.getString("workingtime"));
			reportList.add(report);

		}

		return reportList;
	}

//End Class***************************************************************************************
}
