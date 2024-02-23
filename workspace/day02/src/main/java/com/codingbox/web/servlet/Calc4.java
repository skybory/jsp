package com.codingbox.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/calc4")
public class Calc4 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, 
			HttpServletResponse arg1) 
			throws ServletException, IOException {

		// session 객체
		HttpSession session = arg0.getSession();
		
		
		PrintWriter out = arg1.getWriter();
		String value_ = arg0.getParameter("value");
		String op = arg0.getParameter("operator");
		int value = 0;
		
		if (!value_.equals("")) {
			value = Integer.parseInt(value_);
		}
		
		if (op.equals("=")) {
			// session 영역에 저장된 값 꺼내오기			5+
			
			// 값 연산
			// 5 꺼내오기
			int x = (int) session.getAttribute("value");
			
			// + 꺼내오기
			String operator = (String) session.getAttribute("op");
			
		
			// 이번 요청(request)에서 받아온 값 가져오기 	10=
			int y = value;
			int result = 0;
			
			if (operator.equals("+")) {
				result = x+y;
			}
			else if (operator.equals("-")) {
				result = x-y;
			}
			out.printf("결과 값 : %d\n", result);
		} else {
			// session에 값 저장
			session.setAttribute("value", value);
			session.setAttribute("op", op);
			// 값을 저장하는 내장메서드. key값과 value값을 순서로 파라미터로 가진다.
		}
		
		
		
	}
}
	