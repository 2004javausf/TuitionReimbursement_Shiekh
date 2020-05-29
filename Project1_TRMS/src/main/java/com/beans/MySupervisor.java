package com.beans;

public class MySupervisor {
	private int employeeID;
	private int supervisorID;
	private String employeeName;
	private String SupervisorName;
	public MySupervisor() {
		super();
	}
	public MySupervisor(int employeeID, int supervisorID, String employeeName, String supervisorName) {
		super();
		this.employeeID = employeeID;
		this.supervisorID = supervisorID;
		this.employeeName = employeeName;
		SupervisorName = supervisorName;
	}
	
	public MySupervisor(int supervisorID) {
		super();
		this.supervisorID = supervisorID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getSupervisorID() {
		return supervisorID;
	}
	public void setSupervisorID(int supervisorID) {
		this.supervisorID = supervisorID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getSupervisorName() {
		return SupervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		SupervisorName = supervisorName;
	}
	@Override
	public String toString() {
		return "MySupervisor [employeeID=" + employeeID + ", supervisorID=" + supervisorID + ", employeeName="
				+ employeeName + ", SupervisorName=" + SupervisorName + "]";
	}
	
}
