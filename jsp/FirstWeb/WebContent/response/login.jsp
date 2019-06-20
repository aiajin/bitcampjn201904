<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String id = request.getParameter("id");

	String name="이강인";
	
	String newStr = URLEncoder.encode(name, "utf-8");

	if(id != null && id.equals("test")){
		response.sendRedirect("view.jsp?name="+newStr);
	}

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
<h1>인증처리된 아이디가 아닙니다.</h1>
</body>
</html>








