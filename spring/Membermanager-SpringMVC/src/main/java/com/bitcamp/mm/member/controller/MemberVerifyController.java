package com.bitcamp.mm.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberVerifyController {
	
	@ResponseBody
	@RequestMapping("/member/verify")
	public String verify(
			@RequestParam("id") String id,
			@RequestParam("code") String code
			) {
		
		return id + " : " + code;		
	}

}
