<%@page import="com.codingbox.web.dao.UserDAO"%>
<%@page import="com.codingbox.web.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	String username = request.getParameter("username");
	String userphone = request.getParameter("userphone");

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
	
%>

</body>
</html>