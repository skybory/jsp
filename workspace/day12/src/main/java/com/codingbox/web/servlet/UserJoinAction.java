package com.codingbox.web.servlet;

import org.apache.ibatis.session.SqlSession;

import com.codingbox.web.action.Action;
import com.codingbox.web.action.ActionForward;
import com.codingbox.web.dao.UserDAO;
import com.codingbox.web.dto.UserDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserJoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		UserDAO udao = new UserDAO();
		UserDTO udto = new UserDTO();
		ActionForward forward = new ActionForward();
		
		udto.setUserid(request.getParameter("userid"));
		udto.setUserpw(request.getParameter("userpw"));
		udto.setUsername(request.getParameter("username"));
		udto.setUseraddr(request.getParameter("useraddr"));
		udto.setUserphone(request.getParameter("userphone"));
		
		if(udao.join(udto)) {	// 회원가입
			forward.setPath("/app/user/loginview.jsp");
			forward.setRedirect(true);
		}
		
		return forward; 
	}


	
}
