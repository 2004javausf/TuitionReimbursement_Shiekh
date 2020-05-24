package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.beans.Form;
import com.beans.VideoGame;
import com.dao.VGDAOImpl;


public class VGServlet extends HttpServlet {
	
       

	private static final long serialVersionUID = -7875816714167542708L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		Form vg=null;
		ObjectMapper mapper=new ObjectMapper();
		//convert JSON to Java Object
		//YOU NEED A DEFAULT CONSTRUCTOR IN YOUR JAVA OBJECT CLASS IN ORDER TO USE THIS!!!
		vg=mapper.readValue(request.getInputStream(),Form.class);
		System.out.println(vg);
		VGDAOImpl vgdi=new VGDAOImpl();
		try {
			vgdi.insertForm(vg);
			PrintWriter pw=response.getWriter();
			pw.write("<h3>Added A Request</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
