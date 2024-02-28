<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="member" class="com.codingbox.web.dto.MemberDTO"/>
<jsp:setProperty property="*" name="member" />
<body>
	<form action="search_db.jsp">
		검색하실 회원의 ID <input type="text" name="userid"><br /> <input
			type="button" value="전체 회원 보기" onclick="location.href='list_db.jsp'">
		<input type="submit">

	</form>

	<hr />
	<%-- 	${requestScope.user.userid} --%>

	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>성별</th>
			<th>상세주소</th>
		</tr>
		<c:choose>
			<c:when test="${!empty requestScope.user}">
				<c:set var="user" value="${requestScope.user }" />
				<tr>
					<td>${user.userid }</td>
					<td>${user.userpw }</td>
					<td>${user.username }</td>
					<td>${user.usergender }</td>
					<td>${user.addrdetail }</td>
				</tr>



			</c:when>
		</c:choose>


		<c:choose>
			<c:when test="${!empty requestScope.list}">
				<c:set var="list" value="${requestScope.list}" />
				<c:forEach var="i" begin="0" end="${list.size()-1}" step="1">
					<tr>
						<td>${list[i].userid}</td>
						<td>${list[i].userpw}</td>
						<td>${list[i].username}</td>
						<td>${list[i].usergender}</td>
						<td>${list[i].addrdetail}</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>

	</table>
</body>
</html>


















