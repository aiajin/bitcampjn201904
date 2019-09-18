package com.weovercome.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weovercome.domain.MemberEntity;
import com.weovercome.repository.MemberDaoImpl;
import com.weovercome.repository.MemberRepository;

@Controller
public class IndexController {
	
	@Autowired
	private MemberRepository repository;
	
	
	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		return "index";
	}
	
	@RequestMapping("/hello")
	public void hello(Model model) {
		
		model.addAttribute("msg", "hello~!!");
		
	}
	
	

	
	@RequestMapping("/")
	@ResponseBody
	public Iterable<MemberEntity> memberAllList() {
		
		Iterable<MemberEntity> list = repository.findAllOrderByIdxDesc();
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}		
		
		return list;
		
	}
	
	
	
	
	@RequestMapping("/list")
	public void memberList(Model model) {
		
		Iterable<MemberEntity> list = repository.findAll();
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping("/insert")
	public void memberInsert(Model model) {		
		System.out.println("/insert");	
		
		MemberEntity member = new MemberEntity();		
		member.setUid("cool@hot.com");
		member.setUname("COOLinHOT");
		member.setUpw("12345");		
		
		repository.saveAndFlush(member);	
	}
	
	@RequestMapping("/edit")
	public void memberEdit(Model model) {
		
		System.out.println("/edit");
		MemberEntity emember = new MemberEntity();
		emember.setIdx(40);
		emember.setUid("cool@hot.com");
		emember.setUname("COOLinHOT");
		emember.setUpw("editPW");
		emember.setUphoto("cool@hot.com_");		
		
		System.out.println(emember);
		
		repository.saveAndFlush(emember);
	}
	

	
	@RequestMapping("/delete")
	public void memberDelete(Model model) {
		MemberEntity entity = new MemberEntity();
		entity.setIdx(40);
		repository.delete(entity);
	}
	
	

	
	@RequestMapping("/findIdx/{idx}")
	public void memberfindByIdx(
			@PathVariable("idx") Long idx,
			Model model) {
		
		MemberEntity member = repository.findByIdx(idx);
		System.out.println(member);		
		model.addAttribute("member", member);
		
	}
	
	// 스프링 부트에서는 EntityManager 가 실행 시에 자동으로 Bean으로 등록된다. 
	// @PersistenceContext 가 이 빈을 필드에 할당한다.
	@PersistenceContext 
	EntityManager entityManager;
	
	private MemberDaoImpl dao;
	
	@RequestMapping("/listall")
	public void memberListAll(Model model) {
		
		List<MemberEntity> list = dao.getAll();
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		model.addAttribute("list", list);
		
	}

	@RequestMapping("/find")
	public void memberfind(@RequestParam("fstr") String fstr, Model model) {
		
		dao = new MemberDaoImpl(entityManager);
		
		List<MemberEntity> list = dao.find(fstr);
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		model.addAttribute("list", list);
		
	}


}
