package com.employeemanagementsystem.model;

public class AttendanceModel {
int id;
String date,intime,outtime,status,name,username;




public AttendanceModel() {
	super();
	// TODO Auto-generated constructor stub
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

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getIntime() {
	return intime;
}
public void setIntime(String intime) {
	this.intime = intime;
}
public String getOuttime() {
	return outtime;
}
public void setOuttime(String outtime) {
	this.outtime = outtime;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}







}
