<%@page import="com.codingbox.web.dao.MemberDAO_back"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String userid = request.getParameter("userid");
	MemberDAO_back mdao = new MemberDAO_back();
	
	
	// mdao.checkId(userid)	-> 
	// 중복된 아이디가 있으면 : true
	// 없으면 false
	
	if(!mdao.checkId(userid)){
		out.print("ok");
	} else{
		// 중복된 아이디가 있으니깐 실행 실패 시켜야함)
		out.print("not-ok");
	}
%>
