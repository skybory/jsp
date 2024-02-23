<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<body>
<h3>페이지 이동</h3>
<form action="object_ok.jsp" name="joinForm">
	<fieldset>
		<legend>개인정보</legend>
		<input type="text" name="username" id="username">
		<input type="date" name="userbirth" id="userbirth">
		<input type="button" value="확인" onclick="sendit();">
		
	</fieldset>
</form>
	
	<script>
		function sendit(){
			
			let joinForm = document.joinForm;
			let nameTag = joinForm.username;
			let birthTag = joinForm.userbirth;
			// validation check
			// 입력값 가져오기
			let username = $("#username").val(); 
			let userbirth = $("#userbirth").val(); 
			
			
			// 바닐라 스크립트 사용
			if (nameTag.value=="") { 
				alert("이름을 입력하세요"); 
				nameTag.focus(); 
				return false; 
			}
			// jQuery문 사용
			if (!userbirth) { 
				alert("생일을 입력하세요"); 
				$("#userbirth").focus(); 
				return false; 
			}
			
 			joinForm.submit();


//  			$("joinForm").submit();


		}
	</script>
</body>
</html>