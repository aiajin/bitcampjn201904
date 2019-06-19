<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	h1 {
		text-align: center;
	}
	div {
		padding : 10px;
		width : 45%;
		float: left;
	} 
</style>
</head>
<body>
	<h1> include 지시어</h1>
	<hr>
	<!-- 메뉴 시작 -->
	<%@ include file="include/top.jsp" %>
	<!-- 메뉴 끝 -->
	<!-- 왼쪽 영역 시작 -->
	<%@ include file="include/left.jsp" %>
	<!-- 왼쪽 영역 끝   -->
	<!-- 오른쪽 영역 시작 -->
	<%@ include file="include/right.jsp" %>
	<!-- 오른쪽 영역 끝 -->


















</body>
</html>