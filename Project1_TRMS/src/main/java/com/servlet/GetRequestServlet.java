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

public class GetRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet REQUESTS");
		ObjectMapper mapper= new ObjectMapper();
		VGDAOImpl vgdi= new VGDAOImpl();
		int id= mapper.readValue(request.getParameter("formID"),Integer.class);
		PrintWriter pw =response.getWriter();
		String vgJSON;
		try {
			vgJSON=mapper.writeValueAsString(vgdi.getRequestsList(id));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(vgJSON);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost reject");
		AcceptForm vg=null;
		ObjectMapper mapper=new ObjectMapper();
		vg=mapper.readValue(request.getInputStream(),AcceptForm.class);
		System.out.println(vg);
		VGDAOImpl vgdi=new VGDAOImpl();
		try {
			vgdi.insertFormRejectHOD(vg);
			PrintWriter pw=response.getWriter();
			pw.write("<h3>Added A Request</h3>");
			pw.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
