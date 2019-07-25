<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userData" class="membermanager.member.model.UserInfo" scope="session" />
<jsp:setProperty property="*" name="userData"/>
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
	<%= userData %>
</h1>

<jsp:forward page="viewMember.jsp"/>












</body>
</html>