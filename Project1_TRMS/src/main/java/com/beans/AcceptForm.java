package com.beans;

public class AcceptForm {
	private int empID;

	public AcceptForm() {
		super();
	}

	public AcceptForm(int empID) {
		super();
		this.empID = empID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	@Override
	public String toString() {
		return "AcceptForm [empID=" + empID + "]";
	}
	
}
