package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.beans.AcceptForm;
import com.beans.Event;
import com.beans.Form;
import com.beans.Grading;
import com.beans.Login;
import com.beans.MySupervisor;
import com.util.ConnFactory;

public class VGDAOImpl {
	public static ConnFactory banana= ConnFactory.getInstance();
	
//	//get specific
	
	public Login getLoginByName(String name) throws SQLException{
		Login ln=null;
		Connection conn= banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE EMPLOYEE_NAME= '"+name+"'");
		while(rs.next()) {
			ln=new Login(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
		}
		
		return ln;
	}
	
//	public Form getRequestByID(int id) throws SQLException{
//		Form fm=null;
//		Connection conn= banana.getConnection();
//		Statement stmt=conn.createStatement();
//		ResultSet rs=stmt.executeQuery("SELECT * FROM REIMBURSE WHERE REIMBURSE_EMPLOYEE_ID= "+id);
//		while(rs.next()) {
//			fm=new Form(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
//		}
//		conn.close();
//		return fm;
//	}
	
	public List<Form> getRequestsList(int id) throws Exception {
		 List<Form> requestList= new ArrayList<Form>();
		 Connection conn=banana.getConnection();
			Statement stmt=conn.createStatement();
			System.out.println(id);
			ResultSet rs=stmt.executeQuery("SELECT * FROM REIMBURSE WHERE STATUS='Pending' AND SUPERVISOR_ID="+id);
			Form s=null;
			while(rs.next()) { 
			s= new Form(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));  
			requestList.add(s);
	}
			System.out.println(requestList);
			conn.close();
		return requestList;
	}
	
