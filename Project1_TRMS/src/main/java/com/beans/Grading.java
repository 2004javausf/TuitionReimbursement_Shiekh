package com.beans;

public class Grading {
	private int gradingID;
	private String gradingName;
	private String gradingPass;
	
	
	public Grading() {
		super();
	}


	public Grading(int gradingID, String gradingFormat, String gradingPass) {
		super();
		this.gradingID = gradingID;
		this.gradingName = gradingFormat;
		this.gradingPass = gradingPass;
	}


	public int getGradingID() {
		return gradingID;
	}


	public void setGradingID(int gradingID) {
		this.gradingID = gradingID;
	}


	public String getGradingFormat() {
		return gradingName;
	}


	public void setGradingFormat(String gradingFormat) {
		this.gradingName = gradingFormat;
	}


	public String getGradingPass() {
		return gradingPass;
	}


	public void setGradingPass(String gradingPass) {
		this.gradingPass = gradingPass;
	}


	@Override
	public String toString() {
		return "Grading [gradingID=" + gradingID + ", gradingFormat=" + gradingName + ", gradingPass=" + gradingPass
				+ "]";
	}
	
	
}
