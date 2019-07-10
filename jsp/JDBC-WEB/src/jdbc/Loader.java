package jdbc;

import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


public class Loader extends HttpServlet {
	

	public void init(ServletConfig config) throws ServletException {
		
		String drivers = config.getInitParameter("jdbcdriver");
		
		StringTokenizer st = new StringTokenizer(drivers, ",");
		while(st.hasMoreTokens()) {
			String driver = st.nextToken();
			
			// 데이터베이스 드라이버 로드
			try {
				Class.forName(driver);
				
				
				System.out.println("데이터베이스 드라이버 로드 성공 : " + driver);
				
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
