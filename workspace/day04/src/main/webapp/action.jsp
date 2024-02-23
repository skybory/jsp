<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String name = request.getParameter("user_name");
		
	if (name == null) {
		name = "이름이 없습니다";
	}
	name = name.trim();
	if (name.equals("")) {
		name = "이름을 입력하세요";
	} 	
	// 앞 뒤 공백 제거
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<h1><%=name %></h1>
	

</body>
</html>