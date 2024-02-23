<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "jsp";
	String password = "jsp";
	Class.forName(driver);
	conn = DriverManager.getConnection(url, user, password);

	String sql = "SELECT * FROM CAR" ;
	PreparedStatement pstm = conn.prepareStatement(sql);
	
	ResultSet rs = pstm.executeQuery();
	
// 	if(rs.next()) {
// 		out.print(rs.getDate(1));
// 	}
	
	while(rs.next()) {
		out.print("차 번호 : " + rs.getString(1) + "<br>");
		out.print("브랜드 : " + rs.getString("BRAND") + "<br>");
		out.print("색상 : " + rs.getString(3) + "<br>");
		out.print("가격 : " + rs.getInt("pRiCe") + "원<br>" + "<br>");
	}
	
	out.print("<br><hr>");
	String carnum = "3";
// 	sql = "SELECT * FROM car WHERE carnum = '" + carnum + "'";

	sql = "SELECT * FROM car WHERE carnum = ?";	
	pstm = conn.prepareStatement(sql);
	pstm.setString(1, carnum);
	
	rs = pstm.executeQuery();
	if(rs.next()) {
		out.print("차 번호 : " + rs.getString(1) + "<br>");
		out.print("브랜드 : " + rs.getString("BRAND") + "<br>");
		out.print("색상 : " + rs.getString(3) + "<br>");
		out.print("가격 : " + rs.getInt("pRiCe") + "원<br>" + "<br>");
	}
	
	
	// 객체 반납
	// 객체 만든 역순으로 : rs -> pstm -> conn
	rs.close();
	pstm.close();
	conn.close();
%>


</body>
</html>

