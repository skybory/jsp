package com.codingbox.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/cnt")
public class MyServlet2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		super.service(arg0, arg1);
		arg1.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html; charset=UTF-8");
		
//		localhost:8081/cnt?cnt=5
//				cnt key값 parsing?
//						url 요청, 파라미터 값으로 cnt=5
//						사용자의 요청(request)
//		arg0이 사용자의 요청에 대한 모든 정보를 가지고 있음.
		
		//cnt 라는 키값으로 만들어진 파라미터의 value 값을 획득
	//arg0.getParameter("cnt")
		// 방금 언급한 값을 wrapper 클래스를 통해 정수화시키고, 그 값을 변수cnt에 넣음.
		
		//cnt? 에서 ? 가 의미하는 바는
		// 앞의 식은 끝났다. 이제부터 파라미터 시작~ 이라는 뜻
		// 400번대 에러 : 사용자의 요청이 잘못된 에러
		// 500번대 에러 : 개발자의 개발이 잘못된 에러
//		int cnt =Integer.parseInt(arg0.getParameter("cnt"));
		int cnt = 100;
		String paramCnt = arg0.getParameter("cnt");
	
		if (paramCnt != null && !paramCnt.equals("")){
			cnt = Integer.parseInt(paramCnt);
			}
		

		PrintWriter out = arg1.getWriter();
		for (int i=0; i<cnt; i++) {
			out.println(i+1 + " : 안녕 servlet<br>");
		}
	}
}
