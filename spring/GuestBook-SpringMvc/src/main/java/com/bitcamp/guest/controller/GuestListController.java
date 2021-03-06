package com.bitcamp.guest.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.guest.domain.MessageListView;
import com.bitcamp.guest.service.GetMessageListService;

@Controller
public class GuestListController {
	
	@Autowired
	private GetMessageListService listService;
	
	@RequestMapping("/guest/list")
	public String getList(
			@RequestParam(
					value = "page", 
					defaultValue = "1") int pageNumber,
			Model model
			) {
		
		MessageListView listView = 
				listService.getMessageListView(pageNumber);
		
		model.addAttribute("viewData", listView);
		
		return "guest/list";
	}
	
	@RequestMapping("/guest/listJson")
	@ResponseBody
	public MessageListView getListJson(
			@RequestParam(
					value = "page", 
					defaultValue = "1") int pageNumber,
			Model model,
			HttpServletResponse response
			) {
		
		MessageListView listView = 
				listService.getMessageListView(pageNumber);
		
		
		
		return listView;
	}

	
	
	
	
	
	
	
	
	
}
