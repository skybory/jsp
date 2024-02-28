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
<!-- 	<form> -->
<!-- 		아이디 <input type="text" name="userid"><br /> 비밀번호 <input -->
<!-- 			type="password" name="userpw"><br /> <input type="submit"> -->
<!-- 	</form> -->


	<!-- 
	조건을 jstl로 추가.
	파라미터값으로 넘어온 userid가 null 또는 ""이라면(empty)
	<form> tag 를 그려주고
	그렇지 않다면
	param값 userid, userpw 획득 후 변수에다가 각각 할당, 출력
 -->

	<c:choose>
		<c:when test="${empty param.userid}">
			<form>
				아이디 <input type="text" name="userid"><br/>
				비밀번호 <input type="password" name="userpw"><br/>
				<input type="submit">
			</form>

		</c:when>

		<c:otherwise>
				<c:set var="userid" value="${param.userid}"/>
				<c:set var="userpw" value="${param.userpw}"/>
				회원 아이디 : ${userid}<br>
				회원 비밀번호 : ${userpw}<br>
				
				<%-- userid 값이 admin 과 같으면 -> 관리자 출력
				apple 과 같으면 -> 김사과
				그렇지 않다면 -> 비회원
		
				--%>
		<c:choose>
		<c:when test= "${userid eq 'admin'}">
		관리자
		</c:when>
		
		<c:when test = "${userid eq 'apple'}">
		김사과		
		</c:when>

		<c:otherwise>
		비회원
		</c:otherwise>
		
		</c:choose>



		</c:otherwise>

	</c:choose>

</body>
</html>