package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VGDAOImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class GetMyForm
 */
public class GetMyForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet REQUESTS");
		ObjectMapper mapper= new ObjectMapper();
		VGDAOImpl vgdi= new VGDAOImpl();
		int id= mapper.readValue(request.getParameter("formID"),Integer.class);
		PrintWriter pw =response.getWriter();
		String vgJSON;
		try {
			vgJSON=mapper.writeValueAsString(vgdi.getMyFormList(id));
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
		
	}

}
