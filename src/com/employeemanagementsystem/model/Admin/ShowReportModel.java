package com.employeemanagementsystem.model.Admin;

public class ShowReportModel {
	private int ID, salary,perfomence_index;
	private String Name, Designation;
public ShowReportModel(int iD, int salary, int perfomence_index, String name, String designation) {
		super();
		ID = iD;
		this.salary = salary;
		this.perfomence_index = perfomence_index;
		Name = name;
		Designation = designation;
	}
public int getPerfomence_index() {
		return perfomence_index;
	}
	public void setPerfomence_index(int perfomence_index) {
		this.perfomence_index = perfomence_index;
	}
	//*************************************************************************************
	public ShowReportModel(int iD, int salary, String name, String designation) {
		super();
		ID = iD;
		this.salary = salary;
		Name = name;
		Designation = designation;
	}
	public ShowReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}
}
