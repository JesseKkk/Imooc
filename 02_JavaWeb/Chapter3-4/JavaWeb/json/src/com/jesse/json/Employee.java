package com.jesse.json;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Employee {
	private Integer empno;
	private String ename;
	private String job;
	@JSONField(name = "hiredate", format = "yyy-MM-dd")
	private Date hdate;
	private Float salary;
	@JSONField(serialize = false)
	private String dname;
	
	public Employee() {
		super();
	}

	public Employee(Integer empno, String ename, String job, Date hdate, Float salary, String dname) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hdate = hdate;
		this.salary = salary;
		this.dname = dname;
	}
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHdate() {
		return hdate;
	}
	public void setHdate(Date hdate) {
		this.hdate = hdate;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	
}
