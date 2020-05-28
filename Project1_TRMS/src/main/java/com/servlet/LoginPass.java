package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VGDAOImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginPass extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in login doGet");
		ObjectMapper mapper= new ObjectMapper();
		VGDAOImpl vgdi= new VGDAOImpl();
		String name= mapper.readValue(request.getParameter("name"),String.class);
		PrintWriter pw =response.getWriter();
		System.out.println(" in doGET Login");
		System.out.println(name);
		String vgJSON;
		try {
			vgJSON=mapper.writeValueAsString(vgdi.getLoginByName(name));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(vgJSON);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.flush();
	}


}
