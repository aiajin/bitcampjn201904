package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import member.ChangePasswordService2;
import member.MemberDao;
import member.MemberRegisterService2;

@Configuration
@Import(AppCtx1.class)
public class AppCtx2 {
	
	@Autowired
	MemberDao dao;
	
	
	
	
	@Bean(name = "registService2")	
	public MemberRegisterService2 getMemberRegisterService2() {
		
		MemberRegisterService2 service = new MemberRegisterService2();
		
		// 주입
		//service.setMemberDao(getMemberDao());
		
		return service;
		//return new MemberRegisterService2(getMemberDao());
	}
	
	@Bean(name = "changePwServcie2")
	public ChangePasswordService2 getChangePasswordService2() {
		
		ChangePasswordService2 service = new ChangePasswordService2();
		// 주입
		//service.setMemberDao(getMemberDao());
		
		return service;
		//return new ChangePasswordService2(getMemberDao());
	}

}









