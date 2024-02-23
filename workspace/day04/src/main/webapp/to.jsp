<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

String ansStr = request.getParameter("ans");


%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>응답결과</h1>

<% if (ansStr.equals("300")) { 
   
   out.println("정답입니다");
         
}
else
{
   out.println("정답이 아닙니다");   
}
%>

</body>
</html>