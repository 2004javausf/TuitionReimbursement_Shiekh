package com.beans;

public class AcceptForm {
	private int empID;
	private String message;

	public AcceptForm() {
		super();
	}

	public AcceptForm(int empID) {
		super();
		this.empID = empID;
	}
	

	public AcceptForm(int empID, String message) {
		super();
		this.empID = empID;
		this.message = message;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AcceptForm [empID=" + empID + "]";
	}
	
}
