package com.employeemanagementsystem.model.Admin;

import java.sql.Time;

public class AttandanceModel {
	private int TimeId;
	private Time InTime, OutTime;
	private char Status;
	private int ID;

	public AttandanceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttandanceModel(Time inTime, Time outTime, char status, int iD) {
		super();
		InTime = inTime;
		OutTime = outTime;
		Status = status;
		ID = iD;
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

	public char getStatus() {
		return Status;
	}

	public void setStatus(char status) {
		Status = status;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
