<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	request.setAttribute("member", new Member("tiger","ttt","010-9999-9999"));

	request.setAttribute("name01", "requestData");
	session.setAttribute("name02", "sessionData");
	application.setAttribute("name03", "applicationData");
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
	<h3>
	
		request 영역의 name01 : ${requestScope.name01} <br>
		
		
		
		                  <%= request.getAttribute("name01")  %> <br>
		session 영역의 name02 : ${sessionScope.name02} <br>
		application 영역의 name03 : ${applicationScope.name03}	<br>
		
		member 객체 참조 1 - id : ${requestScope.member.id} <br>
		member 객체 참조 2 - name : ${requestScope.member.name} <br>
		member 객체 참조 3 - pNum : ${requestScope.member.pNum} <br>
		member 객체 참조 4 - num : ${member.num} <br>
		
		  
	
	
	
	
	</h3>















</body>
</html>