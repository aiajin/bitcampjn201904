package service;

import javax.servlet.http.HttpServletRequest;

public class OtherService implements Service {
	
	public String getViewPage(HttpServletRequest request) {
		
		request.setAttribute("result", "Invalid Type");
		
		return "/simplePage.jsp";
	}

}
