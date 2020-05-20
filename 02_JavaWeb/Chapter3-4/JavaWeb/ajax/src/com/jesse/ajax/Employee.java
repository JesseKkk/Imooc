package com.jesse.ajax;

public class Employee {
	private String[] ename;
	private String[] ejob;
	private String[] edepartment;
	
	public Employee() {
		
	}
	
	public Employee(String[] ename, String[] ejob, String[] edepartment) {
		super();
		this.ename = ename;
		this.ejob = ejob;
		this.edepartment = edepartment;
	}
	public String[] getEname() {
		return ename;
	}
	public void setEname(String[] ename) {
		this.ename = ename;
	}
	public String[] getEjob() {
		return ejob;
	}
	public void setEjob(String[] ejob) {
		this.ejob = ejob;
	}
	public String[] getEdepartment() {
		return edepartment;
	}
	public void setEdepartment(String[] edepartment) {
		this.edepartment = edepartment;
	}
	
}
