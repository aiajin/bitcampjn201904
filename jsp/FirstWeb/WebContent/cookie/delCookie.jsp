<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie c1 = new Cookie("name", "");
	c1.setMaxAge(0); //setMaxAge(시간정보: 초 단위) : 60*60*24*365 => 1년
	response.addCookie(c1);
	
	Cookie c2 = new Cookie("code", "");
	c2.setMaxAge(0);
	response.addCookie(c2);
	
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
<h1>쿠키정보가 삭제되었습니다.</h1>
<a href="viewCookie.jsp">viewCookie</a>

</body>
</html>