<%@page import="com.codingbox.web.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.codingbox.web.dao.MemberDAO"%>
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
	MemberDAO mdao = new MemberDAO();
	List<MemberDTO> list = mdao.getList();
	request.setAttribute("list",list);
	pageContext.forward("search_view.jsp");
	%>
	

</body>
</html>














