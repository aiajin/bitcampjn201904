package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mc/simple")
public class SimpleConverterController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String simple(@RequestBody String body) {
		
		System.out.println(body);
		
		return body;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
