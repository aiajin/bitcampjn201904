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

hr {
	border: 0;
	margin: 20px 0;
	border-bottom: 1px solid #333;
}

table {
	border: 0;
	border-collapse: collapse;
	margin: 0 auto;
}

td {
	border: 1px solid #333;
	padding: 10px;
}

tr:last-child>td {
	text-align: center;
}

select {
	height: 25px;
}
</style>
</head>
<body>
	<h1>request Form Test</h1>
	<hr>
	<form action="form_result.jsp" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="uName"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td><select name="job">
						<option>시스템 디자이너</option>
						<option>프로그래머</option>
						<option>그래픽 디자이너</option>
						<option>QA</option>
				</select></td>
			</tr>
			<tr>
				<td>관심분야</td>
				<td>
					java <input type="checkbox" name="favor" value="java">
					HTML5 <input type="checkbox" name="favor" value="HTML5">
					CSS3 <input type="checkbox" name="favor" value="CSS3">
					Javascript <input type="checkbox" name="favor" value="Javascript">
					jQuery <input type="checkbox" name="favor" value="jQuery">
					JSP <input type="checkbox" name="favor" value="JSP">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="전송"> 
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>











</body>
</html>