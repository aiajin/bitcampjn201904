package com.weovercome.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weovercome.domain.MemberInfo;
import com.weovercome.mapper.MemberMapper;

@Controller
public class IndexController {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberMapper mapper;
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		
		return "Spring Boot Start";
	}
	
	
	@RequestMapping("/hello")
	public void hello1() {
		
	}
	
	@Transactional
	@RequestMapping("/memberInfo")
	public void selectByIdx() {
		
		mapper = template.getMapper(MemberMapper.class);
		
		MemberInfo info =  mapper.selectMemberById("ryuyj76@naver.com");
		
		System.out.println(info);
				
	}
	
	@RequestMapping("/members")
	@ResponseBody
	public List<MemberInfo> selectMembers() {
		
		mapper = template.getMapper(MemberMapper.class);
		
		List<MemberInfo> info =  mapper.selectAll();
		
		for (MemberInfo memberInfo : info) {
			System.out.println(memberInfo);
		}
		
		return info;
				
	}

	
	
	
	
	
	
	
}
