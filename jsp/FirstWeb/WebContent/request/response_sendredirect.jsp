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
응답처리가 진행됩니다.
</body>
</html>
<%
	request.setAttribute("code", "code-1");

	String name = request.getParameter("name");
	response.sendRedirect("form3_result.jsp?type=B-Type&name="+name );
%>
















