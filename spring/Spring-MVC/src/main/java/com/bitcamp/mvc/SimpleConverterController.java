package com.bitcamp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mc/simple")
public class SimpleConverterController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {
		
		model.addAttribute("password_val", passwordEncoder.encode("1111"));
		System.out.println(passwordEncoder.encode("1111"));
		System.out.println(passwordEncoder.matches("1111" , passwordEncoder.encode("1111")));
		
		return "form";
	}
	
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String simple(@RequestBody String body) {
		
		System.out.println(body);
		
		return body;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
