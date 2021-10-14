package com.employeemanagementsystem.model.Admin;

public class ShowReportModel {
	String logintime;
	private String logouttime,workingtime;

	public ShowReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowReportModel(String logintime, String logouttime, String workingtime) {
		super();
		this.logintime = logintime;
		this.logouttime = logouttime;
		this.workingtime = workingtime;
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
