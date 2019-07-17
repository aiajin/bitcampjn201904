package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DateService;
import service.GreetingService;
import service.OtherService;
import service.Service;

public class FrontController extends HttpServlet {
	
	Map<String, Service> commands = new HashMap<String, Service>();
	
		
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("config");
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		String configFilePath = config.getServletContext().getRealPath(configFile);
		try {
			fis = new FileInputStream(configFilePath);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		Iterator keyItr = prop.keySet().iterator();		
		while(keyItr.hasNext()) {
			String command = (String) keyItr.next();
			String serviceClassName = prop.getProperty(command);
			
			try {
				Class serviceClass = Class.forName(serviceClassName);
				Service serviceInstance = (Service) serviceClass.newInstance();
				commands.put(command, serviceInstance);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public FrontController() {
		// /, /greeting, /now/date 
		/*
		 * commands.put("/", new GreetingService()); commands.put("/greeting", new
		 * GreetingService()); commands.put("/now/date", new DateService());
		 * commands.put("/board/list", new DateService()); commands.put("/board/write",
		 * new DateService());
		 */
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청파악 : prameter 의 값으로 사용자 요청을 분석/구분
		//String command = request.getParameter("type");
		
		String command = request.getRequestURI();
		
		System.out.println("사용자 요청 URI : " + command);
		
		if(command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
		System.out.println("command : " + command);
		
		// 응답결과
		String resultObj = "";
		String viewpage = "";
		
		// 요청에 맞는 기능 수행 : Model 처리 ( Service + Dao + 기능 Clss ) -> 결과 데이터 반환
		// view 지정
		/*
		 * if(command == null || command.equals("/greeting") || command.equals("/")) {
		 * viewpage = new GreetingService().getViewPage(request); } else if
		 * (command.equals("/now/date")) { viewpage = new
		 * DateService().getViewPage(request); } else { viewpage = new
		 * OtherService().getViewPage(request); }
		 */
		
		 Service service = commands.get(command);
		 if(service == null) {
			 service = new OtherService();
		 }
		 viewpage = service.getViewPage(request);
		 
		
		
		// 결과 데이터를 request 또는 session 영역에 속성으로 저장 : view 로 데이터 전달, 공유		
		//request.setAttribute("result", resultObj);
		
		// forwarding
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		dispatcher.forward(request, response);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
