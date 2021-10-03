package com.employeemanagementsystem.DAO.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.Admin.SignUpModel;

public class UploadAttandanceDao {
	private Connection connect=Dbconnection.getconnect();
	String ListUserForAttandance="select ID,FullName from users";
	String uploadAttandance="";

SignUpModel users=new SignUpModel();	
	
public List<SignUpModel> userListForAttandance() throws SQLException{
	SignUpModel attandance=new SignUpModel();
	List<SignUpModel> listofUsers=new ArrayList<SignUpModel>();
	PreparedStatement ps=connect.prepareStatement(ListUserForAttandance);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
	attandance.setID(rs.getInt("ID"));
	attandance.setFullName(rs.getString("FullName"));
	listofUsers.add(attandance);
	}
	ps.close();
	rs.close();
	return listofUsers;}


	public void insertAttandance() {
		
		
	}
	
}
