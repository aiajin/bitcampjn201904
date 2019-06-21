<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	h1 {
		text-align: center;
	}
	
	table {
		width : 500px;
		border: 0;
		border-collapse: collapse;
		margin : 0 auto;
	}
	
	td {
		border : 1px solid #666;
		padding : 10px;
	}
	
	select {
		height : 25px;
	}
	
	table tr:last-child>td {
		text-align: center;
	}
	
	table tr:first-child>td:first-child {
		width : 100px;
	}
	
</style>
</head>
<body>

	<h1>request Form Test</h1>
	<hr>
	<form action="result.jsp" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="uName"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td><select name="job">
						<option>시스템엔지니어</option>
						<option>프로그래머</option>
						<option>그래픽디자이너</option>
						<option>QA</option>
				</select></td>
			</tr>
			<tr>
				<td>관심사항</td>
				<td>java <input type="checkbox" value="java" name="favor">
					HTML5 <input type="checkbox" value="HTML5" name="favor">
					css3 <input type="checkbox" value="css3" name="favor">
					javascript <input type="checkbox" value="javascript" name="favor">
					JSP <input type="checkbox" value="JSP" name="favor">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="보내기"> 
					<input type="reset">
				</td>
			</tr>
		</table>

	</form>





















</body>
</html>