<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 브라우저가 서버로 요청할 때 모든 쿠키 정보를 함께 전송
	Cookie[] cookies = request.getCookies();
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
<h1>Cookie Data</h1>

	<%
		if (cookies != null && cookies.length > 0) {
			for(int i=0; i<cookies.length; i++ ){
				
				//if(cookies[i].getName().equals("name")){
	%>	
		<h3>
		<%= cookies[i].getName() %> :  
		<%= cookies[i].getValue()  %>
		</h3>
	<%
//				}
			}
		}		
	%>

<a href="editCookie.jsp">editCookie</a> <br>
<a href="delCookie.jsp">delCookie</a>












</body>
</html>