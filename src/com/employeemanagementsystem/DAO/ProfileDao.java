package com.employeemanagementsystem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.ProfileModel;


public class ProfileDao {

	public List<ProfileModel> getProfile(String username) throws SQLException {
		Connection con = Dbconnection.getconnect();
		String getProfile = "select id,username,fullname,pass,gender,contactnumber from users where username=?";
        List<ProfileModel> promodel=new ArrayList<ProfileModel>();
		PreparedStatement ps = con.prepareStatement(getProfile);
		
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
       ProfileModel model=new ProfileModel();
       model.setID(rs.getInt("id"));
       model.setUsername(rs.getString("username"));
       model.setFname(rs.getString("Fullname"));
       model.setPassword(rs.getString("pass"));
       model.setGender(rs.getString("gender"));
       model.setContactnumber(rs.getString("contactnumber"));
       promodel.add(model);
		}
		return promodel;
	}

}
