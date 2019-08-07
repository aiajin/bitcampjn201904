package com.bitcamp.mm.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.mm.member.domain.ListViewData;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.service.MemberListService;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberListService listService;
	
	
	@RequestMapping("/member/memberList")
	public String memberList(
			Model model,
			@RequestParam(value = "p", defaultValue = "1") int pageNumber
			) {
		
		ListViewData listdata = listService.getListData(pageNumber);
		
		System.out.println("전체 회원의 수 : "+ listdata.getTotalCount());
		/*
		 * for(MemberInfo m : listdata.getMemberList()) { 
		 * System.out.println(m); }
		 */
		
		model.addAttribute("viewData", listdata);
		
		
		return "member/memberList";
	}

	
	
	
	
	
	
	
	
	
}
