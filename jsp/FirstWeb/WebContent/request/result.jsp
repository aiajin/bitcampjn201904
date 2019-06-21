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
	
	table tr:first-child>td:first-child {
		width : 100px;
	}
	

</style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

%>
	<h1>전송 결과</h1>
	<hr>
	
		<table>
			<tr>
				<td>이름</td>
				<td><%= request.getParameter("uName") %></td>
			</tr>
			<tr>
				<td>직업</td>
				<td><%= request.getParameter("job") %></td>
			</tr>
			<tr>
				<td>관심사항</td>
				<td>
				<%
					String[] favors = request.getParameterValues("favor");
					if(favors != null) {
					
						for(int i=0; i<favors.length; i++){
							out.println(favors[i]+"<br>");
						}
					}				
				%>
				</td>
			</tr>
		</table>

	















</body>
</html>