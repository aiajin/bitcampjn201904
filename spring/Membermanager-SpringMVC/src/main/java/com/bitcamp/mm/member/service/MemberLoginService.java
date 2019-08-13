package com.bitcamp.mm.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.member.dao.MemberDaoInterface;
import com.bitcamp.mm.member.dao.MemberJdbcTemplateDao;
import com.bitcamp.mm.member.domain.MemberInfo;


@Service("loginService")
public class MemberLoginService implements MemberService {

	//@Autowired
	//private MemberJdbcTemplateDao dao;
	
	// 자동 메퍼를 이용해서 생성할 dao 
	private MemberDaoInterface dao;
	
	// 자동 메퍼를 위한 sqlSessionTemplate 객체 주입
	// @Inject : 타입에 맞는 주입 ( java 에서 지원 : 특정 프레임워크에 의존하지 않음 )
	@Inject
	private SqlSessionTemplate template;
	
	public boolean login(
			String id, 
			String pw, 
			HttpServletRequest request) {
		
		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberDaoInterface.class);
		
		boolean loginChk = false;
		
		MemberInfo memberInfo = null;

			memberInfo = dao.selectMemberById(id);
			
			if(memberInfo!=null && memberInfo.pwChk(pw)) {
				// 세션에 저장
				// loginChk 상태값을 변경
				request.getSession(true).setAttribute("loginInfo", memberInfo.toLoginInfo());
				loginChk = true;
			}

		return loginChk;
		
	}

}
