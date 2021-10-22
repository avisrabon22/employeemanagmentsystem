package com.employeemanagementsystem.model;

public class ReportModel {

	String date,InTime,OutTime,Status;
	
	

	public ReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportModel(String date, String inTime, String outTime, String status) {
		super();
		this.date = date;
		InTime = inTime;
		OutTime = outTime;
		Status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	
}
