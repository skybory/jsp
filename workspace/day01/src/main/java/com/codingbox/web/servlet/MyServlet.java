package com.codingbox.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/hello")
public class MyServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//	super.service(arg0, arg1);
	
	arg1.setCharacterEncoding("UTF-8");
	arg1.setContentType("text/html; charset=UTF-8");
	
	PrintWriter out = arg1.getWriter();
	
	for(int i = 0; i<100; i++) {
		out.println((i+1) + " : 안녕 servlet<br/>");
	}
	
	}
}
