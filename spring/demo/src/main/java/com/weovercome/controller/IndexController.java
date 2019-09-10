package com.weovercome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		return "index";
	}
	
	@RequestMapping("/hello")
	public void hello(Model model) {
		
		model.addAttribute("msg", "hello~!!");
		
	}

}
