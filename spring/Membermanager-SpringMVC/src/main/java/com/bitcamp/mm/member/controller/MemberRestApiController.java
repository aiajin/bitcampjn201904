package com.bitcamp.mm.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.service.MemberListService;

// /rest-api/members      GET     -> 전체 리스트, 페이징 처리된 리스트
// /rest-api/members/{id} GET     -> 회원 한명의 정보 반환
// /rest-api/members      POST    -> 회원 정보를 저장
// /rest-api/members/{id} PUT     -> 회원 정보를 수정
// /rest-api/members/{id} DELETE  -> 회원 정보를 삭제

@Controller //   
@RequestMapping("/rest-api/members")
public class MemberRestApiController {
	
	@Autowired
	private MemberListService listService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<MemberInfo> getAllList(){		
		return listService.getAllList();
	}

	
	
	
	
	
	
	
	
	
	
	
}














