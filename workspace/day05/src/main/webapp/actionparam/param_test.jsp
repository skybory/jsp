<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>param 액션 태그</h3>
	 
<%-- 
	"name"을 key값으로 사용하여 "value" 값을 전달
 --%>
	<jsp:forward page="param_result.jsp">
		<jsp:param value="user" name="userid"/>
		<jsp:param value="김자바" name="username" />
	</jsp:forward>
	
	
	
</body>
</html>






