package com.codingbox.web.servlet;

import java.io.IOException;

import com.codingbox.web.action.ActionForward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.us")
public class UserFrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		ActionForward forward = null;
		if(requestURI.equals("/user/userJoin.us")) {
			forward = new UserJoinAction().execute(req, resp);
		} else if (requestURI.equals("/user/UserLogin.us")) {
			forward = new ActionForward(false, "/app/user/loginview.jsp");
		} else if (requestURI.equals("/user/UserLoginOK.us")) {
			forward = new UserLoginOKAction().execute(req, resp);
			// 로그인 기능
			// DB select, 셀렉트문을 작성하기 위한 java 파일 UserLoginOKAction.java 만들기
			// 나머진 알아서.. 로그인 성공시 -> mainview.jsp 로 이동
			// 페이지 이동 : redirect
		}
		
		// 페이지 이동에 대한 일괄처리
		if(forward != null) {
			if(forward.isRedirect() ) {	// Redirect 방식
				resp.sendRedirect(forward.getPath());
			} else { 					// forward 방식
				req.getRequestDispatcher(forward.getPath()).forward(req, resp);
			}
			
		}
	}
		// *.us url 매핑
		// HttpServlet 상속
		// do Get
		// do Post
		// do Process()
}
