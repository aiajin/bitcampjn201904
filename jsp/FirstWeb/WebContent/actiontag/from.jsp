<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="8kb" %>   

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
	for(int i=0; i<1000; i++){
%>
<h1>from.jsp 페이지에서 실행된 결과 페이지 입니다.</h1>
<%
	}
%>


<jsp:forward page="to.jsp"/>











</body>
</html>