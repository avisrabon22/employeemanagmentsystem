package com.employeemanagementsystem.model;

public class ProfileModel {

	int ID;
	String Fname,username,password,gender,contactnumber;
	public ProfileModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProfileModel(int iD, String fname, String username, String password, String gender, String contactnumber) {
		super();
		ID = iD;
		Fname = fname;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.contactnumber = contactnumber;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	
	
	
}
