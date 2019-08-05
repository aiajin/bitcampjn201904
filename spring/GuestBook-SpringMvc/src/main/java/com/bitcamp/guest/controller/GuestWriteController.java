package com.bitcamp.guest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.guest.domain.RequestGuestWrite;

@Controller
public class GuestWriteController {
	
	@RequestMapping("/guest/writeForm")
	public String getWriteForm() {
		
		return "guest/writeForm";
	}
	
	@RequestMapping(
			value = "guest/write", 
			method = RequestMethod.POST)
	public String write(RequestGuestWrite requestGuestWrite) {
		
		System.out.println(requestGuestWrite);
		
		return "guest/write";
	}

	
	
	
	
	
	
	
}
