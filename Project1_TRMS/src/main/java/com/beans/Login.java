package com.beans;

public class Login {
	private int employeeID;
	private String employeeName;
	private String employeeDesignation;
	private String employeeHodStatus;
	private String employeeBenco;
	private String employeePassword;
	public Login() {
		super();
	}
	public Login(int employeeID, String employeeName, String employeeDesignation, String employeeHodStatus,
			String employeeBenco,String employeePassword) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeeHodStatus = employeeHodStatus;
		this.employeeBenco = employeeBenco;
		this.employeePassword = employeePassword;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public String getEmployeeHodStatus() {
		return employeeHodStatus;
	}
	public void setEmployeeHodStatus(String employeeHodStatus) {
		this.employeeHodStatus = employeeHodStatus;
	}
	public String getEmployeeBenco() {
		return employeeBenco;
	}
	public void setEmployeeBenco(String employeeBenco) {
		this.employeeBenco = employeeBenco;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	@Override
	public String toString() {
		return "Login [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeeDesignation="
				+ employeeDesignation + ", employeeHodStatus=" + employeeHodStatus + ", employeeBenco=" + employeeBenco
				+ "]";
	}
	
}
