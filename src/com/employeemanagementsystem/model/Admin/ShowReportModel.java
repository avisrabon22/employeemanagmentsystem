package com.employeemanagementsystem.model.Admin;

public class ShowReportModel {
	int id;
	private String name,date, logintime,logouttime,workingtime;

	public ShowReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowReportModel(int id,String name, String date, String logintime, String logouttime, String workingtime) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.logintime = logintime;
		this.logouttime = logouttime;
		this.workingtime = workingtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(String logouttime) {
		this.logouttime = logouttime;
	}

	public String getWorkingtime() {
		return workingtime;
	}
	
	public void setWorkingtime(String workingtime) {
		this.workingtime = workingtime;
	}


	

}
