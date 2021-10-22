package com.employeemanagementsystem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.ReportModel;


public class ReportDao {

	public ReportModel getReport() throws SQLException {
		Connection con = Dbconnection.getconnect();
		String Report = "select * from employeereport";

		PreparedStatement ps = con.prepareStatement(Report);
		ResultSet rs = ps.executeQuery();
		List<ReportModel> reportList=new ArryList<ReportModel>();
		while (rs.next()) {
			ReportModel report = new ReportModel();
			report.setDate(rs.getString("date"));
			report.setInTime(rs.getString("intime"));
			report.setOutTime(rs.getString("outtime"));
			report.setStatus(rs.getString("status"));
			

		}

		return null;
	}

//End Class***************************************************************************************
}
