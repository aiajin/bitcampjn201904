<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	// JDBC_URL
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String pw = "tiger";

	try{
	// 1. 드라이버 로드	
	//Class.forName("oracle.jdbc.driver.OracleDriver");
		
	// 2. DB 연결 : 컨넥션
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	

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

	 <h1>EMP LIST</h1>
	 <h3><a href="insertForm.jsp">사원입력</a></h3>
	 <hr>
	 <table>
	 	<tr>
	 		<td>사원번호</td>
	 		<td>사원이름</td>
	 		<td>사원직급</td>
	 	</tr>
	 	
	 	<!-- 테이블 행의 반복 시작 -->
	 	<%

		// 3. Statement 객체 생성
		stmt = conn.createStatement();
	 	
	 	// 사원 리스트를 구하기 위한 SQL 작성
	 	String sql = "select * from emp order by ename";
		
	 	// 4. SQL 실행
	 	// SELECT 결과 받기 
		
	 	rs = stmt.executeQuery(sql);
		
		
		// 5. 결과 출력
		
		while(rs.next()){
	
	 	
	 	%>
	 	<tr>
	 		<td><%= rs.getInt(1) %></td>
	 		<td><a href="viewEmp.jsp?empno=<%= rs.getInt("empno")%>"><%= rs.getString("ename") %></a></td>
	 		<td><%= rs.getString("job") %></td>
	 	</tr>
	 	
	 	<%
		}
	 	
	 	%>
	 	
	 	<!-- 테이블 행 반복 끝 -->
	 	
	 </table>

</body>
</html>

<%
	} catch (SQLException se) {
		se.printStackTrace();		
	} finally {
		// 6. 사용객체 close() : rs, stmt , conn
		if(rs != null){
			try{
			rs.close();
			} catch (SQLException e){
				
			}
		}
		if(stmt != null){
			try{
			stmt.close();
			} catch (SQLException e){
				
			}
		}
		if(conn != null){
			try{
			conn.close();
			} catch (SQLException e){
				
			}
		}
	}
	
	

%>












