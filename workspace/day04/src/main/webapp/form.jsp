<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="myform" method="post" action="action.jsp">
		<fieldset>
			<legend>post data 전송 예제</legend>
			<div>
				<label> 이름 : 
					<input type = "text" name = "user_name" id = "user_name">
				</label>
			</div>
			<button type="submit">Submit</button>
		</fieldset>
	</form>
</body>
</html>