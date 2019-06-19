<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="list.jsp"%>
<%
	String str = new String("회원가입 폼");

	int n = 1/0;



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	img {
		width : 100px;
	}
</style>

</head>
<body>
<h1><%= str %></h1>

<a href="/web/member/list.jsp">회원리스트</a><br>
<img alt="이미지" src="/web/images/mickey_mouse.png">
<script>
	$(document).ready(function(){
		alert('회원 가입페이지 입니다.');
		
	});
</script>
</body>
</html>








