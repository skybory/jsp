<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	margin: 0 auto;
	width: 900px;
}
</style>
</head>
<body>
	<div>
		<table style="width: 900px; border: 0px">
			<tr align="center" valign="middle">
				<td><h3>MVC 게시판</h3></td>
			</tr>
		</table>
		<table border="1" style="border-collapse: collapse; height: 30px">
			<tr>
				<th align="center" width="150px;">제목</th>
				<td>${board.boardtitle}<span
					style="font-weight: bold; color: #6a1b9a; float: right;">
						조회수 : ${board.boardreadcount} </span>
				</td>
			</tr>
			<tr>
				<th align="center" width="150px;">글쓴이</th>
				<td>${board.username}</td>
			</tr>
			<tr height="300px;">
				<th align="center" width="150px;">내용</th>
				<td valign="top" style="padding: 10px;">${board.boardcontents}
				</td>
			</tr>
		</table>
		<table style="border: 0px;">
			<tr align="right" valign="middle">
				<td><a
					href="${pageContext.request.contextPath}/board/BoardList.bo">
						[목록] </a></td>
			</tr>
		</table>

		<%-- 댓글 리스트 --%>
		<hr />
		<form name="replyForm" method="post"
			action="${pageContext.request.contextPath}/board/AddReply.bo">
			<input type="hidden" name="boardnum" value="${board.boardnum}">
			<table border="1">
				<tr>
					<td align="center" width="200px">댓글<br>
						<hr> 이름 &nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
						name="username" maxlength="10" /><br /> 비밀번호 <input
						type="password" name="password" />
					</td>
					<td style="padding-left: 10px;"><textarea name="replycontents"
							style="width: 680px; height: 85px; resize: none;"></textarea><br />
						<a href="javascript:document.replyForm.submit()">[등록]</a></td>
				</tr>

			</table>
			<hr />


			<table border="1">
				<c:choose>
					<c:when test="${ not empty replylist and fn:length(replylist)>0}">
						<c:forEach var="reply" items="${replylist}">
							<tr>
								<td align="center" width="200px;">${reply.username}</td>
		
								<td valign="top" style="padding-left: 10px;"><textarea
										style="text-align: left; border: 0px; width: 680px; height: 85px; resize: none;"
										name="reply${reply.replynum }" id="reply${reply.replynum }" readonly>${reply.replycontents} </textarea>
									<br>
									 <a href="javascript:updateReply(${reply.replynum},'${reply.password}')">[수정]</a> 
									 &nbsp;&nbsp;&nbsp; 
									 <a href="javascript:updateReadonly(${reply.replynum });">[수정하기]</a>
									  &nbsp;&nbsp;&nbsp; 
									  <a href="javascript:deleteReply(${reply.replynum},'${reply.password}')">[삭제]</a>
									  </td>
							</tr>
						</c:forEach>
					</c:when>
				
	
				<c:otherwise>
					<tr>
						<td align="center">댓글이 없습니다.</td>
					</tr>
				</c:otherwise>
				</c:choose>
			</table>



		</form>
	</div>



</body>
<script>function updateReadonly(replynum){
// 	alert("updateReadonly() 호출" + replynum);
	document.getElementById('reply' + replynum).readOnly = false;
}
function updateReply(replynum, password){
	let pw = prompt("댓글 비밀번호를 입력하세요");
	
	if (pw == password){
		document.replyForm.action = "${pageContext.request.contextPath}/board/UpdateReply.bo?replynum="+replynum;
		document.replyForm.submit();
	} else {
		alert("비밀번호를 확인해주세요");
// 		return false;
	}
}
function deleteReply(replynum, password){
	let pw = prompt("댓글 비밀번호를 입력하세요");
	
	if (pw == password){
		document.replyForm.action = "${pageContext.request.contextPath}/board/DeleteReply.bo?replynum="+replynum;
		document.replyForm.submit();
	} else {
		alert("비밀번호를 확인해주세요");
	}
}


</script>



</html>