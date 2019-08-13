package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.mvc.domain.GuestMesageList;
import com.bitcamp.mvc.domain.GuestMessage;

@Controller
public class guestListController {
	
	@RequestMapping("/guest/xmlList.xml")
	@ResponseBody
	public GuestMesageList xmlList() {
		
		return getmessageList();
	}

	private GuestMesageList getmessageList() {
		
		List<GuestMessage> message = new ArrayList<GuestMessage>();
		message.add(new GuestMessage(1, "안녕하세요", new Date()));
		message.add(new GuestMessage(2, "반갑습니다.", new Date()));
		message.add(new GuestMessage(3, "또만나요.", new Date()));
		
		
		
		return new GuestMesageList(message);
	}

}
