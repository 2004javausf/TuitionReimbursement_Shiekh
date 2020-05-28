package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Login;
import com.dao.VGDAOImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet of LoginServlet");
		ObjectMapper mapper = new ObjectMapper();
	// VGDAOImpl vgdi = new VGDAOImpl();
	
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();

		Login login = new Login();
		String etJSON;
		try {
			
			login = (Login) session.getAttribute("login");
			
			etJSON=mapper.writeValueAsString(login);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(etJSON);
			
		} catch (JsonProcessingException e) {
	
			e.printStackTrace();
		} 
		pw.flush();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		String uName=request.getParameter("uName");
		String password=request.getParameter("uPassword");
		System.out.println("Roll Tide in doPost Login");
		System.out.println(uName + " " + password);
		
		VGDAOImpl vgdi = new VGDAOImpl();
		List<Login> loginList=new ArrayList<Login>();
		Login login = new Login();
		
		int l=0;
		try {
			loginList = vgdi.getLogInUser();
			for(int i=0; i<loginList.size();i++) {
			
				if((loginList.get(i).getEmployeeName().equalsIgnoreCase(uName)) && (loginList.get(i).getEmployeePassword().equals(password))) {
					if(loginList.get(i).getEmployeeID()<10) {
						login=loginList.get(i);
						l=1;
						}
					else if(loginList.get(i).getEmployeeID()>9 && loginList.get(i).getEmployeeID()<12) {
						login=loginList.get(i);
						l=2;
						}
					else if(loginList.get(i).getEmployeeID()==12) {
						login=loginList.get(i);
						l=3;
						}
					else if(loginList.get(i).getEmployeeID()==13) {
						login=loginList.get(i);
						l=4;
						}
				}
				
			}
			System.out.println(login);
			String name = login.getEmployeeName();
			if(l==1) {
				HttpSession session=request.getSession();
				session.setAttribute("login",login);
				request.getRequestDispatcher("vg.html").include(request, response);
			}
			else if(l==2) {
				HttpSession session=request.getSession();
				session.setAttribute("login",login);
				request.getRequestDispatcher("supervisor.html").include(request, response);
			}
			else if(l==3) {
				HttpSession session=request.getSession();
				session.setAttribute("login",login);
				request.getRequestDispatcher("hod.html").include(request, response);
			}
			else if(l==4) {
				HttpSession session=request.getSession();
				session.setAttribute("login",login);
				request.getRequestDispatcher("vg.html").include(request, response);
			}
			else {
				pw.print("Sorry, username or password invalid!!!");
				request.getRequestDispatcher("index.html").include(request, response);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.close();
	}

}
