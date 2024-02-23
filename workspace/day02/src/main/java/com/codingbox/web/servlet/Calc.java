package com.codingbox.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Calc extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

		PrintWriter out = arg1.getWriter();
		String stringX = arg0.getParameter("x");
		String stringY = arg0.getParameter("y");
		String op = arg0.getParameter("operator");
		int x=0;
		int y=0;
		int result =0;
		
		if (!stringX.equals("")) {
			x = Integer.parseInt(stringX);
		}
		if (!stringY.equals("")) {
			y = Integer.parseInt(stringY);
		}
		
		
		if (op.equals("덧셈")) {
			result = x + y;
		}
		else if (op.equals("뺄셈")) {
			result = x - y;
		}
	
		out.printf("result is %d\n" , result);
//System.out.println(arg0.getParameter("operator").equals("덧셈"));
//out.println(arg0.getParameter("operator"));		
//out.println("test");
		
//		out.println("result is " + result);
		
	}
}
