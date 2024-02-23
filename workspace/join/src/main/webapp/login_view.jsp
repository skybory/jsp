<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="user.js"></script>
<title>Insert title here</title>
</head>
<body>

<form action = "login_db.jsp" method="post" name="frm">
<p>
	<label> 아이디
		<input type="text" name="userid" id="userid">
	</label>


</p>
<p>
	<label> 패스워드 
		<input type="password" name="userpw" id="userpw">
	</label>
</p>
<input type="button" value="로그인" onclick="loginit();">







</form>
</body>
</html>