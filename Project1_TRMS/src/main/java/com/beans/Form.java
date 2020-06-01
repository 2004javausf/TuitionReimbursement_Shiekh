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
	private String description;
	private String justification;
	private String status;
	private String message;
	private double projectedReimbursement;
	private String grades;
	
	public Form() {
		super();
	}
	
	public Form(int formID, String empName, Date date, int cost, String gradingFormat, String event,String status,String description,String justification,String message,double projectedReimbursement ) {
		super();
		this.formID = formID;
		this.empName = empName;
		this.date = date;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.event = event;
		this.status= status;
		this.description = description;
		this.justification = justification;
		this.message = message;
		
	this.projectedReimbursement = projectedReimbursement;
	}
	public Form(int formID, String empName, Date date, int cost, String gradingFormat, String event,String status,String description,String justification,String message ) {
		super();
		this.formID = formID;
		this.empName = empName;
		this.date = date;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.event = event;
		this.status= status;
		this.description = description;
		this.justification = justification;
		this.message = message;
		
//		this.projectedReimbursement = projectedReimbursement;
	}
public Form(int formID, String empName, Date date, int cost, String gradingFormat, String event,String status,String description,String justification ) {
	super();
	this.formID = formID;
	this.empName = empName;
	this.date = date;
	this.cost = cost;
	this.gradingFormat = gradingFormat;
	this.event = event;
	this.status= status;
	this.description = description;
	this.justification = justification;
	
//	this.projectedReimbursement = projectedReimbursement;
}
public Form(int formID, String empName, Date date, int cost, String gradingFormat, String event,String description,String justification,double projectedReimbursement) {
	super();
	this.formID = formID;
	this.empName = empName;
	this.date = date;
	this.cost = cost;
	this.gradingFormat = gradingFormat;
	this.event = event;
	this.description = description;
	this.justification = justification;
	this.projectedReimbursement = projectedReimbursement;
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
	


	public Form(String status) {
		super();
		this.status = status;
	}
	



	public Form(int formID, String grades) {
		super();
		this.formID = formID;
		this.grades = grades;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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
	
	
	
	public int getCost() {
		return cost;
	}
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getJustification() {
		return justification;
	}


	public void setJustification(String justification) {
		this.justification = justification;
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

	public double getProjectedReimbursement() {
		return projectedReimbursement;
	}


	public void setProjectedReimbursement(double projectedReimbursement) {
		this.projectedReimbursement = projectedReimbursement;
	}
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	
	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "Form [formID=" + formID + ", empName=" + empName + ", date=" + date + ", cost=" + cost
				+ ", gradingFormat=" + gradingFormat + ", event=" + event + ", description=" + description
				+ ", justification=" + justification + ", status=" + status + ", message=" + message
				+ ", projectedReimbursement=" + projectedReimbursement + "]";
	}


	



	
}
