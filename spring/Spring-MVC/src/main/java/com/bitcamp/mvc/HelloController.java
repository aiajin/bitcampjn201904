package com.bitcamp.mvc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		
		// FrontController 전송할 View 경로 와 결과 데이터 저장하고 전달할 객체 -> ModelAndView		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello"); // /WEB-INF/views/hello.jsp
		modelAndView.addObject("userName", "Cool");
		modelAndView.addObject("greeting", "안녕하세요");
		modelAndView.addObject("now", new Date());
		
		return modelAndView;
		
		
		
		
		
	}


}
