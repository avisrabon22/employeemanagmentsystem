package com.employeemanagementsystem.DAO.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.Admin.ShowReportModel;

public class ShowReportDao {

	private Connection con = Dbconnection.getconnect();

	@SuppressWarnings({})
	public List<ShowReportModel> getReport() throws SQLException {
		String sql = "select * from employeereport";
		List<ShowReportModel> reportStorage = new ArrayList<ShowReportModel>();
//		*************************************************************************
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
//*******************************************************************
		while (rs.next()) {
			ShowReportModel showReport = new ShowReportModel();
			showReport.setID(rs.getInt("ID"));
			showReport.setName(rs.getString("Name"));
			showReport.setDesignation(rs.getString("Designation"));
			showReport.setSalary(rs.getInt("salary"));
			reportStorage.add(showReport);
		}
		return reportStorage;
	}

	public void removeReport() throws SQLException {
		String sql="delete from employeereport";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.executeUpdate();
			
	}
	
	
	
	
	
	
//End The class
}
