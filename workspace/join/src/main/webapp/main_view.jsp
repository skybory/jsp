<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.codingbox.web.dto.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
메인화면입니다!
<%
MemberDTO mdto = (MemberDTO)session.getAttribute("session_id");

if(mdto!=null){
String userid = mdto.getUserid();
String username = mdto.getUsername();%>

	<script>
		alert("<%=username%>님 안녕하세요!");
	</script>
	<p>
	<%=username%>님(<%=userid%>) <input type="button" value="로그아웃" onclick=" location.href='logout_db.jsp'">
	</p>
	
<%	} else { %>
	<script>
		alert("로그인 후 이용해주세요");
		location.href="login_view.jsp"
	</script>
<%} %>
</body>
</html>