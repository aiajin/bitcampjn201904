package com.weovercome.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weovercome.domain.MemberInfo;
import com.weovercome.entity.MemberEntity;
import com.weovercome.mapper.MemberMapper;
import com.weovercome.repository.MemberRepository;

@Controller
public class IndexController {
	
	@Autowired
	private MemberRepository repository;
	
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
	
	@RequestMapping("/member/list")
	@ResponseBody
	public List<MemberEntity> getMemberList(){
		
		List<MemberEntity> list = null;
		
		list = repository.findAll();
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		return list;
		
	}
	
	@RequestMapping("/member/insert")
	@ResponseBody
	public String insetMember() {
		
		MemberEntity entity = new MemberEntity();
		entity.setUid("cool@hot");
		entity.setUname("COOLin");
		entity.setUpw("12345");
		
		return repository.saveAndFlush(entity).toString();
		
	}


	@RequestMapping("/member/edit/{idx}")
	@ResponseBody
	public String editMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();
		entity.setIdx(idx);
		entity.setUid("cool@hot.com");
		entity.setUname("COOLinHOT");
		entity.setUpw("editPW");
		
		return repository.saveAndFlush(entity).toString();
		
	}


	@RequestMapping("/member/delete/{idx}")
	@ResponseBody
	public String deleteMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();
		entity.setIdx(idx);
		
		repository.delete(entity);
		
		return "delete success";
		
	}

	
	
	
	
	
	
	
	
}
