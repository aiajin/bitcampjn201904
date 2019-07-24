package guestbook.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/" }, 
		initParams = { 
				@WebInitParam(name = "config", 
						value = "/WEB-INF/commandService.propertise")
		})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	public void init(ServletConfig config) throws ServletException {
		String configfile = config.getInitParameter("config");
		Properties prop = new Properties();
		FileInputStream fis = null;
		String configFilePath = config.getServletContext().getRealPath(configfile);
		
		try {
			fis = new FileInputStream(configFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator itr=  prop.keySet().iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			
		}
				
		
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}


	private void process(HttpServletRequest request, HttpServletResponse response) {
		// 1. 사용자 요청 분석
		// 2. 사용자 요청에 맞는 모델 실행 ( 서비스.메서드 실행 ) -> view 페이지 반환
		// 3. view 로 포워딩
	}

	
	
	
	
	
	
	
	
	
	
	
}
