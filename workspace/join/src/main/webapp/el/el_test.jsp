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
	String data = "hello";
	pageContext.setAttribute("data",data);
%>
	${data}<br>
	${10+20}<br>
	${10>3}
</body>
</html>