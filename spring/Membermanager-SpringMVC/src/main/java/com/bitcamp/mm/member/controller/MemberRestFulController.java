package com.bitcamp.mm.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberRegist;
import com.bitcamp.mm.member.service.MemberDeleteService;
import com.bitcamp.mm.member.service.MemberListService;
import com.bitcamp.mm.member.service.MemberRegService;

@RestController // @ResponseBody 생략한다.
@RequestMapping("/rest/members")
public class MemberRestFulController {
	
	@Autowired
	private MemberListService listService;
	
	@Autowired
	private MemberDeleteService deleteService;
	
	@Autowired
	private MemberRegService regService;
	
	
	
	//@RequestMapping(method = RequestMethod.GET)
	//@ResponseBody
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<MemberInfo>> getAllList(){
		
		List<MemberInfo> list = listService.getAllList();
		
		ResponseEntity<List<MemberInfo>> entity =
				new ResponseEntity<List<MemberInfo>>(
						list, 
						HttpStatus.OK);
		// HttpStatus.OK -> 200
		// HttpStatus.NOT_FOUND -> 404
		// HttpStatus.INTERNAL_SERVER_ERROR -> 500
		
		return entity; 
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}") //  /rest/members/12
	public ResponseEntity<String> deleteMember(
			@PathVariable("id") int idx
			) {
		//int cnt = deleteService.memberDelete(idx);
		
		return new ResponseEntity<String>(
				deleteService.memberDelete(idx)>0?"SUCCESS":"FAIL",
				HttpStatus.OK
				);
	}
	
	//@RequestMapping(method = HttpMethod.POST)
	@CrossOrigin
	@PostMapping	
	public ResponseEntity<String> regMember(
			RequestMemberRegist regRequest,
			HttpServletRequest request
			) {
		
		System.out.println("check : " + regRequest);
		
		int cnt = regService.memberInsert(request, regRequest);
				
		return new ResponseEntity<String>(
				cnt>0 ? "SUCCESS" : "FAIL" ,
				HttpStatus.OK
				);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
