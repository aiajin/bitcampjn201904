package com.weovercome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.Contended;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		return "index";
	}

}
