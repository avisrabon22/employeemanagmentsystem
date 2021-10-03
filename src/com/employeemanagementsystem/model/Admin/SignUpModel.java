package com.employeemanagementsystem.model.Admin;

public class SignUpModel {
	 private int ID;
	private String FullName, Username, Password, Gender, Role, ContactNumber;
   
	
	
	public SignUpModel( int iD,String fullName) {
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


	public SignUpModel(int iD,String fullName, String username, String password, String gender, String role,
			String contactNumber) {
		super();
		ID=iD;
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

}
