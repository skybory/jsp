<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

String ans = request.getParameter("ans");
String result = null;

if (ans == null || ans.equals("")) {
	result = "응답 내용이 없습니다";
} else{
	int user_select = Integer.parseInt(ans);
	if (user_select == 300) {
		result = "정답입니다";
	}
	else {
		result = "정답이 아닙니다";
	}
}


%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>응답결과</h1>
	<p> <%=result %></p>


</body>
</html>