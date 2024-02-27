<%@page import="com.codingbox.web.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.codingbox.web.dao.MemberDAO_back"%>
<%@page import="com.codingbox.web.dbconnection.DBConnection_back"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="mdao" class="com.codingbox.web.dao.MemberDAO_back"/>


<%

// 	MemberDAO mdao = new MemberDAO();
	ArrayList<MemberDTO> result = mdao.selectAll();
%>

<table border="1">
	<tr>
		<th>이름</th>
		<th>나이</th>
	</tr>

<!-- 일반적인 for문 -->
<%for (int i=0; i<result.size();i++ ) { %>
	<tr>
		<td><%=result.get(i).getName()%></td>
		<td><%=result.get(i).getAge()%></td>
	</tr>
<% } %> 


<!-- 향상된 for문 -->
<% for(MemberDTO member : result) { %>
	<tr>
		<td><%=member.getName()%></td>
		<td><%=member.getAge()%></td>
	</tr>
<% } %> 
</table>

<input type="button" value="다시 검색하기"
	onclick="location.href='age_search.jsp'">
</body>
</html>

