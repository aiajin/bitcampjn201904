package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import member.MemberDao;

@Configuration
public class AppCtx1 {
	
	@Bean
	public MemberDao getMemberDao() {
		return new MemberDao();
	}
	
}









