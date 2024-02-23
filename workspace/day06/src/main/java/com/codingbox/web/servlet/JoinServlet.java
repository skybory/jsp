package com.codingbox.web.servlet;

import java.io.IOException;

import com.codingbox.web.dao.UserDAO;
import com.codingbox.web.dto.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinServlet extends HttpServlet{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String userid = req.getParameter("userid");
	String userpw = req.getParameter("userpw");
	String username = req.getParameter("username");
	String userphone = req.getParameter("userphone");

	UserDTO udto = new UserDTO();
	udto.setUserid(userid);
	udto.setUserpw(userpw);
	udto.setUsername(username);
	udto.setUserphone(userphone);
	
	UserDAO udao = new UserDAO();
	boolean check = udao.join(udto);
	if(check) {
		// 회원가입
//  		<h1>회원가입 성공</h1>
		
	} else { 
		// 가입실패
	}
	

	}
}