	public List<Form> getHODReimbursementList(int id) throws Exception {
		 List<Form> requestList= new ArrayList<Form>();
		 Connection conn=banana.getConnection();
			Statement stmt=conn.createStatement();
			System.out.println(id);
			ResultSet rs=stmt.executeQuery("SELECT * FROM REIMBURSE WHERE STATUS='Approved by Supervisor' OR SUPERVISOR_ID="+id+"AND NOT STATUS ='Approved by Head Of Department' AND NOT STATUS='Approved by Benco' AND NOT STATUS='Rejected by Head Of Department' AND NOT STATUS='Rejected by Benco'");
			Form s=null;
			while(rs.next()) { 
			s= new Form(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));  
			requestList.add(s);
	}
			System.out.println(requestList);
			conn.close();
		return requestList;
	}

	public List<Form> getBencoReimbursementList(int id) throws Exception {
		 List<Form> requestList= new ArrayList<Form>();
		 Connection conn=banana.getConnection();
			Statement stmt=conn.createStatement();
			System.out.println(id);
			ResultSet rs=stmt.executeQuery("SELECT * FROM REIMBURSE WHERE STATUS='Approved by Head Of Department' OR SUPERVISOR_ID="+id+"AND NOT STATUS ='Approved by Supervisor' AND NOT STATUS='Approved by Benco' AND NOT STATUS='Rejected by Benco'");
			Form s=null;
			while(rs.next()) { 
			s= new Form(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));  
			requestList.add(s);
	}
			System.out.println(requestList);
			conn.close();
		return requestList;
	}
	public List<Form> getMyFormList(int id) throws Exception {
		 List<Form> requestList= new ArrayList<Form>();
		 Connection conn=banana.getConnection();
			Statement stmt=conn.createStatement();
			System.out.println(id);
			ResultSet rs=stmt.executeQuery("SELECT * FROM REIMBURSE WHERE REIMBURSE_EMPLOYEE_ID="+id);
			Form s=null;
			while(rs.next()) { 
			s= new Form(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(11),rs.getDouble(12));  
			requestList.add(s);
	}
			System.out.println(requestList);
			conn.close();
		return requestList;
	}
	public List<Form> getStatus(int id) throws Exception {
		 List<Form> requestList= new ArrayList<Form>();
		 Connection conn=banana.getConnection();
			Statement stmt=conn.createStatement();
			System.out.println(id);
			ResultSet rs=stmt.executeQuery("SELECT * FROM REIMBURSE WHERE REIMBURSE_EMPLOYEE_ID="+id);
			Form s=null;
			while(rs.next()) { 
			s= new Form(rs.getString(7));  
			requestList.add(s);
	}
			System.out.println(requestList);
			conn.close();
		return requestList;
	}
	public void insertForm(Form f) throws SQLException{
		int mySupervisor= getSupervisorID(f.getFormID());
		System.out.println(f.getDate());
		System.out.println(System.currentTimeMillis());
		long difference=(f.getDate().getTime()-System.currentTimeMillis())/86400000;
		int days = (int) Math.abs(difference);
		System.out.println(difference);
		System.out.println(days);
		if(difference>7) {
			Connection conn= banana.getConnection();
			String sql="INSERT INTO REIMBURSE (REIMBURSE_EMPLOYEE_ID,REIMBURSE_EMPLOYEE_NAME,REIMBURSE_COURSE_DATE,REIMBURSE_COST,REIMBURSE_GRADING_FORMAT,REIMBURSE_EVENT_TYPE,DESCRIPTION,JUSTIFICATION,SUPERVISOR_ID,PROJECTED_REIMBURSEMENT) VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, f.getFormID());
			ps.setString(2, f.getEmpName());
			ps.setDate(3, f.getDate());
			ps.setInt(4, f.getCost());
			ps.setString(5, f.getGradingFormat());
			ps.setString(6, f.getEvent());
			ps.setString(7, f.getDescription());
			ps.setString(8, f.getJustification());
			ps.setInt(9, mySupervisor );
			ps.setDouble(10, f.getProjectedReimbursement());
			ps.executeUpdate();
			conn.close();
		}
	}
	public void insertGrades(Form f) throws SQLException{
		int employeeID=f.getFormID();
		String grades=f.getGrades();
		Connection conn= banana.getConnection();
		Statement stmt=conn.createStatement();
		int i= Integer.parseInt(grades);
		if(i>79 || grades=="pass" || grades=="B" || grades=="A")
		{
			stmt.executeQuery("UPDATE REIMBURSE SET GRADES='"+grades+"',MESSAGE='Your Grades were Satisfactory, Check your Account Balance'  WHERE REIMBURSE_EMPLOYEE_ID="+employeeID);
		}
		else {
			stmt.executeQuery("UPDATE REIMBURSE SET GRADES='"+grades+"',MESSAGE='Your Grades were not Satisfactory to award Reimbursement'  WHERE REIMBURSE_EMPLOYEE_ID="+employeeID);
		}
		
	conn.close();
		
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
		conn.close();
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
		conn.close();
		return gradingList;
	}
	
	public List<Login> getLogInUser() throws SQLException {
		List<Login> loginList=new ArrayList<Login>();
		Login login=null;
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();

		ResultSet rs=stmt.executeQuery("SELECT * FROM EMPLOYEE");
		while(rs.next()) {
			login=new Login(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
			loginList.add(login);
		}
		conn.close();
		return loginList;
		
	}
	
	public  List<MySupervisor> getMySupervisor(int id) throws SQLException {
		MySupervisor mySupervisor = null;
		List<MySupervisor> mySupervisorList = new ArrayList<MySupervisor>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM MYSUPERVISOR WHERE SUPERVISOR_ID="+id);
		while(rs.next()) {
			mySupervisor=new MySupervisor(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
			mySupervisorList.add(mySupervisor);
		}
		conn.close();
		return mySupervisorList;
	}
	public int getSupervisorID(int id) throws SQLException {
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		int mySupervisor = 0 ;
		ResultSet rs=stmt.executeQuery("SELECT SUPERVISOR_ID FROM MYSUPERVISOR WHERE EMPLOYEE_ID="+id);
		while(rs.next()) {
			mySupervisor= rs.getInt(1);
		}
		return mySupervisor;
	
	}
	public void insertFormAccept(AcceptForm f) throws SQLException{
		int employeeID= f.getEmpID();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("UPDATE REIMBURSE SET STATUS='Approved by Supervisor',MESSAGE='No Additional Document Required as of now.' WHERE REIMBURSE_EMPLOYEE_ID="+employeeID);
		conn.close();
	}
	
	public void insertFormReject(AcceptForm f) throws SQLException{
		int employeeID= f.getEmpID();
		String message=f.getMessage();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("UPDATE REIMBURSE SET STATUS='Rejected by Supervisor',MESSAGE='"+message+"' WHERE REIMBURSE_EMPLOYEE_ID="+employeeID);
		conn.close();
	}
	public void insertFormAcceptHOD(AcceptForm f) throws SQLException{
		int employeeID= f.getEmpID();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("UPDATE REIMBURSE SET STATUS='Approved by Head Of Department',MESSAGE='No Additional Document Required as of now.' WHERE REIMBURSE_EMPLOYEE_ID="+employeeID);
		conn.close();
	}
	public void insertFormRejectHOD(AcceptForm f) throws SQLException{
		int employeeID= f.getEmpID();
		String message=f.getMessage();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("UPDATE REIMBURSE SET STATUS='Rejected by Head Of Department',MESSAGE='"+message+"' WHERE REIMBURSE_EMPLOYEE_ID="+employeeID);
		conn.close();
	}
	public void insertFormAcceptBenco(AcceptForm f) throws SQLException{
		int employeeID= f.getEmpID();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("UPDATE REIMBURSE SET STATUS='Approved by Benco',MESSAGE='You need to upload your Grades to get Reimbursement Amount' WHERE REIMBURSE_EMPLOYEE_ID="+employeeID);
		conn.close();
	}
	public void insertFormRejectBenco(AcceptForm f) throws SQLException{
		int employeeID= f.getEmpID();
		String message=f.getMessage();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("UPDATE REIMBURSE SET STATUS='Rejected by Benco',MESSAGE='"+message+"' WHERE REIMBURSE_EMPLOYEE_ID="+employeeID);
		conn.close();
	}
}
