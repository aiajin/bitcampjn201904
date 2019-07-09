package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection1 {

	public static void main(String[] args) {
		
		// 1. 데이터베이스의 드라이버를 로드한다.
		// 2. 데이터베이스 연결
		
		Connection conn=null;
		// JDBC_URL : mysql
		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC&charaterEncoding=utf-8";
		// USER 
		String user = "bit";
		// Password
		String pw = "bit";
		
		
		try {
			
			// 1. 드라이버 로드 : mysql 드라이버 로드
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2. 데이터베이스 연결
			conn=DriverManager.getConnection(jdbcUrl, user, pw);
			
			System.out.println("데이터베이스 연결 성공.");
			
			//   데이터베이스 작업
			Statement stmt = conn.createStatement();
			String sql = "select * from emp join dept on emp.deptno=dept.depno ";
			
			//ResultSet rs = stmt.executeUpdate(sql);
			
			
			
			// 3. 데이터베이스의 연결 종료 : 데이터베이스 작업 종료 후
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
