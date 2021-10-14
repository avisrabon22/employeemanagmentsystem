package com.employeemanagementsystem.model.Admin;

import java.sql.Time;

public class AttandanceModel {
	private int TimeId;
	private String InTime;
	private String OutTime;
	private String Status;
	private int ID;

	public AttandanceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttandanceModel(String inTime, String outTime, String status, int ID) {
		super();
		InTime = inTime;
		OutTime = outTime;
		Status = status;

	}

	public AttandanceModel(int timeId) {
		super();
		TimeId = timeId;
	}

	public int getTimeId() {
		return TimeId;
	}

	public void setTimeId(int timeId) {
		TimeId = timeId;
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

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
