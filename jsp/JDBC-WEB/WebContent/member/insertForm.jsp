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
	<h1>사원 입력</h1>
	<hr>
	<form action="insertEmp.jsp" method="post">
		<table>
			<tr>
				<td>사원번호</td>
				<td><input type="number" name="empno"></td>
			</tr>
			<tr>
				<td>사원이름</td>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<td>사원직무</td>
				<td><input type="text" name="job"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="입력"></td>
			</tr>
		</table>
	</form>













</body>
</html>