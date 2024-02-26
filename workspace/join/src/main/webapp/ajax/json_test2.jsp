<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실시간 순위</title>
</head>
<script src="ajax.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<body>
	<h1>Ajax를 이용해 실시간 순위 나타내기</h1>
	<table border="1">
		<tr>
			<th>실시간 검색 순위</th>
			<th>키워드</th>			
		</tr>
		<tr>
			<td id="td1">순위</td>
			<td id="td2">키워드</td>			
		</tr>
			
	</table>
<!-- <script src="json.js"></script> -->
<script>
// 페이지가 로드 됐을 때
window.onload = function(){
	sendJson2();
}

	
	// data2.json 파일 데이터 읽어와서
	// 실시간 검색어 순위 1 키워드로 독감
	// 2초 뒤에 실시간 검색어 순위 2 키워드 JSP
	// 2초 뒤에 실시간 검색어 순위 3 키워드 java

</script>



</body>
</html>