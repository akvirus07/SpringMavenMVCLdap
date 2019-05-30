package com.gslab.akshay.pojo;

public class Employee {
	private String fname;
	private String sname;
	private String empNo;
	public Employee() {
	}
	public Employee(String fname, String sname, String empNo) {
		super();
		this.fname = fname;
		this.sname = sname;
		this.empNo = empNo;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	

}
