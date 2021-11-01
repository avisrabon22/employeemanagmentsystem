package com.employeemanagementsystem.model.Admin;

//import java.sql.Time;

public class AttandanceAdminModel {
	private int ID;
	private String name;
	private String username;
	private String Date;
	private String InTime;
	private String OutTime;
	private String Status;
	
//#####################################################################################################
	
	public AttandanceAdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}

//***************************************************************************************************
	public AttandanceAdminModel(int iD, String name, String username, String date, String inTime, String outTime,
			String status) {
		super();
		ID = iD;
		this.name = name;
		this.username = username;
		Date = date;
		InTime = inTime;
		OutTime = outTime;
		Status = status;
	}
//	***************************************************************************************************
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}
	
	

	public String getInTime() {
		return InTime;
	}

	public void setInTime(String inTime) {
		InTime = inTime;
	}

	public String getOutTime() {
		return OutTime;
	}

	public void setOutTime(String outTime) {
		OutTime = outTime;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String c) {
		Status = c;
	}

	

}
