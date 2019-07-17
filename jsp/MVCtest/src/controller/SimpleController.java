package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/simple")*/
public class SimpleController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청파악 : prameter 의 값으로 사용자 요청을 분석/구분
		String command = request.getParameter("type");
		
		// 응답결과
		String resultObj = "";
		String viewpage = "";
		
		// 요청에 맞는 기능 수행 : Model 처리 ( Service + Dao + 기능 Clss ) -> 결과 데이터 반환
		// view 지정
		if(command == null || command.equals("greeting")) {
			resultObj = "안녕하세요";
			viewpage = "/simplePage.jsp";
		} else if (command.equals("date")) {
			resultObj = new Date().toString();
			viewpage = "/datepage.jsp";
		} else {
			resultObj = "Invalid Type";
			viewpage = "simplePage.jsp";
		}
		
		
		// 결과 데이터를 request 또는 session 영역에 속성으로 저장 : view 로 데이터 전달, 공유		
		request.setAttribute("result", resultObj);
		
		// forwarding
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		dispatcher.forward(request, response);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
