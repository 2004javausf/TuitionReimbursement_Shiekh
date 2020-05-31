package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.AcceptForm;
import com.dao.VGDAOImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class GradingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet od GradeServlet");
		ObjectMapper mapper = new ObjectMapper();
		VGDAOImpl vgdi = new VGDAOImpl();
		PrintWriter pw = response.getWriter();
		String gfJSON;
		try {
			gfJSON=mapper.writeValueAsString(vgdi.getGF());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(gfJSON);
			
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
		AcceptForm vg=null;
		ObjectMapper mapper=new ObjectMapper();
		vg=mapper.readValue(request.getInputStream(),AcceptForm.class);
		System.out.println(vg);
		VGDAOImpl vgdi=new VGDAOImpl();
		try {
			vgdi.insertFormAcceptBenco(vg);
			PrintWriter pw=response.getWriter();
			pw.write("<h3>Added A Request</h3>");
			pw.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
