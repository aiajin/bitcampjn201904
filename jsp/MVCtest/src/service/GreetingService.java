package service;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;

public class GreetingService implements Service {
	
//	public Object getObject(HttpServletRequest request) {
//		
//		Object object = null;
//		
//		Dao dao = new Dao();
//		
//		dao.insert();
//		
//		String str = "안녕하세요";
//		
//		object = str;
//		
//		return object;
//		
//		
//	}

	
	public String getViewPage(HttpServletRequest request) {
		
		// 핵심처리......
		
		
		request.setAttribute("result", "안녕하세요");
		
		return "/simplePage.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
}
