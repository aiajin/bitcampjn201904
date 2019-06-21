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
<h1>

	<%
		HttpServletRequest req = 
		(HttpServletRequest)pageContext.getRequest();
	
	%>
	<%= request == req %>
	
	<br>
	
	<%
		out.print(123+"<br>");
		pageContext.getOut().print("같은 객체를 사용합니다.");
		
	%>










</h1>


























</body>
</html>