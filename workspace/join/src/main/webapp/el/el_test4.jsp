<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
	ArrayList<String> arrList = new ArrayList<>();
	arrList.add("Hello");
	arrList.add("JSP");
	arrList.add("EL");
	arrList.add("JSTL");
	pageContext.setAttribute("list", arrList);
%>

<body>
	아이디 : ${id} <br>
	패스워드 : ${pw}<br>
	아이디 : ${param.id} <br>
	패스워드 : ${param.pw}<br>
	${list}
	
<!-- JSTL 문으로 반복문을 만들어보자. for 문을 사용하지 않을 수 있음! -->
</body>
</html>