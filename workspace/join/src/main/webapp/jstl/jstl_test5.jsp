<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- for(int i=0; i<=10; i++) 식을 jstl로 아래에 표현-->
	<c:forEach var="i" begin="0" end="10" step="1">
		${i}<br>
	</c:forEach>
	
	<hr/>
	<c:set var = "arrData" value="<%=new int[]{10,20,30,40,50} %>"/>
	<c:forEach var="i" begin="0" end="4" step="1">
		${arrData[i]}
	</c:forEach>
	<hr/>
	<c:forEach var="data" items="${arrData}">
		${data}
	</c:forEach>
	<hr/>
	
	<%
		HashMap<String, Integer> map = new HashMap<>();
		map.put("하나", 1);
		map.put("둘", 2);
		map.put("셋", 3);
	%>

	<c:set var="map" value="<%=map%>"/>
	<c:forEach var = "entry" items="${map}">
		${entry.key} : ${entry.value} <br> 
	</c:forEach>
	
	<hr/>
	
	<c:forEach var="i" begin="1" end="9" step="1">
		5 X ${i } = ${5*i }<br>
	</c:forEach>
	
</body>
</html>
