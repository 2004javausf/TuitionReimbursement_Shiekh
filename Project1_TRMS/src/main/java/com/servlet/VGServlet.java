package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Form;
import com.dao.VGDAOImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class VGServlet extends HttpServlet {
	
       

	private static final long serialVersionUID = -7875816714167542708L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet of EventServlet");
		ObjectMapper mapper = new ObjectMapper();
		VGDAOImpl vgdi = new VGDAOImpl();
		int id= mapper.readValue(request.getParameter("formID"),Integer.class);
		PrintWriter pw = response.getWriter();
		String etJSON;
		try {
			etJSON=mapper.writeValueAsString(vgdi.getMySupervisor(id));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(etJSON);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.flush();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		Form vg=null;
		ObjectMapper mapper=new ObjectMapper();
		vg=mapper.readValue(request.getInputStream(),Form.class);
		System.out.println(vg);
		VGDAOImpl vgdi=new VGDAOImpl();
		try {
			
			vgdi.insertForm(vg);
			PrintWriter pw=response.getWriter();
			pw.write("<h3>Added A Request</h3>");
			pw.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
