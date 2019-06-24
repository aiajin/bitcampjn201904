<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userData" class="member.UserInfo" scope="request" />

<!--
		request.getAttribute("userData")

  -->
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
<h1>포워드 된 페이지 이고, usebean 을 통한 데이터 공유 </h1>
<h1>
	<%= userData %>
</h1>











</body>
</html>