<%@page import="com.codingbox.web.vo.User"%>
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
	// request 객체에서 users 키로 할당된 value값을 꺼낸 후,
	User[] arrUser = (User[])request.getAttribute("users");
	// for문을 통해 객체 배열 출력
	
	for (int i=0; i<arrUser.length; i++){
		out.println(arrUser[i].userid);
		out.println(arrUser[i].username);
		out.println(arrUser[i].age + "<br/>");
	}
	// admin 김자바 10 <br>
	// hong 홍길동 100 <br> ...
	
%>
</body>
</html>