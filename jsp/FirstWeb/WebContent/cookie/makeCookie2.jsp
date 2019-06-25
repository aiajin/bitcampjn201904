<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 등록 방법 ( 쿠키를 굽는다 )
	// 1. Cookie 객체를 생성 : new Cookie(쿠키이름, 데이터)
	// 2. response 객체에 Cookie를 추가 : response.addCookie(쿠키객체의 참조변수)
	
	// Cookie 객체 생성
	//Cookie cookie = new Cookie("code","ace");
	Cookie cookie = CookieBox.createCookie("code", "0");	
	// response 에 쿠키 객체 추가
	response.addCookie(cookie);
	
	//Cookie c1 = new Cookie("name", "손흥민");
	Cookie c1 = CookieBox.createCookie("name", "손흥민");
	response.addCookie(c1);
	
	//Cookie c2 = new Cookie("id", "cool");
	//c2.setMaxAge(60); // 1분
	Cookie c2 = CookieBox.createCookie("nicname", "hot", 60*30);
	response.addCookie(c2);
	
	//Cookie c3 = new Cookie("email", "test@test.com");
	//c3.setMaxAge(60*60); // 1시간
	Cookie c3 = CookieBox.createCookie("pw", "1234", 60*60*2);
	response.addCookie(c3);
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
<h1>쿠키를 생성했습니다.</h1>
<a href="viewCookie2.jsp">viewCookie</a> <br>
<a href="viewCookieJs.jsp">viewCookieJS</a> <br>













</body>
</html>