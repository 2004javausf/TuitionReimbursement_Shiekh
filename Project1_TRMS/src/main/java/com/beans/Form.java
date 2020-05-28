package com.beans;

import java.sql.Date;
import java.sql.Time;

public class Form {
	private int formID;
	private String empName;
	private Date date;
	private int cost;
	private String gradingFormat;
	private String event;
	
	
	public Form() {
		super();
	}
	
	
public Form(int formID, String empName, Date date, int cost, String gradingFormat, String event) {
		super();
		this.formID = formID;
		this.empName = empName;
		this.date = date;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.event = event;
	}



public Form(String empName, Date date, int cost, String gradingFormat, String event) {
	super();
	this.empName = empName;
	this.date = date;
	this.cost = cost;
	this.gradingFormat = gradingFormat;
	this.event = event;
}


	public Form(int formID, String empName, Date date, Time time, int cost, String gradingFormat, String event) {
		super();
		this.formID = formID;
		this.empName = empName;
		this.date = date;
//		this.time = time;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.event = event;
	}


	public int getFormID() {
		return formID;
	}
	public void setFormID(int formID) {
		this.formID = formID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		
		this.date = date;
	}
//	public Time getTime() {
//		return time;
//	}
//	public void setTime(Time time) {
//		this.time = time;
//	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}


	@Override
	public String toString() {
		return "Form [formID=" + formID + ", empName=" + empName + ", date=" + date + ", cost=" + cost
				+ ", gradingFormat=" + gradingFormat + ", event=" + event + "]";
	}



	
}
