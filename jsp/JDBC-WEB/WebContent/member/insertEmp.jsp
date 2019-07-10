<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="member.Emp" />
<jsp:setProperty property="*" name="member" />

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	int resultCnt = 0;

	try {
		// 1. 데이터베이스 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 데이터베이스 연결
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

		// 3. PreparedStatement 생성
		// 사용자 정보 업데이트를 위한 SQL 작성
		String sql = "insert into emp (empno, ename, job) values (?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, member.getEmpno());
		pstmt.setString(2, member.getEname());
		pstmt.setString(3, member.getJob());

		// 4. SQL 실행
		resultCnt = pstmt.executeUpdate();

		// 5. 실행결과 출력 : 수정되었습니다.
	} catch (ClassNotFoundException cs) {

	} catch (SQLException se) {

	} finally {
		// 6. 객체 close	

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {

			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}
	}
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

	<h1>사원 정보 입력 </h1>
	<h3> <%= resultCnt %>개 행이 입력 되었습니다. </h3>
	 	
	 	<a href="empList.jsp">EMP LIST</a>

</body>
</html>