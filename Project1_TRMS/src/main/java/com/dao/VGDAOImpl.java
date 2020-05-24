package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beans.Form;
import com.beans.VideoGame;
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
	
	public void insertForm(Form f) throws SQLException{
		Connection conn= banana.getConnection();
		String sql="INSERT INTO REIMBURSE VALUES(?,?,?,?,?,?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, f.getFormID());
		ps.setString(2, f.getEmpName());
		ps.setDate(3, f.getDate());
		ps.setInt(4, f.getCost());
		ps.setString(5, f.getGradingFormat());
		ps.setString(6, f.getEvent());
		ps.executeUpdate();
	}
}
