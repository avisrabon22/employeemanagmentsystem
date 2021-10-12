package com.employeemanagementsystem.model.Admin;

import java.sql.Time;

public class SignUpModel {
	
	private int ID;
	private String FullName, Username, Password, Gender, Role, ContactNumber;
//SignUp class object**************************************************************************************************
	public SignUpModel(int iD, String fullName) {
		super();
		ID = iD;
		FullName = fullName;

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public SignUpModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUpModel(int iD, String fullName, String username, String password, String gender, String role,
			String contactNumber) {
		super();
		ID = iD;
		FullName = fullName;
		Username = username;
		Password = password;
		Gender = gender;
		Role = role;
		ContactNumber = contactNumber;
	}

	public SignUpModel(String fullName, String username, String password, String gender, String role,
			String contactNumber) {
		super();
		FullName = fullName;
		Username = username;
		Password = password;
		Gender = gender;
		Role = role;
		ContactNumber = contactNumber;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

//	attendance class object******************************************************************************************
AttandanceModel attendanceModel = new AttandanceModel();
	
	private int AttendanceID=attendanceModel.getID();
	private Time InTime=attendanceModel.getInTime();
	private Time OutTime=attendanceModel.getOutTime();
	private String Status=attendanceModel.getStatus();
//**************************************************************************	
	public SignUpModel(Time inTime, Time outTime, String status) {
		super();
		InTime = inTime;
		OutTime = outTime;
		Status = status;
	}
		
	public int getAttendanceID() {
		return AttendanceID;
	}

	public void setAttendanceID(int attendanceID) {
		AttendanceID = attendanceID;
	}

	public Time getInTime() {
		return InTime;
	}

	public void setInTime(Time inTime) {
		InTime = inTime;
	}

	public Time getOutTime() {
		return OutTime;
	}

	public void setOutTime(Time outTime) {
		OutTime = outTime;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	
	
	
	
	
	
	
	
	
	
	
//End main Class***************************************************************************************************************	
}

