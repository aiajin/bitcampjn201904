<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CookieBox cBox = new CookieBox(request);

	boolean loginChk = cBox.exists("LOGIN") && cBox.getValue("LOGIN").equals("SUCCESS");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>

</style>
</head>
<body>

	<h1>로그인 여부 확인</h1>
	<h3>
	<%
		if(loginChk){
			out.println("아이디는 "+ cBox.getValue("ID")+"로 로그인 되어 있는 상태입니다.");
			out.println("<a href=\"logout.jsp\">로그아웃</a>");
		} else {
			out.println("로그인 되어 있는 상태가 아닙니다. ");
		}
	
	%>
	</h3>














</body>
</html>