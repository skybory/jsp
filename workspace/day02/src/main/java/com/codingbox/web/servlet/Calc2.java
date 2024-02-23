package com.codingbox.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, 
			HttpServletResponse arg1) throws ServletException, IOException {

		PrintWriter out = arg1.getWriter();
		int result =0;

		String numStr[] = arg0.getParameterValues("num");
		//key : num 을 사용해서  value값을 배열로 가져옴
		
		for(int i=0; i<numStr.length; i++) {
		//validation 처리 반복문속에서 해야함, 귀찮으니 패스
			
			int num = Integer.parseInt(numStr[i]);
			result += num;
			
		}
		out.printf("result is %d\n" , result);
	}
}
	
