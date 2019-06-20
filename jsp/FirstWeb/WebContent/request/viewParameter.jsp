<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
	request.setCharacterEncoding("utf-8");
	
%>
	<h1>요청 파라미터 출력</h1>
	<ul>
		<li>name 파라미터 : <%= request.getParameter("name") %></li>
		<li>address 파라미터 : <%= request.getParameter("address") %></li>
		<li>pet 파라미터 : <%= request.getParameter("pet") %></li>
	</ul>











</body>
</html>