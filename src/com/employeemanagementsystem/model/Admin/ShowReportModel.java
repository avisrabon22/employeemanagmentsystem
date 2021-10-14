package com.employeemanagementsystem.model.Admin;

import com.mongodb.internal.connection.Time;

public class ShowReportModel {
	private Time logintime,logouttime,workingtime;

	public ShowReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowReportModel(Time logintime, Time logouttime, Time workingtime) {
		super();
		this.logintime = logintime;
		this.logouttime = logouttime;
		this.workingtime = workingtime;
	}

	public Time getLogintime() {
		return logintime;
	}

	public void setLogintime(Time logintime) {
		this.logintime = logintime;
	}

	public Time getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(Time logouttime) {
		this.logouttime = logouttime;
	}

	public Time getWorkingtime() {
		return workingtime;
	}

	public void setWorkingtime(Time workingtime) {
		this.workingtime = workingtime;
	}
	

}
