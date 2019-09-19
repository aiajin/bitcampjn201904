package com.bitcamp.mm.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sec")
public class SecurityController {
	
	
	@GetMapping("/all")
	public void doAll() {
		System.out.println("doAll() : everyone");
	}
	
	@GetMapping("/member")
	public void doMember() {
		System.out.println("doMember() : logined member");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		System.out.println("doAdmin() : admin only");
	}

}
