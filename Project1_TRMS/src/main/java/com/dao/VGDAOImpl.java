package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.Event;
import com.beans.Form;
import com.beans.Grading;
import com.util.ConnFactory;

public class VGDAOImpl {
	public static ConnFactory banana= ConnFactory.getInstance();
	
//	//get specific
	public Form getRequestByID(int id) throws SQLException{
		Form fm=null;
		Connection conn= banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM REIMBURSE WHERE REIMBURSE_EMPLOYEE_ID= "+id);
		while(rs.next()) {
			fm=new Form(rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getString(6));
		}
		return fm;
	}
	
	public List<Form> getRequestsList() throws Exception {
		 List<Form> requestList= new ArrayList<Form>();
		 Connection conn=banana.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM REIMBURSE");
			Form s=null;
			while(rs.next()) { 
			s= new Form(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getString(6));  
			requestList.add(s);
	}
		return requestList;
	}
	
	public void insertForm(Form f) throws SQLException{
		Connection conn= banana.getConnection();
		String sql="INSERT INTO REIMBURSE (REIMBURSE_EMPLOYEE_ID,REIMBURSE_EMPLOYEE_NAME,REIMBURSE_COURSE_DATE,REIMBURSE_COST,REIMBURSE_GRADING_FORMAT,REIMBURSE_EVENT_TYPE) VALUES(?,?,?,?,?,?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, f.getFormID());
		ps.setString(2, f.getEmpName());
		ps.setDate(3, f.getDate());
		ps.setInt(4, f.getCost());
		ps.setString(5, f.getGradingFormat());
		ps.setString(6, f.getEvent());
		ps.executeUpdate();
	}
	
	public  List<Event> getET() throws SQLException {
		Event event = null;
		List<Event> eventList = new ArrayList<Event>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM EVENT");
		while(rs.next()) {
			event=new Event(rs.getInt(1),rs.getString(2),rs.getInt(3));
			eventList.add(event);
		}
		return eventList;
	}
	
	//get all Event Type
	public  List<Grading> getGF() throws SQLException {
		Grading grading = null;
		List<Grading> gradingList = new ArrayList<Grading>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM GRADING");
		while(rs.next()) {
			grading=new Grading(rs.getInt(1),rs.getString(2),rs.getString(3));
			gradingList.add(grading);
		}
		return gradingList;
	}
}
