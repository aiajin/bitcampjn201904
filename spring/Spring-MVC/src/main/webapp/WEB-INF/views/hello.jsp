<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>View : hello.jsp </h1>
<h3>
	userName : ${userName} <br>
	greeting : ${greeting} <br>
	now : ${now}
</h3>

<a href="<c:url value="/header/getHeader" />">/header/getHeader</a>

</body>
</html>